package dev.jpp.listapi.model;

public class ResetPasswordModel {
	private String emailToResetPassword;

	public ResetPasswordModel() {
		super();
	}

	public ResetPasswordModel(String emailToResetPassword) {
		super();
		this.emailToResetPassword = emailToResetPassword;
	}

	public String getEmailToResetPassword() {
		return emailToResetPassword;
	}

	public void setEmailToResetPassword(String emailToResetPassword) {
		this.emailToResetPassword = emailToResetPassword;
	}
}
