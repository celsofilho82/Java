
public class Administrador extends Funcionario implements Autenticavel {

	private int senha;
	
	@Override
	public double getBonificacao() {
		// TODO Auto-generated method stub
		return 50.0;
	}

	@Override
	public void setSenha(int senha) {
		// TODO Auto-generated method stub
		this.senha = senha;
	}

	@Override
	public boolean autentica(int senha) {
		// TODO Auto-generated method stub
		if(this.senha == senha){
            return true;
        } else {
            return false;
        }
	}

}
