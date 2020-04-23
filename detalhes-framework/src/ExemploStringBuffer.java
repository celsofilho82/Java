
public class ExemploStringBuffer {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		
		// A principal vantagem do StringBuffer é que ele gerar strings mutáveis 
		// conforme exemplo:
		sb.append("Bem vindo ao curso de Java. ");
		sb.append("Fique a vontade para tirar suas dúvidas ");
		System.out.println(sb);
		
		// Com o método insert() podemos inserir uma string em determinada posição
		sb.insert(26, " da LabVirtNet");
		System.out.println(sb);
		
		StringBuilder sbuild = new StringBuilder();
		
		// StringBuilder funciona da mesma forma que a StringBuffer e a grande
		// diferênça é que StringBuffer é thread safe e StringBuilder não.
		sbuild.append("Bem vindo ao curso de Java. ");
		sbuild.append("Fique a vontade para tirar suas dúvidas ");
		System.out.println(sbuild);
		
	}
}
