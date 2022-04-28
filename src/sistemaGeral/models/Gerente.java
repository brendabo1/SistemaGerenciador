package sistemaGeral.models;

public class Gerente extends Usuario{
	private final boolean acesso_admin = true;
	private static final String pre_fixo = "GER";
	
		public Gerente(String nome, String senha, String id){
			this.nome = nome;
			this.senha = senha;
			this.id = id;
		}

		public boolean getAcesso_admin() {
			return acesso_admin;
		}

		public static String getPreFixo() {
			return pre_fixo;
		}
		
		
}
