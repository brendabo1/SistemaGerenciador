package sistemaGeral.views;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ViewFornecedor {
	
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
		this.menus.subMenu_comPDF("FORNECEDOR", 20);
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
	
	
	public ArrayList<String> cadastro() throws NoSuchElementException{
		ArrayList<String> fornecedor = new ArrayList<>();
		String nome, cnpj, end;
		Scanner input = new Scanner(System.in);
		this.menus.cabecalhoMenu("CADASTRO", 20);
		System.out.println("Nome: ");
		nome = input.nextLine();
		fornecedor.add(nome);
		System.out.println("CNPJ: ");
		cnpj = input.nextLine();
		fornecedor.add(cnpj);
		System.out.println("Endereco: ");
		end = input.nextLine();
		fornecedor.add(end);
		return fornecedor;
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
