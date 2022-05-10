package sistemaGeral.models.gerenciadores;

import java.util.HashMap;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.Produto;

public class GerenciamentoFornecedor extends GerenciamentoGeral {
		private HashMap<String, Fornecedor> map_fornecedores;
	
		public GerenciamentoFornecedor(BancoDeDados banco) {
			this.map_fornecedores = banco.getMap_fornecedores();
		}
		
		public boolean cadastrar(String nome, String CNPJ, String endereco) {
			String novo_id = gerarID(Fornecedor.getPreFixo());
			Fornecedor novo_fornecedor = new Fornecedor(novo_id, CNPJ, nome, endereco);
			return adicionar(map_fornecedores, novo_fornecedor);
		}
						
		
		public boolean editarNome(String novo_nome, Fornecedor fornecedor) {
			fornecedor.setNome(novo_nome);
			return fornecedor.getNome().equals(novo_nome);
		}
		
		public boolean editarCNPJ(String novo_CNPJ, Fornecedor fornecedor) {
			fornecedor.setCNPJ(novo_CNPJ);
			return fornecedor.getCNPJ().equals(novo_CNPJ);
		}
		
		public boolean editarEndereco(String novo_endereco, Fornecedor fornecedor) {
			fornecedor.setEndereco(novo_endereco);
			return fornecedor.getEndereco().equals(novo_endereco);
		}
		
		
		public boolean adicionarProdutoEmFornecedor (Produto novo_produto, Fornecedor fornecedor) {
			fornecedor.getMap_produtosFornecidos().put(novo_produto.getId(), novo_produto);
			return (fornecedor.getMap_produtosFornecidos().get(novo_produto.getId()).equals(novo_produto));
		}
		
		public boolean removerProdutoEmFornecedor (String id_selecionado, Fornecedor fornecedor) {
			Produto produto_removido = fornecedor.getMap_produtosFornecidos().remove(id_selecionado);
			return (produto_removido != null);
		}
}
