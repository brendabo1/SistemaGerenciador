package sistemaGeral.models.gerenciadores;

import java.util.HashMap;

import sistemaGeral.controllers.ControllerFornecedor;
import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.Produto;
import sistemaGeral.models.entidades.enums.UnidadeMedida;

/**
 * Classe para aplicacao de operacoes na entidade Produto.
 * @author Elmer Carvalho
 *@author Brenda Barbosa
 */
public class GerenciamentoProduto extends GerenciamentoGeral{
		private HashMap<String, Produto> map_produtos;
		private GerenciamentoFornecedor gerFornecedor;

		/**
		 * Construtor do gerenciamento de produto.
		 * @param banco objeto que arm
		 * @param gerFornecedor
		 */
		public GerenciamentoProduto(BancoDeDados banco, GerenciamentoFornecedor gerFornecedor) {
			this.map_produtos = banco.getMap_produtos();
			this.gerFornecedor = gerFornecedor;
		}
					
		public Produto cadastrar(String nome, Fornecedor fornecedor, UnidadeMedida unidade, Double quantidade_conteudo) {
			String novo_id = gerarID(Produto.getPreFixo());
			Produto novo_produto = new Produto(novo_id, nome, fornecedor, unidade, quantidade_conteudo);
			if (adicionar(map_produtos, novo_produto) && gerFornecedor.adicionarProdutoEmFornecedor(novo_produto, fornecedor))
				return novo_produto;
			return null;
		}
		
		
		
		public boolean editarNome(String novo_nome, Produto produto) {
			produto.setNome(novo_nome);
			return produto.getNome().equals(novo_nome);
		}
		
		public boolean editarFornecedor(Fornecedor novo_fornecedor, Produto produto) {
			produto.setFornecedor(novo_fornecedor);
			return produto.getFornecedor().equals(novo_fornecedor);
		}
		
		public boolean editarUnidadeMedida(UnidadeMedida nova_unidade, Produto produto) {
			produto.setUnidade_medida(nova_unidade);
			return produto.getUnidade_medida().equals(nova_unidade);
		}
		
		public boolean editarQuantidadeConteudo (Double nova_quantidadeConteudo, Produto produto) {
			produto.setConteudo_produto(nova_quantidadeConteudo);
			return produto.getConteudo_produto().equals(nova_quantidadeConteudo);
		}

		public HashMap<String, Produto> getMap_produtos() {
			return map_produtos;
		}

		public void setMap_produtos(HashMap<String, Produto> map_produtos) {
			this.map_produtos = map_produtos;
		}

		public GerenciamentoFornecedor getGerFornecedor() {
			return gerFornecedor;
		}
		
}
