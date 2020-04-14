
public class Revenda {
	
	public static void main(String[] args) {
		Proprietario dono = new Proprietario();
		dono.nome = "Celso Ribeiro";
		dono.cpf = "826.987.675-53";
		dono.idade = 37;
		dono.logradouro = "Rua Maria de Fátima, 11";
		dono.bairro = "Pau da Lima";
		dono.cidade = "Salvador";
		
		Carro meuCarro = new Carro();
		meuCarro.fabricante = "Chevrollet";
		meuCarro.modelo = "Onix";
		meuCarro.anoDeFabricacao = 2015;
		meuCarro.cor = "Branco";
		meuCarro.dono = dono;
		meuCarro.ligar();
		
		System.out.println("Fabricante: " + meuCarro.fabricante);
		System.out.println("Modelo: " + meuCarro.modelo);
		System.out.println("Ano: " + meuCarro.anoDeFabricacao);
		System.out.println("Proprietário: " + meuCarro.dono.nome);
		
	}

}
