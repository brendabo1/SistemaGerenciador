package sistemaGeral.models;


abstract public class EntidadesDoSistema {
		protected String id;
		
		
		@Override
		abstract public String toString();

		
		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}
		
}
