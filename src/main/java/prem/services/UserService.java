package prem.services;

import prem.enties.User;
import prem.models.LoginModel;
import prem.models.UserModel;

public interface UserService {
	void register(UserModel userModel);
	User getUser(LoginModel userModel);
}

