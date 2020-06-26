package br.com.alura.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Mapeando a classe conta para um tabela no banco de dados
public class Conta {

	@Id // Indica qual atributo representa a chave primaria:
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que o valor será gerado automaticamente
	private Long id;
	private Integer agencia;
	private Integer numero;
	private String titular;
	// Novo atributo inserido depois de criada a tablea conta no database
	private Double saldo;

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

}
