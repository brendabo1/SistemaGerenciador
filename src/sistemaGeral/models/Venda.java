package sistemaGeral.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Venda extends EntidadesDoSistema{
		private String data;
		private String hora;
		private ArrayList<ItemCardapio> itens_comprados = new ArrayList<>();
		private Double preco_total = 0.0;
		private String forma_de_pagamento;
		private static final  String preFixo = "VEN";

		
		//private static final DateTimeFormatter padrao_hora = DateTimeFormatter.ofPattern("HH:mm:ss");
		//private static final DateTimeFormatter padrao_data = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		public Venda(ArrayList<ItemCardapio> itens_comprados, String forma_de_pagamento, String id) {
			itens_comprados = new ArrayList<>();			

			this.data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			this.hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			
			for (ItemCardapio item: itens_comprados) this.preco_total += item.getPreco();
			
			this.forma_de_pagamento = forma_de_pagamento;
			this.id = id;
		}
		
		
	@Override
	public String toString() {
		String string_retorno = "DATA: " + this.data + "HORA: " + this.hora + "   __   " +  "\nCOMPRAS:\n";
		
		for (ItemCardapio item: this.itens_comprados) {
			string_retorno +=  item.getNome() + " -- " + "R$" + item.getPreco() + "\n";
		}
		
		string_retorno += "PRE�O TOTAL R$: " + this.preco_total + "   __   " + "EFETUADO POR: " + this.forma_de_pagamento +
				"   __   " + "ID: " + id;
		
		return string_retorno;
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
		
	
}
