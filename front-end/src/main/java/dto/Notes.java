package dto;

import java.io.Serializable;
import java.util.UUID;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Notes implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private UUID idNote;
	private String nameNote;
	private String content;
	private UUID idUser;
	private User user;
	
	public UUID getIdNote() {
		return this.idNote;
	}
	public void setIdNote(UUID idNote) {
		this.idNote = idNote;
	}
	
	public String getNameNote() {
		return this.nameNote;
	}
	public void setNameNote(String nameNote) {
		this.nameNote = nameNote;
	}
	
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public UUID getIdUser() {
		return this.idUser;
	}
	public void setIdUser(UUID idUser) {
		this.idUser = idUser;
	} 
	
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
