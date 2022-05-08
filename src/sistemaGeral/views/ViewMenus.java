package sistemaGeral.views;

//home
public class ViewMenus {
	
	public static void exibirLinha() {
		System.out.println("\n-------------------------------------------------------");
	}
	
	
	public static void cabecalhoMenu(String titulo, int espacamento) {		
		ViewMenus.exibirLinha();
		for(int i=0; i < espacamento; i++) System.out.print(" ");	
		System.out.print(titulo);	
		ViewMenus.exibirLinha(); 

	}
	
	public static void menuInicial() {
		ViewMenus.cabecalhoMenu("MENU", 20);
		System.out.println("[1] Usuarios");
		System.out.println("[2] Fornecedores");
		System.out.println("[3] Cardapio");
		System.out.println("[4] Produtos"); //Apenas os produtos cadastrados no sistema
		System.out.println("[5] Vendas");
		System.out.println("[6] Estoque");  //Produtos e seus dados (validade, quantidade)
		System.out.println("Op��o: ");
		
	}
	
	
	public static void menuUsuario(String titulo, int espacamento) {
		//if(permissao) usuario.permissao
		ViewMenus.exibirLinha();
		ViewMenus.cabecalhoMenu(titulo, espacamento);	
		ViewMenus.exibirLinha(); 
		System.out.println("[1] Cadastrar");
		System.out.println("[2] Editar");
		System.out.println("[3] Listar");
		System.out.println("[4] Excluir");
		System.out.println("[5] Gerar PDF");
		
	}

}
