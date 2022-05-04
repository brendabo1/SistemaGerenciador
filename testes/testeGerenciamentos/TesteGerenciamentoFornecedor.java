package testeGerenciamentos;

import static org.junit.Assert.assertEquals;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.gerenciadores.GerenciamentoFornecedor;



class TesteGerenciamentoFornecedor {

	@Test
	void testCadastrar_Fornecedor() {
		GerenciamentoFornecedor gerenciamentoFornecedor = new GerenciamentoFornecedor();
		assertTrue(gerenciamentoFornecedor.cadastrar("Central dos Papeis", "12312312332112", "Rua da Graça, n65"));
	}
	
	@Test
	void testCadastrar_MultiplosFornecedores() {
		GerenciamentoFornecedor gerenciamentoFornecedor = new GerenciamentoFornecedor();
		gerenciamentoFornecedor.cadastrar("Casa do Molho", "cnpjnumerico", "Rua da Graça, n65");
		gerenciamentoFornecedor.cadastrar("Felipe Martins ltda", "12312312332000", "Avenida Misericordia, n1");
		gerenciamentoFornecedor.cadastrar("Central dos Papeis", "12312312330001", "Rua da Paz, n201");
		gerenciamentoFornecedor.cadastrar("Distribuidora Camargo", "00012312332112", "Rua M, caminho 12, n5");
		assertEquals(4, gerenciamentoFornecedor.getLista_fornecedores().size());
	}
	
	@Test
	void testEditar_NomeFornecedorValido() {
		GerenciamentoFornecedor gerenciamentoFornecedor = new GerenciamentoFornecedor();
		gerenciamentoFornecedor.cadastrar("Casa do Molho", "12312312332112", "Rua da Graça, n65");
		Fornecedor fornecedor2 = new Fornecedor("FOR1", "cnpj", "nome", "endereco");
		gerenciamentoFornecedor.cadastrar("Nome", "12312312332112", "endereco");
		assertTrue(gerenciamentoFornecedor.editarNome("Distribuidora VALIDA", fornecedor2));
	}
	

}
