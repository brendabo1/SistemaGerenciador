package sistemaGeral.models.gerenciadores;

import sistemaGeral.models.BancoDeDados;

public class TESTE_GERENCIAMENTO {
	
	
		public static void main(String[] args) {
				BancoDeDados banco = new BancoDeDados();
				GerenciamentoFornecedor gerFornecedor = new GerenciamentoFornecedor(banco);
				
				gerFornecedor.cadastrar("Mario", "9821", "Rua Antonio");
				gerFornecedor.cadastrar("Rogerio", "4312", "Praça da Margarida");
				gerFornecedor.cadastrar("Joana", "4333", "Cidade Nova");
				
				System.out.println(gerFornecedor.listar(gerFornecedor.getMap_fornecedores()));
		}
}
