package br.com.alura.jpa.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

// Classe criada para fazermos movimentações quando temos uma conta aberta em um banco, 
// como transferências, depósitos, saques e etc.

@Entity // Entidade precisará ser persistida e tratada pela JPA
public class Movimentacao {

	@Id // Chave primária id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Estratégia IDENTITY, a qual é um Auto-increment
	private Long id;

	@Enumerated(EnumType.STRING) // Diremos à JPA que queremos salvar a String que caracteriza o enum
	private TipoMovimentacao tipoMovimentacao;

	private BigDecimal valor;
	private LocalDateTime data;
	private String descricao;

	// Uma categoria pode estar associada a várias movimentações e vice-versa será
	// criada uma tabela de relacionamentos chamada movimentação_categoria por causa
	// da cardinalidade
	@ManyToMany
	private List<Categoria> categorias;

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	// Criando um relacionamento entre a movimentação e conta
	// Informando a cardinalidade deste relacionamento
	@ManyToOne
	private Conta conta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
