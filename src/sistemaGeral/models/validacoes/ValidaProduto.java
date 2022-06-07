package sistemaGeral.models.validacoes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.Produto;

public class ValidaProduto implements ValidaString, ValidaNumero{
	
	public boolean nomeValido(String nome) {
		return ValidaString.stringTamMin(nome, 3);
	}
	
	public boolean conteudoProdutoValido(double qnt) {
		return ValidaNumero.isDoublePositivo(qnt);
	}
	
	public boolean produtoExistente(String nomeProduto_buscado, String idFornecedor_buscado, HashMap<String, Produto> mapProdutos) {
		Collection<Produto> produtos = mapProdutos.values();
		for(Produto p:produtos) {
			if(p.getNome().equals(nomeProduto_buscado) && p.getFornecedor().getId().equals(idFornecedor_buscado)) 
				return true;
		}
		return false;		
	}
	
	public boolean isProdutoValido(String nome, double qnt, String idFornecedor_buscado, HashMap<String, Produto> mapProdutos) {
		if(this.nomeValido(nome) && this.conteudoProdutoValido(qnt)) {
			if(!this.produtoExistente(nome, idFornecedor_buscado, mapProdutos)) return true;
		}
		throw new IllegalArgumentException();
	}
}
