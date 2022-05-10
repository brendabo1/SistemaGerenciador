package sistemaGeral.models.entidades;

public class IngredienteDoItem extends EntidadesDoSistema{
	private Produto produto;
	private Double quantidade_usada;

	
	 IngredienteDoItem (Produto produto, Double quantidade_usada, String id) {
		this.id = id;
		this.produto = produto;
		this.quantidade_usada = quantidade_usada;
		
		IngredienteDoItem.preFixo = "ING";
	}
	 
	 
	@Override
	public String toString() {
		String message = String.format("[%s] - %s  -  %f %s", produto.getId(), produto.getNome(), quantidade_usada, produto.getUnidade_medida());
		return message;
	}
	

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getQuantidade_usada() {
		return quantidade_usada;
	}
	public void setQuantidade_usada(Double quantidade_usada) {
		this.quantidade_usada = quantidade_usada;
	}
}
