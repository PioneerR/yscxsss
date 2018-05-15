package com.yscxsss.service.user;
import com.yscxsss.dao.user.UserMapper;
import com.yscxsss.pojo.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired(required=false)
	private UserMapper userMapper;	
	private Logger log=Logger.getLogger(UserServiceImpl.class);

	@Override
	public boolean addUser(User user) {
		boolean flag=false;
		int num=0;
		//1为商家，0为用户		
		try {
			num = userMapper.addUser(user);
			if (num>0) {
				flag=true;
			}
		} catch (SQLException e) {
			log.error(e);
		}		
		return flag;
	}

	@Override
	public boolean deleteUser(String loginName, Integer id) {
		boolean flag=false;
		int num=0;		
		try {
			num = userMapper.deleteUser(loginName,id);
			if (num>0) {
				flag=true;
			}
		} catch (SQLException e) {
			log.error(e);
		}		
		return flag;
	}

	@Override
	public boolean updateUser(User user) {
		boolean flag=false;
		int num=0;
		try {
			num = userMapper.updateUser(user);
			if (num>0) {
				flag=true;
			}
		} catch (SQLException e) {
			log.error(e);
		}		
		return flag;
	}

	@Override
	public User getUser(String loginName, Integer id) {
		User u=null;
		try {
			if(userMapper!=null){
				u = userMapper.getUser(loginName,id);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public int getTotalCount() {
		int num=0;
		try {
			num=userMapper.getTotalCount();
		} catch (SQLException e) {
			log.error(e);
		}
		return num;
	}

	@Override
	public List<User> getListUser(Integer startIndex, Integer pageSize) {
		List<User> list=new ArrayList<User>();
		try {
			list=userMapper.getListUser(startIndex, pageSize);
		} catch (SQLException e) {
			log.error(e);
		}
		return list;
	}

	@Override
	public User loginCheck(String loginName, String password) {
		User u=null;
		try {
			u=userMapper.loginCheck(loginName, password);
		} catch (SQLException e) {
			log.error(e);
		}
		return u;
	}

	@Override
	public boolean check(String type, String value) {
		boolean flag=false;
		int num=0;
		try {
			num=userMapper.check(type, value);
			if(num>0){
				flag=true;
			}
		} catch (SQLException e) {
			log.error(e);
		}
		return flag;
	}
	
}
