package beans;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID=1L;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public Boolean getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(Boolean isadmin) {
		this.isadmin = isadmin;
	}
	private String username; 
	private String email; 
	private String password; 
	private String departement; 
	private Boolean isadmin;
	
		


	
	

}
