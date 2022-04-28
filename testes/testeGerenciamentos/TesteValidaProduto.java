package testeGerenciamentos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import sistemaGeral.controllers.validacoes.ValidarProduto;

class TesteValidaProduto {

	@Test
	void testNome_Vazio() {		
		assertFalse(ValidarProduto.validarNome(""));
	}
	
	@Test
	void testNome_EmBranco() {		
		assertFalse(ValidarProduto.validarNome("  "));
	}
	
	@Test
	void testNome_SomenteNumeros() {		
		assertFalse(ValidarProduto.validarNome("1668437"));
	}
	
	@Test
	void testNome_AlfaNumerico() {		
		assertTrue(ValidarProduto.validarNome("Cachaça51"));
	}
	@Test
	void testNome_ComCaracteresEspeciais() {		
		assertTrue(ValidarProduto.validarNome("#Batata da Casa"));
	}
	
	@Test
	void testNome_AlfanNumerico_e_CaracteresEspeciais() {		
		assertTrue(ValidarProduto.validarNome("#Batata 4Queijos!"));
	}
	
	@Test
	void testPreco_Zero() {		
		assertFalse(ValidarProduto.validarPreco(0.0));
	}
	
	@Test
	void testPreco_Negativo() {		
		assertFalse(ValidarProduto.validarPreco(-25.5));
	}
	
	@Test
	void testPreco_Positivo() {		
		assertTrue(ValidarProduto.validarPreco(15.50));
	}
	
	@Test
	void testValidade_Vazia() {		
		assertFalse(ValidarProduto.validarValidade(""));
	}
	
	@Test
	void testValidade_EmBranco() {		
		assertFalse(ValidarProduto.validarValidade("  "));
	}
	
	@Test
	void testValidade_Letras() {		
		assertFalse(ValidarProduto.validarValidade("ddmmaaaa"));
	}
	
	@Test
	void testValidade_LetrasFormatadas() {		
		assertFalse(ValidarProduto.validarValidade("dd/mm/aaaa"));
	}
	
	@Test
	void testValidade_AlfaNumerico() {		
		assertFalse(ValidarProduto.validarValidade("dd/02/2022"));
	}
	
	@Test
	void testValidade_NaoFormatada() {		
		assertFalse(ValidarProduto.validarValidade("01012022"));
	}
	
	@Test
	void testValidade_Formatada() {		
		assertTrue(ValidarProduto.validarValidade("01/01/2022"));
	}
}