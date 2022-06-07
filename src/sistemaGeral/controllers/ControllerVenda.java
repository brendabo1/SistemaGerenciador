package sistemaGeral.controllers;

import java.util.HashMap;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Venda;
import sistemaGeral.models.gerenciadores.GerenciamentoItemCardapio;
import sistemaGeral.models.gerenciadores.GerenciamentoVenda;
import sistemaGeral.views.ViewFornecedor;

public class ControllerVenda {
	private GerenciamentoVenda gerenVenda;
	private ViewFornecedor tela = new ViewFornecedor();
	private HashMap<String, Venda> map_vendas;	

	public ControllerVenda(BancoDeDados bancoDados) {
		this.gerenVenda = new GerenciamentoVenda(bancoDados);
		this.map_vendas = bancoDados.getMap_vendas();
	}

}
