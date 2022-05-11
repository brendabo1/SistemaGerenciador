package sistemaGeral.models.gerenciadores;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.CarrinhoDeCompra;
import sistemaGeral.models.entidades.EntidadesDoSistema;
import sistemaGeral.models.entidades.IngredienteDoItem;
import sistemaGeral.models.entidades.ItemCardapio;
import sistemaGeral.models.entidades.Lote;
import sistemaGeral.models.entidades.Venda;
import sistemaGeral.models.entidades.enums.CategoriasDeItens;
import sistemaGeral.models.entidades.enums.FormasDePagamento;

public class GerenciamentoVenda extends GerenciamentoGeral {
		private HashMap<String, Venda> map_vendas;
		private GerenciamentoItemCardapio gerItemCardapio;
		private GerenciamentoLote gerLote;
		
		public GerenciamentoVenda(BancoDeDados banco, GerenciamentoItemCardapio gerItemCardapio, GerenciamentoLote gerLote) {
			this.map_vendas = banco.getMap_vendas();
			this.gerItemCardapio = gerItemCardapio;
			this.gerLote = gerLote;
		}
		
		
		public Venda cadastrar(HashMap<String, CarrinhoDeCompra> itens_comprados, FormasDePagamento formaDePagamento) {
			String nova_id = gerarID(Venda.getPreFixo());
			Venda nova_venda = new Venda(nova_id, itens_comprados, formaDePagamento);
			if (adicionar(this.map_vendas, nova_venda))
				return nova_venda;
			return null;
		}
		

		public boolean editarFormaDePagamento (FormasDePagamento formaDePagamento, Venda venda) {
			venda.setForma_de_pagamento(formaDePagamento);
			return venda.getForma_de_pagamento().equals(formaDePagamento);
		}
		
		public boolean adicionarItemComprado (ItemCardapio item_comprado, Integer quantidade_comprada, Venda venda) {
			if (!gerItemCardapio.verificarSePodeSerVendido(item_comprado, quantidade_comprada))
					return false;
			
			for (IngredienteDoItem ingrediente :  item_comprado.getIngredientes().values()) {
				String nome_produto = ingrediente.getProduto().getNome().toLowerCase();
				gerLote.consumirLote(ingrediente.getQuantidade_usada() * quantidade_comprada, nome_produto);
			}
			
			for (CarrinhoDeCompra compra : venda.getItens_comprados().values()) {
				if (compra.getItem_comprado().getId() == item_comprado.getId()) {
					compra.setQuantidade_comprada(compra.getQuantidade_comprada() + quantidade_comprada);
					return true;
				}
			}
			
			String novo_id = gerarID(CarrinhoDeCompra.getPreFixo());
			CarrinhoDeCompra nova_compra = new CarrinhoDeCompra(item_comprado, quantidade_comprada, novo_id);
			venda.getItens_comprados().put(novo_id, nova_compra);
			return true;
		}

		public boolean removerItemComprado (String id_carrinhoCompras, Integer quantidade_retirada,Venda venda) {
			CarrinhoDeCompra compra = venda.getItens_comprados().get(id_carrinhoCompras);
			
			if (compra == null || quantidade_retirada <= 0 || quantidade_retirada > compra.getQuantidade_comprada())
					return false;
			
			String nome_produto = compra.getItem_comprado().getNome().toLowerCase();
			String id_lote = gerLote.getAgrupamentoDeLotes().get(nome_produto).get(0);
			Lote lote = gerLote.getMap_estoque().get(id_lote);
			
			Double valor_devolvido = lote.getProduto().getConteudo_produto() * quantidade_retirada;
			lote.setQuantidade_em_armazenamento(lote.getQuantidade_em_armazenamento() + valor_devolvido);
			
			compra.setQuantidade_comprada(compra.getQuantidade_comprada() - quantidade_retirada);
			if (compra.getQuantidade_comprada() == 0)
				venda.getItens_comprados().remove(compra.getId());
			return true;
		}
		
		
		public boolean gerarPDF(String titulo, ArrayList<Venda> listaVendas) throws FileNotFoundException, DocumentException {
			Document docpdf = new Document(PageSize.A4, 10f, 10f, 10f, 10f);
			PdfWriter.getInstance(docpdf, new FileOutputStream("src\\PDF_Venda.pdf")); 
			docpdf.open();
			Paragraph pTitulo = new Paragraph(15F , titulo, FontFactory.getFont(FontFactory.HELVETICA, 18F));
			Paragraph pLinha = new Paragraph(12F , listaVendas.get(0).linhaTituloToString(), FontFactory.getFont(FontFactory.HELVETICA, 15F));
			pTitulo.setAlignment(Element.ALIGN_CENTER);
			docpdf.add(pTitulo);
			docpdf.add(pLinha);
			for(Venda f:listaVendas) {
				Paragraph pMessage = new Paragraph(15F , f.toString(), FontFactory.getFont(FontFactory.HELVETICA, 15F));
				pTitulo.setAlignment(Element.ALIGN_JUSTIFIED);
				docpdf.add(pMessage);
			}
				
			docpdf.close();
			return true;
		}
		
		public boolean gerarPDFVendaGeral(BancoDeDados bancoDados) throws FileNotFoundException, DocumentException {
			ArrayList<Venda> listaVendasGeral = this.convertHashToArr(bancoDados.getMap_vendas());
			this.gerarPDF("VENDAS", listaVendasGeral);
			
			 return true;
		 }
		
		public ArrayList<Venda> listaVendasNoMes(int mes, BancoDeDados bancoDados){
			ArrayList<Venda> listaVendas = this.convertHashToArr(bancoDados.getMap_vendas());
			ArrayList<Venda> vendasNoMes = new ArrayList<>();
			
			for(Venda venda: listaVendas) {
				if(venda.getData().getMonthValue() == mes){
					vendasNoMes.add(venda);
				}
			}
			return vendasNoMes;
		}
		
		 public boolean gerarPDFPorMes(int mes, BancoDeDados bancoDados) throws FileNotFoundException, DocumentException {
			ArrayList<Venda> vendas_periodo = this.listaVendasNoMes(mes, bancoDados);
			String titulo = "Vendas no Mês: " + mes;
			return this.gerarPDF(titulo, vendas_periodo);
		 }
		 
		 public ArrayList<Venda> listaVendasporCategoria(CategoriasDeItens categoria, BancoDeDados bancoDados){
			 //erros no Comparator e collection.sort
			 ArrayList<Venda> listaVendas = this.convertHashToArr(bancoDados.getMap_vendas());
			 ArrayList<Venda> vendasPorCategoria = new ArrayList<>();
			 for(Venda venda: listaVendas) {
				 ArrayList<CarrinhoDeCompra> listaPratosComprados = this.convertHashToArr(venda.getItens_comprados());
				 for(CarrinhoDeCompra item: listaPratosComprados) {
					if(item.getItem_comprado().getCategoria() == categoria) {
						vendasPorCategoria.add(venda);
					}
				 }
			 }	 
			
			 return vendasPorCategoria;	
	
			}
		 
		 public boolean gerarPDFCategoriaPrato(CategoriasDeItens categoria, BancoDeDados bancoDados) throws FileNotFoundException, DocumentException {
				ArrayList<Venda> vendasCategoria = this.listaVendasporCategoria(categoria, bancoDados);
				String titulo = "Vendas no Mês: " + categoria;
				return this.gerarPDF(titulo, vendasCategoria);
			 }
		 
		 
		 
}
