package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AppRequisitos {
	
	@Column(length=250)
	private String systemOS;
	
	@Column(length=250)
	private String systemMemory;
	
	@Column(length=250)
	private String systemProcessor;
	
	@Column(length=250)
	private String systemVideoCard;
	
	@Column(length=250)
	private String systemDirectX;
	
	@Column(length=250)
	private String systemHD;
	
	public AppRequisitos(String systemOS, String systemMemory, String systemProcessor, String systemVideoCard,
			String systemDirectX, String systemHD) {
		super();
		this.systemOS = systemOS;
		this.systemMemory = systemMemory;
		this.systemProcessor = systemProcessor;
		this.systemVideoCard = systemVideoCard;
		this.systemDirectX = systemDirectX;
		this.systemHD = systemHD;
	}
	
	public AppRequisitos(){
		super();
	}
	
	public String getSystemOS() {
		return systemOS;
	}
	public void setSystemOS(String systemOS) {
		this.systemOS = systemOS;
	}
	public String getSystemMemory() {
		return systemMemory;
	}
	public void setSystemMemory(String systemMemory) {
		this.systemMemory = systemMemory;
	}
	public String getSystemProcessor() {
		return systemProcessor;
	}
	public void setSystemProcessor(String systemProcessor) {
		this.systemProcessor = systemProcessor;
	}
	public String getSystemVideoCard() {
		return systemVideoCard;
	}
	public void setSystemVideoCard(String systemVideoCard) {
		this.systemVideoCard = systemVideoCard;
	}
	public String getSystemDirectX() {
		return systemDirectX;
	}
	public void setSystemDirectX(String systemDirectX) {
		this.systemDirectX = systemDirectX;
	}
	public String getSystemHD() {
		return systemHD;
	}
	public void setSystemHD(String systemHD) {
		this.systemHD = systemHD;
	}
	
}
