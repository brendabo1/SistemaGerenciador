package sistemaGeral.models.validacoes;

public class ValidaString {
	
	public static boolean isAlfanumerico(String entrada, int tam_min) {
		return (entrada.matches("[a-zA-Z_0-9]+") && entrada.length() >= tam_min);	//aceita letras e numeros, exceto simbolos e especiais	
	}
	
	public static boolean isAlfabetico(String entrada, int tam_min) {
		return (entrada.matches("[a-zA-Z]+") && entrada.length() >= tam_min); //1 ou + letras 	
	}
	
	public static boolean isNumeric(String entrada, int tam_min) {
		return (entrada.matches("[0-9]+") && entrada.length() >= tam_min);
	}
	
}
