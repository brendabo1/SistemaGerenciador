package sistemaGeral.models.entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Venda extends EntidadesDoSistema{
		private LocalDate data = LocalDate.now();
		private LocalTime hora = LocalTime.now();
		private ArrayList<ItemCardapio> itens_comprados = new ArrayList<>();
		private Double preco_total = 0.0;
		private String forma_de_pagamento;
		private static String preFixo = "VEN";


		public Venda(String id, ArrayList<ItemCardapio> itens_comprados, String forma_de_pagamento) {
			itens_comprados = new ArrayList<>();			
			for (ItemCardapio item: itens_comprados) this.preco_total += item.getPreco();
			
			this.forma_de_pagamento = forma_de_pagamento;
			this.id = id;
		}
		
		
	@Override
	public String toString() {
		String message = String.format("ID: %s  DATA: %s  HORA: %s  \nCOMPRAS:\n", this.id, this.data, this.hora);
		
		for (ItemCardapio item: this.itens_comprados) {
			message +=  item.getNome() + "   R$" + item.getPreco() + "\n";
		}
		
		message += "PREÇO TOTAL  R$: " + this.preco_total + 
				"\nFORMA DE PAGAMENTO: " + this.forma_de_pagamento;
		
		return message;
	}
	

	public ArrayList<ItemCardapio> getItens_comprados() {
		return itens_comprados;
	}

	public void setItens_comprados(ArrayList<ItemCardapio> itens_comprados) {
		this.itens_comprados = itens_comprados;
	}

	public Double getPreco_total() {
		return preco_total;
	}

	public void setPreco_total(Double preco_total) {
		this.preco_total = preco_total;
	}

	public String getForma_de_pagamento() {
		return forma_de_pagamento;
	}

	public void setForma_de_pagamento(String forma_de_pagamento) {
		this.forma_de_pagamento = forma_de_pagamento;
	}
	
	public static String getPrefixo() {
		return preFixo;
	}


	public static String getPreFixo() {
		return preFixo;
	}


	public static void setPreFixo(String preFixo) {
		Venda.preFixo = preFixo;
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
