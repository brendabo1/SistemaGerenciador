package sistemaGeral.views;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ViewProduto {
	private ViewMenus menus = new ViewMenus();
	
	
	public void exibirMensagem(String mensagem) {
		System.out.println(mensagem);
	}
	public void exibirCabecalho(String titulo) {
		this.menus.cabecalhoMenu(titulo, 20);
	}
	
	public int subMenu() throws InputMismatchException, NoSuchElementException {
		int opcao;
		Scanner input = new Scanner(System.in);
		this.menus.subMenu_semPDF("PRODUTO", 20);
		opcao = input.nextInt();
		return opcao;
	}
	
	public String entraDado(String msg) throws NoSuchElementException{
		String dado;
		Scanner input = new Scanner(System.in);	
		System.out.println(msg);
		dado = input.nextLine();
		return dado;
	}
	
	public int menuUnidadeMedida() throws InputMismatchException, NoSuchElementException {
		int opcao;
		Scanner input = new Scanner(System.in);
		System.out.println("Unidade de Medida do Produto: ");
		System.out.println("[1] Kilo(Kg)");
		System.out.println("[2] Grama(g)");
		System.out.println("[3] Litro(L)");
		System.out.println("[4] Mililito(mL)");
		System.out.println("[5] Unidade");
		opcao = input.nextInt();
		return opcao;
	}
	
	public ArrayList<String> cadastro() throws InputMismatchException, NoSuchElementException{
		ArrayList<String> produto = new ArrayList<>();
		String nome, idFornecedor;
		Scanner input = new Scanner(System.in);
		
		this.menus.cabecalhoMenu("CADASTRO", 20);
		System.out.println("Produto: ");
		nome = input.nextLine();
		produto.add(nome);
		System.out.println("ID Fornecedor: ");
		idFornecedor = input.nextLine();
		produto.add(idFornecedor);
		return produto;
	}
	
	
	
	public int edicao() throws NoSuchElementException, IllegalStateException, InputMismatchException {
		int op;
		Scanner input = new Scanner(System.in);
		this.menus.cabecalhoMenu("EDICAO", 20);
		System.out.println("[1] Nome");
		System.out.println("[2] CNPJ");
		System.out.println("[3] Endereco");
		System.out.println("Opçao: ");
		op = input.nextInt();
		return op;
		
	}
}
