package sistemaGeral.models.gerenciadores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import sistemaGeral.models.BancodeDados;
import sistemaGeral.models.DatasUtils;
import sistemaGeral.models.entidades.Lote;
import sistemaGeral.models.entidades.Produto;


public class GerenciamentoLote extends GerenciamentoGeral implements DatasUtils {
		private HashMap<String, Lote> map_estoque;
		private HashMap<String, ArrayList<String>> agrupamentoDeLotes;
		
		GerenciamentoLote (BancodeDados banco) {
			this.map_estoque = banco.getMap_estoque();
			this.agrupamentoDeLotes = banco.getAgrupamentoDeLotes();
		}
		
		
	public boolean cadastrar (Produto produto, Double quantidade_comprada, Double preco_unitario, LocalDate validade) {
		String novo_id = gerarID(Lote.getPreFixo());
		Lote novo_lote = new Lote(produto, quantidade_comprada, preco_unitario, validade, novo_id);
		return (adicionar(map_estoque, novo_lote) && inserirLoteOrdenado(novo_lote));
	}
		
	public boolean editarProduto (Produto novo_produto, Lote lote) {
		
	}	
	
	
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
		
	
		
}
