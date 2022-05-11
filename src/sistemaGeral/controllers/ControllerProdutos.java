package sistemaGeral.controllers;

import java.util.HashMap;

import sistemaGeral.models.BancoDeDados;


public class ControllerProdutos {
	private GerenciamentoFornecedor gerenFornecedor;
	private ViewFornecedor tela = new ViewFornecedor();
	private HashMap<String, Fornecedor> map_fornecedores;	

	public ControllerFornecedor(BancoDeDados bancoDados) {
		this.gerenFornecedor = new GerenciamentoFornecedor(bancoDados);
		this.map_fornecedores = this.gerenFornecedor.getMap_fornecedores();
	}

}
