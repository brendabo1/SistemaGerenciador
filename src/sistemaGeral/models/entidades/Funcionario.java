package sistemaGeral.models.entidades;

public class Funcionario extends Usuario{
	private final boolean acesso_admin = true;
	
		public Funcionario(String id, String nome, String senha){
			this.id = id;
			this.nome = nome;
			this.senha = senha;	
			Funcionario.preFixo = "FUN";
		}

		public boolean getAcesso_admin() {
			return acesso_admin;
		}
}
