package sistemaGeral.models.validacoes;

public interface ValidaNumero {
	
	default public boolean isDoublePositivo(double num) {
		return num > 0;
	}
	
	
}
