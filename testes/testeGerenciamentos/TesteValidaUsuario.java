package testeGerenciamentos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import sistemaGeral.models.entidades.Funcionario;
import sistemaGeral.models.entidades.Usuario;
import sistemaGeral.models.validacoes.ValidaUsuario;

class TesteValidaUsuario {

	@Test
	void testNome_Vazio() {		
		assertFalse(ValidaUsuario.validarNome(""));
	}
	@Test
	void testNome_EmBranco() {		
		assertFalse(ValidaUsuario.validarNome("        "));
	}
	
	@Test
	void testNome_SomenteNumeros() {		
		assertFalse(ValidaUsuario.validarNome("12344657"));
	}
	
	@Test
	void testNome_AlfaNumerico() {		
		assertFalse(ValidaUsuario.validarNome("Nome467"));
	}
	
	@Test
	void testNome_ComCaracteresEspeciais() {		
		assertFalse(ValidaUsuario.validarNome("@m@nda"));
	}
	
	@Test
	void testNome_Tamanho_4() {		
		assertFalse(ValidaUsuario.validarNome("Nome"));
	}
	
	@Test
	void testNome_AlfabeticoTamanho_5() {		
		assertTrue(ValidaUsuario.validarNome("Jovem"));
	}
	
	@Test
	void testSenha_Vazia() {		
		assertFalse(ValidaUsuario.validarSenha(""));
	}
	@Test
	void testSenha_EmBranco() {		
		assertFalse(ValidaUsuario.validarSenha("        "));
	}
	@Test
	void testSenha_AlfaNumerica_Tamanho_5() {		
		assertFalse(ValidaUsuario.validarSenha("sen12"));
	}
	@Test
	void testSenha_AlfaNumerica_Tamanho_6() {		
		assertTrue(ValidaUsuario.validarSenha("lembrar321"));
	}
	@Test
	void testSenha_Numerica_Tamanho_6() {		
		assertTrue(ValidaUsuario.validarSenha("123456"));
	}
	@Test
	void testSenha_Numerica_Tamanho_5() {		
		assertFalse(ValidaUsuario.validarSenha("12345"));
	}
	@Test
	void testSenha_AlfaNumerica_ComCaracteresEspeciais() {		
		assertTrue(ValidaUsuario.validarSenha("Senh@_25"));
	}
	@Test
	void testSenha_AlfaNumerica_ComEspacos() {		
		assertTrue(ValidaUsuario.validarSenha("S 3 N H A135"));
	}
	
	@Test
	void testNome_AddJaCadatrado() {	
		List<Usuario> lista_usuarios = new ArrayList<>();
		Usuario user1 = new Funcionario("ID123", "Carlos", "123456");
		lista_usuarios.add(user1);
		assertTrue(ValidaUsuario.nomeJaCadastrado("Carlos", lista_usuarios));
	}
	@Test
	void testNome_AddNaoCadatrado() {	
		List<Usuario> lista_usuarios = new ArrayList<>();
		Usuario user1 = new Funcionario("ID123", "Carlos", "123456");
		lista_usuarios.add(user1);
		assertFalse(ValidaUsuario.nomeJaCadastrado("Paulo", lista_usuarios));
	}
	
	@Test
	void testNome_BuscaNomeListaVazia() {	
		List<Usuario> lista_usuarios = new ArrayList<>();
		assertFalse(ValidaUsuario.nomeJaCadastrado("Thiago", lista_usuarios));
	}
	
	@Test
	void testNome_BuscaNomeVazioCadastrado() {	
		List<Usuario> lista_usuarios = new ArrayList<>();
		Usuario user1 = new Funcionario("ID123", "Ana Beatriz", "123456");
		lista_usuarios.add(user1);
		assertFalse(ValidaUsuario.nomeJaCadastrado("", lista_usuarios));
	}

}
