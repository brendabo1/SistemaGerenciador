package sistemaGeral.models.entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import sistemaGeral.models.entidades.enums.FormasDePagamento;

/**
 * Entidade referente a representacao de vendas no sistema.
 * @author Elmer Carvalho
 *@author Brenda Barbosa
 */
public class Venda extends EntidadesDoSistema{

		private LocalDate data = LocalDate.now();
		private LocalTime hora = LocalTime.now();
		private HashMap<String, CarrinhoDeCompra> itens_comprados;
		private Double preco_total;
		private FormasDePagamento forma_de_pagamento;
		final private static String preFixo = "VEN";

		/**
		 * Construtor de venda.
		 * @param id identificacao de venda.
		 * @param itens_comprados HashMap dos itens comprados.
		 * @param forma_de_pagamento forma de pagamento da venda.
		 */
		public Venda(String id,  HashMap<String, CarrinhoDeCompra> itens_comprados, FormasDePagamento forma_de_pagamento) {
			this.id = id;
			this.itens_comprados = itens_comprados;
			this.forma_de_pagamento = forma_de_pagamento;
			this.preco_total = calcularPrecoTotal();
		}
		
		
	@Override
	public String toString() {
		String message = String.format("%s  DATA: %s  HORA: %s  \nItem:\n", this.id, this.data, this.hora);
		
		for (CarrinhoDeCompra item: this.itens_comprados.values()) {
			message +=  item.getItem_comprado().getNome() +  "   R$" + item.getItem_comprado().getPreco() + item.getQuantidade_comprada() +"\n";
		}
		
		message += "PREÇO TOTAL  R$: " + this.preco_total + 
				"\nFORMA DE PAGAMENTO: " + this.forma_de_pagamento;
		
		return message;
	}
	
	public String linhaTituloToString() {
		String message = String.format("\n%2s %19s %22s %12s %s %s %s", "ID", "DATA", "HORA", "ITEM", "PRECO UNT", "QNT");
		return message;
	}

	
	private Double calcularPrecoTotal  () {
		Double preco_total = 0.0;
		for (CarrinhoDeCompra compra : itens_comprados.values()) {
			this.preco_total += compra.getPreco_compras();
		}
		return preco_total;
	}	
	


	public  HashMap<String, CarrinhoDeCompra> getItens_comprados() {
		return itens_comprados;
	}
	
	public void setItens_comprados( HashMap<String, CarrinhoDeCompra> itens_comprados) {
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

	
	public static String getPreFixo() {
		return preFixo;
	}

		
	public String formatarData(LocalDate data) {
		String dataFormatada = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return dataFormatada;
	}
	
	public String formatarHora(LocalTime hora) {
		String horaFormatada = data.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		return horaFormatada;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	public LocalTime getHora() {
		return hora;
	}


	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
}
