package sistemaGeral.models.entidades;

public class Gerente extends Usuario{
	private final boolean acesso_admin = true;
	private static String preFixo = "GER";
	
		public Gerente(String id, String nome, String senha){
			this.id = id;
			this.nome = nome;
			this.senha = senha;			
		}

		public boolean getAcesso_admin() {
			return acesso_admin;
		}

		public static String getPreFixo() {
			return preFixo;
		}

		public static void setPreFixo(String preFixo) {
			Gerente.preFixo = preFixo;
		}
		
}
