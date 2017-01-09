package com.niit.collabaration.DAO;

import java.util.List;

import com.niit.collabaration.model.User;

public interface UserDAO {
	public String save(User user);
	public String  update(User user);
	public List<User> getlistofuser();
	public User get(String id);
	public String validate(String id,String password);
	public String reasonforrejection(String id);

}
