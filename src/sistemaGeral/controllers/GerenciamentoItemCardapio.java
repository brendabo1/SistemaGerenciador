package sistemaGeral.controllers;

import java.util.ArrayList;

import sistemaGeral.models.CategoriasDeItens;
import sistemaGeral.models.ItemCardapio;
import sistemaGeral.models.Produto;

public class GerenciamentoItemCardapio extends GerenciamentoGeral{
		private ArrayList<ItemCardapio> lista_itensCardapio = new ArrayList<>();
	
	
		public boolean cadastrar(String nome, ArrayList<Produto> ingredientes, Double preco, CategoriasDeItens categoria) {
				String id = gerarID(this.lista_itensCardapio, ItemCardapio.getPrefixo());
				ItemCardapio novo_itemCardapio = new ItemCardapio(nome, ingredientes, preco, categoria, id);
				return adicionar(this.lista_itensCardapio, novo_itemCardapio);
			}
			
		
			
		public boolean editarNome(String novo_nome, ItemCardapio item) {
				item.setNome(novo_nome);
				return item.getNome().equals(novo_nome);
		}
		
		public boolean editarIngredientes(ArrayList<Produto> novos_ingredientes, ItemCardapio item) {
				item.setIngredientes(novos_ingredientes);
				return item.getIngredientes().equals(novos_ingredientes);
		}

		public boolean editarPreco(Double novo_preco, ItemCardapio item) {
				item.setPreco(novo_preco);
				return item.getPreco().equals(novo_preco);
		}
		
		public boolean editarCategoria(CategoriasDeItens nova_categoria, ItemCardapio item) {
				item.setCategoria(nova_categoria);
				return item.getCategoria().equals(nova_categoria);
		}



		
		
		public ArrayList<ItemCardapio> getLista_itensCardapio() {
			return lista_itensCardapio;
		}
		



		public void setLista_itensCardapio(ArrayList<ItemCardapio> lista_itensCardapio) {
			this.lista_itensCardapio = lista_itensCardapio;
		}
			
		
}
