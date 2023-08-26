package prem.dao;

import prem.enties.User;

public interface UserDao {
	void insert(User user);
	User get(String username,String password);
}
