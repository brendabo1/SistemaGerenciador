package sistemaGeral.models.entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import sistemaGeral.models.entidades.enums.FormasDePagamento;

public class Venda extends EntidadesDoSistema{
		private String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		private String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		private HashMap<String, HashMap<ItemCardapio, Integer>> itens_comprados;
		private Double preco_total = 0.0;
		private FormasDePagamento forma_de_pagamento;


		public Venda(String id, HashMap<String, HashMap<ItemCardapio, Integer>> itens_comprados, FormasDePagamento forma_de_pagamento) {
			this.id = id;
			this.itens_comprados = itens_comprados;
			this.forma_de_pagamento = forma_de_pagamento;
			
			for (ItemCardapio item : itens_comprados.values())
				this.preco_total += item.getPreco();
			
			Venda.preFixo = "VEN";
		}
		
		
	@Override
	public String toString() {
		String message = String.format("ID: %s  DATA: %s  HORA: %s  \nCOMPRAS:\n", this.id, this.data, this.hora);
		
		for (ItemCardapio item: this.itens_comprados.values()) {
			message +=  item.getNome() + "   R$" + item.getPreco() + "\n";
		}
		
		message += "PREÇO TOTAL  R$: " + this.preco_total + 
				"\nFORMA DE PAGAMENTO: " + this.forma_de_pagamento;
		
		return message;
	}
	
	
	private Double calcularPrecoTotal  () {
		for (HashMap<ItemCardapio, Integer> map : this.itens_comprados.values()) {
			this.preco_total += map.
		}
	}	
	
	
	public String getHora() {
		return this.hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public String getData() {
		return this.data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public HashMap<String, HashMap<ItemCardapio, Integer>> getItens_comprados() {
		return itens_comprados;
	}
	public void setItens_comprados(HashMap<String, HashMap<ItemCardapio, Integer>> itens_comprados) {
		this.itens_comprados = itens_comprados;
	}

	public Double getPreco_total() {
		return preco_total;
	}
	public void setPreco_total(Double preco_total) {
		this.preco_total = preco_total;
	}

	public FormasDePagamento getForma_de_pagamento() {
		return forma_de_pagamento;
	}
	public void setForma_de_pagamento(FormasDePagamento forma_de_pagamento) {
		this.forma_de_pagamento = forma_de_pagamento;
	}
}
