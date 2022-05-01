package sistemaGeral;

import java.util.Scanner;

import sistemaGeral.models.gerenciadores.GerenciamentoFornecedor;
import sistemaGeral.models.gerenciadores.GerenciamentoItemCardapio;
import sistemaGeral.models.gerenciadores.GerenciamentoProduto;
import sistemaGeral.models.gerenciadores.GerenciamentoUsuario;
import sistemaGeral.models.gerenciadores.GerenciamentoVenda;
import sistemaGeral.views.ViewFornecedor;
import sistemaGeral.views.ViewItemCardapio;
import sistemaGeral.views.ViewProduto;
import sistemaGeral.views.ViewUsuario;
import sistemaGeral.views.ViewVenda;

public class SistemaEstabelecimento {
		public static GerenciamentoUsuario gerUsuario = new GerenciamentoUsuario();
		public static GerenciamentoFornecedor gerFornecedor = new GerenciamentoFornecedor();
		public static GerenciamentoProduto gerProduto = new GerenciamentoProduto();
		public static GerenciamentoItemCardapio gerItemCardapio = new GerenciamentoItemCardapio();
		public static GerenciamentoVenda gerVenda = new GerenciamentoVenda();
		
		
		public static ViewUsuario view_Usuario = new ViewUsuario(gerUsuario);
		public static ViewProduto view_Produto = new ViewProduto(gerProduto);
		public static ViewFornecedor view_Fornecedor = new ViewFornecedor(gerFornecedor);
		public static ViewItemCardapio  view_ItemCardapio = new ViewItemCardapio(gerItemCardapio, gerProduto);
		public static ViewVenda view_Venda = new ViewVenda(gerVenda, gerItemCardapio);
				

		
		public static void main(String[] args) {
			/*
			Antigo pre-cadastro de itens
			
			gerProduto.cadastrar("Banana", 1.5, "21/04/2022");
			gerProduto.cadastrar("Molho de Tomate", 3.0, "17/09/2023");
			gerProduto.cadastrar("Pimenta Malagueta", 7.85, "18/06/2022");
			gerProduto.cadastrar("Creme de Leite", 4.50, "29/11/2023");
			*/
			gerFornecedor.cadastrar("Carro do Ovo", "43442567854326", "Rua Santo Antonio");
			gerFornecedor.cadastrar("Lanches Mania", "8922567854326", "Avenida Dutra");
			gerFornecedor.cadastrar("Nestl�", "43442567424326", "Pra�a do Juazeiro");
			
			
			boolean sistema_on = true;
			Scanner input = new Scanner(System.in);
			while (sistema_on) {
				
					if (gerUsuario.getLista_usuarios().isEmpty()) {
						view_Usuario.cadastro();
					}
					
					boolean menu = true;
					while (menu) {
						System.out.print("\n[1] - USUARIOS \n[2] - PRODUTOS \n[3] - FORNECEDORES \n[4] - VENDAS "
								+ "\n[5] - ITENS DO CARDAPIO \n[6] - SAIR DO PROGRAMA  \nOP��O: ");
						String primeira_escolha = input.next().strip();
						
						switch(primeira_escolha) {
							case "1": {
								menu_switch(1);
								break;
								
							}
							case "2": {
								menu_switch(2);
								break;
							}
							
							case "3": {
								menu_switch(3);
								break;
							}
							
							case "4": {
								menu_switch(4);
								break;
							}
							
							case "5": {
								menu_switch(5);
								break;
							}
							
							case "6": {
								System.out.println("Programa Encerrado . . .");
								menu = false;
								sistema_on = false;
								break;
							}
							
							default: {
								System.out.println("Digite 1, 2, 3, 4, 5 ou 6");
								break;
							}
							
						}
					}
			}

			
		}



		public static void menu_switch(int num) {
			Scanner input = new Scanner(System.in);
			
			boolean continuar_menu_switch = true;
			
			do {
				System.out.print("\n[1] - CADASTRAR \n[2] - EXCLUIR \n[3] - LISTAR \n[4] - EDITAR \nOp��o: ");
				String opcao = input.next().strip();
				
				switch (opcao) {
					case "1": {
							switch (num) {
								case 1: {view_Usuario.cadastro(); break;}
								case 2: {view_Produto.cadastro(); break;}
								case 3: {view_Fornecedor.cadastro(); break;}
								case 4: {view_Venda.cadastro(); break;}
								case 5: { view_ItemCardapio.cadastro(); break;}
							}
							continuar_menu_switch = false;
							break;
				  }
					case "2": {
						switch (num) {
							case 1: {view_Usuario.excluir(); break;}
							case 2: {view_Produto.excluir(); break;}
							case 3: {view_Fornecedor.excluir(); break;}
							case 4: {view_Venda.excluir(); break;}
							case 5: { view_ItemCardapio.excluir(); break;}
						}	
						continuar_menu_switch = false;
						break;
					}
					case "3": {							
						switch (num) {
							case 1: {gerUsuario.listar(gerUsuario.getLista_usuarios()); break;}
							case 2: {gerProduto.listar(gerProduto.getLista_produtos()); break;}
							case 3: {gerFornecedor.listar(gerFornecedor.getLista_fornecedores()); break;}
							case 4: {gerVenda.listar(gerVenda.getLista_vendas()); break;}
							case 5: {gerItemCardapio.listar(gerItemCardapio.getLista_itensCardapio()); break;}
						}
						continuar_menu_switch = false;
						break;
					}
					case "4": {
						switch (num) {
							case 1: {view_Usuario.editar(); break;}
							case 2: {view_Produto.editar(); break;}
							case 3: {view_Fornecedor.editar(); break;}
							case 4: {view_Venda.editar(); break;}
							case 5: { view_ItemCardapio.editar(); break;}
						}	
						continuar_menu_switch = false;
						break;
					}
					default: {
						System.out.println("Digite 1, 2, 3 ou 4");
						break;
					}
			}	
		} while (continuar_menu_switch);
		}
		
}
