package sistemaGeral.models;

import java.util.ArrayList;

public class Fornecedor extends EntidadesDoSistema {
		private String CNPJ;
		private String nome;
		private String endereco;
		private ArrayList<Produto> produtos_fornecidos;
		private static final  String preFixo = "FOR";

		
		
		public Fornecedor(String CNPJ, String nome, String endereco, String id, ArrayList<Produto> produtos) {
			this.CNPJ = CNPJ;
			this.nome = nome;
			this.endereco = endereco;
			this.id = id;
			this.produtos_fornecidos = produtos;
		}

		public  String toString() {
			
			return "CNPJ: " + CNPJ + "  -  " + "NOME: " + nome + "  -  " + "ENDERE�O: " + endereco + "  -  " + "ID: " + id;
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
