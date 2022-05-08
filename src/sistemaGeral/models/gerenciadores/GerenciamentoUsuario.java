package sistemaGeral.models.gerenciadores;

import java.util.ArrayList;

import sistemaGeral.models.BancodeDados;
import sistemaGeral.models.entidades.Funcionario;
import sistemaGeral.models.entidades.Gerente;
import sistemaGeral.models.entidades.Usuario;
import sistemaGeral.models.entidades.enums.TipoUsuario;

public class GerenciamentoUsuario extends GerenciamentoGeral {
		private ArrayList<Usuario> lista_usuarios;

		
		private Usuario usuario_logado = null;
		
		public GerenciamentoUsuario(BancodeDados bancoDados) {
			this.lista_usuarios = bancoDados.getLista_usuarios();
		}
		
		public boolean primeiroAcesso() {
			if(lista_usuarios.isEmpty()) return true;
			return false;
		}

		public boolean cadastrar(String nome, String senha, TipoUsuario tipo_usuario) {	
			String id;
			switch (tipo_usuario) {
				case GERENTE:
						id = gerarID(this.lista_usuarios, Gerente.getPreFixo());
						Gerente novo_gerente = new Gerente(id, nome, senha);
						if (adicionar(this.lista_usuarios, novo_gerente)) return true;
				case FUNCIONARIO: 
						id = gerarID(this.lista_usuarios, Funcionario.getPreFixo());
						Funcionario novo_funcionario = new Funcionario(nome, senha, id);
						if (adicionar(this.lista_usuarios, novo_funcionario)) return true;
			}
			
			return false;
		}
		
		public boolean login_ID(String ID, String senha) {
			for (Usuario user: this.lista_usuarios) 
				if (user.getId().equals(ID) && user.getSenha().equals(senha)) {
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
		
}
