package br.com.alura.java.io.teste;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class TesteUnicodeEncoding {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// Unicode, Encode e codepoint
		
		// Verificando o codepoint de uma string
		String s = "C";
		System.out.println(s.codePointAt(0));
		
		// Verificando o encoding padrão utilizado pelo Java
		// O charset define como converter os codepoints em uma 
		// sequência de bits e bytes para gravar no disco
		Charset charset = Charset.defaultCharset();
		System.out.println(charset.displayName());
		
		// Obtendo os bytes de uma string
		byte[] bytes = s.getBytes();
		System.out.println(bytes.length + ", UTF-8");
		
		// Alterando o charset padrão
		// Uma exceção "UnsupportedEncodingException" pode ser lançada
		byte[] bytes2 = s.getBytes("windows-1252");
		System.out.println(bytes.length + ", windows-1252");
	}

}
