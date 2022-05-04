package sistemaGeral.models.validacoes;

import java.util.List;

import sistemaGeral.models.entidades.Usuario;

public class ValidaUsuario {
		
	public static boolean validarNome(String nome) {
		nome = nome.replace("\n", "");
		return ((!nome.isBlank()) && nome.matches("[a-zA-Z]*") && nome.length() >= 5);
	}
	
	public static boolean validarSenha(String senha) {
		return (!senha.isBlank() && senha.length() >= 6);
	}
	
	public static boolean nomeJaCadastrado(String nome, List<Usuario> lista_cadastrados) {
		for (Usuario usuario: lista_cadastrados) if (usuario.getNome().equals(nome)) return true;
		
		return false;
	}
	
}
