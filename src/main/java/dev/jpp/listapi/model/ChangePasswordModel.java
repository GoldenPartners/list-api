package dev.jpp.listapi.model;

public class ChangePasswordModel {
	private Long iduser;
	private String currentPassword;
	private String newPassword;
	private String repeatPassword;
	
	public ChangePasswordModel() {
		super();
	}

	public ChangePasswordModel(Long iduser, String currentPassword, String newPassword, String repeatPassword) {
		super();
		this.iduser = iduser;
		this.currentPassword = currentPassword;
		this.newPassword = newPassword;
		this.repeatPassword = repeatPassword;
	}

	public Long getIduser() {
		return iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
}
