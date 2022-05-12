package sistemaGeral.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.Usuario;
import sistemaGeral.models.gerenciadores.GerenciamentoFornecedor;
import sistemaGeral.models.validacoes.ValidaFornecedor;
import sistemaGeral.models.validacoes.ValidaUsuario;
import sistemaGeral.views.ViewFornecedor;


public class ControllerFornecedor {

	private GerenciamentoFornecedor gerenFornecedor;
	private ViewFornecedor tela = new ViewFornecedor();
	private HashMap<String, Fornecedor> map_fornecedores;	

	public ControllerFornecedor(BancoDeDados bancoDados) {
		this.gerenFornecedor = new GerenciamentoFornecedor(bancoDados);
		this.map_fornecedores = this.gerenFornecedor.getMap_fornecedores();S
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
			//case 4: {this.gerarPDF(); break;}
			case 5: {this.exclusao(); break;}
			case 6: {continuar = false; break;}
			default:{this.tela.exibirMensagem("Insira uma opcao valida"); break;}
			}
		}while(continuar);	
	}
	
	public void cadastro() {
		ArrayList<String> dadosFornecddor;
		String nome, cnpj, end;
		ValidaFornecedor validacao = new ValidaFornecedor();
		Scanner input = new Scanner(System.in);
		
		try {	
			dadosFornecddor = this.tela.cadastro();
			nome = dadosFornecddor.get(0);
			cnpj = dadosFornecddor.get(1);
			end = dadosFornecddor.get(2);
			if(validacao.isFornecedorValido(nome, cnpj, end, this.map_fornecedores)) {
				tela.exibirMensagem("Usuário cadastrado com sucesso");
			}
		} catch(NoSuchElementException e){
			tela.exibirMensagem("Fornecedor nao cadastrado. \nInsira uma opcao valida");
		} catch (IllegalArgumentException e) {
			this.tela.exibirMensagem("Dados invalidos ou ja cadastrados\nFornecedor nao cadastrado");
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
	
	public void listagem(){
		String fornecedores, topo = String.format("\n%2s %19s %22s %12s", "ID", "CNPJ", "NOME", "ENDERECO");
		
		this.tela.exibirCabecalho("FORNECEDORES");
		fornecedores = this.gerenFornecedor.listar(this.map_fornecedores);
		if(fornecedores == null)
			this.tela.exibirMensagem("Nenhum usuario cadastrado");
		else {
			this.tela.exibirMensagem(topo);
			this.tela.exibirMensagem(fornecedores);
		}
	}
	
	public void exclusao() {
		String id;

		try {
			this.tela.exibirCabecalho("EXCLUIR");
			id = this.tela.entraDado("ID: ");
			this.gerenFornecedor.buscarEntidade_ID(this.map_fornecedores, id);
			this.gerenFornecedor.excluir(this.map_fornecedores, id);
			tela.exibirMensagem("Usuário excluido com sucesso");
		} catch(NoSuchElementException e){
			this.tela.exibirMensagem(e.getMessage());
		} catch (IllegalArgumentException e) {
			this.tela.exibirMensagem("Valor Invalido");
		}
	}
	
	
}
