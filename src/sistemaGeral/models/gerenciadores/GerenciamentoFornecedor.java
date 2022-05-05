package sistemaGeral.models.gerenciadores;

import java.util.ArrayList;

import sistemaGeral.models.entidades.Fornecedor;

public class GerenciamentoFornecedor extends GerenciamentoGeral {
		private ArrayList<Fornecedor> lista_fornecedores = getLista_fornecedores();
		
		
		public boolean cadastrar(String nome, String CNPJ, String endereco) {
			String id = gerarID(this.lista_fornecedores, Fornecedor.getPrefixo());
			Fornecedor novo_fornecedor = new Fornecedor(id, CNPJ, nome, endereco);
			return adicionar(this.lista_fornecedores, novo_fornecedor);
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




		
		
		public ArrayList<Fornecedor> getLista_fornecedores() {
			return lista_fornecedores;
		}
		




		public void setLista_fornecedores(ArrayList<Fornecedor> lista_fornecedores) {
			this.lista_fornecedores = lista_fornecedores;
		}	
}
