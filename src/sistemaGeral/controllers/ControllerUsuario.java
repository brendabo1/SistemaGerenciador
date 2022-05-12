package sistemaGeral.controllers;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Usuario;
import sistemaGeral.models.gerenciadores.GerenciamentoUsuario;
import sistemaGeral.models.validacoes.ValidaUsuario;
import sistemaGeral.views.ViewUsuario;

public class ControllerUsuario {
	
	private GerenciamentoUsuario gerenUsuario;
	private ViewUsuario tela = new ViewUsuario();
	private HashMap<String, Usuario> map_usuarios;	

	public ControllerUsuario(BancoDeDados bancoDados) {
		this.gerenUsuario = new GerenciamentoUsuario(bancoDados);
		map_usuarios = this.gerenUsuario.getMap_usuarios();
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
			id = this.tela.login_ID();
			senha = this.tela.login_senha();
			this.login(id, senha);
			
		} catch (IllegalArgumentException e) {
			this.tela.exibirMensagem("ID ou Senha inválidos");
			return false;
		} catch (NoSuchElementException e) {
			this.tela.exibirMensagem("ID ou Senha inválidos");
			return false;
		}
		
		return true;
	}
	
	public int menuInicial() {
		int opcao = 0;
		try {
		opcao = tela.menuInicial();		
		} catch (InputMismatchException e) {
			this.tela.exibirMensagem("\nInsira uma opcao valida");
		} catch (NoSuchElementException e) {
			this.tela.exibirMensagem("\nInsira uma opcao valida");
		}	
		return opcao;
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
	
	
	public void cadastro() {
		String nome, senha;
		ValidaUsuario validacao = new ValidaUsuario();
		Scanner input = new Scanner(System.in);
		
		try {
			
			nome = this.tela.cadastro();
			tela.exibirMensagem("Senha: ");
			senha = input.nextLine();
			if(validacao.isUsuarioValido(nome, senha)) {
				this.gerenUsuario.cadastrar(nome, senha);
				tela.exibirMensagem("Usuário cadastrado com sucesso");
			}
		} catch(NoSuchElementException e){
			tela.exibirMensagem("Usuário nao cadastrado. \nInsira uma opcao valida");
		} catch (IllegalArgumentException e) {
			this.tela.exibirMensagem("Usuário nao cadastrado. \nNome ou senha muito curtos");
		}
		
	}
	
	public void edicao(){
		String nome, id, senha;
		Usuario user;
		int opcao; 
		ValidaUsuario validacao = new ValidaUsuario();
		Scanner input = new Scanner(System.in);
		
		try {
			this.tela.exibirCabecalho("EDITAR");
			tela.exibirMensagem("ID: ");
			id = input.nextLine();
			user = (Usuario) this.gerenUsuario.buscarEntidade_ID(this.map_usuarios, id);
			if(user != null) {
				opcao = this.tela.edicao();
				switch (opcao) {
				case 1: {
					nome = this.tela.entraDado("Novo nome: ");
					if(validacao.isNomeValido(nome)) this.gerenUsuario.editarNome(nome, user);
					else throw new IllegalArgumentException();
					break;
					}
				case 2: {
					senha = this.tela.entraDado("Nova senha: ");
					if(validacao.isSenhaValido(senha)) this.gerenUsuario.editarSenha(senha, user);
					else throw new IllegalArgumentException();
					break;
					}
				}
			}
			tela.exibirMensagem("Usuário editado com sucesso");
		} catch(NoSuchElementException e){
			this.tela.exibirMensagem(e.getMessage());
		} catch (IllegalArgumentException e) {
			this.tela.exibirMensagem(e.getMessage());
		}
		
	}
	
	public void listagem(){
		String usuarios, topo = String.format("%10s %10s", "ID", "NOME");;
		
		this.tela.exibirCabecalho("USUARIOS");
		usuarios = this.gerenUsuario.listar(this.map_usuarios);
		if(usuarios == null)
			this.tela.exibirMensagem("Nenhum usuario cadastrado");
		else {
			this.tela.exibirMensagem(topo);
			this.tela.exibirMensagem(usuarios);
		}
	}
	
	public void exclusao() {
		String id;
		Usuario user;
		Scanner input = new Scanner(System.in);
		try {
			this.tela.exibirCabecalho("EXCLUIR");
			tela.exibirMensagem("ID: ");
			id = input.nextLine();
			user = (Usuario) this.gerenUsuario.buscarEntidade_ID(this.map_usuarios, id);
			this.gerenUsuario.excluir(this.map_usuarios, id);
			tela.exibirMensagem("Usuário excluido com sucesso");
		} catch(NoSuchElementException e){
			this.tela.exibirMensagem(e.getMessage());
		} catch (IllegalArgumentException e) {
			this.tela.exibirMensagem("Valor Invalido");
		}
	}
	
	
}
