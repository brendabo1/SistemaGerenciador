package sistemaGeral.controllers.validacoes;

public class ValidarVenda {
		public static boolean validarFormaDePagamento(String formaDePagamento) {
			return (!formaDePagamento.isBlank() && formaDePagamento.matches("[a-zA-Z]*"));
		}
}
