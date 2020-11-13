package dto;

import java.io.Serializable;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tags implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private UUID idTag;
	private String nameTag;
	
	public UUID getIdTag() {
		return this.idTag;
	}
	public void setIdTag(UUID idTag) {
		this.idTag = idTag;
	}
	
	public String getNameTag() {
		return this.nameTag;
	}
	public void setNameTag(String nameTag) {
		this.nameTag = nameTag;
	}

}
