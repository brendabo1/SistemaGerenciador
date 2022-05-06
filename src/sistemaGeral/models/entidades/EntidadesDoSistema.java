package sistemaGeral.models.entidades;


abstract public class EntidadesDoSistema {
		protected String id;
		static protected String preFixo;
		
		
		@Override
		abstract public String toString();

		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}


		public static String getPreFixo() {
			return preFixo;
		}
		public static void setPreFixo(String pre_Fixo) {
			preFixo = pre_Fixo;
		}
}
