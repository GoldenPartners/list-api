package dev.jpp.listapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lst_userrole")
public class UserRole {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	@Column(name="role", nullable=false)
	private String role;
	
	public UserRole() {
		super();
	}
	
	public UserRole(int id, User user, String role) {
		super();
		this.id = id;
		this.user = user;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", user=" + user + ", role=" + role + "]";
	}
}
