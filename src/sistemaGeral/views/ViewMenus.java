package sistemaGeral.views;

//home
public class ViewMenus {
	
	private void exibirLinha() {
		System.out.println("\n-------------------------------------------------------");
	}
	
	
	public void cabecalhoMenu(String titulo, int espacamento) {		
		this.exibirLinha();
		for(int i=0; i < espacamento; i++) System.out.print(" ");	
		System.out.print(titulo);	
		this.exibirLinha(); 

	}
	
	public void menuInicial() {
		this.cabecalhoMenu("MENU", 20);
		System.out.println("[1] Usuarios");
		System.out.println("[2] Fornecedores");
		System.out.println("[3] Cardapio");
		System.out.println("[4] Produtos"); //Apenas os produtos cadastrados no sistema
		System.out.println("[5] Vendas");
		System.out.println("[6] Estoque");  //Produtos e seus dados (validade, quantidade)
		System.out.println("Opçao: ");
		
	}
	
	
	public void subMenu_comPDF(String titulo, int espacamento) {

		this.exibirLinha();
		this.cabecalhoMenu(titulo, espacamento);	
		this.exibirLinha(); 
		System.out.println("[1] Cadastrar");
		System.out.println("[2] Editar");
		System.out.println("[3] Listar");
		System.out.println("[4] Excluir");
		System.out.println("[5] Gerar PDF");
		
	}
	
	public void subMenu_semPDF(String titulo, int espacamento) {
		this.exibirLinha();
		this.cabecalhoMenu(titulo, espacamento);	
		this.exibirLinha(); 
		System.out.println("[1] Cadastrar");
		System.out.println("[2] Editar");
		System.out.println("[3] Listar");
		System.out.println("[4] Excluir");
		
	}
	
	//public void printMensagem

}
