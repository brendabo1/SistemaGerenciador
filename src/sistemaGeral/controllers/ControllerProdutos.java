package sistemaGeral.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.Produto;
import sistemaGeral.models.entidades.enums.UnidadeMedida;
import sistemaGeral.models.gerenciadores.GerenciamentoFornecedor;
import sistemaGeral.models.gerenciadores.GerenciamentoProduto;
import sistemaGeral.models.validacoes.ValidaFornecedor;
import sistemaGeral.models.validacoes.ValidaProduto;
import sistemaGeral.views.ViewProduto;


public class ControllerProdutos {
	private GerenciamentoProduto gerenProduto;
	//private GerenciamentoFornecedor gerenFornecedor;
	private ViewProduto tela = new ViewProduto();
	private HashMap<String, Produto> map_produtos;	

	public ControllerProdutos(BancoDeDados bancoDados, ControllerFornecedor ctrFornecedor) {
		this.gerenProduto = new GerenciamentoProduto(bancoDados, ctrFornecedor);
		this.map_produtos = this.gerenProduto.getMap_produtos();
	}
	
	public int opcaoSubMenu() {
		int opcao = 0;	
		try {
			opcao = this.tela.subMenu();
				
		} catch (InputMismatchException e) {
			this.tela.exibirMensagem("\nInsira uma opcao valida");
		} catch (NoSuchElementException e) {
			this.tela.exibirMensagem("\nInsira uma opcao valida");
		}
		return opcao;
	
	}
	
	public void subMenu() {
		int opcao;
		boolean continuar = true;
		do {
			opcao = this.opcaoSubMenu();
			switch (opcao) {
			case 1: {this.cadastro(); break;}
			case 2: {this.edicao(); break;}
			case 3: {this.listagem(); break;}
			case 4: {this.exclusao(); break;}
			case 5: {continuar = false; break;}
			default:{this.tela.exibirMensagem("Insira uma opcao valida"); break;}
			}
		}while(continuar);	
	}
	
	public UnidadeMedida selecionaUnidadeMedida(int opcao) {
		UnidadeMedida und = null;
		boolean continuar = false;
		do {
			opcao = this.tela.menuUnidadeMedida();
			switch(opcao) {
			case 1: {und = UnidadeMedida.KG; break;}
			case 2: {und = UnidadeMedida.G; break;}
			case 3: {und = UnidadeMedida.L; break;}
			case 4: {und = UnidadeMedida.ML; break;}
			case 5: {und = UnidadeMedida.UNIDADE; break;}
			default:{this.tela.exibirMensagem("Insira uma opcao valida"); continuar =true; break;}
			}
		}while(continuar);
		return und;
	}
	
	public void cadastro() {
		ArrayList<String> dadosProduto;
		String nome, id_fornecedor;
		int op_undMedida;
		double qnt;
		UnidadeMedida und = null;
		Fornecedor fornecedor;
		ValidaProduto validacao = new ValidaProduto();
		Scanner input = new Scanner(System.in);
		
		try {	
			dadosProduto = this.tela.cadastro();
			nome = dadosProduto.get(0);
			id_fornecedor = dadosProduto.get(1);
			fornecedor = (Fornecedor) this.gerenProduto.buscarEntidade_ID(this.map_produtos, id_fornecedor);
			op_undMedida = this.tela.menuUnidadeMedida();
			und = this.selecionaUnidadeMedida(op_undMedida);
			this.tela.exibirMensagem("Quantidade conteudo por produto: ");
			qnt = input.nextDouble();
			if(validacao.isProdutoValido(nome, qnt, id_fornecedor, this.map_produtos)) {
				this.gerenProduto.cadastrar(nome, fornecedor, und, qnt);
				tela.exibirMensagem("Usuário cadastrado com sucesso");
			}
		} catch(NoSuchElementException e){
			tela.exibirMensagem("Produto nao cadastrado. \nInsira uma opcao valida");
		} catch (IllegalArgumentException e) {
			this.tela.exibirMensagem("Dados invalidos ou ja cadastrados\nProduto nao cadastrado");
		}
		
	}
	
	public void edicao(){
		String nome, id, cnpj, end;
		int opcao;
		Fornecedor fornecedor;
		ValidaFornecedor validacao = new ValidaFornecedor();
		Scanner input = new Scanner(System.in);
		
		try {
			id = this.tela.entraDado("ID: ");
			fornecedor = (Fornecedor) this.gerenFornecedor.buscarEntidade_ID(this.map_fornecedores, id);
			if(fornecedor != null) {
				opcao = this.tela.edicao();
				switch (opcao) {
				case 1: {
					nome = this.tela.entraDado("Novo nome: ");
					if(validacao.isNomeValido(nome)) this.gerenFornecedor.editarNome(nome, fornecedor);
					else throw new IllegalArgumentException();
					break;
					}
				case 2: {
					cnpj = this.tela.entraDado("Novo CNPJ: ");
					if(validacao.isCnpjValido(cnpj)) this.gerenFornecedor.editarCNPJ(cnpj, fornecedor); 
					else throw new IllegalArgumentException();
					break;
					}
				case 3: {
					end = this.tela.entraDado("Novo endereco: ");
					if(validacao.isEnderecoValido(end)) this.gerenFornecedor.editarEndereco(end, fornecedor); 
					else throw new IllegalArgumentException();
					break;
					}
				default:{this.tela.exibirMensagem("Insira uma opcao valida"); break;}
				}
			}
			tela.exibirMensagem("Fornecedor editado com sucesso");
		} catch(NoSuchElementException e){
			tela.exibirMensagem("Fornecedor nao cadastrado. \nInsira uma dado valido");
		} catch (IllegalArgumentException e) {
			this.tela.exibirMensagem("Dados invalidos\nFornecedor nao cadastrado");
		}
		
	}

}
