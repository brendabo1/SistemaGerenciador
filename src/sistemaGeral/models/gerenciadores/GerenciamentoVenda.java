package sistemaGeral.models.gerenciadores;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.ItemCardapio;
import sistemaGeral.models.entidades.Venda;

public class GerenciamentoVenda extends GerenciamentoGeral {
	

		private HashMap<String, Venda> map_vendas;
		
		public GerenciamentoVenda(BancoDeDados banco) {
			this.map_vendas = banco.getMap_vendas();
		}
		
		
		public boolean cadastrar(ArrayList<ItemCardapio> compras, String formaDePagamento) {
			String id = gerarID(this.lista_vendas, Venda.getPrefixo());
			Venda nova_venda = new Venda(id, compras, formaDePagamento);
			return adicionar(this.lista_vendas, nova_venda);
			
		}
		
		
		public boolean editarFormaDePagamento(String formaDePagamento, Venda venda) {
			venda.setForma_de_pagamento(formaDePagamento);
			return venda.getForma_de_pagamento().equals(formaDePagamento);
		}
			
}
