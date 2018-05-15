package com.yscxsss.service.user;

import com.yscxsss.pojo.User;

import java.util.List;

public interface UserService {

	public boolean addUser(User user);

	public boolean deleteUser(String loginName,Integer id);
	
	public boolean updateUser(User user);

	public User getUser(String loginName,Integer id);

	public int getTotalCount();
	
	public List<User> getListUser(Integer startIndex,Integer pageSize);
	
	public User loginCheck(String loginName,String password);
	
	public boolean check(String type,String value);
	
}
