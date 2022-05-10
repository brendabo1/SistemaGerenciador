package sistemaGeral.models.gerenciadores;

import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Fornecedor;

public class TESTE_GERENCIAMENTO {
	
	
		public static void main(String[] args) throws FileNotFoundException, DocumentException {
			//GerenciamentoFornecedor GE = new GerenciamentoFornecedor();
			
			//for (int i = 0; i < 10; i++) System.out.println(GE.gerarID("FOR"));
			BancoDeDados banco_teste = new BancoDeDados();
			GerenciamentoFornecedor gerenciamento = new GerenciamentoFornecedor(banco_teste);
			Fornecedor fornecedor1 = gerenciamento.cadastrar("nome bla", "12345678912345", "Endereco qualquer rua tal");
			TESTE t = new TESTE();
			String message = String.format("%s%10s\n", "muuuuuuito grande", "coluna");
			t.gerarPDF("Venda", fornecedor1.toString());
			System.out.println(message);
			
		}
}
