package sistemaGeral.views;

import java.util.Scanner;

<<<<<<< HEAD
=======
import sistemaGeral.controllers.validacoes.ValidarUsuario;
>>>>>>> develop_brenda
import sistemaGeral.models.entidades.Usuario;
import sistemaGeral.models.entidades.enums.TipoUsuario;
import sistemaGeral.models.gerenciadores.GerenciamentoUsuario;
import sistemaGeral.models.validacoes.ValidaUsuario;

public class ViewUsuarioAntiga {
			private String nome;
			private String senha;
			private GerenciamentoUsuario gerenciamento_usuario;
			
			public ViewUsuarioAntiga(GerenciamentoUsuario gerenciamento_usuario){
				this.gerenciamento_usuario = gerenciamento_usuario;
			}
			
			
			public void login() {
				Scanner input = new Scanner(System.in);
				boolean continuar_login = true;
				
				while (continuar_login) {
					System.out.println("------ LOGIN ------");
					
					do {
						System.out.print("Digite o Nome: ");
						nome = input.next().strip();
					} while (!nomeCorreto(nome));
					
					do {
						System.out.print("Digite a Senha: ");
						senha = input.next();
					} while (!senhaCorreta(senha));
					
					if (gerenciamento_usuario.login(nome, senha)) {
						System.out.println("------ SEJA BEM VINDO(A)  " + nome.toUpperCase() + " ------");
						continuar_login = false;
					}	
					else {
						System.out.println("--> Usu�rio n�o cadastrado <--");
						do {
							System.out.print("Deseja tentar novamente? [S/N] ");
							String opcao = input.next().strip().toUpperCase();
							switch (opcao) {
								case "S": {
									continuar_login = true;
									break;
								}
								case "N": {
									continuar_login = false;
									break;
								}
								default: {
									System.out.println("--> Digite N ou S <--");
									break;
								}
							}
						} while (continuar_login);
				}
			}
		}
			
			
			public void cadastro() {
				boolean continuar_cadastro = true;
				
				while (continuar_cadastro) {
					Scanner input = new Scanner(System.in);
					System.out.println("------ CADASTRO ------");
					do {
						System.out.print("Digite o Nome: ");
						nome = input.next().strip();
					} while (!nomeCorreto(nome) || nomeJaUsado(nome));
					
					do {
						System.out.print("Digite a Senha: ");
						senha = input.next().strip();
					} while (!senhaCorreta(senha));
					
					do {
						System.out.print("[1] - Cadastrar como Gerente "
								+ "\n[2] - Cadastrar como Funcionario  "
								+ "\n[3] - Sair do Cadastro"
								+ "\nQual op��o: ");
						String opcao = input.next().strip();
						
						switch (opcao) {
							case "1": {
								if (gerenciamento_usuario.cadastrar(nome, senha, TipoUsuario.GERENTE)) {
									System.out.println("-- Gerente " + nome + " Cadastrado --");
									continuar_cadastro = false;
								}	
								break;
							}
							case "2": {
								if (gerenciamento_usuario.cadastrar(nome, senha, TipoUsuario.FUNCIONARIO)) {
									System.out.println("-- Funcionario " + nome + " Cadastrado --");
									continuar_cadastro = false;
								}	
								break;
							}
							case "3": {
								continuar_cadastro = false;
								break;
							}
							default: {
								System.out.println("--> Digite 1, 2 ou 3 <--");
								break;
							}
						}
					} while (continuar_cadastro);
				}
			}
			
			
			public void editar() {
				Scanner input = new Scanner(System.in);
				boolean continuar_editar = true;
				
				while (continuar_editar) {
					System.out.println("------ EDITAR USU�RIO ------");
					
					do {
						System.out.print("[1] - Visualizar Usu�rios \n[2] - Selecionar ID \n[3] - Fechar Edi��o \nQual op��o: ");
						String opcao = input.next().strip();
						Usuario usuario_selecionado;
						switch(opcao) {
							case "1": {
								gerenciamento_usuario.listar(gerenciamento_usuario.getLista_usuarios());
								break;
							}
							case "2": {
								System.out.print("Digite o ID: ");
								String id_selecionado = input.next().strip();
							    usuario_selecionado = gerenciamento_usuario.buscarEntidade(gerenciamento_usuario.getLista_usuarios(), id_selecionado);
								if (usuario_selecionado == null) 
									System.out.println("--> Usu�rio n�o encontrado <--");
								else {
									System.out.println("--- EDITAR USU�RIO " + usuario_selecionado.getNome().toUpperCase() + " ---");
									System.out.print("[1] - Editar Nome \n[2] - Editar Senha \n[3] - Sair Edi��o \nQual op��o: ");
									opcao = input.next().strip();
									switch (opcao) {
										case "1": {
											System.out.print("Novo Nome: ");
											String novo_nome = input.next().strip();
											if (validarNovoNomeUsuario(novo_nome)) {
												if (gerenciamento_usuario.editarNome(novo_nome, usuario_selecionado))
													System.out.println("-- Nome Alterado --");
											}
											break;
										}
										case "2": {
											System.out.println("Nova Senha: ");
											String nova_senha = input.next().strip();
											if (validarNovaSenhaUsuario(nova_senha)) {
												if (gerenciamento_usuario.editarSenha(nova_senha, usuario_selecionado))
													System.out.println("-- Senha Alterada --");
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
				System.out.println("-- Excluir Usuario --");
				Scanner input = new Scanner(System.in);
				boolean continuar_excluir = true;
				
				do {
					System.out.print("[1] - Visualizar Usuarios\n[2] - Selecionar ID \n[3] - Sair da Exclus�o \nQual op��o: ");
					String opcao = input.next().strip();
					switch(opcao) {
						case "1": {
							gerenciamento_usuario.listar(gerenciamento_usuario.getLista_usuarios());
							break;
						}
						case "2": {
							System.out.print("Digite o ID: ");
							String id_buscado = input.next().strip();
							if (gerenciamento_usuario.excluir(gerenciamento_usuario.getLista_usuarios(), id_buscado))
								System.out.println("-- Usu�rio Exclu�do --");
							else 
								System.out.println("--> Usu�rio n�o encontrado <--");
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

			
			private boolean nomeCorreto(String nome) {
				if (!ValidaUsuario.validarNome(nome)) {
					System.out.println("--> O nome deve ser composto somente por letras e ter pelo menos 5 caracteres <--");	
					return false;
				}
				return true;
			}
			
			private boolean senhaCorreta(String senha) {
				if (!ValidaUsuario.validarSenha(senha)) {
					System.out.println("--> A senha deve conter pelo menos 6 caracteres <--");
					return false;
				}
				return true;
			}
			
			private boolean nomeJaUsado(String nome) {
				if (ValidaUsuario.nomeJaCadastrado(nome, gerenciamento_usuario.getLista_usuarios())) {
					System.out.println("--> O nome j� se encontra cadastrado, tente outro <--");
					return true;
				}
				return false;	
			}

			
			private boolean validarNovoNomeUsuario(String novo_nome) {
				if (ValidaUsuario.validarNome(novo_nome) && !ValidaUsuario.nomeJaCadastrado(novo_nome, gerenciamento_usuario.getLista_usuarios()))
					return true;
				else {
					System.out.println("--> Nome inv�lido ou J� se encontra cadastrado <--");
					return false;
				}
			}
			
			private boolean validarNovaSenhaUsuario(String nova_senha) {
				if (ValidaUsuario.validarSenha(nova_senha))
					return true;
				else {
					System.out.println("--> Senha inv�lida, precisa ter pelo menos 6 caracteres <--");
					return false;
				}
			}
}
