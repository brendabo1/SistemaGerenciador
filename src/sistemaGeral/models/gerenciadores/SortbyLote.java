package sistemaGeral.models.gerenciadores;

import java.util.Comparator;

import sistemaGeral.models.entidades.ItemCardapio;
import sistemaGeral.models.entidades.Lote;


public class SortbyLote implements Comparator<Lote> {

	@Override
	public int compare(Lote lote1, Lote lote2) {
		return lote1.getValidade().compareTo(lote2.getValidade());
	}


}
