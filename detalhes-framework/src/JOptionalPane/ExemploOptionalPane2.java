package JOptionalPane;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.net.URL;

public class ExemploOptionalPane2 {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		
		// Mensagem informativa padrão
		JOptionPane.showMessageDialog(null, "Seu cadastro foi realizado com sucesso");
		
		// Alterando o icone da tela de mensagem, mostrando um altera na tela do usuário.
		JOptionPane.showMessageDialog(null, "Atenção: email não informado", "Atenção", JOptionPane.WARNING_MESSAGE);
		
		// Alterando o icone da tela de mensagem, mostrando um erro na tela do usuário.
		JOptionPane.showMessageDialog(null, "Erro: Favor informar o CPF", "Erro", JOptionPane.ERROR_MESSAGE);
		
		// Mostrar uma mesagem informativa mas sem nenhum icone.
		JOptionPane.showMessageDialog(null, "Obrigado", "Agradecimento", JOptionPane.PLAIN_MESSAGE);
		
		// Gerando um icone apartir de uma imagem e inserindo na janela
		URL url = ExemploOptionalPane2.class.getResource("java.png");
		Icon icone = new ImageIcon(url);
		JOptionPane.showMessageDialog(null, "Obrigado por escolher um curso de Java", "LabVirtNet", JOptionPane.INFORMATION_MESSAGE, icone);
		
	}

}
