package testeGerenciamentos;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.gerenciadores.GerenciamentoFornecedor;
import sistemaGeral.models.gerenciadores.GerenciamentoProduto;




class TesteGerenciamentoFornecedor {
		
	BancoDeDados banco = new BancoDeDados();
	GerenciamentoFornecedor gerFornecedor = new GerenciamentoFornecedor(banco);
	GerenciamentoProduto gerProduto = new GerenciamentoProduto(banco, gerFornecedor);
	
	@Test
	void testCriandoUmFornecedor() {
		assertNotNull(gerFornecedor.cadastrar("Paulo", "91919191919", "Rua Ansiedade"));
	}

	@Test 
	void testEditarNomeDoFornecedor() {
		Fornecedor fornecedor = gerFornecedor.cadastrar("Antonio", "9191919191", "Avenida Cansado");
		assertTrue(gerFornecedor.editarNome("Gustavo", fornecedor));
	}
	
	@Test
	void testEditarCNPJdoFornecedor() {
		Fornecedor fornecedor = gerFornecedor.cadastrar("Antonio", "9191919191", "Praça VouTrancar");
		assertTrue(gerFornecedor.editarCNPJ("55555555555", fornecedor));
	}
	
	@Test
	void testEditarEnderecoDoFornecedor() {
		Fornecedor fornecedor = gerFornecedor.cadastrar("Antonio", "9191919191", "Rua SemTempo");
		assertTrue(gerFornecedor.editarEndereco("Rua PrecisoRespirar", fornecedor));
	}
	
	
}
