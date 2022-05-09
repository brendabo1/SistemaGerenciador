package sistemaGeral.models.entidades;

import java.time.LocalDate;

public class Lote extends EntidadesDoSistema {
		private Produto produto;
		private Double unidades_compradas;
		private Double preco;
		private LocalDate validade;
		private Double quantidade_em_armazenamento;
	
		
		
		public Lote (Produto produto, Double quantidade_comprada, Double preco_unitario, LocalDate validade, String id) {
				this.produto = produto;
				this.unidades_compradas = quantidade_comprada;
				this.preco = preco_unitario;
				this.validade = validade;
				this.id = id;
				this.quantidade_em_armazenamento = this.unidades_compradas + produto.getConteudo_produto();
		}
	
		
	
		@Override
		public String toString() {
			String message = String.format("ID: %s   PRODUTO: %s   QUANTIDADE: %.1f   PREÇO: R$%.2f   VALIDADE: %s", 
																		  this.id, this.produto.getNome(), this.unidades_compradas, this.validade);
			return message;
		}
	
	
		public Produto getProduto() {
			return produto;
		}	
		public void setProduto(Produto produto) {
			this.produto = produto;
		}
		
		
		public Double getPreco() {
			return preco;
		}
		public void setPreco(Double preco) {
			this.preco = preco;
		}
		
		
		public LocalDate getValidade() {
			return validade;
		}
		public void setValidade(LocalDate validade) {
			this.validade = validade;
		}
	
	
		public Double getUnidades_compradas() {
			return unidades_compradas;
		}
		public void setUnidades_compradas(Double unidades_compradas) {
			this.unidades_compradas = unidades_compradas;
		}
	
	
		public Double getQuantidade_em_armazenamento() {
			return quantidade_em_armazenamento;
		}
		public void setQuantidade_em_armazenamento(Double quantidade_em_armazenamento) {
			this.quantidade_em_armazenamento = quantidade_em_armazenamento;
		}
}
