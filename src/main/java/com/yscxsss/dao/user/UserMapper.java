package com.yscxsss.dao.user;

import com.yscxsss.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	public User getUserById(@Param("id")int id) throws Exception;
	
}
