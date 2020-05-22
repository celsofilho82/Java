
public class Gerente extends Funcionario implements Autenticavel {

	private int senha;
	
	public double getBonificacao() {
		return super.getSalario();
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
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
