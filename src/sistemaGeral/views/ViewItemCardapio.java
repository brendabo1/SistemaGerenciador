package sistemaGeral.views;

import java.util.ArrayList;
import java.util.Scanner;


import sistemaGeral.models.entidades.ItemCardapio;
import sistemaGeral.models.entidades.Produto;

import sistemaGeral.models.entidades.enums.CategoriasDeItens;
import sistemaGeral.models.gerenciadores.GerenciamentoItemCardapio;
import sistemaGeral.models.gerenciadores.GerenciamentoProduto;
import sistemaGeral.models.validacoes.ValidaItemCardapio;

public class ViewItemCardapio {
			private String nome;
			private ArrayList<Produto> ingredientes;
			private Double preco;
			private CategoriasDeItens categoria;
			private GerenciamentoItemCardapio gerenciamento_itemCardapio;
			private GerenciamentoProduto gerenciamento_produto;
			
			
			public ViewItemCardapio(GerenciamentoItemCardapio gerenciamento_itemCardapio, GerenciamentoProduto gerenciamento_produto) {
				this.gerenciamento_itemCardapio = gerenciamento_itemCardapio;	
				this.gerenciamento_produto = gerenciamento_produto;
				this.ingredientes = new ArrayList<>();
			}
			
			
			public void cadastro() {
				boolean continuar_cadastro = true;
				
				while (continuar_cadastro) {
					if (gerenciamento_produto.getLista_produtos().isEmpty())
						System.out.println("--> Atualmente não há ingredientes disponíveis <--");
					else {
					
						Scanner input = new Scanner(System.in);
						System.out.println("------ CADASTRO ITEM NO CARDAPIO ------");
						do {
							System.out.print("Digite o Nome: ");
							nome = input.next().strip();
						} while (!nomeCorreto(nome) || nomeJaUsado(nome));
						
						do {
							System.out.print("Digite o Preço ");
							preco = input.nextDouble();
						} while (!precoCorreto(preco));
						
						boolean continuar_escolhendo_ingredientes = true;
		
						do {
							System.out.print("Escolha os ingredientes: ");
							gerenciamento_produto.listar(gerenciamento_produto.getLista_produtos());
							System.out.print("Digite o ID: ");
							String id = input.next().strip();
							Produto produto_escolhido = gerenciamento_produto.buscarEntidade(gerenciamento_produto.getLista_produtos(), id);
							if (produto_escolhido == null)
								System.out.println("--> O produto selecionado não está cadastrado <--");
							else {
								if(gerenciamento_produto.adicionar(ingredientes, produto_escolhido))
									System.out.println("Adicionado o ingrediente " + produto_escolhido.getNome());
							}
							if (ingredientes.isEmpty()) {
								System.out.println("É preciso escolher pelo menos 1 ingrediente");
							}
							else {
								System.out.print("Deseja acrescentar mais ingredientes?[S/N]  ");
								String opcao = input.next().strip().toUpperCase();
								switch(opcao) {
									case "S": { break;}
									case "N": {
										
										continuar_escolhendo_ingredientes = false;
										break;
									}
									default: {
										System.out.println("Digite S ou N");
										break;
									}
								}			
							}
						} while (continuar_escolhendo_ingredientes);
						
						boolean continuar_escolhendo_categoria = true;
						do {
							System.out.println("Escolha uma Categoria: ");
							System.out.print("[1] - Prato \n[2] - Sobremesa \n[3] - Bebiba \nQual opção:");
							String opcao = input.next().strip();
							switch(opcao) {
								case "1": {
									this.categoria = CategoriasDeItens.PRATO;
									continuar_escolhendo_categoria = false;
									break;
								}
								case "2": {
									this.categoria = CategoriasDeItens.SOBREMESA;
									continuar_escolhendo_categoria = false;
									break;
								}
								case "3": {
									this.categoria = CategoriasDeItens.BEBIDA;
									continuar_escolhendo_categoria = false;
									break;
								}
								default: {
									System.out.println("Digite 1, 2 ou 3");
									break;
								}
							}	
						} while (continuar_escolhendo_ingredientes);
						
						if (gerenciamento_itemCardapio.cadastrar(nome, ingredientes, preco, categoria)) {
							System.out.println("-- " + nome + " foi Cadastrado no Sistema --");
							continuar_cadastro = false;
						}
						else 
							System.out.println("--> Não foi possível cadastrar no Sistema <--");
					}
				}	
			}
			
