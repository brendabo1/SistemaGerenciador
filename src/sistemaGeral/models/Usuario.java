package sistemaGeral.models;

abstract public class Usuario extends EntidadesDoSistema {
		protected String nome;
		protected String senha;
		
	
		
		@Override
		public String toString() {
			return "NOME: " + this.nome + "  -  " + "ID: " + this.id;
		}
		
		
		public String getNome() {
			return this.nome;
		}
		
		public void setNome(String novo_nome) {
			this.nome = novo_nome;
		}
		
		public String getSenha() {
			return this.senha;
		}
		
		public void setSenha(String nova_senha) {
			this.senha = nova_senha;
		}
		
}
