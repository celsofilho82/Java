package JOptionalPane;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ExemploOptionalPane4 {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		
		// Criando uma array de objects para ser usuado como possibilidades na janela de confirmação do usuário
		Object[] possibilidades = {"Masculino", "Feminino", "Não informado"};
		
		// Obtendo informações do usuário através de uma janela de input.
		// Esse método retorna uma string
		String sexo = (String) JOptionPane.showInputDialog(null, "Selecione sexo", "LabVirtNet", JOptionPane.PLAIN_MESSAGE, null
				,possibilidades, possibilidades[2]);
		
		System.out.println("Sexo selecionado: " + sexo);
		
		// Obtendo informações do usuário através do teclado
		String nome = (String) JOptionPane.showInputDialog(null, "Digite seu nome: ", "LabVirtNet", JOptionPane.PLAIN_MESSAGE, null
				,null, null);
		System.out.println("Seu nome é: " + nome);
		
	}

}
