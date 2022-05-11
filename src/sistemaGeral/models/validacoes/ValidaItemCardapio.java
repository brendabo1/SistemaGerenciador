package sistemaGeral.models.validacoes;

public class ValidaItemCardapio {
	
	public boolean isNomeValido(String nomeItem) {
		return ValidaString.stringTamMin(nomeItem, 3);
	}
	
	public boolean isPrecoValido(Double preco) {
		return ValidaNumero.isDoublePositivo(preco);
	}
	
}
