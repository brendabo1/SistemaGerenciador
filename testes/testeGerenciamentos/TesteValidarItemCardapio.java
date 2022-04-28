package testeGerenciamentos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sistemaGeral.controllers.validacoes.ValidarItemCardapio;

class TesteValidarItemCardapio {

	@Test
	void testNome_Vazio() {		
		assertFalse(ValidarItemCardapio.validarNome(""));
	}
	
	@Test
	void testNome_EmBranco() {		
		assertFalse(ValidarItemCardapio.validarNome("   "));
	}
	
	@Test
	void testNome_Numerico() {		
		assertFalse(ValidarItemCardapio.validarNome("321456"));
	}
	
	@Test
	void testNome_Alfabetico() {		
		assertTrue(ValidarItemCardapio.validarNome("Aipim Frito"));
	}
	
	@Test
	void testNome_AlfaNumerico() {		
		assertTrue(ValidarItemCardapio.validarNome("Cachaça 51"));
	}
	
	@Test
	void testNome_NumericoComEspacos() {		
		assertFalse(ValidarItemCardapio.validarNome("1 1 1 1"));
	}
	
	@Test
	void testNome_ComCaracteresEspeciais() {		
		assertTrue(ValidarItemCardapio.validarNome("Drink #Poderosa"));
	}
	
	@Test
	void testPreco_Zero() {		
		assertFalse(ValidarItemCardapio.validarPreco(0.0));
	}
	
	@Test
	void testPreco_Negativo() {		
		assertFalse(ValidarItemCardapio.validarPreco(-17.30));
	}
	
	@Test
	void testPreco_Positivo() {		
		assertTrue(ValidarItemCardapio.validarPreco(20.90));
	}

}