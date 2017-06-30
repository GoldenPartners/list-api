package dev.jpp.listapi.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lst_user")
public class User {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="phone", nullable=false)
	private String phone;
	
	@Column(name="email", nullable=false, unique=true)
	private String email;
	
	@Column(name="password", nullable=false, length=60)
	private String password;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="user")
	private Set<UserRole> roles;
	
	@Column(name="enabled")
	private Boolean enabled;
	
	public User() {
		super();
	}
	
	public User(int id, String name, String phone, String email, String password, Set<UserRole> roles, Boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
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
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", roles=" + roles + ", enabled=" + enabled + "]";
	}
}
