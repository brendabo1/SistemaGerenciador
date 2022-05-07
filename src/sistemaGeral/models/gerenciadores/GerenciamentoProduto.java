package sistemaGeral.models.gerenciadores;

import java.util.ArrayList;

import sistemaGeral.models.BancodeDados;
import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.Produto;
import sistemaGeral.models.entidades.enums.UnidadeMedida;

public class GerenciamentoProduto extends GerenciamentoGeral{
		private ArrayList<Produto> lista_produtos;
		
		public GerenciamentoProduto(BancodeDados bancoDados) {
			this.lista_produtos = bancoDados.getLista_produtos();
		}
					
		public boolean cadastrar(String nome,  Fornecedor fornecedor, UnidadeMedida unidade, Double quantidade_conteudo) {
			String id = gerarID(this.lista_produtos, Produto.getPrefixo());
			Produto novo_produto = new Produto(id, nome,  fornecedor, unidade, quantidade_conteudo);
			return adicionar(this.lista_produtos, novo_produto);
		}
		
		
		public boolean editarNome(String novo_nome, Produto produto) {
			produto.setNome(novo_nome);
			return produto.getNome().equals(novo_nome);
		}
	
		
		/*public boolean editarValidade(String nova_validade, Produto produto) {
			produto.setValidade(nova_validade);
			return produto.getValidade().equals(nova_validade);
		}*/
		
		
}
