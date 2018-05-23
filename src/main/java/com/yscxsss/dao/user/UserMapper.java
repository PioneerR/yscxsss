package com.yscxsss.dao.user;

import com.yscxsss.pojo.User;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	public Integer addUser(@Param("user")User user)throws SQLException;

	public int deleteUser(@Param("loginName")String loginName,
			@Param("id")Integer id)throws SQLException;
	
	public int updateUser(@Param("user")User user)throws SQLException;

	public User getUser(@Param("loginName")String loginName,
						@Param("id")Integer id)throws SQLException;

	public int getTotalCount()throws SQLException;
	
	public List<User> getListUser(@Param("startIndex")Integer startIndex, 
								 @Param("pageSize")Integer pageSize)throws SQLException;
	
	public User loginCheck(@Param("loginName")String loginName,
						 @Param("password")String password)throws SQLException;
	
	public int check(@Param("type")String type,@Param("value")String value)throws SQLException;
	
}
