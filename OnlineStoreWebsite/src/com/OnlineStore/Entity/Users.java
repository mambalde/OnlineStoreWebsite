package com.OnlineStore.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u ORDER BY u.fullname"),
	@NamedQuery(name="Users.findByEmail", query="SELECT u FROM Users u WHERE u.email= :email"),
	@NamedQuery(name= "Users.countAll", query= "SELECT COUNT(u) FROM Users u"),
	@NamedQuery(name= "Users.checkLogin", query= "SELECT u FROM Users u WHERE u.email = :email AND u.password= :password")
	
})
public class Users {
	private Integer userId;
	private String email;
	private String fullname;
	private String password;
	
	

	public Users() {
		super();
		
	}
	public Users( Integer userId, String email, String fullname, String password) {
		this(email, fullname, password);
		this.userId = userId;
		
	}
	public Users(String email, String fullname, String password) {
		super();
		this.email = email;
		this.fullname = fullname;
		this.password = password;
	}

	@Column(name = "user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "full_name")
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
