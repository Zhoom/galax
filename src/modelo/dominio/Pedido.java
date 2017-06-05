package modelo.dominio;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TAB_pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pedidoID")
	@SequenceGenerator(name="pedidoID", allocationSize=1)
	@Column(name="PK_pedidoID")
	private Integer pedidoID;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_pedido", nullable=false)
	private Calendar dataPedido;
	
	@Column(name="valor_total", nullable=false)
	private Float valorTotal;
	
	@OneToMany(mappedBy = "pedido")
	private List<AppDoPedido> appDoPedido;
	
	@OneToOne
	private Carrinho carrinho;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private FormaDePagamento formaDePagamento;

	public Pedido(Integer pedidoID, Calendar dataPedido, Float valorTotal, List<AppDoPedido> appDoPedido,
			Carrinho carrinho, Usuario usuario, FormaDePagamento formaDePagamento) {
		super();
		this.pedidoID = pedidoID;
		this.dataPedido = dataPedido;
		this.valorTotal = valorTotal;
		this.appDoPedido = appDoPedido;
		this.carrinho = carrinho;
		this.usuario = usuario;
		this.formaDePagamento = formaDePagamento;
	}
	
	public Pedido(){
		super();
	}
	
	public Integer getPedidoID() {
		return pedidoID;
	}

	public void setPedidoID(Integer pedidoID) {
		this.pedidoID = pedidoID;
	}

	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<AppDoPedido> getAppDoPedido() {
		return appDoPedido;
	}

	public void setAppDoPedido(List<AppDoPedido> appDoPedido) {
		this.appDoPedido = appDoPedido;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	@Override
	public String toString() {
		return "Pedido [pedidoID=" + pedidoID + ", dataPedido=" + dataPedido + ", valorTotal=" + valorTotal
				+ ", appDoPedido=" + appDoPedido + ", carrinho=" + carrinho + ", usuario=" + usuario
				+ ", formaDePagamento=" + formaDePagamento + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedidoID == null) ? 0 : pedidoID.hashCode());
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
		Pedido other = (Pedido) obj;
		if (pedidoID == null) {
			if (other.pedidoID != null)
				return false;
		} else if (!pedidoID.equals(other.pedidoID))
			return false;
		return true;
	}
	
}
