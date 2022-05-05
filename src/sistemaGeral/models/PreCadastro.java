package sistemaGeral.models;

import sistemaGeral.models.gerenciadores.GerenciamentoFornecedor;
import sistemaGeral.models.gerenciadores.GerenciamentoItemCardapio;
import sistemaGeral.models.gerenciadores.GerenciamentoProduto;
import sistemaGeral.models.gerenciadores.GerenciamentoUsuario;
import sistemaGeral.models.gerenciadores.GerenciamentoVenda;

public class PreCadastro {
	private GerenciamentoUsuario gerUsuario = new GerenciamentoUsuario();
	private GerenciamentoFornecedor gerFornecedor = new GerenciamentoFornecedor();
	private GerenciamentoProduto gerProduto = new GerenciamentoProduto();
	private GerenciamentoItemCardapio gerItemCardapio = new GerenciamentoItemCardapio();
	private GerenciamentoVenda gerVenda = new GerenciamentoVenda();
	
	//Pre Cadastro Fornecedores
	public void preCadastrarFornecedores() {  
		this.gerFornecedor.cadastrar("Molhos & co", "12345678912345", "Rua do Molho, 3, Bairro Industrial, Camaçari");
		this.gerFornecedor.cadastrar("Martinez Embalagens", "12345678900015", "Rua Vaco da Gama, n 251, Santa Monica, Feira de Santana");
		this.gerFornecedor.cadastrar("Distribuidora Camargo", "00012312332112", "Rua M, caminho 12, n 5, Cidade Nova Feira de Santana");
		this.gerFornecedor.cadastrar("Central dos Papeis", "11112312330001", "Rua da Paz, n201, Algoinhas");
			
	}
	
	//Pre Cadastro Fornecedores
	public void preCadastrarProdutos() {
		this.gerProduto.cadastrar("Sacola", 0,50, null, null);
		
	}
	
	
	

}
