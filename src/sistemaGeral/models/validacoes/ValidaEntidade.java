package sistemaGeral.models.validacoes;

import java.time.LocalDate;
import java.util.ArrayList;

import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.ItemCardapio;
import sistemaGeral.models.entidades.Produto;
import sistemaGeral.models.entidades.Usuario;

public class ValidaEntidade {
	public boolean validarData(LocalDate data) {	
		if(data.compareTo(LocalDate.now())>0) return true;
		return false;
	}

	public boolean nomeUsuarioJaCadastrado(String nome, ArrayList<Usuario> lista_cadastrados) {
		for (Usuario user: lista_cadastrados) if (user.getNome().equals(nome)) return true;
		
		return false;
	}
	
	public static boolean nomeFornecedorJaCadastrado(String nome, ArrayList<Fornecedor> lista_cadastrados) {
		for (Fornecedor fornecedor: lista_cadastrados) if (fornecedor.getNome().equals(nome)) return true;
		
		return false;
	}
	
	public static boolean nomeItemJaCadastrado(String nome, ArrayList<ItemCardapio> lista_cadastrados) {
		for (ItemCardapio item: lista_cadastrados) if (item.getNome().equals(nome)) return true;
		
		return false;
	}
	
	public static boolean nomeProdutoJaCadastrado(String nome, ArrayList<Produto> lista_cadastrados) {
		for (Produto produto: lista_cadastrados) if (produto.getNome().equals(nome)) return true;
		
		return false;
	}

}