			public void editar() {
				Scanner input = new Scanner(System.in);
				boolean continuar_editar = true;
				
				while (continuar_editar) {
					System.out.println("------ EDITAR ITEM DO CARDAPIO ------");
					
					do {
						System.out.print("[1] - Visualizar Itens \n[2] - Selecionar ID \n[3] - Fechar Edição \nQual opção: ");
						String opcao = input.next().strip();
						ItemCardapio itemCardapio_selecionado;
						switch(opcao) {
							case "1": {
								gerenciamento_itemCardapio.listar(gerenciamento_itemCardapio.getLista_itensCardapio());;
								break;
							}
							case "2": {
								System.out.print("Digite o ID: ");
								String id_selecionado = input.next().strip();
							    itemCardapio_selecionado = gerenciamento_itemCardapio.buscarEntidade(gerenciamento_itemCardapio.getLista_itensCardapio(), id_selecionado);
								if (itemCardapio_selecionado == null) 
									System.out.println("--> Item não encontrado <--");
								else {
									System.out.println("--- EDITAR ITEM" + itemCardapio_selecionado.getNome().toUpperCase() + " ---");
									System.out.print("[1] - Editar Nome \n[2] - Editar Preço  \n[3] - Editar Ingredientes \n[4] - Editar Categoria \n[5] - Sair Edição \nQual opção: ");
									opcao = input.next().strip();
									switch (opcao) {
										case "1": {
											System.out.print("Novo Nome: ");
											String novo_nome = input.next().strip();
											if(nomeCorreto(novo_nome) && !nomeJaUsado(novo_nome)) {
													if (gerenciamento_itemCardapio.editarNome(novo_nome, itemCardapio_selecionado))
													System.out.println("-- Nome Alterado --");
											}
											break;
										}
										case "2": {
											System.out.print("Novo Preço: ");
											Double novo_preco= input.nextDouble();
											if(precoCorreto(novo_preco)) {
												if (gerenciamento_itemCardapio.editarPreco(novo_preco, itemCardapio_selecionado))
													System.out.println("-- Preço Alterado --");
											}
											break;
										}
										case "3": {
											boolean continuar_escolhendo_ingredientes = true;
											do {
												System.out.print("Escolha os ingredientes: ");
												gerenciamento_produto.listar(gerenciamento_produto.getLista_produtos());
												System.out.print("Digite o ID: ");
												String id = input.next().strip();
												Produto produto_escolhido = gerenciamento_produto.buscarEntidade(gerenciamento_produto.getLista_produtos(), id);
												if (produto_escolhido == null)
													System.out.println("--> O produto selecionado não está cadastrado <--");
												else {
													if(gerenciamento_produto.adicionar(ingredientes, produto_escolhido))
														System.out.println("Adicionado o ingrediente " + produto_escolhido.getNome());
												}
												if (ingredientes.isEmpty()) {
													System.out.println("É preciso escolher pelo menos 1 ingrediente");
												}
												else {
													System.out.print("Deseja acrescentar mais ingredientes?[S/N]  ");
													opcao = input.next().strip().toUpperCase();
													switch(opcao) {
														case "S": { break;}
														case "N": {
															
															gerenciamento_itemCardapio.editarIngredientes(ingredientes, itemCardapio_selecionado);
															continuar_escolhendo_ingredientes = false;
															break;
														}
														default: {
															System.out.println("Digite S ou N");
															break;
														}
													}			
												}
											} while (continuar_escolhendo_ingredientes);
											break;
										}
										case "4": {
											boolean continuar_escolhendo_categoria = true;
											do {
												System.out.println("Escolha uma Categoria: ");
												System.out.print("[1] - Prato \n[2] - Sobremesa \n[3] - Bebiba \nQual opção:");
												opcao = input.next().strip();
												switch(opcao) {
													case "1": {
														gerenciamento_itemCardapio.editarCategoria(CategoriasDeItens.PRATO, itemCardapio_selecionado);
														continuar_escolhendo_categoria = false;
														break;
													}
													case "2": {
														gerenciamento_itemCardapio.editarCategoria(CategoriasDeItens.SOBREMESA, itemCardapio_selecionado);
														continuar_escolhendo_categoria = false;
														break;
													}
													case "3": {
														gerenciamento_itemCardapio.editarCategoria(CategoriasDeItens.BEBIDA, itemCardapio_selecionado);
														continuar_escolhendo_categoria = false;
														break;
													}
													default: {
														System.out.println("Digite 1, 2 ou 3");
														break;
													}
												}	
											} while (continuar_escolhendo_categoria);
											break;
										}
										case "5": {
											continuar_editar = false;
										}
										default: {
											System.out.println("Digite 1, 2, 3 ou 4");
											break;
										}
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
				System.out.println("-- Excluir Item do Cardapio --");
				Scanner input = new Scanner(System.in);
				boolean continuar_excluir = true;
				
				do {
					System.out.print("[1] - Visualizar Itens\n[2] - Selecionar ID \n[3] - Sair da Exclusão \nQual opção: ");
					String opcao = input.next().strip();
					switch(opcao) {
						case "1": {
							gerenciamento_itemCardapio.listar(gerenciamento_itemCardapio.getLista_itensCardapio());
							break;
						}
						case "2": {
							System.out.print("Digite o ID: ");
							String id_buscado = input.next().strip();
							if (gerenciamento_itemCardapio.excluir(gerenciamento_itemCardapio.getLista_itensCardapio(), id_buscado))
								System.out.println("-- Item Excluído --");
							else 
								System.out.println("--> Item não encontrado <--");
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

			
			private boolean nomeCorreto(String novo_nome) {
				if (ValidaItemCardapio.validarNome(novo_nome))
					return true;
				else {
					System.out.println("--> O nome não pode ser composto apenas por números ou estar vazio <--");
					return false;
				}
			}
			
			private boolean ingredientesCorretos(ArrayList<Produto> novos_ingredientes, ArrayList<Produto> produtos) {
				if (ValidaItemCardapio.validarIngredientes(novos_ingredientes, produtos))
					return true;
				else {
					System.out.println("--> Um ou mais ingredientes não constam na lista de produtos <--");
					return false;
				}
			}
			
			private boolean  precoCorreto(Double novo_preco) {
				if (ValidaItemCardapio.validarPreco(novo_preco))
					return true;
				else {
					System.out.println("--> O preço deve ser maior que zero <--");
					return false;
				}
			}
			
			private boolean nomeJaUsado(String novo_nome) {
				if (ValidaItemCardapio.nomeJaCadastrado(novo_nome, this.gerenciamento_itemCardapio.getLista_itensCardapio())) {
					System.out.println("--> Já existe um item cadastrado com este nome <--");
					return true;
				}
				else {
					return false;
				}
			}
			
}
