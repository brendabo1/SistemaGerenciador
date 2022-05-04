package testeGerenciamentos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import sistemaGeral.models.validacoes.ValidaProduto;

class TesteValidaProduto {

	@Test
	void testNome_Vazio() {		
		assertFalse(ValidaProduto.validarNome(""));
	}
	
	@Test
	void testNome_EmBranco() {		
		assertFalse(ValidaProduto.validarNome("  "));
	}
	
	@Test
	void testNome_SomenteNumeros() {		
		assertFalse(ValidaProduto.validarNome("1668437"));
	}
	
	@Test
	void testNome_AlfaNumerico() {		
		assertTrue(ValidaProduto.validarNome("Cachaça51"));
	}
	@Test
	void testNome_ComCaracteresEspeciais() {		
		assertTrue(ValidaProduto.validarNome("#Batata da Casa"));
	}
	
	@Test
	void testNome_AlfanNumerico_e_CaracteresEspeciais() {		
		assertTrue(ValidaProduto.validarNome("#Batata 4Queijos!"));
	}
	
	@Test
	void testPreco_Zero() {		
		assertFalse(ValidaProduto.validarPreco(0.0));
	}
	
	@Test
	void testPreco_Negativo() {		
		assertFalse(ValidaProduto.validarPreco(-25.5));
	}
	
	@Test
	void testPreco_Positivo() {		
		assertTrue(ValidaProduto.validarPreco(15.50));
	}
	
	@Test
	void testValidade_Vazia() {		
		assertFalse(ValidaProduto.validarValidade(""));
	}
	
	@Test
	void testValidade_EmBranco() {		
		assertFalse(ValidaProduto.validarValidade("  "));
	}
	
	@Test
	void testValidade_Letras() {		
		assertFalse(ValidaProduto.validarValidade("ddmmaaaa"));
	}
	
	@Test
	void testValidade_LetrasFormatadas() {		
		assertFalse(ValidaProduto.validarValidade("dd/mm/aaaa"));
	}
	
	@Test
	void testValidade_AlfaNumerico() {		
		assertFalse(ValidaProduto.validarValidade("dd/02/2022"));
	}
	
	@Test
	void testValidade_NaoFormatada() {		
		assertFalse(ValidaProduto.validarValidade("01012022"));
	}
	
	@Test
	void testValidade_Formatada() {		
		assertTrue(ValidaProduto.validarValidade("01/01/2022"));
	}
}