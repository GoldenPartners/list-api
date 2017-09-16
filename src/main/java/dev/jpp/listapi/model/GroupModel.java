package dev.jpp.listapi.model;

public class GroupModel {
	private Long id;
	private String name;
	private String description;
	private UserModel creator;
	
	public GroupModel() {
		super();
	}

	public GroupModel(Long id, String name, String description, UserModel creator) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.creator = creator;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserModel getCreator() {
		return creator;
	}

	public void setCreator(UserModel creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "GroupModel [id=" + id + ", name=" + name + ", description=" + description + 
				", creator=" + creator == null ? "null" : creator.getId() + "]";
	}
}
