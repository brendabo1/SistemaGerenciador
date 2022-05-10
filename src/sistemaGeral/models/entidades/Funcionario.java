package sistemaGeral.models.entidades;

public class Funcionario extends Usuario{
	private final boolean acesso_admin = true;
	private static String preFixo = "FUN";	
	
	
		public Funcionario(String id, String nome, String senha){
			this.id = id;
			this.nome = nome;
			this.senha = senha;	
		}

		public static String getPreFixo() {
			return preFixo;
		}

		public static void setPreFixo(String preFixo) {
			Funcionario.preFixo = preFixo;
		}

		public boolean getAcesso_admin() {
			return acesso_admin;
		}
}
