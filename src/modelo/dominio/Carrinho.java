package modelo.dominio;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TAB_carrinho")
public class Carrinho {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carrinhoID")
	@SequenceGenerator(name="carrinhoID", allocationSize=1)
	@Column(name="PK_carrinhoID")
	private Integer carrinhoID;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataCricao;
	
	@Column(nullable=false, columnDefinition="NUMERIC(10,2)")
	private Float subtotal = (float) 0.0;
	
	@Column(nullable=false)
	private Integer desconto = 0;
	
	@Column(nullable=false, columnDefinition="NUMERIC(10,2)")
	private Float valorTotal = (float) 0.0;
	
	@OneToMany(mappedBy = "carrinho")
	private List<AppDoCarrinho> appDoCarrinho;

	@OneToOne
	private Pedido pedido;

	public Carrinho(Integer carrinhoID, Calendar dataCricao, Float subtotal, Integer desconto, Float valorTotal,
			List<AppDoCarrinho> appDoCarrinho, Pedido pedido) {
		super();
		this.carrinhoID = carrinhoID;
		this.dataCricao = dataCricao;
		this.subtotal = subtotal;
		this.desconto = desconto;
		this.valorTotal = valorTotal;
		this.appDoCarrinho = appDoCarrinho;
		this.pedido = pedido;
	}
	
	public Carrinho(){
		super();
	}
	
	public Integer getCarrinhoID() {
		return carrinhoID;
	}

	public void setCarrinhoID(Integer carrinhoID) {
		this.carrinhoID = carrinhoID;
	}

	public Calendar getDataCricao() {
		return dataCricao;
	}

	public void setDataCricao(Calendar dataCricao) {
		this.dataCricao = dataCricao;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public Integer getDesconto() {
		return desconto;
	}

	public void setDesconto(Integer desconto) {
		this.desconto = desconto;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<AppDoCarrinho> getAppDoCarrinho() {
		return appDoCarrinho;
	}

	public void setAppDoCarrinho(List<AppDoCarrinho> appDoCarrinho) {
		this.appDoCarrinho = appDoCarrinho;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "Carrinho [carrinhoID=" + carrinhoID + ", dataCricao=" + dataCricao + ", subtotal=" + subtotal
				+ ", desconto=" + desconto + ", valorTotal=" + valorTotal + ", appDoCarrinho=" + appDoCarrinho
				+ ", pedido=" + pedido + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carrinhoID == null) ? 0 : carrinhoID.hashCode());
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
		Carrinho other = (Carrinho) obj;
		if (carrinhoID == null) {
			if (other.carrinhoID != null)
				return false;
		} else if (!carrinhoID.equals(other.carrinhoID))
			return false;
		return true;
	}
	
}
