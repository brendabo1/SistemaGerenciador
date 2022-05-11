package sistemaGeral.models.validacoes;


public class ValidaUsuario {
	public boolean isNomeValido(String nome) {
		return ValidaString.isAlfaNumericaComposta(nome, 3);
	}
	
	public boolean isSenhaValido(String senha) {
		return ValidaString.stringTamMin(senha, 4);
	}
	
	public boolean isUsuarioValido(String nome, String senha) {
		if(this.isNomeValido(nome)) {
			if(this.isSenhaValido(senha)) return true;
		}
		else throw new IllegalArgumentException();
		return false;
	}
	

}
