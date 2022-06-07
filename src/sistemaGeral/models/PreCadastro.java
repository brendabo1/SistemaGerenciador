package sistemaGeral.models;

import java.util.ArrayList;

import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.ItemCardapio;
import sistemaGeral.models.entidades.Produto;
import sistemaGeral.models.entidades.enums.UnidadeMedida;
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
		this.gerFornecedor.cadastrar("Seara ltda", "12345678900015", "Rua Vaco da Gama, n 251, Santa Monica, Feira de Santana");
		this.gerFornecedor.cadastrar("Distribuidora Camargo", "00012312332112", "Rua M, caminho 12, n 5, Cidade Nova Feira de Santana");
		this.gerFornecedor.cadastrar("Central das Massas ", "11112312330001", "Rua da Paz, n201, Algoinhas");
			
	}
	
	//Pre Cadastro Fornecedores
	public void preCadastrarProdutos() {
		this.gerProduto.cadastrar("Sacola Plastica", this.gerFornecedor.buscarEntidade_Nome(this.gerFornecedor.getLista_fornecedores(), "Martinez Embalagens"), UnidadeMedida.UNIDADE, 100.0);
		this.gerProduto.cadastrar("Molho de tomate", this.gerFornecedor.buscarEntidade_Nome(this.gerFornecedor.getLista_fornecedores(), "Molhos & cos"), UnidadeMedida.ML, 300.0);
		//this.gerProduto.cadastrar("Sacola", 0,50, null, null);
		
	}
	
	
	public void precadatrar() {
		Fornecedor fornecedorMolhos = new Fornecedor("ID00001", "Molhos & co", "12345678912345", "Rua do Molho, 3, Bairro Industrial, Camaçari"); 
		Fornecedor fornecedorFarinha = new Fornecedor("ID00002", "Distribuidora Camargo", "00012312332112", "Rua M, caminho 12, n 5, Cidade Nova Feira de Santana");
		Fornecedor fornecedorSeara = new Fornecedor("ID00003", "Seara ltda", "12345678912345", "BR324, Av Dep Luis Eduardo Magalhães, S/N, KM 529, Feira de Santana");
		Fornecedor fornecedorMassas = new Fornecedor("ID00004","Central das Massas", "11112312330001", "Rua da Paz, n201, Algoinhas");
		Produto molhoTomate= new Produto("ID00001", "Molho de Tomate", fornecedorMolhos, UnidadeMedida.ML, 300.0);
		Produto trigo= new Produto("ID00002", "Farinha de Trigo", fornecedorFarinha, UnidadeMedida.KG, 2.5);
		Produto frango = new Produto("ID00003", "Peito de Frango", fornecedorSeara, UnidadeMedida.KG, 1.0);
		ArrayList<Produto> ingredientes_bolinho = new ArrayList<>();
		ingredientes_bolinho.add(molhoTomate);
		ingredientes_bolinho.add(trigo);
		ingredientes_bolinho.add(frango);
		//ItemCardapio bolinhoDeFrango = new ItemCardapio("ID00001", "Bolinho de Frango Frito", ingredientes_bolinho, );
		
	}
	
	
	

}
