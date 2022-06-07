package testeGerenciamentos;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.IngredienteDoItem;
import sistemaGeral.models.entidades.ItemCardapio;
import sistemaGeral.models.entidades.Produto;
import sistemaGeral.models.entidades.enums.CategoriasDeItens;
import sistemaGeral.models.entidades.enums.UnidadeMedida;
import sistemaGeral.models.gerenciadores.GerenciamentoFornecedor;
import sistemaGeral.models.gerenciadores.GerenciamentoItemCardapio;
import sistemaGeral.models.gerenciadores.GerenciamentoLote;
import sistemaGeral.models.gerenciadores.GerenciamentoProduto;

public class TesteGerenciamentoItemCardapio {
		BancoDeDados banco = new BancoDeDados();
		GerenciamentoLote gerLote = new GerenciamentoLote(banco);
		GerenciamentoFornecedor gerFornecedor = new GerenciamentoFornecedor(banco);
		GerenciamentoProduto gerProduto = new GerenciamentoProduto(banco, gerFornecedor);
		GerenciamentoItemCardapio gerItemCardapio = new GerenciamentoItemCardapio(banco, gerLote);
		
		@Test
		void testCriandoUmItemCardapio() {
			Fornecedor fornecedor = gerFornecedor.cadastrar("Mario", "0101010101", "Viela da Amargura");
			Produto produto = gerProduto.cadastrar("Banana", fornecedor, UnidadeMedida.KG, 2.0);
			HashMap<String, IngredienteDoItem> ingredientes = new HashMap<>();
			IngredienteDoItem ingrediente = gerItemCardapio.criarIngrediente(produto, 10.0);
			ingredientes.put(ingrediente.getId(), ingrediente);
			
			assertNotNull(gerItemCardapio.cadastrar("Bananada", ingredientes, 20.40, CategoriasDeItens.SOBREMESA));
		}
		
		@Test 
		void testEditandoNome() {
			Fornecedor fornecedor = gerFornecedor.cadastrar("Mario", "0101010101", "Cidade do Sono");
			Produto produto = gerProduto.cadastrar("Banana", fornecedor, UnidadeMedida.KG, 2.0);
			HashMap<String, IngredienteDoItem> ingredientes = new HashMap<>();
			IngredienteDoItem ingrediente = gerItemCardapio.criarIngrediente(produto, 10.0);
			ingredientes.put(ingrediente.getId(), ingrediente);	
			ItemCardapio item = gerItemCardapio.cadastrar("Bananada", ingredientes, 20.40, CategoriasDeItens.SOBREMESA);
			
			assertTrue(gerItemCardapio.editarNome("BananeiraComBanana", item));
		}
		
		@Test
		void testEditandoPreco() {
			Fornecedor fornecedor = gerFornecedor.cadastrar("Mario", "0101010101", "Povoado da Tristeza");
			Produto produto = gerProduto.cadastrar("Banana", fornecedor, UnidadeMedida.KG, 2.0);
			HashMap<String, IngredienteDoItem> ingredientes = new HashMap<>();
			IngredienteDoItem ingrediente = gerItemCardapio.criarIngrediente(produto, 10.0);
			ingredientes.put(ingrediente.getId(), ingrediente);	
			ItemCardapio item = gerItemCardapio.cadastrar("Bananada", ingredientes, 20.40, CategoriasDeItens.SOBREMESA);
			
			assertTrue(gerItemCardapio.editarPreco(40.0, item));
		}
		
		@Test
		void testEditandoCategoria() {
			Fornecedor fornecedor = gerFornecedor.cadastrar("Mario", "0101010101", "Rua do PoucoDormir");
			Produto produto = gerProduto.cadastrar("Banana", fornecedor, UnidadeMedida.KG, 2.0);
			HashMap<String, IngredienteDoItem> ingredientes = new HashMap<>();
			IngredienteDoItem ingrediente = gerItemCardapio.criarIngrediente(produto, 10.0);
			ingredientes.put(ingrediente.getId(), ingrediente);	
			ItemCardapio item = gerItemCardapio.cadastrar("Bananada", ingredientes, 20.40, CategoriasDeItens.SOBREMESA);
			
			assertTrue(gerItemCardapio.editarCategoria(CategoriasDeItens.PRATO, item));
		}
		
		@Test
		void testEditandoQuantidadeDoIngrediente() {
			Fornecedor fornecedor = gerFornecedor.cadastrar("Mario", "0101010101", "Povoado da Tristeza");
			Produto produto = gerProduto.cadastrar("Banana", fornecedor, UnidadeMedida.KG, 2.0);
			HashMap<String, IngredienteDoItem> ingredientes = new HashMap<>();
			IngredienteDoItem ingrediente = gerItemCardapio.criarIngrediente(produto, 10.0);
			ingredientes.put(ingrediente.getId(), ingrediente);	
			ItemCardapio item = gerItemCardapio.cadastrar("Bananada", ingredientes, 20.40, CategoriasDeItens.SOBREMESA);
	
			assertTrue(gerItemCardapio.editarQuantidadeDoIngrediente(40.0, ingrediente.getId(), item));
		}
		
		@Test
		void testAdicionarIngrediente() {
			Fornecedor fornecedor = gerFornecedor.cadastrar("Mario", "0101010101", "Avenida QueroCama");
			Produto produto = gerProduto.cadastrar("Banana", fornecedor, UnidadeMedida.KG, 2.0);
			HashMap<String, IngredienteDoItem> ingredientes = new HashMap<>();
			IngredienteDoItem ingrediente = gerItemCardapio.criarIngrediente(produto, 10.0);
			ingredientes.put(ingrediente.getId(), ingrediente);	
			ItemCardapio item = gerItemCardapio.cadastrar("Bananada", ingredientes, 20.40, CategoriasDeItens.SOBREMESA);
			
			Produto novo_produto = gerProduto.cadastrar("Morango", fornecedor, UnidadeMedida.KG, 3.0);
			IngredienteDoItem novo_ingrediente = gerItemCardapio.criarIngrediente(novo_produto, 15.0);

			assertTrue(gerItemCardapio.adicionarIngrediente(novo_ingrediente, item));
		}
		
		@Test
		void testExcluirIngrediente() {
			Fornecedor fornecedor = gerFornecedor.cadastrar("Mario", "0101010101", "Avenida QueroCama");
			Produto produto = gerProduto.cadastrar("Banana", fornecedor, UnidadeMedida.KG, 2.0);
			HashMap<String, IngredienteDoItem> ingredientes = new HashMap<>();
			IngredienteDoItem ingrediente = gerItemCardapio.criarIngrediente(produto, 10.0);
			ingredientes.put(ingrediente.getId(), ingrediente);	
			ItemCardapio item = gerItemCardapio.cadastrar("Bananada", ingredientes, 20.40, CategoriasDeItens.SOBREMESA);
			
			Produto novo_produto = gerProduto.cadastrar("Morango", fornecedor, UnidadeMedida.KG, 3.0);
			IngredienteDoItem novo_ingrediente = gerItemCardapio.criarIngrediente(novo_produto, 15.0);
			gerItemCardapio.adicionarIngrediente(novo_ingrediente, item);
			
			assertTrue(gerItemCardapio.excluirIngrediente(ingrediente.getId(), item));
		}
}
