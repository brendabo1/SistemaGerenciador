package sistemaGeral;


import sistemaGeral.controllers.ControllerFornecedor;
import sistemaGeral.controllers.ControllerProdutos;
import sistemaGeral.controllers.ControllerUsuario;
import sistemaGeral.models.BancoDeDados;


public class SistemaEstabelecimento {
		private boolean sistema_on = true;
		private BancoDeDados bancoDeDados = new BancoDeDados();
		private ControllerUsuario ctrUsuario = new ControllerUsuario(bancoDeDados);
		private ControllerFornecedor ctrFornecedor = new ControllerFornecedor(bancoDeDados);
		private ControllerProdutos ctrProduto = new ControllerProdutos(bancoDeDados, ctrFornecedor);
			
		public void run() {
			int opcao, op_submenu; 
			//String op_submenu;
			boolean userAutenticado;
			
			ctrUsuario.msgAbertura();
			do {
				userAutenticado = this.ctrUsuario.autenticarUser();
			}while(!userAutenticado);
			while(sistema_on) {
				opcao = ctrUsuario.menuInicial();
				switch(opcao) {
				case 1: {
					this.ctrUsuario.subMenu();
					
				break;
				}		
				
				case 2: {
					this.ctrFornecedor.subMenu();
					break;
				}
				
				case 3: {
					this.ctrProduto.subMenu();
					break;
				}
				
				case 4: {
					break;
				}
				
				case 5: {
					break;
				}
				
				case 6: {
					System.out.println("Programa Encerrado . . .");
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
			

		

}
