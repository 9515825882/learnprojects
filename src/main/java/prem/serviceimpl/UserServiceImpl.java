package prem.serviceimpl;

import prem.enties.User;
import prem.models.LoginModel;
import prem.models.UserModel;
import prem.services.UserService;
import prem.dao.*;
import prem.daoimpl.UserDaoImpl;

public class UserServiceImpl implements UserService{
	private UserDao dao=new UserDaoImpl();
	@Override
	public void register(UserModel userModel) {
		User user=new User();
		user.setUsername(userModel.getUsername());
		user.setPassword(userModel.getPassword());
		user.setEmail(userModel.getEmail());
		dao.insert(user);
	}
	@Override
	public User getUser(LoginModel loginModel) {
		return dao.get(loginModel.getUsername(), loginModel.getPassword());
	}
	
	

}