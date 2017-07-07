package dev.jpp.listapi.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class UserModel {
	private Long id;
	private String name;
	private String phone;
	private String email;
	private String password;
	private Boolean enabled;
	
	@JsonManagedReference
	private Set<UserRoleModel> roles;
	
	public UserModel() {
		super();
	}
	
	public UserModel(Long id, String name, String phone, String email, String password, Set<UserRoleModel> roles, Boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.enabled = enabled;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public Set<UserRoleModel> getRoles() {
		return roles;
	}
	public void setRoles(Set<UserRoleModel> roles) {
		this.roles = roles;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", password=" + password + ", enabled=" + enabled + "]";
	}
}
