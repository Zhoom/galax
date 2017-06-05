package modelo.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="categoriaID")
	@SequenceGenerator(name="categoriaID", allocationSize=1)
	@Column(name="PK_ID")
	private Integer id;
	
	@Column(unique=true)
	private String tipo;
	
	@OneToMany(mappedBy = "categoria")
	private List<App> app;

	public Categoria(Integer id, String tipo, List<App> app) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.app = app;
	}
	
	public Categoria(){
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<App> getApp() {
		return app;
	}

	public void setApp(List<App> app) {
		this.app = app;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", tipo=" + tipo + ", app=" + app + "]";
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
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
