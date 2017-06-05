package modelo.dominio;

import java.util.Calendar;

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
@Table(name="TAB_app_do_usuario")
public class AppDoUsuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usrId")
	@SequenceGenerator(name="usrId", allocationSize=1)
	@Column(name="PK_ID")
	private Integer id;
	
	@Column(name="data_compra")
	private Calendar dataCompra;
	
	@Column(name="horas_usadas")
	private Integer horasUsadas;
	
	@Column(name="ultimo_uso")
	private Calendar ultimaVezUtilizado;
	
	@ManyToOne
	@JoinColumn(name="FK_usuario", nullable=false)
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name="FK_app", nullable=false)
	private App app;

	public AppDoUsuario(Integer id, Calendar dataCompra, Integer horasUsadas, Calendar ultimaVezUtilizado,
			Usuario usuario, App app) {
		super();
		this.id = id;
		this.dataCompra = dataCompra;
		this.horasUsadas = horasUsadas;
		this.ultimaVezUtilizado = ultimaVezUtilizado;
		this.usuario = usuario;
		this.app = app;
	}
	
	public AppDoUsuario(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	public AppDoUsuario(){
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Calendar dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Integer getHorasUsadas() {
		return horasUsadas;
	}

	public void setHorasUsadas(Integer horasUsadas) {
		this.horasUsadas = horasUsadas;
	}

	public Calendar getUltimaVezUtilizado() {
		return ultimaVezUtilizado;
	}

	public void setUltimaVezUtilizado(Calendar ultimaVezUtilizado) {
		this.ultimaVezUtilizado = ultimaVezUtilizado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}
	
}
