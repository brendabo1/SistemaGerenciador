package sistemaGeral.views;

import java.util.Scanner;

public class ViewUsuario {
	
	private ViewMenus menus = new ViewMenus();
	
	public void boasVindas() {
		this.menus.cabecalhoMenu("BEM VINDO", 20);
		System.out.print("\nBem Vindo ao SG, um Sistema de Gerenciamento \n"
				+ "pensado para atender microeempreendedores com soluções de automação comercial.\n\n"
				+ "Realize o cadastro para logar no sistema.\n");
	}
	
	public String login_ID() {
		String id;
		Scanner input = new Scanner(System.in);
		this.menus.cabecalhoMenu("LOGIN", 20);
		System.out.println("ID: ");
		id = input.nextLine().trim();
		input.close();
		return id;
	}
	
	public String login_senha() {
		String senha;
		System.out.println("SENHA: ");
		Scanner input = new Scanner(System.in);
		senha = input.nextLine().trim();
		input.close();
		return senha;
	}
	
	

}
