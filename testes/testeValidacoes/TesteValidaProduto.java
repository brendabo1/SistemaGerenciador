package testeValidacoes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.enums.UnidadeMedida;
import sistemaGeral.models.gerenciadores.GerenciamentoFornecedor;
import sistemaGeral.models.gerenciadores.GerenciamentoProduto;
import sistemaGeral.models.validacoes.ValidaProduto;

class TesteValidaProduto {
	
	@BeforeEach
	public BancoDeDados inicializandoProdutoBancoDeDados() {
		BancoDeDados banco_teste = new BancoDeDados();
		GerenciamentoFornecedor gerenFornecedor = new GerenciamentoFornecedor(banco_teste);
		//gerenFornecedor.cadastrar("Central das Massas", "11112312330001", "Rua da Paz, n201, Algoinhas");
		GerenciamentoProduto gerenProduto = new GerenciamentoProduto(banco_teste, gerenFornecedor);
		gerenProduto.cadastrar("Molho de tomate", gerenFornecedor.cadastrar("Central das Massas", "11112312330001", "Rua da Paz, n201, Algoinhas"), UnidadeMedida.L, 1.0);
		return banco_teste;
	}

	@Test
	@ValueSource(listas = {inicializandoProdutoBancoDeDados()})
	void testProdutoExistente(BancoDeDados listas) {
		ValidaProduto validacao = new ValidaProduto();
		validacao.produtoExistente(null, null, banco_teste);
	}

}
