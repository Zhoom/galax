package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_app_do_carrinho")
public class AppDoCarrinho {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="appDoCarrinhoID")
	@SequenceGenerator(name="appDoCarrinhoID", allocationSize=1)
	@Column(name="PK_ID")
	private Integer id;
	
	@Column(length=100, name="nome_app", nullable=false)
	private String nome;
	
	@Column(name="preco_app", nullable=false)
	private Float preco;
	
	@ManyToOne
	@JoinColumn(name="FK_carrinho", nullable=false)
	private Carrinho carrinho;
	
	@OneToOne
	@JoinColumn(name="FK_app", nullable=false)
	private App app;
	
	public AppDoCarrinho(Integer id, String nome, Float preco, Carrinho carrinho, App app) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.carrinho = carrinho;
		this.app = app;
	}
	
	public AppDoCarrinho() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}
	
}
