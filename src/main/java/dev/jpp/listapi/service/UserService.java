package dev.jpp.listapi.service;

import dev.jpp.listapi.model.ChangePasswordModel;
import dev.jpp.listapi.model.ResetPasswordModel;
import dev.jpp.listapi.model.UserModel;

public interface UserService extends ISimpleCrudService<UserModel> {
	public abstract void resetPassword(ResetPasswordModel model);
	public abstract Boolean changePassword(ChangePasswordModel model);
}
