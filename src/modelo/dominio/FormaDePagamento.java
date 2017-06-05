package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_forma_de_pagamento")
public class FormaDePagamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="forma_pagamentoID")
	@SequenceGenerator(name="forma_pagamentoID", allocationSize=1)
	@Column(name="PK_ID")
	private Integer id;
	
	@Column(length=50, nullable=false)
	private String descricao;

	public FormaDePagamento(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	public FormaDePagamento(){
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "FormaDePagamento [id=" + id + ", descricao=" + descricao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormaDePagamento other = (FormaDePagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
