package sistemaGeral.models.gerenciadores;

import sistemaGeral.models.BancoDeDados;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import com.itextpdf.text.DocumentException;

import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.Produto;
import sistemaGeral.models.entidades.Venda;
import sistemaGeral.models.entidades.enums.UnidadeMedida;

public class TESTE_GERENCIAMENTO {
	

		public void outro() throws FileNotFoundException, DocumentException {
			//GerenciamentoFornecedor GE = new GerenciamentoFornecedor();
			
			//for (int i = 0; i < 10; i++) System.out.println(GE.gerarID("FOR"));
			/*BancoDeDados banco_teste = new BancoDeDados();
			GerenciamentoFornecedor gerenciamentoF = new GerenciamentoFornecedor(banco_teste);
			GerenciamentoProduto gerenciamento = new GerenciamentoProduto(banco_teste, gerenciamentoF);
			Fornecedor fornecedor2 = gerenciamentoF.cadastrar("nome bla", "12345678912345", "Endereco qualquer rua tal");
			Produto produto1 = gerenciamento.cadastrar("nome bla", fornecedor2, UnidadeMedida.KG, 2.5);
			//Produto produto2 = gerenciamento.cadastrar("nome bla", fornecedor2, UnidadeMedida.KG, 2.5);
			
			TESTE t = new TESTE();
			String message = String.format("%s%10s\n", "muuuuuuito grande", "coluna");
			t.gerarPDF("Produto", banco_teste);
			*/
			String titulo = "Vendas no Mês " + 3;
			System.out.print(titulo);
	
			BancoDeDados banco = new BancoDeDados();
			GerenciamentoFornecedor gerFornecedor = new GerenciamentoFornecedor(banco);
			
			gerFornecedor.cadastrar("Mario", "9821", "Rua Antonio");
			gerFornecedor.cadastrar("Rogerio", "4312", "Praça da Margarida");
			gerFornecedor.cadastrar("Joana", "4333", "Cidade Nova");
			//ArrayList<Fornecedor>
			HashMap <String, Venda> hash = banco.getMap_vendas();
			Collection<Venda> testeCollection = hash.values();
			ArrayList<Venda> merda = new ArrayList<>(testeCollection);
			Collections.sort(merda, new SortbyCategoriaPrato());
			
			System.out.println(gerFornecedor.listar(gerFornecedor.getMap_fornecedores()));

		}
		
		public void mainAntigo() {
			boolean sistema_on = true;
			Scanner input = new Scanner(System.in);
			while (sistema_on) {
				
					if (gerUsuario.getLista_usuarios().isEmpty()) {
						view_Usuario.cadastro();
					}
					
					boolean menu = true;
					while (menu) {
						System.out.print("\n[1] - USUARIOS \n[2] - PRODUTOS \n[3] - FORNECEDORES \n[4] - VENDAS "
								+ "\n[5] - ITENS DO CARDAPIO \n[6] - SAIR DO PROGRAMA  \nOPï¿½ï¿½O: ");
						String primeira_escolha = input.next().strip();
						
						switch(primeira_escolha) {
							case "1": {
								this.submenus(1);
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



		public void submenus(int num) {
			
			boolean continuar = true;
			
			do {
				
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
>>>>>>> 274760bbc9b264d2801c042ca4d547fa12f2086f

}

