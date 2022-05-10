package sistemaGeral.models.gerenciadores;


import java.util.HashMap;



import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.CarrinhoDeCompra;
import sistemaGeral.models.entidades.IngredienteDoItem;
import sistemaGeral.models.entidades.ItemCardapio;
import sistemaGeral.models.entidades.Lote;
import sistemaGeral.models.entidades.Venda;
import sistemaGeral.models.entidades.enums.FormasDePagamento;

public class GerenciamentoVenda extends GerenciamentoGeral {
		private HashMap<String, Venda> map_vendas;
		private GerenciamentoItemCardapio gerItemCardapio;
		private GerenciamentoLote gerLote;
		
		public GerenciamentoVenda(BancoDeDados banco, GerenciamentoItemCardapio gerItemCardapio, GerenciamentoLote gerLote) {
			this.map_vendas = banco.getMap_vendas();
			this.gerItemCardapio = gerItemCardapio;
			this.gerLote = gerLote;
		}
		
		
		public Venda cadastrar(HashMap<String, CarrinhoDeCompra> itens_comprados, FormasDePagamento formaDePagamento) {
			String nova_id = gerarID(Venda.getPreFixo());
			Venda nova_venda = new Venda(nova_id, itens_comprados, formaDePagamento);
			if (adicionar(this.map_vendas, nova_venda))
				return nova_venda;
			return null;
		}
		

		public boolean editarFormaDePagamento (FormasDePagamento formaDePagamento, Venda venda) {
			venda.setForma_de_pagamento(formaDePagamento);
			return venda.getForma_de_pagamento().equals(formaDePagamento);
		}
		
		public boolean adicionarItemComprado (ItemCardapio item_comprado, Integer quantidade_comprada, Venda venda) {
			if (!gerItemCardapio.verificarSePodeSerVendido(item_comprado, quantidade_comprada))
					return false;
			
			for (IngredienteDoItem ingrediente :  item_comprado.getIngredientes().values()) {
				String nome_produto = ingrediente.getProduto().getNome().toLowerCase();
				gerLote.consumirLote(ingrediente.getQuantidade_usada() * quantidade_comprada, nome_produto);
			}
			
			for (CarrinhoDeCompra compra : venda.getItens_comprados().values()) {
				if (compra.getItem_comprado().getId() == item_comprado.getId()) {
					compra.setQuantidade_comprada(compra.getQuantidade_comprada() + quantidade_comprada);
					return true;
				}
			}
			
			String novo_id = gerarID(CarrinhoDeCompra.getPreFixo());
			CarrinhoDeCompra nova_compra = new CarrinhoDeCompra(item_comprado, quantidade_comprada, novo_id);
			venda.getItens_comprados().put(novo_id, nova_compra);
			return true;
		}

		public boolean removerItemComprado (String id_carrinhoCompras, Integer quantidade_retirada,Venda venda) {
			CarrinhoDeCompra compra = venda.getItens_comprados().get(id_carrinhoCompras);
			
			if (compra == null || quantidade_retirada <= 0 || quantidade_retirada > compra.getQuantidade_comprada())
					return false;
			
			String nome_produto = compra.getItem_comprado().getNome().toLowerCase();
			String id_lote = gerLote.getAgrupamentoDeLotes().get(nome_produto).get(0);
			Lote lote = gerLote.getMap_estoque().get(id_lote);
			
			Double valor_devolvido = lote.getProduto().getConteudo_produto() * quantidade_retirada;
			lote.setQuantidade_em_armazenamento(lote.getQuantidade_em_armazenamento() + valor_devolvido);
			
			compra.setQuantidade_comprada(compra.getQuantidade_comprada() - quantidade_retirada);
			if (compra.getQuantidade_comprada() == 0)
				venda.getItens_comprados().remove(compra.getId());
			return true;
		}
}
