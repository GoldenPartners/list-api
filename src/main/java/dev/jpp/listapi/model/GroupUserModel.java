package dev.jpp.listapi.model;

public class GroupUserModel {
	private Long id;
	private UserModel user;
	private GroupModel group;
	
	public GroupUserModel() {
		super();
	}

	public GroupUserModel(Long id, UserModel user, GroupModel group) {
		super();
		this.id = id;
		this.user = user;
		this.group = group;
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

	public GroupModel getGroup() {
		return group;
	}

	public void setGroup(GroupModel group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "GroupUserModel [id=" + id + 
				", user=" + user == null ? "null" : user.getId() + 
				", group=" + group == null ? "null" : group.getId() + "]";
	}
}
