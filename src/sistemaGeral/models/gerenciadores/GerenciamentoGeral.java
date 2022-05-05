package sistemaGeral.models.gerenciadores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sistemaGeral.models.entidades.EntidadesDoSistema;
import sistemaGeral.models.entidades.Fornecedor;
import sistemaGeral.models.entidades.ItemCardapio;

abstract public class GerenciamentoGeral {
	
	/**
	 * Gera um código de identificação único e ordenado para cada novo elemento do tipo Entidade do Sistema
	 * @param <T> Entidade do Sistema
	 * @param lista Lista de objetos do tipo Entidade Do Sistema
	 * @param prefixo Sigla predefinida e imutável de cada classe do tipo Entidade
	 * @return Novo codigo de identificação único;
	 */
	public static <T extends EntidadesDoSistema> String gerarID(List<T> lista, String prefixo) {
		String novo_id = "", ultimoID, ultimoNum;
		int num, indexUltimo;
		
		if(lista.isEmpty()) {
			num = 0;			
		}
		else {
			indexUltimo = lista.size()-1;
			ultimoID = lista.get(indexUltimo).getId();
			ultimoNum = ultimoID.substring(3, ultimoID.length());
			num = Integer.parseInt(ultimoNum);
		}
		
		num++;
		novo_id = prefixo + Integer.toString(num);
		
		return novo_id;
	}
	

	
	public <T extends EntidadesDoSistema> boolean adicionar(List<T> lista, T obj) {
		return lista.add(obj);
	}
	
	
	public <T extends EntidadesDoSistema> boolean excluir(List<T> lista, String ID_buscado) {
		for (EntidadesDoSistema i: lista) if (i.getId().equals(ID_buscado)) return lista.remove(i);
		
		return false;
	}
	
	//Isso deveria estar no controler pra exibir na view
	public <T extends EntidadesDoSistema> void listar(List<T> lista) {
			if (lista.isEmpty()) {
				System.out.println("--> Atualmente não há cadastro <--");
			}
			else 
				for (EntidadesDoSistema i: lista) System.out.println(i.toString());
	}
	
	
	public <T extends EntidadesDoSistema> T buscarEntidade_ID(List<T> lista, String id_buscada) {
			for (T entidade: lista) if (entidade.getId().equals(id_buscada)) return entidade;
			
			return null;
	}
	
	public <T extends EntidadesDoSistema> T buscarEntidade_Nome(List<T> lista, String nome_buscado) {
		for (T entidade: lista) if (entidade.getId().equals(nome_buscado)) return entidade;
		
		return null;
	}
	
	
	/*
	public ArrayList<ItemCardapio> listarNomesBuscadosCorrespondentes(String nome_buscado) {
		ArrayList<ItemCardapio> itensCorrespondentes = new ArrayList<>();
		for(ItemCardapio item: this.lista_itensCardapio) {
			if(item.getNome().contains(nome_buscado)) itensCorrespondentes.add(item);
		}
		return itensCorrespondentes;
		
	}*/
	
   
}
