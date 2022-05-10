package sistemaGeral.models.validacoes;

import java.util.ArrayList;
import java.util.Collection;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Fornecedor;

public class ValidaFornecedor implements ValidaString, ValidaEntidade {
	
	public boolean cnpjValido(String cnpj) {
		return ValidaString.isNumericTamExato(cnpj, 14);
	}
	
	public boolean nomeValido(String nome) {
		return ValidaString.isAlfaNumericaComposta(nome, 4);
	}
	
	public boolean enderecoValido(String endereco) {
		return ValidaString.stringTamMin(endereco, 4);
	}
	
	public boolean fornecedoroExistente(String nomeProduto_buscado, String nomeFornecedor_buscado, BancoDeDados bancoDados) {
		Collection<Fornecedor> collectionProdutos = bancoDados.getMap_fornecedores().values();
		ArrayList<Fornecedor> lista_produtos = new ArrayList<>(collectionProdutos);
		for(Produto p:lista_produtos) {
			if(p.getNome() == nomeProduto_buscado && p.getFornecedor().getNome() == nomeFornecedor_buscado) 
				return true;
		}
		return false;		
	}

}
