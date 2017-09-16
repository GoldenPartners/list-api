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
@Table(name="lst_groupuser")
public class GroupUser {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="group_id", nullable=false)
	private Group group;

	public GroupUser() {
		super();
	}

	public GroupUser(Long id, User user, Group group) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "GroupUser [id=" + id + ", user=" + user.getId() + ", group=" + group.getId() + "]";
	}
}
