package sistemaGeral.models.validacoes;

public class ValidaString {
	
	private static String stringSemEspacos(String str) {
		String str_semEspacos = "";
		String[] arrStr;
		
		if(str.trim().contains(" ")) {
			arrStr =  str.split(" ", -1);  //remove qualquer ocorrencia
			for (String a : arrStr)
				str_semEspacos += a;
			return str_semEspacos;
		}
		return str;
	}
	
	public static boolean isAlfaNumerica(String entrada, int tam_min) {
		return (entrada.trim().matches("[a-zA-Z_0-9]+") && entrada.length() >= tam_min);	//aceita letras e numeros, exceto simbolos, espaco e especiais	
	}
	
	public static boolean isAlfabetica(String entrada, int tam_min) {
		return (entrada.trim().matches("[a-zA-Z]+") && entrada.length() >= tam_min); //1 ou + letras 	nao permite espaco
	}
	
	public static boolean isNumeric(String entrada, int tam_min) {    
		return (entrada.trim().matches("[0-9]+") && entrada.length() >= tam_min);
	}
	
	public static boolean isAlfaNumericaComposta(String entrada, int tam_min) {
		
		return ValidaString.isAlfaNumerica(ValidaString.stringSemEspacos(entrada), tam_min);
	}
	
	public static boolean isAlfabeticaComposta(String entrada, int tam_min) {
		
		return ValidaString.isAlfabetica(ValidaString.stringSemEspacos(entrada), tam_min);
	}
	
}
