package sistemaGeral.models.gerenciadores;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
<<<<<<< HEAD
import java.util.Set;
import java.util.TreeSet;
=======
import java.util.ArrayList;
import java.util.Collection;
>>>>>>> 274760bbc9b264d2801c042ca4d547fa12f2086f

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.Produto;
import sistemaGeral.models.entidades.Venda;


public class TESTE {
<<<<<<< HEAD
			public static void main(String[] args) {
				System.out.println("\033[0;31m" + "BRENDA" + "\033[0m");
			}
=======
	
	 public void gerarPDF(String titulo, BancoDeDados banco) throws FileNotFoundException, DocumentException {
		 Collection<Fornecedor> collectionF = banco.getMap_fornecedores().values();
		 ArrayList<Fornecedor> lista_f = new ArrayList<>(collectionF);	
		 
		 Collection<Produto> collectionP = banco.getMap_produtos().values();
		 ArrayList<Produto> lista_P = new ArrayList<>(collectionP);
		 
		 Collection<Venda> collectionV = banco.getMap_vendas().values();
		 ArrayList<Venda> lista_V = new ArrayList<>(collectionV);
		 
		 Document docpdf = new Document(PageSize.A4, 10f, 10f, 10f, 10f);
			PdfWriter.getInstance(docpdf, new FileOutputStream("src\\PDF_Teste.pdf")); //caminho relativo
			docpdf.open();
			Paragraph pTitulo = new Paragraph(15F , titulo, FontFactory.getFont(FontFactory.HELVETICA, 18F));
			Paragraph pLinha = new Paragraph(12F , lista_V.get(0).linhaTituloToString(), FontFactory.getFont(FontFactory.HELVETICA, 15F));
			pTitulo.setAlignment(Element.ALIGN_CENTER);
			docpdf.add(pTitulo);
			docpdf.add(pLinha);
			for(Venda f:lista_V) {
				Paragraph pMessage = new Paragraph(15F , f.toString(), FontFactory.getFont(FontFactory.HELVETICA, 15F));
				pTitulo.setAlignment(Element.ALIGN_JUSTIFIED);
				docpdf.add(pMessage);
			}
			
			docpdf.close();
			
			
			//importar a lib itext
>>>>>>> 274760bbc9b264d2801c042ca4d547fa12f2086f
		}
	 
	 
	 
	 public boolean gerarPDFPorPeriodo(String periodo, BancoDeDados banco) {
		Collection<Venda> collectionVendas = banco.getMap_vendas().values();
		ArrayList<Venda> lista_produtos = new ArrayList<>(collectionVendas);
		
		return true;
	 }

	public ArrayList<Venda> ordenarNoPeriodo(int mes, BancoDeDados banco){
		
		Collection<Venda> collectionVendas = banco.getMap_vendas().values();
		ArrayList<Venda> lista_vendas = new ArrayList<>(collectionVendas);
		
		ArrayList<Venda> vendasNoMes = new ArrayList<>();
		for(Venda v: lista_vendas) {
			if(v.getData().getMonthValue() == mes){
				vendasNoMes.add(v);
			}
		}
		return vendasNoMes;
	}
	
	
	

