package sistemaGeral.controllers.validacoes;

import java.util.List;

import sistemaGeral.models.Produto;

public class ValidarProduto {

	public static boolean validarNome(String nome) {
		return (!nome.isBlank() && !nome.matches("[0-9]*"));
	}	
	
	public static boolean validarPreco(Double preco) {
		return (preco > 0);
	}
	
	public static boolean validarValidade(String validade) {
		return (!validade.isBlank() && validade.matches("\\d{2}/\\d{2}/\\d{4}"));
	}
	
	public static boolean nomeJaCadastrado(String nome, List<Produto> lista_cadastrados) {
		for (Produto produto: lista_cadastrados) if (produto.getNome().equals(nome)) return true;
		
		return false;
	}
}
