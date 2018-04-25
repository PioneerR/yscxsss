package com.yscxsss.service.user;
import com.yscxsss.dao.user.UserMapper;
import com.yscxsss.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;
	@Override
	public User getUserById(int id) {
		User u=null;
		try {
			u = mapper.getUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	
	
}
