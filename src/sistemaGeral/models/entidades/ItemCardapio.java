package sistemaGeral.models.entidades;

import java.util.ArrayList;

import sistemaGeral.models.entidades.enums.CategoriasDeItens;

public class ItemCardapio extends EntidadesDoSistema {
		private String nome;
		private Double preco;

		private ArrayList<Ingrediente> ingredientes = new ArrayList<>();
		
		private CategoriasDeItens categoria;
		
		
		
		private class Ingrediente {
			private Produto produto;
			private Double quantidade_usada;
			
			Ingrediente (Produto produto, Double quantidade_usada) {
				this.produto = produto;
				this.quantidade_usada = quantidade_usada;
			}

			public Produto getProduto() {
				return produto;
			}
			public void setProduto(Produto produto) {
				this.produto = produto;
			}

			public Double getQuantidade_usada() {
				return quantidade_usada;
			}
			public void setQuantidade_usada(Double quantidade_usada) {
				this.quantidade_usada = quantidade_usada;
			}
		}

		
		public ItemCardapio(String id, String nome, ArrayList<Ingrediente> ingredientes, Double preco, CategoriasDeItens categoria) {
			this.id = id;
			this.nome = nome;
			this.ingredientes = ingredientes;
			this.preco = preco;
			this.categoria = categoria;
			ItemCardapio.preFixo = "ITM";
		}

		
		@Override
		public String toString() {
			String message = String.format("ID: %s  NOME: %s  PREÇO: %.2f  CATEGORIA: %s  \nINGREDIENTES: ", this.id, this.nome, this.preco, this.categoria.toString());
					
			for (Ingrediente i: this.ingredientes) {
				message +=  i.getProduto().getNome() +" - " +  i.getQuantidade_usada() + i.getProduto().getUnidade_medida()+  " | "; 		
			}
			return message;
		}


		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}


		public ArrayList<Ingrediente> getIngredientes() {
			return this.ingredientes;
		}
		public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
			this.ingredientes = ingredientes;
		}


		public Double getPreco() {
			return preco;
		}
		public void setPreco(Double preco) {
			this.preco = preco;
		}


		public CategoriasDeItens getCategoria() {
			return categoria;
		}
		public void setCategoria(CategoriasDeItens categoria) {
			this.categoria = categoria;
		}
}