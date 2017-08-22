package dev.jpp.listapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class UserRoleModel {
	private Long id;
	private String role;
	
	@JsonBackReference
	private UserModel user;
	
	public UserRoleModel() {
		super();
	}

	public UserRoleModel(Long id, UserModel user, String role) {
		super();
		this.id = id;
		this.user = user;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
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
		return "UserRoleModel [id=" + id + ", user=" + user + ", role=" + role + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.getRole().equals(((UserRoleModel)obj).getRole());
	}
}
