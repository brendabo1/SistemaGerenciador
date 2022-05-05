package sistemaGeral.models.entidades;

import sistemaGeral.models.entidades.enums.UnidadeMedida;

public class Produto extends EntidadesDoSistema {		
		private String nome;
		private Fornecedor fornecedor;
		private UnidadeMedida unidade_medida;
		private Double quantidade_conteudo;
		
		private static final  String preFixo = "PRO";

		
		public Produto(String id, String nome, Fornecedor fornecedor, UnidadeMedida unidade, Double quantidade_conteudo) {
			this.id = id;
			this.nome = nome;
			this.fornecedor = fornecedor;
			this.unidade_medida = unidade;
			this.quantidade_conteudo = quantidade_conteudo;
		}

		
		@Override
		public String toString() {
			String message = String.format("ID: %s  NOME: %s  FORNECEDOR: %s", id, nome, fornecedor.getNome());
			return message;
		}
		
		public Fornecedor getFornecedor() {
			return fornecedor;
		}
		public void setFornecedor(Fornecedor fornecedor) {
			this.fornecedor = fornecedor;
		}

		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		
		public static String getPrefixo() {
			return preFixo;
		}


		public UnidadeMedida getUnidade_medida() {
			return unidade_medida;
		}
		public void setUnidade_medida(UnidadeMedida unidade_medida) {
			this.unidade_medida = unidade_medida;
		}


		public Double getQuantidade_conteudo() {
			return quantidade_conteudo;
		}
		public void setQuantidade_conteudo(Double quantidade_conteudo) {
			this.quantidade_conteudo = quantidade_conteudo;
		}
}
