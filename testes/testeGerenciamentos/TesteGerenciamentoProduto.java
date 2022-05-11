package testeGerenciamentos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.Produto;
import sistemaGeral.models.entidades.enums.UnidadeMedida;
import sistemaGeral.models.gerenciadores.GerenciamentoFornecedor;
import sistemaGeral.models.gerenciadores.GerenciamentoProduto;

class TesteGerenciamentoProduto {
	BancoDeDados banco = new BancoDeDados();
	GerenciamentoFornecedor gerFornecedor = new GerenciamentoFornecedor(banco);
	GerenciamentoProduto gerProduto = new GerenciamentoProduto(banco, gerFornecedor);	
	
	@Test
	void testCriandoUmProduto() {
		Fornecedor fornecedor = gerFornecedor.cadastrar("Antonio", "9123213223", "Rua dos Passos");
		assertNotNull(gerProduto.cadastrar("Manga", fornecedor, UnidadeMedida.KG, 0.5));
	}
	
	@Test
	void testEditandoNome() {
		Fornecedor fornecedor = gerFornecedor.cadastrar("Antonio", "9123213223", "Rua dos Passos");
		Produto produto = gerProduto.cadastrar("Arroz", fornecedor, UnidadeMedida.G, 300.0);
		assertTrue(gerProduto.editarNome("Feijão", produto));
	}
	
	@Test
	void testEditandoFornecedor() {
		Fornecedor fornecedor_1 = gerFornecedor.cadastrar("Antonio", "9123213223", "Rua dos Passos");
		Fornecedor fornecedor_2 = gerFornecedor.cadastrar("Ronaldo", "8888888888", "Praça de Amelia");
		Produto produto = gerProduto.cadastrar("Arroz", fornecedor_1, UnidadeMedida.G, 300.0);
		assertTrue(gerProduto.editarFornecedor(fornecedor_2, produto));
	}
	
	@Test
	void testEditandoUnidadeDeMedida() {
		Fornecedor fornecedor = gerFornecedor.cadastrar("Ronaldo", "8888888888", "Praça de Amelia");
		Produto produto = gerProduto.cadastrar("Abobora", fornecedor, UnidadeMedida.G, 750.50);
		assertTrue(gerProduto.editarUnidadeMedida(UnidadeMedida.KG, produto));
	}
	
	@Test
	void testEditandoQuantidadeDoConteudo() {
		Fornecedor fornecedor = gerFornecedor.cadastrar("Ronaldo", "8888888888", "Praça de Amelia");
		Produto produto = gerProduto.cadastrar("Abobora", fornecedor, UnidadeMedida.G, 750.50);
		assertTrue(gerProduto.editarQuantidadeConteudo(840.20, produto));
	}
}
