package sistemaGeral.controllers.validacoes;

import java.util.ArrayList;
import java.util.List;

import sistemaGeral.models.ItemCardapio;
import sistemaGeral.models.Produto;

public class ValidarItemCardapio {
		
		public static boolean validarNome(String nome) {
			return (!nome.isBlank() && !nome.replace(" ", "").matches("[0-9]*"));
		}
		
		public static boolean validarPreco(Double preco) {
			return (preco > 0);
		}
		
		public static boolean validarIngredientes(ArrayList<Produto> ingredientes, ArrayList<Produto> produtos) {
			int contador = 0;
			for (Produto p_1: ingredientes) {
				for (Produto p_2: produtos) if (p_2.equals(p_1)) contador++;
			}
			
			return (contador == ingredientes.size());
		}
		
		public static boolean nomeJaCadastrado(String nome, List<ItemCardapio> lista_cadastrados) {
			for (ItemCardapio item: lista_cadastrados) if (item.getNome().equals(nome)) return true;
			
			return false;
		}
		
}
