package sistemaGeral.models.validacoes;

import java.util.List;

import sistemaGeral.models.entidades.Fornecedor;

public class ValidaFornecedor {
		
		public static boolean validarCNPJ(String CNPJ) {
			return (CNPJ.length() == 14 && CNPJ.matches("[0-9]*") );
		}
		
		public static boolean validarNome(String nome) {
			return (!nome.isBlank() && !nome.matches("[0-9]*"));
		}
		
		public static boolean validarEndereco(String endereco) {
			
			return (!endereco.matches("[0-9]*") && !endereco.isBlank() && endereco.length() > 4 && !endereco.contains("#$%@&!?"));
		}
		
		public static boolean nomeJaCadastrado(String nome, List<Fornecedor> lista_cadastrados) {
			for (Fornecedor fornecedor: lista_cadastrados) if (fornecedor.getNome().equals(nome)) return true;
			
			return false;
		}
		
		public static boolean cnpjJaCadastrado(String CNPJ, List<Fornecedor> lista_cadastrados) {
			for (Fornecedor fornecedor: lista_cadastrados) if (fornecedor.getCNPJ().equals(CNPJ)) return true;
			
			return false;
		}
}
