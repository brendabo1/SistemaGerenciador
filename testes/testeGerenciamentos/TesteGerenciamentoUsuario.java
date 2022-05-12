package testeGerenciamentos;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Usuario;
import sistemaGeral.models.gerenciadores.GerenciamentoUsuario;


class TesteGerenciamentoUsuario {
			BancoDeDados banco = new BancoDeDados();
			GerenciamentoUsuario gerUsuario = new GerenciamentoUsuario(banco);
	
	
	@Test
	void testCriandoUsuario() {
		assertNotNull(gerUsuario.cadastrar("Maria", "Maria123"));
	}
	
	@Test
	void testFazendoLoginDeUsuario() {
		Usuario novo_usuario = gerUsuario.cadastrar("Ronaldo", "Gauchinho");
		assertTrue(gerUsuario.loginID(novo_usuario.getId(), novo_usuario.getSenha()));
	}
	
	@Test
	void testEditarNome() {
		Usuario novo_usuario = gerUsuario.cadastrar("Ronaldo", "Gauchinho");
		assertTrue(gerUsuario.editarNome("Neymar", novo_usuario));
	}
	
	@Test
	void testEditarSenha() {
		Usuario novo_usuario = gerUsuario.cadastrar("Ronaldo", "Gauchinho");
		assertTrue(gerUsuario.editarSenha("MacacoPrego", novo_usuario));
	}

}
