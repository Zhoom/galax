package modelo.dominio;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TAB_usuarios")
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario {
	
	//@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userID")
	//@SequenceGenerator(name="userID", allocationSize=1)
	//@Column(name="PK_userID")
	//private Integer userID;
	
	@Id
	private String login;
	
	@Column(name="senha_hash", nullable=false)
	private String senhaHash;
	
	@Column(nullable=false)
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento")
	private Calendar dataNasc;
	
	private String avatar;
	
	@Column(nullable=false)
	private boolean licenca = false;
	
	@Column(nullable=false)
	private boolean isAdmin = false;
	
	@OneToMany(mappedBy = "usuario")
	private List<Pedido> pedido;
	
	@OneToMany(mappedBy = "usuario")
	private List<AppDoUsuario> appDoUsuario;

	public Usuario(String login, String senhaHash, String email, Calendar dataNasc, String avatar,
			boolean licenca, boolean isAdmin, List<Pedido> pedido, List<AppDoUsuario> appDoUsuario) {
		super();
		this.login = login;
		this.senhaHash = senhaHash;
		this.email = email;
		this.dataNasc = dataNasc;
		this.avatar = avatar;
		this.licenca = licenca;
		this.isAdmin = isAdmin;
		this.pedido = pedido;
		this.appDoUsuario = appDoUsuario;
	}
	
	public Usuario(String login, String senhaHash, String email) {
		super();
		this.login = login;
		this.senhaHash = senhaHash;
		this.email = email;
	}

	public Usuario(String login, String senhaHash) {
		super();
		this.login = login;
		this.senhaHash = senhaHash;
	}

	public Usuario(){
		super();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenhaHash() {
		return senhaHash;
	}

	public void setSenhaHash(String senhaHash) {
		this.senhaHash = senhaHash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public boolean isLicenca() {
		return licenca;
	}

	public void setLicenca(boolean licenca) {
		this.licenca = licenca;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	public List<AppDoUsuario> getAppDoUsuario() {
		return appDoUsuario;
	}

	public void setAppDoUsuario(List<AppDoUsuario> appDoUsuario) {
		this.appDoUsuario = appDoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", senhaHash=" + senhaHash + ", email=" + email
				+ ", dataNasc=" + dataNasc + ", avatar=" + avatar + ", licenca=" + licenca + ", isAdmin=" + isAdmin
				+ ", pedido=" + pedido + ", appDoUsuario=" + appDoUsuario + "]";
	}
	
}
