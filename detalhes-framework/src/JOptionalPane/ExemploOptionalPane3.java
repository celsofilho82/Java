package JOptionalPane;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ExemploOptionalPane3 {

	public static void main(String[] args) throws Exception{
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		
		// Gerando as opções para usar na janela de confirmação do usuário.
		Object[] opcoes = {"Sim", "Não", "Sim, com email"};
		
		// Neste exemplo estamos obtendo informações do usuário
		// Esse método devolve um inteiro que é a opção selecionada pelo usuário.
		int opcao = JOptionPane.showOptionDialog(null, "Você gostaria de finalizar o seu cadastro?", "Confirmação"
				, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[2]);
		System.out.println("Opção selecionada: " + opcao);
	}

}
