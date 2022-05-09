package sistemaGeral.controllers;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.gerenciadores.GerenciamentoUsuario;
import sistemaGeral.views.ViewUsuario;

public class ControllerUsuario {
	
	private GerenciamentoUsuario modelUsuario;
	private ViewUsuario tela;	

	public ControllerUsuario(BancoDeDados bancoDados) {
		this.modelUsuario = new GerenciamentoUsuario(bancoDados);
		this.tela = new ViewUsuario();
	}

	public void autenticarUser() {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		//TODO	
	}
	
	
}
