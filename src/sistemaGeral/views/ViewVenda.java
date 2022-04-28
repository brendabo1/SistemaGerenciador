package sistemaGeral.views;

import java.util.ArrayList;
import java.util.Scanner;

import sistemaGeral.controllers.GerenciamentoItemCardapio;
import sistemaGeral.controllers.GerenciamentoVenda;
import sistemaGeral.controllers.validacoes.ValidarVenda;
import sistemaGeral.models.ItemCardapio;
import sistemaGeral.models.Produto;
import sistemaGeral.models.Venda;

public class ViewVenda {
		private ArrayList<ItemCardapio> compras;
		private String formaDePagamento;
		private GerenciamentoVenda gerenciamento_venda = new GerenciamentoVenda();
		private GerenciamentoItemCardapio gerenciamento_itemCardapio = new GerenciamentoItemCardapio();
		
		public ViewVenda(GerenciamentoVenda gerenciamento_venda, GerenciamentoItemCardapio gerenciamento_itemCardapio) {
			this.gerenciamento_venda = gerenciamento_venda;
			this.gerenciamento_itemCardapio = gerenciamento_itemCardapio;
			this.compras = new ArrayList<>();
		}
		
		public void cadastro() {
			if (gerenciamento_itemCardapio.getLista_itensCardapio().isEmpty())
				System.out.println("--> Atualmente n�o h� itens cadastrados dispon�veis para venda <--");
			else {
				Scanner input = new Scanner(System.in);
				boolean continuar_registrando_compra = true;
				do {
					System.out.println("------ CADASTRAR VENDA ------");
					gerenciamento_itemCardapio.listar(gerenciamento_itemCardapio.getLista_itensCardapio());
					System.out.print("Digite o ID: ");
					String id = input.next().strip();
					ItemCardapio item = gerenciamento_itemCardapio.buscarEntidade(gerenciamento_itemCardapio.getLista_itensCardapio(), id);
					if (item == null)
						System.out.println("--> Item n�o encontrado <--");
					else {
						compras.add(item);
					}
					System.out.print("Deseja registrar mais compras?[S/N] ");
					String opcao = input.next().strip().toUpperCase();
					switch(opcao) {
						case "S": {
							break;
						}
						case "N": {
							continuar_registrando_compra = false;
							break;
						}
						default: {
							System.out.println("Digite S ou N");
							break;
						}
					}
				} while (continuar_registrando_compra);
				
				String nova_formaDePagamento;
				do {
					System.out.print("Digite a Forma de Pagamento: ");
					nova_formaDePagamento = input.next().strip();			
				} while (!formaDePagamentoCorreta(nova_formaDePagamento));
				
				if (gerenciamento_venda.cadastrar(compras, nova_formaDePagamento))
					System.out.println("Venda cadastrada");
			}
			
			
		}

		public void editar() {
			Scanner input = new Scanner(System.in);
			boolean continuar_editar = true;
			
			while (continuar_editar) {
				System.out.println("------ EDITAR VENDA ------");
				
				do {
					System.out.print("[1] - Visualizar Vendas \n[2] - Selecionar ID \n[3] - Fechar Edi��o \nQual op��o: ");
					String opcao = input.next().strip();
					Venda venda_selecionado;
					switch(opcao) {
						case "1": {
							gerenciamento_venda.listar(gerenciamento_venda.getLista_vendas());;
							break;
						}
						case "2": {
							System.out.print("Digite o ID: ");
							String id_selecionado = input.next().strip();
						    venda_selecionado = gerenciamento_venda.buscarEntidade(gerenciamento_venda.getLista_vendas(), id_selecionado);
							if (venda_selecionado == null) 
								System.out.println("--> Venda n�o encontrada <--");
							else {
								System.out.println("--- EDITAR VENDA ---");
								System.out.print("Nova Forma de Pagamento: ");
								String nova_formaDePagamento = input.next().strip();
								if(formaDePagamentoCorreta(nova_formaDePagamento)) {
										if (gerenciamento_venda.editarFormaDePagamento(nova_formaDePagamento, venda_selecionado))
											System.out.println("-- Venda Alterada --");
								}
							}
							break;
						}
						case "3": {
							continuar_editar = false;
							break;
						}
						default: {
							System.out.println("Digite 1, 2 ou 3");
							break;
						}
					}
				} while (continuar_editar);
			}	
		}
		
		public void excluir() {
			System.out.println("-- Excluir Venda --");
			Scanner input = new Scanner(System.in);
			boolean continuar_excluir = true;
			
			do {
				System.out.print("[1] - Visualizar Vendas\n[2] - Selecionar ID \n[3] - Sair da Exclus�o \nQual op��o: ");
				String opcao = input.next().strip();
				switch(opcao) {
					case "1": {
						gerenciamento_venda.listar(gerenciamento_venda.getLista_vendas());
						break;
					}
					case "2": {
						System.out.print("Digite o ID: ");
						String id_buscado = input.next().strip();
						if (gerenciamento_venda.excluir(gerenciamento_venda.getLista_vendas(), id_buscado))
							System.out.println("-- Venda Exclu�do --");
						else 
							System.out.println("--> Venda n�o encontrado <--");
						break;
					}
					case "3": {
						continuar_excluir = false;
						break;
						}
					default: {
						System.out.println("Digite 1, 2 ou 3");
						break;
					}
				}
			} while (continuar_excluir);
		}
		
		
		private boolean formaDePagamentoCorreta(String nova_formaDePagamento) {
			if (ValidarVenda.validarFormaDePagamento(nova_formaDePagamento))
				return true;
			else {
				System.out.println("--> A forma de pagamento n�o pode estar vazia ou ser composta por n�meros <--");
				return false;
			}
		}
		
		
}
