package sistemaGeral.models.gerenciadores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import sistemaGeral.models.BancoDeDados;
import sistemaGeral.models.DatasUtils;
import sistemaGeral.models.entidades.EntidadesDoSistema;
import sistemaGeral.models.entidades.Lote;
import sistemaGeral.models.entidades.Produto;

/**
 * Classe para aplicacao de operacoes na entidade Lote.
 * @author Elmer Carvalho
 *@author Brenda Barbosa
 */
public class GerenciamentoLote extends GerenciamentoGeral implements DatasUtils {
		private HashMap<String, Lote> map_estoque;
		private HashMap<String, ArrayList<String>> agrupamentoDeLotes;
		
		/**
		 * Construtor do gerenciamento de lote.
		 * @param banco objeto para armazenamento das entidades.
		 */
		public GerenciamentoLote (BancoDeDados banco) {
			this.map_estoque = banco.getMap_estoque();
			this.agrupamentoDeLotes = banco.getAgrupamentoDeLotes();
		}
		
	/**
	 * M�todo para cadastro do lote.
	 * @param produto produto que compoe o lote.
	 * @param quantidade_comprada quantidade comprada do produto.
	 * @param preco_unitario preco do produto.
	 * @param validade validade do produto.
	 * @return retorna o lote se cadastrar ou null caso nao cadastre.
	 */
	public Lote cadastrar (Produto produto, Double quantidade_comprada, Double preco_unitario, LocalDate validade) {
		String novo_id = gerarID(Lote.getPreFixo());
		Lote novo_lote = new Lote(produto, quantidade_comprada, preco_unitario, validade, novo_id);
		if (adicionar(map_estoque, novo_lote) && inserirLoteOrdenado(novo_lote))
			return novo_lote;
		return null;
	}
	
	/**
	 * M�todo para consumir os produtos do lote.
	 * @param quantidade_consumida grandeza numerica referente a unidade de medida do produto que sera consumido.
	 * @param nome_produto nome do produto que sera consumido.
	 * @return retorna false se nao consumir e true se consumir.
	 */
	public boolean consumirLote (Double quantidade_consumida, String nome_produto) {
		ArrayList<String> id_lotes = agrupamentoDeLotes.get(nome_produto);
		if (id_lotes == null)
			return false;
		
		for (String id : id_lotes) {
			Lote lote = map_estoque.get(id);
			
			if (lote == null)
				id_lotes.remove(id);
			
			if (lote.getQuantidade_em_armazenamento() <= quantidade_consumida) {
				quantidade_consumida -= lote.getQuantidade_em_armazenamento();
				excluirLote(id);
				if (quantidade_consumida == 0.0) 
					break;
			} else {
				lote.setQuantidade_em_armazenamento(lote.getQuantidade_em_armazenamento() - quantidade_consumida);
				break;
			}
		}
		return true;
	}
	
	/**
	 * M�todo para edicao do produto do lote.
	 * @param novo_produto novo produto do lote.
	 * @param lote lote que sera modificado.
	 * @return retorna true se editar e false se nao editar.
	 */
	public boolean editarProduto (Produto novo_produto, Lote lote) {
		lote.setProduto(novo_produto);
		return lote.getProduto().equals(novo_produto);
	}	
	
	/**
	 * Metodo para editar a quantidade comprada do produto no lote.
	 * @param nova_quantidadeComprada nova quantidade do produto.
	 * @param lote lote que sera modificado.
	 * @return retorna true se modificar e false se nao modificar.
	 */
	public boolean editarQuantidadeComprada (Double nova_quantidadeComprada, Lote lote) {
		lote.setUnidades_compradas(nova_quantidadeComprada);
		return lote.getUnidades_compradas().equals(nova_quantidadeComprada);
	}
	
	/**
	 * Metodo para editar o preco do produto.
	 * @param novo_precoUnitario novo predo do produto.
	 * @param lote lote que sera modificado.
	 * @return retorna true se modificar e false se nao modificar.
	 */
	public boolean editarPrecoUnitario (Double novo_precoUnitario, Lote lote) {
		lote.setPreco(novo_precoUnitario);
		return lote.getPreco().equals(novo_precoUnitario);
	}
	
	/**
	 * Metodo para modificar a validade do produto.
	 * @param nova_validade nova validade do produto.
	 * @param lote lote que sera modificado.
	 * @return retorna true se modificar e false se nao modificar.
	 */
	public boolean editarValidade (LocalDate nova_validade, Lote lote) {
		lote.setValidade(nova_validade);
		return lote.getValidade().equals(nova_validade);
	}
	
	/**
	 * Metodo para excluir o lote.
	 * @param id_selecionado identificadao do lote que sera consumido.
	 * @return
	 */
	public boolean excluirLote (String id_selecionado) {
		Lote lote = map_estoque.get(id_selecionado);
		ArrayList<String> id_lotes = agrupamentoDeLotes.get(lote.getProduto().getNome().toLowerCase());

		return (super.excluir(map_estoque, id_selecionado) && id_lotes.remove(id_selecionado));
	}
	
	/**
	 * Metodo para inserir lote de forma ordenada.
	 * @param novo_lote novo lote que sera ordenado.
	 * @return retorna true se adicionar ordenado e false se nao adicionar.
	 */
 	private boolean inserirLoteOrdenado(Lote novo_lote) {
		String nome_produto = novo_lote.getProduto().getNome().toLowerCase();
		ArrayList<String> listaLote = agrupamentoDeLotes.get(nome_produto);
		
		if (listaLote == null) {	
			listaLote = new ArrayList<>();
			listaLote.add(novo_lote.getId());				
			agrupamentoDeLotes.put(nome_produto, listaLote);
			return true;
		} else {
			for (int i = 0; i < listaLote.size(); i++) {
				Lote lote_cadastrado = map_estoque.get(listaLote.get(i));
				if (DatasUtils.primeiraDataMenor(novo_lote.getValidade(), lote_cadastrado.getValidade())) {
						listaLote.add(i, novo_lote.getId());
						return true;
				}
				if (i == listaLote.size()-1) {
						listaLote.add(novo_lote.getId());
						return true;
				}
			}	
		}
		return false;
	}
		
 	
 	public HashMap<String, Lote> getMap_estoque() {
		return map_estoque;
	}
	public HashMap<String, ArrayList<String>> getAgrupamentoDeLotes() {
		return agrupamentoDeLotes;
	}


	// N�o deve ser utilizado, por isso sobrescrevi. Utilize o outro m�todo de exclus�o.
 	@Override
	public <T extends EntidadesDoSistema> boolean excluir(HashMap<String, T> map_entidade, String ID_buscado) {
 		return false;
 	}
}
