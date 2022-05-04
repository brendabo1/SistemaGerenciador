package sistemaGeral.models.gerenciadores;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import sistemaGeral.models.entidades.ItemCardapio;
import sistemaGeral.models.entidades.Venda;

public class GerenciamentoVenda extends GerenciamentoGeral {
	
		private ArrayList<Venda> lista_vendas = getLista_vendas();
		
		
		public boolean cadastrar(ArrayList<ItemCardapio> compras, String formaDePagamento) {
			String id = gerarID(this.lista_vendas, Venda.getPrefixo());
			Venda nova_venda = new Venda(id, compras, formaDePagamento);
			return adicionar(this.lista_vendas, nova_venda);
			
		}
		
		
		public boolean editarFormaDePagamento(String formaDePagamento, Venda venda) {
			venda.setForma_de_pagamento(formaDePagamento);
			return venda.getForma_de_pagamento().equals(formaDePagamento);
		}
		
		//TO DO editar carrinho de compras, preco 

		public ArrayList<Venda> getLista_vendas() {
			return lista_vendas;
		}


		public void setLista_vendas(ArrayList<Venda> lista_vendas) {
			this.lista_vendas = lista_vendas;
		}
		
		/**
		 * Gera um relat�rio PDF na ra�z do projeto contendo a mensagem recebida.
		 * @param message
		 * @throws FileNotFoundException
		 * @throws DocumentException
		 */
		
		public boolean gerarPDF(String message) throws FileNotFoundException, DocumentException {
			Document docpdf = new Document();
			PdfWriter.getInstance(docpdf, new FileOutputStream("src\\PDF_Teste.pdf")); //caminho relativo
			docpdf.open();
			boolean t= docpdf.add(new Paragraph("Hello World Java\n" + message));
			docpdf.close();
			return t;
			
			//importar a lib itext
		}
		
		
}
