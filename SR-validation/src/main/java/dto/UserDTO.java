package dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDTO 
{
	String email;
	String name;
	String password;
	@Id
	long mobile;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "UserDTO [email=" + email + ", name=" + name + ", password=" + password + ", mobile=" + mobile + "]";
	}
	
	
}
