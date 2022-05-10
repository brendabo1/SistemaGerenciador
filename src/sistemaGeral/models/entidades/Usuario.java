package sistemaGeral.models.entidades;

public class Usuario extends EntidadesDoSistema {
		private String nome;
		private String senha;
		final static private String preFixo = "USR";
		
		
		public Usuario (String nome, String senha, String id) {
			this.nome = nome;
			this.senha = senha;
			this.id = id;
		}
		
		
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


		public static String getPrefixo() {
			return preFixo;
		}
}
