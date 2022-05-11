package sistemaGeral.models.validacoes;


import java.time.LocalDate;
import java.util.ArrayList;

import sistemaGeral.models.entidades.Estoque;
import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.ItemCardapio;
import sistemaGeral.models.entidades.Produto;
import sistemaGeral.models.entidades.Usuario;

public interface ValidaEntidade {
	public static boolean validarData(LocalDate data) {	
		if(data.compareTo(LocalDate.now())>0) return true;
		return false;
	}  //nao usar pra permitir verificar produtos vencidos

}
