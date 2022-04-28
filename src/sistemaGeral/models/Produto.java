package sistemaGeral.models;

public class Produto extends EntidadesDoSistema {
		private String nome;
		private Double preco;
		private String validade;
		private static final  String preFixo = "PRO";

		
		public Produto(String nome, Double preco, String validade, String id) {
			this.nome = nome;
			this.preco = preco;
			this.validade = validade;
			this.id = id;
		}
		
		public String toString() {
			return "NOME: " + nome + "  -  " + "PREÇO: " + preco + "  -  " + "VALIDADE: " + validade + "  -  " + "ID: " + id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Double getPreco() {
			return preco;
		}

		public void setPreco(Double preco) {
			this.preco = preco;
		}

		public String getValidade() {
			return validade;
		}

		public void setValidade(String validade) {
			this.validade = validade;
		}
		
		public static String getPrefixo() {
			return preFixo;
		}
		
}
