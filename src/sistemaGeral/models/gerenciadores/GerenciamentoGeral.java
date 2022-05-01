package sistemaGeral.models.gerenciadores;

import java.util.List;
import java.util.Random;

import sistemaGeral.models.EntidadesDoSistema;

abstract public class GerenciamentoGeral {
	  
	/**
	 * Gera um código de identificação único e ordenado para cada novo elemento do tipo Entidade do Sistema
	 * @param <E> Entidade do Sistema
	 * @param lista Lista de objetos do tipo Entidade Do Sistema
	 * @param prefixo Sigla predefinida e imutável de cada classe do tipo Entidade
	 * @return Novo codigo de identificação único;
	 */
	public static  <E extends EntidadesDoSistema> String gerarID(List<E> lista, String prefixo) {
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
	

		
		public <G extends EntidadesDoSistema> boolean adicionar(List<G> lista, G obj) {
			return lista.add(obj);
		}
		
		
		public  <G extends EntidadesDoSistema> boolean excluir(List<G> lista, String ID_buscado) {
				for (EntidadesDoSistema i: lista) if (i.getId().equals(ID_buscado)) return lista.remove(i);
				
				return false;
		}
		
		
		public  <G extends EntidadesDoSistema> void listar(List<G> lista) {
				if (lista.isEmpty()) {
					System.out.println("--> Atualmente não há cadastro <--");
				}
				else 
					for (EntidadesDoSistema i: lista) System.out.println(i.toString());
		}
		
		
		public <G extends EntidadesDoSistema> G buscarEntidade(List<G> lista, String id) {
				for (G entidade: lista) if (entidade.getId().equals(id)) return entidade;
				
				return null;
		}
	   
}
