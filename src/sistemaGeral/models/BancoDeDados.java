package sistemaGeral.models;

import java.util.ArrayList;

import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.ItemCardapio;
import sistemaGeral.models.entidades.Produto;
import sistemaGeral.models.entidades.Usuario;
import sistemaGeral.models.entidades.Venda;

public class BancoDeDados {
	private ArrayList<Produto> lista_produtos = new ArrayList<>();
	private ArrayList<ItemCardapio> lista_itensCardapio = new ArrayList<>();
	private ArrayList<Fornecedor> lista_fornecedores = new ArrayList<>();
	private ArrayList<Venda> lista_vendas = new ArrayList<>();
	private ArrayList<Usuario> lista_usuarios = new ArrayList<>();
	
	public ArrayList<Produto> getLista_produtos() {
		return lista_produtos;
	}
	public void setLista_produtos(ArrayList<Produto> lista_produtos) {
		this.lista_produtos = lista_produtos;
	}
	public ArrayList<Venda> getLista_vendas() {
		return lista_vendas;
	}
	public void setLista_vendas(ArrayList<Venda> lista_vendas) {
		this.lista_vendas = lista_vendas;
	}
	public ArrayList<Usuario> getLista_usuarios() {
		return lista_usuarios;
	}
	public void setLista_usuarios(ArrayList<Usuario> lista_usuarios) {
		this.lista_usuarios = lista_usuarios;
	}
	public ArrayList<ItemCardapio> getLista_itensCardapio() {
		return lista_itensCardapio;
	}
	public void setLista_itensCardapio(ArrayList<ItemCardapio> lista_itensCardapio) {
		this.lista_itensCardapio = lista_itensCardapio;
	}
	public ArrayList<Fornecedor> getLista_fornecedores() {
		return lista_fornecedores;
	}
	public void setLista_fornecedores(ArrayList<Fornecedor> lista_fornecedores) {
		this.lista_fornecedores = lista_fornecedores;
	}
}
