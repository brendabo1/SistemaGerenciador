package testeGerenciamentos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sistemaGeral.models.validacoes.ValidaItemCardapio;

class TesteValidarItemCardapio {

	@Test
	void testNome_Vazio() {		
		assertFalse(ValidaItemCardapio.validarNome(""));
	}
	
	@Test
	void testNome_EmBranco() {		
		assertFalse(ValidaItemCardapio.validarNome("   "));
	}
	
	@Test
	void testNome_Numerico() {		
		assertFalse(ValidaItemCardapio.validarNome("321456"));
	}
	
	@Test
	void testNome_Alfabetico() {		
		assertTrue(ValidaItemCardapio.validarNome("Aipim Frito"));
	}
	
	@Test
	void testNome_AlfaNumerico() {		
		assertTrue(ValidaItemCardapio.validarNome("Cachaça 51"));
	}
	
	@Test
	void testNome_NumericoComEspacos() {		
		assertFalse(ValidaItemCardapio.validarNome("1 1 1 1"));
	}
	
	@Test
	void testNome_ComCaracteresEspeciais() {		
		assertTrue(ValidaItemCardapio.validarNome("Drink #Poderosa"));
	}
	
	@Test
	void testPreco_Zero() {		
		assertFalse(ValidaItemCardapio.validarPreco(0.0));
	}
	
	@Test
	void testPreco_Negativo() {		
		assertFalse(ValidaItemCardapio.validarPreco(-17.30));
	}
	
	@Test
	void testPreco_Positivo() {		
		assertTrue(ValidaItemCardapio.validarPreco(20.90));
	}

}