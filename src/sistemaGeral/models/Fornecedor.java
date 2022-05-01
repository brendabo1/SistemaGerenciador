package sistemaGeral.models;

import java.util.ArrayList;

public class Fornecedor extends EntidadesDoSistema {
		private String CNPJ;
		private String nome;
		private String endereco;
		private ArrayList<Produto> produtos_fornecidos = new ArrayList<>();
		
		private static final  String preFixo = "FOR";
	
		
		public Fornecedor(String id, String CNPJ, String nome, String endereco) {
			this.id = id;
			this.CNPJ = CNPJ;
			this.nome = nome;
			this.endereco = endereco;
		}

		public  String toString() {
			String message = String.format("ID: %s  CNPJ: %s  NOME: %s  ENDEREÇO: %s", this.id, this.CNPJ, this.nome, this.endereco);
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
		
		
		public ArrayList<Produto> getProdutos_fornecidos() {
			return produtos_fornecidos;
		}

		public void setProdutos_fornecidos(ArrayList<Produto> produtos_fornecidos) {
			this.produtos_fornecidos = produtos_fornecidos;
		}

		public static String getPrefixo() {
			return preFixo;
		}
}
