package sistemaGeral.models.entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Venda extends EntidadesDoSistema{
		private String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		private String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
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
	
	
	public String getHora() {
		return this.hora;
	}
	
	public String getData() {
		return this.data;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}


	public void setData(String data) {
		this.data = data;
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
		
	
}
