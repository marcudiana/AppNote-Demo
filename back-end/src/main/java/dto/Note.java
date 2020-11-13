package dto;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@XmlRootElement
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "idNote", updatable = false, nullable = false)
	@Type(type = "uuid-char")
	private UUID idNote;
	
	@Column
	private String nameNote;
	
	@Column
	private String content;
	
	@ManyToMany(mappedBy = "notes", cascade = CascadeType.ALL)
	private Set<Tag> tags;
	
	@Transient
	private Set<UUID> requestTags;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUser", nullable = false)
	private User user;
	@Transient
	private UUID idUser;
	
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
	
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public UUID getIdUser() {
		return this.idUser;
	}
	
	public void setIdUser(UUID idUser) {
		this.idUser = idUser;
	}
	
	public Set<Tag> getTags() {
		return this.tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	public Set<UUID> getRequestTags() {
		return this.requestTags;
	}
	public void setIdTag(Set<UUID> requestTags) {
		this.requestTags = requestTags;
	}
}