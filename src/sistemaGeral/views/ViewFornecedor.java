package sistemaGeral.views;

import java.util.Scanner;

import sistemaGeral.controllers.validacoes.ValidarFornecedor;
import sistemaGeral.controllers.validacoes.ValidarProduto;
import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.Produto;
import sistemaGeral.models.gerenciadores.GerenciamentoFornecedor;

public class ViewFornecedor {
		private String CNPJ;
		private String nome;
		private String endereco;
		private GerenciamentoFornecedor gerenciamento_fornecedor;
		
		public ViewFornecedor(GerenciamentoFornecedor gerenciamento_fornecedor) {
			this.gerenciamento_fornecedor = gerenciamento_fornecedor;
		}
		
		public void cadastro() {
			boolean continuar_cadastro = true;
			
			while (continuar_cadastro) {
				Scanner input = new Scanner(System.in);
				System.out.println("------ CADASTRO FORNECEDOR ------");
				do {
					System.out.print("Digite o Nome: ");
					nome = input.next().strip();
				} while (!nomeCorreto(nome) || nomeJaUsado(nome));
				
				do {
					System.out.print("Digite o CNPJ ");
					CNPJ = input.next().strip();
				} while (cnpjCorreto(CNPJ) && !cnpjJaUsado(CNPJ));
				
				do {
					System.out.print("Digite o Endereço: ");
					endereco = input.next().strip();
				} while (enderecoCorreto(endereco));
				
				if (gerenciamento_fornecedor.cadastrar(nome, CNPJ, endereco)) {
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
				System.out.println("------ EDITAR FORNECEDOR ------");
				
				do {
					System.out.print("[1] - Visualizar Fornecedores \n[2] - Selecionar ID \n[3] - Fechar Edição \nQual opção: ");
					String opcao = input.next().strip();
					Fornecedor fornecedor_selecionado;
					switch(opcao) {
						case "1": {
							gerenciamento_fornecedor.listar(gerenciamento_fornecedor.getLista_fornecedores());;
							break;
						}
						case "2": {
							System.out.print("Digite o ID: ");
							String id_selecionado = input.next().strip();
						    fornecedor_selecionado = gerenciamento_fornecedor.buscarEntidade(gerenciamento_fornecedor.getLista_fornecedores(), id_selecionado);
							if (fornecedor_selecionado == null) 
								System.out.println("--> Fornecedor não encontrado <--");
							else {
								System.out.println("--- EDITAR FORNECEDOR " + fornecedor_selecionado.getNome().toUpperCase() + " ---");
								System.out.print("[1] - Editar Nome \n[2] - Editar CNPJ  \n[3] - Editar Endereço \n[4] - Sair Edição \nQual opção: ");
								opcao = input.next().strip();
								switch (opcao) {
									case "1": {
										System.out.print("Novo Nome: ");
										String novo_nome = input.next().strip();
										if(nomeCorreto(novo_nome) && !nomeJaUsado(novo_nome)) {
												if (gerenciamento_fornecedor.editarNome(novo_nome, fornecedor_selecionado))
												System.out.println("-- Nome Alterado --");
										}
										break;
									}
									case "2": {
										System.out.print("Novo CNPJ ");
										String novo_cnpj = input.next().strip();
										if(cnpjCorreto(novo_cnpj) && !cnpjJaUsado(novo_cnpj)) {
											if (gerenciamento_fornecedor.editarCNPJ(novo_cnpj, fornecedor_selecionado))
												System.out.println("-- CNPJ Alterado --");
										}
										break;
									}
									case "3": {
										System.out.print("Novo Endereço: ");
										String novo_endereco = input.next().strip();
										if(enderecoCorreto(novo_endereco)) {
											if (gerenciamento_fornecedor.editarEndereco(novo_endereco, fornecedor_selecionado))
												System.out.println("-- Endereço Alterado --");
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
			System.out.println("-- Excluir Fornecedor --");
			Scanner input = new Scanner(System.in);
			boolean continuar_excluir = true;
			
			do {
				System.out.print("[1] - Visualizar Fornecedores\n[2] - Selecionar ID \n[3] - Sair da Exclusão \nQual opção: ");
				String opcao = input.next().strip();
				switch(opcao) {
					case "1": {
						gerenciamento_fornecedor.listar(gerenciamento_fornecedor.getLista_fornecedores());
						break;
					}
					case "2": {
						System.out.print("Digite o ID: ");
						String id_buscado = input.next().strip();
						if (gerenciamento_fornecedor.excluir(gerenciamento_fornecedor.getLista_fornecedores(), id_buscado))
							System.out.println("-- Fornecedor Excluído --");
						else 
							System.out.println("--> Fornecedor não encontrado <--");
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
			if (ValidarFornecedor.validarNome(novo_nome))
				return true;
			else {
				System.out.println("--> O nome não pode estar em branco ou ser composto somente por números <--");
				return false;
			}
		}
		
		private boolean cnpjCorreto(String novo_cnpj) {
			if (ValidarFornecedor.validarCNPJ(novo_cnpj))
				return true;
			else {
				System.out.println("--> O CNPJ deve ter exatamente 14 caracteres, todos númericos <--");
				return false;
			}
		}
		
		private boolean enderecoCorreto(String novo_endereco) {
			if (ValidarFornecedor.validarEndereco(novo_endereco))
				return true;
			else {
				System.out.println("--> O endereço precisa ter mais de 4 caracteres e não ser composto somente por números <--");
				return false;
			}
		}
		
		private boolean nomeJaUsado(String nome) {
			if (ValidarFornecedor.nomeJaCadastrado(nome, gerenciamento_fornecedor.getLista_fornecedores())) {
				System.out.println("--> O nome já se encontra cadastrado, tente outro <--");
				return true;
			}
			return false;	
		}
		
		private boolean cnpjJaUsado(String CNPJ) {
			if (ValidarFornecedor.cnpjJaCadastrado(CNPJ, gerenciamento_fornecedor.getLista_fornecedores())) {
				System.out.println("--> O CNPJ já se encontra cadastrado, tente outro <--");
				return true;
			}
			return false;	
		}
		
		
}
