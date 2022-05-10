package sistemaGeral.controllers;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.gerenciadores.GerenciamentoUsuario;
import sistemaGeral.views.ViewUsuario;

public class ControllerUsuario {
	
	private GerenciamentoUsuario gerenUsuario;
	private ViewUsuario tela;	

	public ControllerUsuario(BancoDeDados bancoDados) {
		this.gerenUsuario = new GerenciamentoUsuario(bancoDados);
		this.tela = new ViewUsuario();
	}

	public void autenticarUser() {
		String id, senha;
		try {
			id = tela.login_ID();
			senha = tela.login_senha();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		//TODO	
	}
	
	public void
	
	
	
}
