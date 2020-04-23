package JOptionalPane;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ExemploOptionalPane1 {

	public static void main(String[] args) throws Exception {
		
		// Essa classe é utilizada para mostrar mensagems em aplicações que rodam no cliente
		// Neste exemplo estamos mostrando uma mesagem de confirmação para o usuário e alterando o look padrão da janela.
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		JOptionPane.showMessageDialog(null, "Seu cadastro foi realizado com sucesso");

	}

}
