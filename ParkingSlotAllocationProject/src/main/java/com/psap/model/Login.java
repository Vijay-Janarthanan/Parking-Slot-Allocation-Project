package com.psap.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "Login")
public class Login implements Serializable{

	@Id
	private String loginId;
	@Min(5)
	private String password;
	@OneToOne()
	private User usr;
	@OneToOne
	private Role role;
	
	// Constructors, Getter & Setter method
	
	public Login() {
		super();
	}
	
	public Login(String loginId, String password, User usr, Role role) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.usr = usr;
		this.role = role;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return usr;
	}

	public void setUser(User usr) {
		this.usr = usr;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", password=" + password + ", user=" + usr + ", role=" + role + "]";
	}
	
	
}
