package sistemaGeral.models.gerenciadores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import sistemaGeral.models.entidades.EntidadesDoSistema;


abstract public class GerenciamentoGeral {
	
	private HashSet<String> id_cadastrados = new HashSet<>();
	
	public  String gerarID(String preFixo) {
			Random random = new Random();
			String novo_id;
			
			do {
				novo_id = preFixo;
				for (int i = 0; i < 5; i++) 
						novo_id += random.nextInt(0, 9);
			} while (id_cadastrados.contains(novo_id));
			
			return novo_id;
	}
	
	
	public <T extends EntidadesDoSistema> boolean adicionar(HashMap<String, T> map_entidade, T obj) {
		T obj_anterior = map_entidade.put(obj.getId(), obj);
		if (obj_anterior == null) {
				id_cadastrados.add(obj.getId());
				return true;
		}
		else {
			map_entidade.put(obj.getId(), obj_anterior);
			return false;
		}
	}
	
	
	public <T extends EntidadesDoSistema> boolean excluir(HashMap<String, T> map_entidade, String ID_buscado) {
		T obj_anterior = map_entidade.remove(ID_buscado);
		if (obj_anterior != null) {
			id_cadastrados.remove(ID_buscado);
			return true;
		}
		return false;
	}
	
	
	public <T extends EntidadesDoSistema> String listar(HashMap<String, T> map_entidade) {
			if (map_entidade.isEmpty())
					return null;
		
			String message = new String();
			for (T obj : map_entidade.values())
					message += obj.toString();
			
			return message;
	}
	
	
	public <T extends EntidadesDoSistema> T buscarEntidade_ID(HashMap<String, T> map_entidade, String id_buscada) {
			return map_entidade.get(id_buscada);
	}
	
	public <T extends EntidadesDoSistema> ArrayList<T> convertHashToArr(HashMap<String, T> hash){
		Collection<T> colecao = hash.values();
		ArrayList<T> lista = new ArrayList<>(colecao);
		return lista;
	}
}
