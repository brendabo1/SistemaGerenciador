package sistemaGeral.models.gerenciadores;

import java.util.ArrayList;
import java.util.HashMap;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.IngredienteDoItem;
import sistemaGeral.models.entidades.ItemCardapio;
import sistemaGeral.models.entidades.Lote;
import sistemaGeral.models.entidades.Produto;
import sistemaGeral.models.entidades.enums.CategoriasDeItens;

public class GerenciamentoItemCardapio extends GerenciamentoGeral{
		private HashMap<String, ItemCardapio> map_itemCardapio;
		private GerenciamentoLote gerLote;
	 	
	 	public GerenciamentoItemCardapio(BancoDeDados banco, GerenciamentoLote gerLote) {
	 		this.map_itemCardapio = banco.getMap_itensCardapio();
	 		this.gerLote = gerLote;
	 	}
	 	
		public ItemCardapio cadastrar(String nome, HashMap<String, IngredienteDoItem> ingredientes, Double preco, CategoriasDeItens categoria) {
				String novo_id = gerarID(ItemCardapio.getPreFixo());
				ItemCardapio novo_itemCardapio = new ItemCardapio(novo_id, nome, ingredientes, preco, categoria);
				if (adicionar(map_itemCardapio, novo_itemCardapio))
					return novo_itemCardapio;
				return null;
		}
					
		public boolean verificarSePodeSerVendido (ItemCardapio item, Integer quantidade_item) {
			for (IngredienteDoItem ingrediente : item.getIngredientes().values()) {
				String nome_produto = ingrediente.getProduto().getNome().toLowerCase();
				ArrayList<String> id_lotes = gerLote.getAgrupamentoDeLotes().get(nome_produto);
				
				if (id_lotes == null)
						return false;
				
				Double quantidadeNoEstoque = 0.0;
				for (String id : id_lotes) 
						quantidadeNoEstoque += gerLote.getMap_estoque().get(id).getQuantidade_em_armazenamento();
				
				if (quantidadeNoEstoque < (ingrediente.getQuantidade_usada() * quantidade_item))
						return false;
			}
			return true;
		}
		
			
		public boolean editarNome(String novo_nome, ItemCardapio item) {
				item.setNome(novo_nome);
				return item.getNome().equals(novo_nome);
		}

		public boolean editarPreco(Double novo_preco, ItemCardapio item) {
				item.setPreco(novo_preco);
				return item.getPreco().equals(novo_preco);
		}
		
		public boolean editarCategoria(CategoriasDeItens nova_categoria, ItemCardapio item) {
				item.setCategoria(nova_categoria);
				return item.getCategoria().equals(nova_categoria);
		}
		
		public boolean editarProdutoDoIngrediente(Produto novo_produto, String id_selecionado, ItemCardapio item) {
			IngredienteDoItem ingrediente = item.getIngredientes().get(id_selecionado);
			if (ingrediente == null)
					return false;
			ingrediente.setProduto(novo_produto);
			return ingrediente.getProduto().equals(novo_produto);
		}
		
		public boolean editarQuantidadeDoIngrediente(Double nova_quantidade, String id_selecionado, ItemCardapio item) {
			IngredienteDoItem ingrediente = item.getIngredientes().get(id_selecionado);
			if (ingrediente == null)
					return false;
			ingrediente.setQuantidade_usada(nova_quantidade);
			return ingrediente.getQuantidade_usada().equals(nova_quantidade);
		}
		
		public boolean adicionarIngrediente(IngredienteDoItem novo_ingrediente, ItemCardapio item) {
			return adicionar(item.getIngredientes(), novo_ingrediente);
		}
		
		public boolean excluirIngrediente (String id_selecionado, ItemCardapio item) {
			return excluir(item.getIngredientes(), id_selecionado);
		}
}
