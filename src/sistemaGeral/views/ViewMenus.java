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
		System.out.println("[5] Lote");
		System.out.println("[6] Vendas");
		System.out.println("[7] Estoque");
		System.out.println("[8] Sair");
		System.out.println("Opçao: ");
		
	}
	
	
	public void subMenu_comPDF(String titulo, int espacamento) {
		this.cabecalhoMenu(titulo, espacamento);	
		System.out.println("[1] Cadastrar");
		System.out.println("[2] Editar");
		System.out.println("[3] Listar");
		System.out.println("[4] Excluir");
		System.out.println("[5] Gerar PDF");
		System.out.println("[6] Voltar");
		System.out.println("Opçao: ");
		
	}
	
	public void subMenu_semPDF(String titulo, int espacamento) {
		this.cabecalhoMenu(titulo, espacamento);	
		System.out.println("[1] Cadastrar");
		System.out.println("[2] Editar");
		System.out.println("[3] Listar");
		System.out.println("[4] Excluir");
		System.out.println("[5] Voltar");
		System.out.println("Opçao: ");
		
	}
	
	//public void printMensagem

}
