package sistemaGeral.controllers;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.gerenciadores.GerenciamentoUsuario;
import sistemaGeral.models.validacoes.ValidaUsuario;
import sistemaGeral.views.ViewUsuario;

public class ControllerUsuario {
	
	private GerenciamentoUsuario gerenUsuario;
	private ViewUsuario tela = new ViewUsuario();;	

	public ControllerUsuario(BancoDeDados bancoDados) {
		this.gerenUsuario = new GerenciamentoUsuario(bancoDados);
	}

	public void msgAbertura() {
		tela.boasVindas();
	}
	
	public boolean login(String id, String senha) {
		if(!this.gerenUsuario.loginID(id, senha))
			throw new IllegalArgumentException();
		else return true;
	}
	
	public boolean autenticarUser() {
		String id, senha;
		Scanner input = new Scanner(System.in);
		try {
			this.tela.login_ID();
			id = input.nextLine();
			this.tela.login_senha();
			senha = input.nextLine();
			this.login(id, senha);
			input.close();
			
		} catch (IllegalArgumentException e) {
			this.tela.exibirMensagemErro("ID ou Senha inválidos");
			return false;
		}
		
		return true;
	}
	
	public String menuInicial() {
		String opcao = null;
		Scanner input = new Scanner(System.in);
	
		try {
			tela.menuInicial();
			opcao = input.nextLine().trim();
				
		} catch (IllegalArgumentException e) {
			this.tela.exibirMensagemErro("\nInsira uma opcao valida");
		} catch (NoSuchElementException e) {
			this.tela.exibirMensagemErro("\nInsira uma opcao valida");
		}
		input.close();
		return opcao;
	
	}

	public String opcaoSubMenu() {
		String opcao = null;
		Scanner input = new Scanner(System.in);
	
		try {
			this.tela.subMenu();
			opcao = input.nextLine().trim();
				
		} catch (IllegalArgumentException e) {
			this.tela.exibirMensagemErro("\nInsira uma opcao valida");
		} catch (NoSuchElementException e) {
			this.tela.exibirMensagemErro("\nInsira uma opcao valida");
		}
		input.close();
		return opcao;
	
	}
	
	public void subMenu() {
		String opcao;
		boolean continuar = true;
		do {
			opcao = this.opcaoSubMenu();
			switch (opcao) {
			case "1": {this.cadastro(); break;}
			case "2": {this.edicao(); break;}
			case "3": {this.listagem(); break;}
			case "4": {this.exclusao(); break;}
			case "5": {continuar = false; break;}
			}
		}while(continuar);	
	}
		
	public void cadastro() {
		String nome, senha;
		ValidaUsuario validacao = new ValidaUsuario();
		Scanner input = new Scanner(System.in);
		try {
			this.tela.login_ID();
			id = input.nextLine();
			this.tela.login_senha();
			senha = input.nextLine();
			this.login(id, senha);
			input.close();
			
		} catch (IllegalArgumentException e) {
			this.tela.exibirMensagemErro("ID ou Senha inválidos");
		}
		
		
		validacao.isNomeValido(null)
		validacao.isSenhaValido(null)
	}
	
	
}
