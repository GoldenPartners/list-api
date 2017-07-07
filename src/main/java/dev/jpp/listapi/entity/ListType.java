package dev.jpp.listapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lst_listType")
public class ListType {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="description")
	private String description;
	
	public ListType() {
		super();
	}

	public ListType(Long id, String code, String description) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ListType [id=" + id + ", code=" + code + ", description=" + description + "]";
	}
}
