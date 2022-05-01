package sistemaGeral.views;

public class Menus {
	public static void mensagemBemVindo() {
		Menus.cabecalhoMenu("BEM VINDO", 20);
		System.out.print("\nOlá¡, Gerente!\nBem Vindo ao SG, o Sistema de Gerenciamento \n"
				+ "pensado para atender microeempreendedores com soluções de automação comercial.\n\n"
				+ "Realize o cadastro para logar no sistema.\n");
	}
	
	
	public static void exibirLinha() {
		System.out.println("\n-------------------------------------------------------");
	}
	
	
	public static void cabecalhoMenu(String titulo, int espacamento) {		
		Menus.exibirLinha();
		for(int i=0; i < espacamento; i++) System.out.print(" ");	
		System.out.print(titulo);	
		Menus.exibirLinha(); 

	}
	
	public static void menuInicial() {
		Menus.cabecalhoMenu("MENU", 20);
		System.out.println("[1] Usuarios");
		System.out.println("[2] Fornecedores");
		System.out.println("[3] Cardapio");
		System.out.println("[4] Produtos");
		System.out.println("[5] Vendas");
		System.out.println("Opção: ");
		
	}
	
	
	public static void menuUsuario() {
		//if(permissao) usuario.permissao
		Menus.exibirLinha();
		Menus.cabecalhoMenu("MENU USUARIO", 15);	
		Menus.exibirLinha(); 
		System.out.println("[1] Usuarios");
		System.out.println("[2] Fornecedor");
		System.out.println("[3] Cardapio");
		System.out.println("[4] Produtos");
		System.out.println("[5] Vendas");
		
	}

}
