package sistemaGeral.models.gerenciadores;

import java.util.ArrayList;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Fornecedor;

public class GerenciamentoFornecedor extends GerenciamentoGeral {
		private ArrayList<Fornecedor> lista_fornecedores;
	
		public GerenciamentoFornecedor(BancoDeDados bancoDados) {
			this.lista_fornecedores = bancoDados.getLista_fornecedores();
		}
		
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
		
		public Fornecedor buscarFornecedor_Nome(String nomeBuscado) {
			for(Fornecedor fornecedor: this.lista_fornecedores) {
				if(fornecedor.getNome().equals(nomeBuscado)) return fornecedor;
			}
			return null;
			
		}
		
		public ArrayList<Fornecedor> listarNomesBuscadosCorrespondentes(String nome_buscado) {
			ArrayList<Fornecedor> fornecedoresCorrespondentes = new ArrayList<>();
			for(Fornecedor fornecedor: this.lista_fornecedores) {
				if(fornecedor.getNome().contains(nome_buscado)) fornecedoresCorrespondentes.add(fornecedor);
			}
			return fornecedoresCorrespondentes;
			
		}
			
}
