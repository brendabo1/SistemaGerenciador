package sistemaGeral.controllers;

import java.util.ArrayList;

import sistemaGeral.models.ItemCardapio;
import sistemaGeral.models.Venda;

public class GerenciamentoVenda extends GerenciamentoGeral {
			ArrayList<Venda> lista_vendas = new ArrayList<>();
			
			
			public boolean cadastrar(ArrayList<ItemCardapio> compras, String formaDePagamento) {
				String id = gerarID(this.lista_vendas, Venda.getPrefixo());
				Venda nova_venda = new Venda(id, compras, formaDePagamento);
				return adicionar(this.lista_vendas, nova_venda);
				
			}
			
			
			public boolean editarFormaDePagamento(String formaDePagamento, Venda venda) {
				venda.setForma_de_pagamento(formaDePagamento);
				return venda.getForma_de_pagamento().equals(formaDePagamento);
			}


			public ArrayList<Venda> getLista_vendas() {
				return lista_vendas;
			}


			public void setLista_vendas(ArrayList<Venda> lista_vendas) {
				this.lista_vendas = lista_vendas;
			}
			
			
}
