package testeValidacoes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaGeral.models.validacoes.ValidaString;

class TesteValidaString {
	
	@BeforeEach
	public void inicializaValidaString() {
		ValidaString validacao = new ValidaString();
	}

	@Test
	void testeStringVazia() {
		fail("Not yet implemented");
	}

}
