package sistemaGeral.models.validacoes;

import java.util.ArrayList;
import java.util.Collection;
import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Produto;

public class ValidaProduto implements ValidaString, ValidaNumero{
	
	public boolean nomeValido(String nome) {
		return ValidaString.stringTamMin(nome, 3);
	}
	
	public boolean conteudoProdutoValido(Double qnt) {
		return ValidaNumero.isDoublePositivo(qnt);
	}
	
	public boolean produtoExistente(String nomeProduto_buscado, String nomeFornecedor_buscado, BancoDeDados bancoDados) {
		Collection<Produto> collectionProdutos = bancoDados.getMap_produtos().values();
		ArrayList<Produto> lista_produtos = new ArrayList<>(collectionProdutos);
		for(Produto p:lista_produtos) {
			if(p.getNome().equals(nomeProduto_buscado) && p.getFornecedor().getNome().equals(nomeFornecedor_buscado)) 
				return true;
		}
		return false;		
	}
}
