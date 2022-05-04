package sistemaGeral.models.entidades;

import java.util.ArrayList;

import sistemaGeral.models.entidades.enums.CategoriasDeItens;

public class ItemCardapio extends EntidadesDoSistema {
		private String nome;
		private Double preco;

		private ArrayList<Produto> ingredientes;
		
		private CategoriasDeItens categoria;
		private static final  String preFixo = "ITM";
		
		
		
		private class Ingrediente {
			Produto produto;
			Double quantidade_usada;
		}

		
		public ItemCardapio(String id, String nome, ArrayList<Produto> ingredientes, Double preco, CategoriasDeItens categoria) {
			this.id = id;
			this.nome = nome;
			this.ingredientes = ingredientes;
			this.preco = preco;
			this.categoria = categoria;
		}

		
		@Override
		public String toString() {
			String message = String.format("ID: %s  NOME: %s  PREÇO: %.2f  CATEGORIA: %s  \nINGREDIENTES: ", this.id, this.nome, this.preco, this.categoria.toString());
					
			for (Produto p: this.ingredientes) {
				message +=  p.getNome() + ", "; 
			
			}
			return message;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public ArrayList<Produto> getIngredientes() {
			return ingredientes;
		}


		public void setIngredientes(ArrayList<Produto> ingredientes) {
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
		
		public static String getPrefixo() {
			return preFixo;
		}
		
}