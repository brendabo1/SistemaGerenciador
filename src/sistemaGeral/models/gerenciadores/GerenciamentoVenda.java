package sistemaGeral.models.gerenciadores;


import java.util.HashMap;



import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.ItemCardapio;
import sistemaGeral.models.entidades.Venda;
import sistemaGeral.models.entidades.enums.FormasDePagamento;

public class GerenciamentoVenda extends GerenciamentoGeral {
		private HashMap<String, Venda> map_vendas;
		
		public GerenciamentoVenda(BancoDeDados banco) {
			this.map_vendas = banco.getMap_vendas();
		}
		
		
		public Venda cadastrar(HashMap<String, ItemCardapio> itens_comprados, FormasDePagamento formaDePagamento) {
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
		
		public boolean adicionarItemComprado (ItemCardapio novo_item, Venda venda) {
			venda.getItens_comprados().put(novo_item.getId(), novo_item);
			venda.setPreco_total(venda.getPreco_total() + novo_item.getPreco());
			return true;
		}
}
