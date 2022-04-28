package sistemaGeral.models;

public class Fornecedor extends EntidadesDoSistema {
		private String CNPJ;
		private String nome;
		private String endereco;
		private static final  String preFixo = "FOR";

		
		
		public Fornecedor(String CNPJ, String nome, String endereco, String id) {
			this.CNPJ = CNPJ;
			this.nome = nome;
			this.endereco = endereco;
			this.id = id;
		}

		public  String toString() {
			
			return "CNPJ: " + CNPJ + "  -  " + "NOME: " + nome + "  -  " + "ENDEREÇO: " + endereco + "  -  " + "ID: " + id;
		}


		public String getCNPJ() {
			return CNPJ;
		}


		public void setCNPJ(String cNPJ) {
			CNPJ = cNPJ;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getEndereco() {
			return endereco;
		}


		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		
		
		public static String getPrefixo() {
			return preFixo;
		}
}
