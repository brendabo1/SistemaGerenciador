package sistemaGeral.models.gerenciadores;

import java.util.ArrayList;

import sistemaGeral.models.Fornecedor;
import sistemaGeral.models.Produto;
import sistemaGeral.models.UnidadeMedida;

public class GerenciamentoProduto extends GerenciamentoGeral{
		private ArrayList<Produto> lista_produtos = new ArrayList<>();
	
		
		
		public boolean cadastrar(String nome, Double preco, Fornecedor fornecedor, UnidadeMedida unidade) {
			String id = gerarID(this.lista_produtos, Produto.getPrefixo());
			Produto novo_produto = new Produto(id, nome, preco, fornecedor, unidade);
			return adicionar(this.lista_produtos, novo_produto);
		}
		
		
		public boolean editarNome(String novo_nome, Produto produto) {
			produto.setNome(novo_nome);
			return produto.getNome().equals(novo_nome);
		}
		
		public boolean editarPreco(Double novo_preco, Produto produto) {
			produto.setPreco(novo_preco);
			return produto.getPreco().equals(novo_preco);
		}
		
		/*public boolean editarValidade(String nova_validade, Produto produto) {
			produto.setValidade(nova_validade);
			return produto.getValidade().equals(nova_validade);
		}*/
		


		public ArrayList<Produto> getLista_produtos() {
			return lista_produtos;
		}


		public void setLista_produtos(ArrayList<Produto> lista_produtos) {
			this.lista_produtos = lista_produtos;
		}
		
}
