package sistemaGeral.models.entidades;

import java.util.HashMap;

public class Fornecedor extends EntidadesDoSistema {
		private String CNPJ;
		private String nome;
		private String endereco;
		private HashMap<String, Produto> map_produtosFornecidos = new HashMap<>();
		private static String preFixo = "FOR";	
		
				

		public Fornecedor(String id, String CNPJ, String nome, String endereco) {
			this.id = id;
			this.CNPJ = CNPJ;
			this.nome = nome;
			this.endereco = endereco;
		}
	
		
		
		@Override
		public String toString() {
			String message = String.format("%5s %5s %5s %5s", this.id, this.CNPJ, this.nome, this.endereco);
			return message;
		}

		public String linhaTituloToString() {
			String message = String.format("\n%2s %19s %22s %12s", "ID", "CNPJ", "NOME", "ENDERECO");
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
		
		public void setMap_produtosFornecidos(HashMap<String, Produto> map_produtosFornecidos) {
			this.map_produtosFornecidos = map_produtosFornecidos;
		}


		public static void setPreFixo(String preFixo) {
			Fornecedor.preFixo = preFixo;
		}


		public static String getPreFixo() {
			return preFixo;
		}


}
