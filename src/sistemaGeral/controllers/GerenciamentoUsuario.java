package sistemaGeral.controllers;

import java.util.ArrayList;

import sistemaGeral.models.Funcionario;
import sistemaGeral.models.Gerente;
import sistemaGeral.models.Usuario;

public class GerenciamentoUsuario extends GerenciamentoGeral {
		private ArrayList<Usuario> lista_usuarios = new ArrayList<>();

		
		private static Usuario usuario_logado = null;

		public boolean cadastrar(String nome, String senha, TipoUsuario tipo_usuario) {	
			String id;
			switch (tipo_usuario) {
				case GERENTE:
						id = gerarID(this.lista_usuarios, Gerente.getPreFixo());
						Gerente novo_gerente = new Gerente(nome, senha, id);
						if (adicionar(this.lista_usuarios, novo_gerente)) return true;
				case FUNCIONARIO: 
						id = gerarID(this.lista_usuarios, Funcionario.getPreFixo());
						Funcionario novo_funcionario = new Funcionario(nome, senha, id);
						if (adicionar(this.lista_usuarios, novo_funcionario)) return true;
			}
			
			return false;
		}
		
		public boolean login(String nome, String senha) {
			for (Usuario entidade: this.lista_usuarios) 
				if (entidade.getNome().equals(nome) && entidade.getSenha().equals(senha)) {
					usuario_logado = entidade;
					return true;
				}
			
			return false;
		}
		
		public boolean editarNome(String novo_nome, Usuario usuario) {
			usuario.setNome(novo_nome);
			
			return usuario.getNome().equals(novo_nome);
		}
		
		public boolean editarSenha(String nova_senha, Usuario usuario) {
			usuario.setSenha(nova_senha);
			
			return usuario.getSenha().equals(nova_senha);
		}
		
			
		public ArrayList<Usuario> getLista_usuarios() {
			return lista_usuarios;
		}


		public void setLista_usuarios(ArrayList<Usuario> lista_usuarios) {
			this.lista_usuarios = lista_usuarios;
		}

}
