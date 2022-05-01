package sistemaGeral.models;

public class Produto extends EntidadesDoSistema {
		private String nome;
		private Double preco;
		//private String validade;
		//private double quantidade;
		private UnidadeMedida und_medida;
		private Fornecedor fornecedor;
		private static final  String preFixo = "PRO";

		
		public Produto(String id, String nome, Double preco, Fornecedor fornecedor, UnidadeMedida und_medida ) {
			this.id = id;
			this.nome = nome;
			this.preco = preco;
			//this.validade = validade;
			//this.quantidade = qnt;
			this.und_medida = und_medida;
			this.fornecedor = fornecedor;
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
		
		@Override
		public String toString() {
			String message = String.format("ID: %s  NOME: %s  PREÇO: %.2f", id, nome, preco);
			return message;
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
		
		public static String getPrefixo() {
			return preFixo;
		}
		
}
