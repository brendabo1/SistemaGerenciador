package sistemaGeral.models.validacoes;

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

}
