package testeGerenciamentos;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.Lote;
import sistemaGeral.models.entidades.Produto;
import sistemaGeral.models.entidades.enums.UnidadeMedida;
import sistemaGeral.models.gerenciadores.GerenciamentoFornecedor;
import sistemaGeral.models.gerenciadores.GerenciamentoLote;
import sistemaGeral.models.gerenciadores.GerenciamentoProduto;

public class TesteGerenciamentoLote {
		BancoDeDados banco = new BancoDeDados();
		GerenciamentoFornecedor gerFornecedor = new GerenciamentoFornecedor(banco);
		GerenciamentoProduto gerProduto = new GerenciamentoProduto(banco, gerFornecedor);
		GerenciamentoLote gerLote = new GerenciamentoLote(banco);
		
		@Test
		void testCriandoUmLote() {
			Fornecedor fornecedor = gerFornecedor.cadastrar("Jo�ozinDaQuebrada", "66666666666", "Batalh�o do Amor");
			Produto produto = gerProduto.cadastrar("Farinha", fornecedor, UnidadeMedida.KG, 50.75);
			assertNotNull(gerLote.cadastrar(produto, 75.0, 25.60, LocalDate.parse("2022-08-21")));
		}
		
		@Test
		void testConsumirUmLote () {
			Fornecedor fornecedor = gerFornecedor.cadastrar("Jo�ozinDaQuebrada", "66666666666", "Batalh�o do Amor");
			Produto produto = gerProduto.cadastrar("Farinha", fornecedor, UnidadeMedida.KG, 50.75);
			Lote lote = gerLote.cadastrar(produto, 75.0, 25.60, LocalDate.parse("2022-08-21"));
			assertTrue(gerLote.consumirLote(20.0, produto.getNome().toLowerCase()));
		}
		
		@Test
		void testEditarProdutoDoLote() {
			Fornecedor fornecedor = gerFornecedor.cadastrar("Jo�ozinDaQuebrada", "66666666666", "Batalh�o do Amor");
			Produto produto = gerProduto.cadastrar("Farinha", fornecedor, UnidadeMedida.KG, 50.75);
			Lote lote = gerLote.cadastrar(produto, 75.0, 25.60, LocalDate.parse("2022-08-21"));
			
			Produto novo_produto = gerProduto.cadastrar("Arroz", fornecedor, UnidadeMedida.KG, 45.70);
			assertTrue(gerLote.editarProduto(novo_produto, lote));
		}
		
		@Test
		void testEditarQuantidadeCompradaDoLote() {
			Fornecedor fornecedor = gerFornecedor.cadastrar("Jo�ozinDaQuebrada", "66666666666", "Batalh�o do Amor");
			Produto produto = gerProduto.cadastrar("Farinha", fornecedor, UnidadeMedida.KG, 50.75);
			Lote lote = gerLote.cadastrar(produto, 75.0, 25.60, LocalDate.parse("2022-08-21"));
			
			assertTrue(gerLote.editarQuantidadeComprada(45.0, lote));
		}
		
		@Test
		void testEditarPrecoUnitarioDoLote() {
			Fornecedor fornecedor = gerFornecedor.cadastrar("Jo�ozinDaQuebrada", "66666666666", "Batalh�o do Amor");
			Produto produto = gerProduto.cadastrar("Farinha", fornecedor, UnidadeMedida.KG, 50.75);
			Lote lote = gerLote.cadastrar(produto, 75.0, 25.60, LocalDate.parse("2022-08-21"));
			
			assertTrue(gerLote.editarPrecoUnitario(86.75, lote));
		}
		
		@Test
		void testEditarValidarDoLote() {
			Fornecedor fornecedor = gerFornecedor.cadastrar("Jo�ozinDaQuebrada", "66666666666", "Batalh�o do Amor");
			Produto produto = gerProduto.cadastrar("Farinha", fornecedor, UnidadeMedida.KG, 50.75);
			Lote lote = gerLote.cadastrar(produto, 75.0, 25.60, LocalDate.parse("2022-08-21"));
			
			assertTrue(gerLote.editarValidade(LocalDate.parse("2023-11-09"), lote));
		}
		
		@Test
		void testExcluirUmLote() {
			Fornecedor fornecedor = gerFornecedor.cadastrar("Jo�ozinDaQuebrada", "66666666666", "Batalh�o do Amor");
			Produto produto = gerProduto.cadastrar("Farinha", fornecedor, UnidadeMedida.KG, 50.75);
			Lote lote = gerLote.cadastrar(produto, 75.0, 25.60, LocalDate.parse("2022-08-21"));
			
			assertTrue(gerLote.excluirLote(lote.getId()));
		}
		

}
