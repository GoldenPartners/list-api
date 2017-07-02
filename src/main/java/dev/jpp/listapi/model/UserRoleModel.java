package dev.jpp.listapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class UserRoleModel {
	private int id;
	private String role;
	
	@JsonBackReference
	private UserModel user;
	
	public UserRoleModel() {
		super();
	}

	public UserRoleModel(int id, UserModel user, String role) {
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
}
