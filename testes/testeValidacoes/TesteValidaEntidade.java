package testeValidacoes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DateTimeException;
import java.time.LocalDate;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import sistemaGeral.models.validacoes.ValidaEntidade;

class TesteValidaEntidade {

	@Test
	void testValidarData_ExistenteFutura() {
		LocalDate data = LocalDate.of(2022, 8, 15);   // 15/8/2022
		assertTrue(ValidaEntidade.validarData(data));
	}
	
	@Test
	void testValidarData_ExistentePassada() {
		LocalDate data = LocalDate.of(2022, 1, 10);  //  10/01/2022
		assertFalse(ValidaEntidade.validarData(data));
	}
		

}
