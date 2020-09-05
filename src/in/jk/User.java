package in.jk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class User {
	
	@Id
	@Column(name="userId")
	private int userId;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	
	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + "]";
	}
	
	
	

}
