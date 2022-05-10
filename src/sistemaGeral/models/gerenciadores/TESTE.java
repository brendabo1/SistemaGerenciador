package sistemaGeral.models.gerenciadores;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class TESTE {
	
	 public void gerarPDF(String titulo, String message) throws FileNotFoundException, DocumentException {
		 	Document docpdf = new Document(PageSize.A4, 10f, 10f, 10f, 10f);
			PdfWriter.getInstance(docpdf, new FileOutputStream("src\\PDF_Teste.pdf")); //caminho relativo
			docpdf.open();
			Paragraph pTitulo = new Paragraph(15F , titulo, FontFactory.getFont(FontFactory.HELVETICA, 18F));
			pTitulo.setAlignment(Element.ALIGN_CENTER);
			docpdf.add(pTitulo);
			
			Paragraph pMessage = new Paragraph(15F , message, FontFactory.getFont(FontFactory.HELVETICA, 18F));
			pTitulo.setAlignment(Element.ALIGN_JUSTIFIED);
			docpdf.add(pMessage);
			
			docpdf.close();
			
			
			//importar a lib itext
		}

}
