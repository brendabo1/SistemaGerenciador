package sistemaGeral.models.entidades;

public class Gerente extends Usuario{
	private final boolean acesso_admin = true;
	
		public Gerente(String id, String nome, String senha){
			this.id = id;
			this.nome = nome;
			this.senha = senha;		
			Gerente.preFixo = "GER";
		}

		public boolean getAcesso_admin() {
			return acesso_admin;
		}
}
