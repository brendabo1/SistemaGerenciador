package sistemaGeral.models.entidades;

abstract public class Usuario extends EntidadesDoSistema {
		protected String nome;
		protected String senha;
		
			
		@Override
		public String toString() {
			String message = String.format("ID: %s  NOME: %s", this.id, this.nome);
			return message;
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
