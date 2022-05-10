package sistemaGeral.models.gerenciadores;

import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.Produto;
import sistemaGeral.models.entidades.enums.UnidadeMedida;

public class TESTE_GERENCIAMENTO {
	
	
		public static void main(String[] args) throws FileNotFoundException, DocumentException {
			//GerenciamentoFornecedor GE = new GerenciamentoFornecedor();
			
			//for (int i = 0; i < 10; i++) System.out.println(GE.gerarID("FOR"));
			BancoDeDados banco_teste = new BancoDeDados();
			GerenciamentoFornecedor gerenciamentoF = new GerenciamentoFornecedor(banco_teste);
			GerenciamentoProduto gerenciamento = new GerenciamentoProduto(banco_teste, gerenciamentoF);
			Fornecedor fornecedor2 = gerenciamentoF.cadastrar("nome bla", "12345678912345", "Endereco qualquer rua tal");
			Produto produto1 = gerenciamento.cadastrar("nome bla", fornecedor2, UnidadeMedida.KG, 2.5);
			Produto produto2 = gerenciamento.cadastrar("nome bla", fornecedor2, UnidadeMedida.KG, 2.5);
			
			TESTE t = new TESTE();
			String message = String.format("%s%10s\n", "muuuuuuito grande", "coluna");
			t.gerarPDF("Produto", banco_teste);
			System.out.printf("%6d", 15);
			
		}
}
