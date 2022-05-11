package sistemaGeral.models.gerenciadores;

import java.util.HashMap;
import java.util.NoSuchElementException;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Usuario;

public class GerenciamentoUsuario extends GerenciamentoGeral {
		private HashMap<String, Usuario> map_usuarios;

		
		public GerenciamentoUsuario(BancoDeDados banco) {
			this.map_usuarios = banco.getMap_usuarios();
			if (this.map_usuarios.isEmpty())
				cadastrar("admin", "admin");
		}
		
		

		public Usuario cadastrar(String nome, String senha) {	
				String novo_id;
				if (this.map_usuarios.isEmpty())
						novo_id = Usuario.getPrefixo() + "00000";
				else
						novo_id = gerarID(Usuario.getPrefixo());
				
				Usuario novo_usuario = new Usuario(nome, senha, novo_id);
				if (adicionar(map_usuarios, novo_usuario))
					return novo_usuario;
				return null;
		}
		
		public boolean loginID(String id, String senha) {
			Usuario usuario = this.map_usuarios.get(id);
			if (usuario == null)
					return false;
			
			if (usuario.getSenha().equals(senha))
					return true;
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
		
		



		public HashMap<String, Usuario> getMap_usuarios() {
			return map_usuarios;
		}



		public void setMap_usuarios(HashMap<String, Usuario> map_usuarios) {
			this.map_usuarios = map_usuarios;
		}
}
