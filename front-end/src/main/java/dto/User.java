package dto;

import java.io.Serializable;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class User implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private UUID idUser;
		
		private String email;
		
		private String pass;
		
		public UUID getIdUser() {
			return this.idUser;
			
		}
		public void setIdUser(UUID idUser) {
			this.idUser = idUser;
		}
		
		public String getEmail() {
			return this.email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getPass() {
			return this.pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		
	}