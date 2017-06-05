package modelo.dominio;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TAB_apps")
public class App {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="appID")
	@SequenceGenerator(name="appID", allocationSize=1)
	@Column(name="PK_appID")
	private	Integer	appID;
	
	@Column(length=100, name="nome_app", nullable=false)
	private String appNome;
	
	@Column(nullable=false)
	private Float preco;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_lancamento")
	private Calendar dataLancamento;

	@Column(length=100, nullable=false)
	private String desenvolvedor;
	
	@Column(length=250)
	private String descricao;
	
	@Column(length=800,name="sobre_app")
	private String sobreApp;
	
	@ManyToOne
	@JoinColumn(name="FK_publicador")
	private Publicador publicador;
	
	@ManyToOne
	@JoinColumn(name="FK_categoria")
	private Categoria categoria;
	
	@OneToMany(mappedBy="app")
	private List<AppComplemento> complemento;
	
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name="systemOS",column=@Column(name="system_os_min")),
        @AttributeOverride(name="systemMemory", column=@Column(name="system_memory_min")),
        @AttributeOverride(name="systemProcessor", column=@Column(name="system_processor_min")),
        @AttributeOverride(name="systemVideoCard", column=@Column(name="system_videocard_min")),
        @AttributeOverride(name="systemDirectX", column=@Column(name="system_directx_min")),
        @AttributeOverride(name="systemHD", column=@Column(name="system_hd_min"))
    })
	private AppRequisitos requisitoMinimo;

	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name="systemOS",column=@Column(name="system_os_rec")),
        @AttributeOverride(name="systemMemory", column=@Column(name="system_memory_rec")),
        @AttributeOverride(name="systemProcessor", column=@Column(name="system_processor_rec")),
        @AttributeOverride(name="systemVideoCard", column=@Column(name="system_videocard_rec")),
        @AttributeOverride(name="systemDirectX", column=@Column(name="system_directx_rec")),
        @AttributeOverride(name="systemHD", column=@Column(name="system_hd_rec"))
    })
	private AppRequisitos requisitoRecomendado;


	public App(Integer appID, String appNome, Float preco, String desenvolvedor, String descricao, String sobreApp, AppRequisitos requisitoMinimo, AppRequisitos requisitoRecomendado) {
		super();
		this.appID = appID;
		this.appNome = appNome;
		this.preco = preco;
		this.desenvolvedor = desenvolvedor;
		this.descricao = descricao;
		this.sobreApp = sobreApp;
		this.requisitoMinimo = requisitoMinimo;
		this.requisitoRecomendado = requisitoRecomendado;
	}
	
	public App(){
		super();
	}

	public Integer getAppID() {
		return appID;
	}

	public void setAppID(Integer appID) {
		this.appID = appID;
	}

	public String getAppIDStr() {
		if (this.appID == null)
			return "";
		
		return appID.toString();
	}
	
	public String getAppNome() {
		return appNome;
	}

	public void setAppNome(String appNome) {
		this.appNome = appNome;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}
	
	public String getPrecoStr() {
		if (this.preco == null)
			return "";
		
		return String.format(Locale.ENGLISH, "%.2f", preco);
	}
	
	public String getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(String desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public String getDescricaoStr() {
		if (this.descricao == null)
			return "";
		
		return descricao.toString();
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSobreApp() {
		return sobreApp;
	}

	public void setSobreApp(String sobreApp) {
		this.sobreApp = sobreApp;
	}
	
	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Publicador getPublicador() {
		return publicador;
	}

	public void setPublicador(Publicador publicador) {
		this.publicador = publicador;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<AppComplemento> getComplemento() {
		return complemento;
	}

	public void setComplemento(List<AppComplemento> complemento) {
		this.complemento = complemento;
	}

	public AppRequisitos getRequisitoMinimo() {
		return requisitoMinimo;
	}

	public void setRequisitoMinimo(AppRequisitos requisitoMinimo) {
		this.requisitoMinimo = requisitoMinimo;
	}

	public AppRequisitos getRequisitoRecomendado() {
		return requisitoRecomendado;
	}

	public void setRequisitoRecomendado(AppRequisitos requisitoRecomendado) {
		this.requisitoRecomendado = requisitoRecomendado;
	}

	@Override
	public String toString() {
		return "App [appID=" + appID + ", appNome=" + appNome + ", preco=" + preco + ", desenvolvedor=" + desenvolvedor
				+ ", descricao=" + descricao + ", sobreApp=" + sobreApp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appID == null) ? 0 : appID.hashCode());
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
		App other = (App) obj;
		if (appID == null) {
			if (other.appID != null)
				return false;
		} else if (!appID.equals(other.appID))
			return false;
		return true;
	}
	
}
