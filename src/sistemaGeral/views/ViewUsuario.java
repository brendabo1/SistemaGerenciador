package sistemaGeral.views;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ViewUsuario {
	
	private ViewMenus menus = new ViewMenus();
	
	public void boasVindas() {
		this.menus.cabecalhoMenu("BEM VINDO", 20);
		System.out.print("\nBem Vindo ao SG, um Sistema de Gerenciamento \n"
				+ "pensado para atender microeempreendedores com solucoes de automacao comercial.\n\n"
				+ "Realize o cadastro para logar no sistema.\n");
	}
	
	public String login_ID() throws NoSuchElementException{
		String id;
		Scanner input = new Scanner(System.in);
		this.menus.cabecalhoMenu("LOGIN", 20);
		System.out.println("ID: ");
		id = input.nextLine().trim();
		return id;
	}
	
	public String login_senha() {
		String senha;
		Scanner input = new Scanner(System.in);
		System.out.println("SENHA: ");
		senha = input.nextLine();
		return senha;
	}
	
	
	public int menuInicial() throws InputMismatchException, NoSuchElementException {
		int opcao;
		Scanner input = new Scanner(System.in);
		this.menus.menuInicial();
		opcao = input.nextInt();
		return opcao;
		
	}
	
	public void exibirMensagem(String mensagem) {
		System.out.println(mensagem);
	}
	public void exibirCabecalho(String titulo) {
		this.menus.cabecalhoMenu(titulo, 20);
	}
	
	public int subMenu() throws InputMismatchException, NoSuchElementException {
		int opcao;
		Scanner input = new Scanner(System.in);
		this.menus.subMenu_semPDF("USUARIOS", 20);
		opcao = input.nextInt();
		return opcao;
	}
	
	public String cadastro() throws NoSuchElementException{
		String nome;
		Scanner input = new Scanner(System.in);
		this.menus.cabecalhoMenu("CADASTRO", 20);
		System.out.println("Nome: ");
		nome = input.nextLine();
		return nome;
	}
	
	

}
