package sistemaGeral.models.entidades;

public class CarrinhoDeCompra {
		private ItemCardapio item_comprado;
		private Integer quantidade_comprada;
		private Double preco_compras = 0.0;
		
		public CarrinhoDeCompra (ItemCardapio item_comprado, Integer quantidade_comprada) {
				this.item_comprado = item_comprado;
				this.quantidade_comprada = quantidade_comprada;
				this.preco_compras += this.item_comprado.getPreco() * quantidade_comprada;
		}
		

		public ItemCardapio getItem_comprado() {
			return item_comprado;
		}
		public void setItem_comprado(ItemCardapio item_comprado) {
			this.item_comprado = item_comprado;
		}

		public Integer getQuantidade_comprada() {
			return quantidade_comprada;
		}
		public void setQuantidade_comprada(Integer quantidade_comprada) {
			this.quantidade_comprada = quantidade_comprada;
		}

		public Double getPreco_compras() {
			return preco_compras;
		}
		public void setPreco_compras(Double preco_compras) {
			this.preco_compras = preco_compras;
		}
}
