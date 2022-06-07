package sistemaGeral.models.validacoes;

import java.util.Collection;
import java.util.HashMap;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Fornecedor;

/**
 * Classe respons�vel por identificar os objetos e valores aceitos pelo sistema.
 * @author Brenda Barbosa
 * @author Elmer Carvalho
 */
public class ValidaFornecedor implements ValidaString, ValidaEntidade {
	
	/**
	 * Verifica se a string corresponde a um cnpj com 14 d�gitos
	 * @param cnpj string a ser analisada
	 * @return true se o cnpj contiver exatamente 14 d�gitos numericos
	 */
	public boolean isCnpjValido(String cnpj) {
		return ValidaString.isNumericTamExato(cnpj, 14);
	}
	/**
	 * Verifica se a string contendo letras e/ou numeros corresponde a um nome, simples ou composto, com comprimento m�nimo
	 * @param nome string a ser analisada
	 * @return true se o nome nao vazio possuir comprimento igual ou superior a 4 caracteres
	 */
	public boolean isNomeValido(String nome) {
		return ValidaString.isAlfaNumericaComposta(nome, 4);
	}
	
	/**
	 * Varifica se a string atende ao tamanho m�nimo
	 * @param endereco string a ser analisada
	 * @return true se o endereco possui comprimento igual ou superior a 4 caracteres
	 */	
	public boolean isEnderecoValido(String endereco) {
		return ValidaString.stringTamMin(endereco, 4);
	}
	
	/**
	 * Verifica se o cnpj j� est� cadastrado no sistema
	 * @param cnpjBuscado string unica de cada fornecedor a ser verificada
	 * @param bancoDados banco respons�vel por armazenar as estruturas de dados do sistema
	 * @return true se o cnpj j� estiver cadastrado no sistema
	 */
	public boolean isFornecedoroExistente(String cnpjBuscado, HashMap<String, Fornecedor> mapFornecedores) {
		Collection<Fornecedor> fornecedores = mapFornecedores.values();
		for(Fornecedor f:fornecedores) {
			if(f.getCNPJ().equals(cnpjBuscado)) 
				return true;
		}
		return false;		
	}
	
	public boolean isFornecedorValido(String nome, String cnpj, String end, HashMap<String, Fornecedor> mapFornecedores) {
		if(this.isNomeValido(nome) && this.isCnpjValido(cnpj) && this.isEnderecoValido(end)) {
			if(!this.isFornecedoroExistente(cnpj, mapFornecedores)) return true;
		}
		throw new IllegalArgumentException();
	}

}
