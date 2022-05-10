package sistemaGeral.models.entidades;

import java.util.HashMap;

public class Fornecedor extends EntidadesDoSistema {
		private String CNPJ;
		private String nome;
		private String endereco;
		private HashMap<String, Produto> map_produtosFornecidos = new HashMap<>();
		
		
		
		public Fornecedor(String id, String CNPJ, String nome, String endereco) {
			this.id = id;
			this.CNPJ = CNPJ;
			this.nome = nome;
			this.endereco = endereco;
			Fornecedor.preFixo = "FOR";
		}
	
		
		
		@Override
		public  String toString() {
			String message = String.format("ID: %s  CNPJ: %s  NOME: %s  ENDERE�O: %s", this.id, this.CNPJ, this.nome, this.endereco);
			return message;
		}

		
		
		public String getCNPJ() {
			return CNPJ;
		}
		public void setCNPJ(String CNPJ) {
			this.CNPJ = CNPJ;
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


		public HashMap<String, Produto> getMap_produtosFornecidos() {
			return map_produtosFornecidos;
		}
}
