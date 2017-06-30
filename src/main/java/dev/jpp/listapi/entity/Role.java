package dev.jpp.listapi.entity;

public enum Role {
	ADMIN("admin"),
	RRPP("rrpp"),
	RECEPTIONIST("receptionist");
	
	private String roleName;
	
	private Role(String name) {
		this.roleName = name;
	}
	
	public String getRoleName() {
		return this.roleName;
	}
}
