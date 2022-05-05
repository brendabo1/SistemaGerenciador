package sistemaGeral.views;

import java.util.Scanner;

import sistemaGeral.controllers.validacoes.ValidarProduto;
import sistemaGeral.models.entidades.Produto;
import sistemaGeral.models.gerenciadores.GerenciamentoProduto;

public class ViewProduto {
			private String nome;
			private Double preco;
			private String validade;
			private GerenciamentoProduto gerenciamento_produto;
			
			
			public ViewProduto(GerenciamentoProduto gerenciamento_produto) {
				this.gerenciamento_produto = gerenciamento_produto;
			}
			
			public void cadastro() {
				boolean continuar_cadastro = true;
				
				while (continuar_cadastro) {
					Scanner inputS = new Scanner(System.in);
					Scanner inputD = new Scanner(System.in);

					System.out.println("------ CADASTRO PRODUTO ------");
					do {
						System.out.print("Digite o Nome: ");
						nome = inputS.next().strip();
					} while (!nomeCorreto(nome) || nomeJaUsado(nome));
					
					Double novo_preco;
					do {
						System.out.print("Digite o Preço ");
						novo_preco = inputD.nextDouble();
					} while (!precoCorreto(novo_preco));
					
					do {
						System.out.print("Digite a Validade: ");
						validade = inputS.next().strip();
					} while (!validadeCorreta(validade));
					
					if (gerenciamento_produto.cadastrar(nome, novo_preco, validade)) {
						System.out.println("-- " + nome + " foi Cadastrado no Sistema --");
						continuar_cadastro = false;
					}
					else 
						System.out.println("--> Não foi possível cadastrar no Sistema <--");
				}
			}
			
			public void editar() {
				Scanner input = new Scanner(System.in);
				boolean continuar_editar = true;
				
				while (continuar_editar) {
					System.out.println("------ EDITAR PRODUTO ------");
					
					do {
						System.out.print("[1] - Visualizar Produtos \n[2] - Selecionar ID \n[3] - Fechar Edição \nQual opção: ");
						String opcao = input.next().strip();
						Produto produto_selecionado;
						switch(opcao) {
							case "1": {
								gerenciamento_produto.listar(gerenciamento_produto.getLista_produtos());;
								break;
							}
							case "2": {
								System.out.print("Digite o ID: ");
								String id_selecionado = input.next().strip();
							    produto_selecionado = gerenciamento_produto.buscarEntidade(gerenciamento_produto.getLista_produtos(), id_selecionado);
								if (produto_selecionado == null) 
									System.out.println("--> Usuário não encontrado <--");
								else {
									System.out.println("--- EDITAR PRODUTO " + produto_selecionado.getNome().toUpperCase() + " ---");
									System.out.print("[1] - Editar Nome \n[2] - Editar Preço  \n[3] - Editar Validade \n[4] - Sair Edição \nQual opção: ");
									opcao = input.next().strip();
									switch (opcao) {
										case "1": {
											System.out.print("Novo Nome: ");
											String novo_nome = input.next().strip();
											if(nomeCorreto(novo_nome) && !nomeJaUsado(novo_nome)) {
 												if (gerenciamento_produto.editarNome(novo_nome, produto_selecionado))
													System.out.println("-- Nome Alterado --");
											}
											break;
										}
										case "2": {
											System.out.print("Novo Preço: ");
											Double novo_preco = input.nextDouble();
											if(precoCorreto(novo_preco)) {
												if (gerenciamento_produto.editarPreco(novo_preco, produto_selecionado))
													System.out.println("-- Preço Alterada --");
											}
											break;
										}
										case "3": {
											System.out.print("Nova Validade: ");
											String nova_validade = input.next().strip();
											if (validadeCorreta(nova_validade)) {
												if (gerenciamento_produto.editarValidade(nova_validade, produto_selecionado))
													System.out.println("-- Validade Alterada --");
											}
											break;
										}
										case "4": {
											continuar_editar = false;
											break;
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
				System.out.println("-- Excluir Produto --");
				Scanner input = new Scanner(System.in);
				boolean continuar_excluir = true;
				
				do {
					System.out.print("[1] - Visualizar Produtos\n[2] - Selecionar ID \n[3] - Sair da Exclusão \nQual opção: ");
					String opcao = input.next().strip();
					switch(opcao) {
						case "1": {
							gerenciamento_produto.listar(gerenciamento_produto.getLista_produtos());
							break;
						}
						case "2": {
							System.out.print("Digite o ID: ");
							String id_buscado = input.next().strip();
							if (gerenciamento_produto.excluir(gerenciamento_produto.getLista_produtos(), id_buscado))
								System.out.println("-- Produto Excluído --");
							else 
								System.out.println("--> Produto não encontrado <--");
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
				if (ValidarProduto.validarNome(novo_nome))
					return true;
				else {
					System.out.println("--> O nome não pode estar vazio ou ser somente números <--");
					return false;
				}
			}
			
			private boolean precoCorreto(Double novo_preco) {
				if (ValidarProduto.validarPreco(novo_preco))
					return true;
				else {
					System.out.println("--> O preço não pode ser menor ou igual a zero <--");
					return false;
				}
			}
			
			private boolean validadeCorreta(String nova_validade) {
				if (ValidarProduto.validarValidade(nova_validade))
					return true;
				else {
					System.out.println("--> A validade precisa estar no formato dd/mm/aaaa <--");
					return false;
				}
			}
		
			private boolean nomeJaUsado(String nome) {
				if (ValidarProduto.nomeJaCadastrado(nome, gerenciamento_produto.getLista_produtos())) {
					System.out.println("--> O nome já se encontra cadastrado, tente outro <--");
					return true;
				}
				return false;	
			}
			
}
