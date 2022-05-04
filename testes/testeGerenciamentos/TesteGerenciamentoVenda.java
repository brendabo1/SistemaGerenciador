package testeGerenciamentos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

import com.itextpdf.text.DocumentException;

import sistemaGeral.models.entidades.CategoriasDeItens;
import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.ItemCardapio;
import sistemaGeral.models.entidades.Produto;
import sistemaGeral.models.entidades.UnidadeMedida;
import sistemaGeral.models.gerenciadores.GerenciamentoVenda;


public class TesteGerenciamentoVenda {
	@Test
	public void testRelatorio_Venda() throws FileNotFoundException, DocumentException {
		GerenciamentoVenda gerenciador = new GerenciamentoVenda();
		Fornecedor fornecedor1 = new Fornecedor("ID000", "Central dos Papeis", "12312312332112", "Rua da Graça, n65");
		Produto cerveja = new Produto("ID123", "cerveja", 6.50, fornecedor1, UnidadeMedida.L);
		ArrayList<Produto> ingredientes = new ArrayList<>();
		ingredientes.add(cerveja);
		ItemCardapio item = new ItemCardapio("ID111", "Cerveja Brahama", ingredientes, 6.50, CategoriasDeItens.BEBIDA);
		ArrayList<ItemCardapio> compras = new ArrayList<>();
		compras.add(item);
		gerenciador.cadastrar(compras, "PIX");
		String message = String.format("VENDA \n\n Itens: %s", compras.toString());
		assertTrue(gerenciador.gerarPDF(message));
				
	}
}
