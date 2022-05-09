package testeValidacoes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaGeral.models.validacoes.ValidaString;

class TesteValidaString {
	

	@Test
	void testeIsAlfabeticaVazia_TamMinimoZero() {
		assertFalse(ValidaString.isAlfabetica("", 0));
	}
	
	@Test
	void testeAlfabetica_TamMinimoZero() {
		assertTrue(ValidaString.isAlfabetica("nome", 0));
	}

	@Test
	void testeAlfabeticaVazia_TamMinimoNegativo() {
		assertFalse(ValidaString.isAlfabetica("", -1));
	}
	
	@Test
	void testeIsAlfabetica_TamMinimoNegativo() {
		assertTrue(ValidaString.isAlfabetica("app", -1));
	}
	
	@Test
	void testeIsAlfabetica_ApenasLetras_TamMenor_TamMinimo() {
		assertFalse(ValidaString.isAlfabetica("nome", 6));
	}
	
	@Test
	void testeIsAlfabetica_ApenasLetras_TamIgualTamMinimo() {
		assertTrue(ValidaString.isAlfabetica("teste", 5));
	}
	
	@Test
	void testeIsAlfabetica_LetrasComEspaco() {
		assertFalse(ValidaString.isAlfabetica("Item do cardapio", 5));
	}
		
	@Test
	void testeIsAlfabetica_ComNumero() {
		assertFalse(ValidaString.isAlfabetica("t3ste", 5));
	}
	
	@Test
	void testeIsAlfabetica_ApenasCaracteresEspeciais() {
		assertFalse(ValidaString.isAlfabetica("#$%&*()", 5));
	}
	
	@Test
	void testeIsAlfabetica_ApenasEspacos() {
		assertFalse(ValidaString.isAlfabetica("   ", 1));
	}
	
	@Test
	void testeIsAlfabeticaComposta_ApenasEspacos() {
		assertFalse(ValidaString.isAlfabeticaComposta("   ", 1));
	}
	
	@Test
	void testeIsAlfabeticaComposta_PalavraCompostaComNumeros() {
		assertFalse(ValidaString.isAlfabeticaComposta("Batatinha Frita 123", 1));
	}
	
	@Test
	void testeIsAlfabeticaComposta_PalavraComposta() {
		assertTrue(ValidaString.isAlfabeticaComposta("Batata Frita", 3));
	} 
	
	@Test
	void testeIsAlfaNumerica_Vazia_TamMinimoZero() {
		assertFalse(ValidaString.isAlfaNumerica("", 0));
	}
	
	@Test
	void testeIsAlfaNumerica_ApenasEspacos_TamMinimoZero() {
		assertFalse(ValidaString.isAlfaNumerica("   ", 0));
	}
	
	@Test
	void testeIsAlfaNumerica_ApenasNumeros() {
		assertTrue(ValidaString.isAlfaNumerica("123", 1));
	}
	
	@Test
	void testeIsAlfaNumerica_NumerosComEspaco() {
		assertFalse(ValidaString.isAlfaNumerica("12 3", 1));
	}
	
	@Test
	void testeIsAlfaNumerica_ApenasLetras() {
		assertTrue(ValidaString.isAlfaNumerica("Algoritmo", 1));
	}
	
	@Test
	void testeIsAlfaNumerica_NomeComposto() {
		assertFalse(ValidaString.isAlfaNumerica("Algoritmo teste", 1));
	}
	
	@Test
	void testeIsAlfaNumerica_LetrasNumeros() {
		assertTrue(ValidaString.isAlfaNumerica("t3st", 1));
	}
	
	@Test
	void testeIsAlfaNumerica_LetrasNumerosComCaracteresEspeciais() {
		assertFalse(ValidaString.isAlfaNumerica("@lun.0", 1));
	}
	
	@Test
	void testeIsAlfaNumericaComposta_LetrasNumeroComEspaco() {
		assertTrue(ValidaString.isAlfaNumericaComposta("Batatinha 123", 1));
	}
	
	@Test
	void testeIsNumerica_Vazia() {
		assertFalse(ValidaString.isNumeric("", 1));
	}
	
	@Test
	void testeIsNumerica_ApenasEspacos() {
		assertFalse(ValidaString.isNumeric("   ", 1));
	}
	
	@Test
	void testeIsNumerica_ApenasCaracteresEspeciais() {
		assertFalse(ValidaString.isNumeric("#$&* )", 1));
	}
	
	@Test
	void testeIsNumerica_ApenasLetras() {
		assertFalse(ValidaString.isNumeric("abc def", 1));
	}
	
	@Test
	void testeIsNumerica_LetrasNumeros() {
		assertFalse(ValidaString.isNumeric("123Testando", 1));
	}
	
	@Test
	void testeIsNumerica_NumerosComCaracteresEspeciais() {
		assertFalse(ValidaString.isNumeric("123...4", 1));
	}
	
	@Test
	void testeIsNumerica_ApenasNumeros() {
		assertTrue(ValidaString.isNumeric("123", 1));
	}

}
