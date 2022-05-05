package testeGerenciamentos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import sistemaGeral.controllers.validacoes.ValidarUsuario;
import sistemaGeral.models.entidades.Funcionario;
import sistemaGeral.models.entidades.Usuario;

class TesteValidaUsuario {

	@Test
	void testNome_Vazio() {		
		assertFalse(ValidarUsuario.validarNome(""));
	}
	@Test
	void testNome_EmBranco() {		
		assertFalse(ValidarUsuario.validarNome("        "));
	}
	
	@Test
	void testNome_SomenteNumeros() {		
		assertFalse(ValidarUsuario.validarNome("12344657"));
	}
	
	@Test
	void testNome_AlfaNumerico() {		
		assertFalse(ValidarUsuario.validarNome("Nome467"));
	}
	
	@Test
	void testNome_ComCaracteresEspeciais() {		
		assertFalse(ValidarUsuario.validarNome("@m@nda"));
	}
	
	@Test
	void testNome_Tamanho_4() {		
		assertFalse(ValidarUsuario.validarNome("Nome"));
	}
	
	@Test
	void testNome_AlfabeticoTamanho_5() {		
		assertTrue(ValidarUsuario.validarNome("Jovem"));
	}
	
	@Test
	void testSenha_Vazia() {		
		assertFalse(ValidarUsuario.validarSenha(""));
	}
	@Test
	void testSenha_EmBranco() {		
		assertFalse(ValidarUsuario.validarSenha("        "));
	}
	@Test
	void testSenha_AlfaNumerica_Tamanho_5() {		
		assertFalse(ValidarUsuario.validarSenha("sen12"));
	}
	@Test
	void testSenha_AlfaNumerica_Tamanho_6() {		
		assertTrue(ValidarUsuario.validarSenha("lembrar321"));
	}
	@Test
	void testSenha_Numerica_Tamanho_6() {		
		assertTrue(ValidarUsuario.validarSenha("123456"));
	}
	@Test
	void testSenha_Numerica_Tamanho_5() {		
		assertFalse(ValidarUsuario.validarSenha("12345"));
	}
	@Test
	void testSenha_AlfaNumerica_ComCaracteresEspeciais() {		
		assertTrue(ValidarUsuario.validarSenha("Senh@_25"));
	}
	@Test
	void testSenha_AlfaNumerica_ComEspacos() {		
		assertTrue(ValidarUsuario.validarSenha("S 3 N H A135"));
	}
	
	@Test
	void testNome_AddJaCadatrado() {	
		List<Usuario> lista_usuarios = new ArrayList<>();
		Usuario user1 = new Funcionario("ID123", "Carlos", "123456");
		lista_usuarios.add(user1);
		assertTrue(ValidarUsuario.nomeJaCadastrado("Carlos", lista_usuarios));
	}
	@Test
	void testNome_AddNaoCadatrado() {	
		List<Usuario> lista_usuarios = new ArrayList<>();
		Usuario user1 = new Funcionario("ID123", "Carlos", "123456");
		lista_usuarios.add(user1);
		assertFalse(ValidarUsuario.nomeJaCadastrado("Paulo", lista_usuarios));
	}
	
	@Test
	void testNome_BuscaNomeListaVazia() {	
		List<Usuario> lista_usuarios = new ArrayList<>();
		assertFalse(ValidarUsuario.nomeJaCadastrado("Thiago", lista_usuarios));
	}
	
	@Test
	void testNome_BuscaNomeVazioCadastrado() {	
		List<Usuario> lista_usuarios = new ArrayList<>();
		Usuario user1 = new Funcionario("ID123", "Ana Beatriz", "123456");
		lista_usuarios.add(user1);
		assertFalse(ValidarUsuario.nomeJaCadastrado("", lista_usuarios));
	}

}
