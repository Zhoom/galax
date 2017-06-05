package modelo.dominio;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TAB_publicador")
public class Publicador extends Usuario{
	
	@Column(length=100, name="nome_publicador")
	private String nome;
	
	@OneToMany(mappedBy = "publicador")
	private List<App> appPublicado;

	public Publicador(String login, String senhaHash, String email, Calendar dataNasc, String avatar,
			boolean licenca, boolean isAdmin, List<Pedido> pedido, List<AppDoUsuario> appDoUsuario, String nome, List<App> appPublicado) {
		super(login, senhaHash, email, dataNasc, avatar, licenca, isAdmin, pedido, appDoUsuario);
		this.nome = nome;
		this.appPublicado = appPublicado;
	}
	
	public Publicador(){
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<App> getAppPublicado() {
		return appPublicado;
	}

	public void setAppPublicado(List<App> appPublicado) {
		this.appPublicado = appPublicado;
	}

	@Override
	public String toString() {
		return "Publicador [publisherID=" + ", nome=" + nome + ", appPublicado=" + appPublicado + "]";
	}
	
}
