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
	
	public void login_ID() {
		String id;
		//Scanner input = new Scanner(System.in);
		this.menus.cabecalhoMenu("LOGIN", 20);
		System.out.println("ID: ");
		//id = input.nextLine().trim();
		//input.close();
	}
	
	public void login_senha() {
		String senha;
		System.out.println("SENHA: ");
		//Scanner input = new Scanner(System.in);
		//senha = input.nextLine().trim();
		
	}
	
	
	public void menuInicial() throws InputMismatchException, NoSuchElementException {
		int opcao;
		//Scanner input = new Scanner(System.in);
		this.menus.menuInicial();
		//opcao = input.nextInt();
		//input.close();
	}
	
	public void exibirMensagemErro(String mensagem) {
		System.out.println(mensagem);
	}
	
	public void subMenu() {
		this.menus.subMenu_semPDF("USUARIOS", 15);
	}
	
	public void cadastro() {
		this.menus.cabecalhoMenu("CADASTRO", 15);
	}
	
	

}
