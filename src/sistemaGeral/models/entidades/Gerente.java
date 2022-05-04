package sistemaGeral.models.entidades;

public class Gerente extends Usuario{
	private final boolean acesso_admin = true;
	private static final String pre_fixo = "GER";
	
		public Gerente(String id, String nome, String senha){
			this.id = id;
			this.nome = nome;
			this.senha = senha;			
		}

		public boolean getAcesso_admin() {
			return acesso_admin;
		}

		public static String getPreFixo() {
			return pre_fixo;
		}
		
		
}
