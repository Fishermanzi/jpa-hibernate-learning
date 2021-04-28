package br.com.eumesmo.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movimentacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private BigDecimal valor;
	
	@Enumerated
	private TipoMovimentacao tipo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	private String descricao;
	
	@ManyToOne
	private Conta conta;
	
	@ManyToMany
	private List<Categoria> categorias;

	////////////
	////////////
	
	@Deprecated
	public Movimentacao() {

	}
	
	public Movimentacao(BigDecimal valor, TipoMovimentacao tipo, Calendar data, String descricao, Conta conta) {
		this.valor = valor;
		this.tipo = tipo;
		this.data = data;
		this.descricao = descricao;
		this.conta = conta;
	}
	
	public Movimentacao(BigDecimal valor, TipoMovimentacao tipo, Calendar data, String descricao, Conta conta, List<Categoria> categorias) {
		
		this.valor = valor;
		this.tipo = tipo;
		this.data = data;
		this.descricao = descricao;
		this.conta = conta;
		this.categorias = categorias;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Categoria> getCategoria() {
		return this.categorias;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categorias = categoria;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movimentacao: [valor=").append(valor).append(", tipo=").append(tipo).append(", descricao=").append(descricao)
				.append("]");
		return builder.toString();
	}
	

}
