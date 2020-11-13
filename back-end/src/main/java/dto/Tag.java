package dto;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@XmlRootElement
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "idTag", updatable = false, nullable = false)
	@Type(type = "uuid-char")
	private UUID idTag;
	
	@Column
	private String nameTag;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "note_tag", joinColumns = @JoinColumn(name = "idNote"), inverseJoinColumns = @JoinColumn(name = "idTag"))
	private Set<Note> notes;
	
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
	
	public Set<Note> getNote() {
		return this.notes;
	}
	public void setNote(Set<Note> notes) {
		this.notes = notes;
	}
}
