package sistemaGeral.models;

import java.util.ArrayList;

public class ItemCardapio extends EntidadesDoSistema {
		private String nome;
		private ArrayList<Produto> ingredientes;
		private Double preco;
		private CategoriasDeItens categoria;
		private static final  String preFixo = "ITM";

		
		public ItemCardapio(String nome, ArrayList<Produto> ingredientes, Double preco, CategoriasDeItens categoria, String id) {
			this.nome = nome;
			this.ingredientes = ingredientes;
			this.preco = preco;
			this.categoria = categoria;
			this.id = id;
		}

		
		@Override
		public String toString() {
			String retorno = "NOME: " + nome + "  -  "+ "PREÇO: " + preco + "  -  " + "CATEGORIA: " + categoria.toString() + "  -  " + "ID: " + id + "  -  " + 
					"\nINGREDIENTES: ";
			for (Produto p: ingredientes) {
				retorno +=  p.getNome() + "  "; 
			
			}
			return retorno;
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