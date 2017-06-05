package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_appComplemento")
public class AppComplemento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="imageId")
	@SequenceGenerator(name="imageId", allocationSize=1)
	@Column(name="PK_imageId")
	private String imageId;
	
	@Column(name="ImagemRef")
	private String imagelinkRef;
	
	@ManyToOne
	private App app;

	public AppComplemento(String imagelinkRef, String imageId) {
		super();
		this.imagelinkRef = imagelinkRef;
		this.imageId = imageId;
	}
	
	public AppComplemento(){
		super();
	}

	public String getImagelinkRef() {
		return imagelinkRef;
	}

	public void setImagelinkRef(String imagelinkRef) {
		this.imagelinkRef = imagelinkRef;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	@Override
	public String toString() {
		return "AppComplemento [imageId=" + imageId + ", imagelinkRef=" + imagelinkRef + "]";
	}
	
}
