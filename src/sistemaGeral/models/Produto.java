package sistemaGeral.models;

public class Produto extends EntidadesDoSistema {
		private String nome;
		private Double preco;
		private String validade;
		private double quantidade;
		private UnidadeMedida und_medida;
		private Fornecedor fornecedor;
		private static final  String preFixo = "PRO";

		
		public Produto(String nome, Double preco, String validade, String id, double qnt, Fornecedor fornecedor, UnidadeMedida und_medida ) {
			this.nome = nome;
			this.preco = preco;
			this.validade = validade;
			this.id = id;
			this.quantidade = qnt;
			this.und_medida = und_medida;
			this.fornecedor = fornecedor;
		}
		
		public double getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(double quantidade) {
			this.quantidade = quantidade;
		}

		public UnidadeMedida getUnd_medida() {
			return und_medida;
		}

		public void setUnd_medida(UnidadeMedida und_medida) {
			this.und_medida = und_medida;
		}

		public Fornecedor getFornecedor() {
			return fornecedor;
		}

		public void setFornecedor(Fornecedor fornecedor) {
			this.fornecedor = fornecedor;
		}

		public String toString() {
			return "NOME: " + nome + "  -  " + "PRE�O: " + preco + "  -  " + "VALIDADE: " + validade + "  -  " + "ID: " + id;
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
