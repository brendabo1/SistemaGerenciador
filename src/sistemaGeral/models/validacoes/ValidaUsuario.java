package sistemaGeral.models.validacoes;


public class ValidaUsuario {
	public boolean isNomeValido(String nome) {
		return ValidaString.isAlfaNumericaComposta(nome, 3);
	}
	
	public boolean isSenhaValido(String senha) {
		return ValidaString.stringTamMin(senha, 4);
	}

}
