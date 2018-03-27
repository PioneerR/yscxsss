package com.yscxsss.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MyBatisUtil {
	
	private static Logger log=Logger.getLogger("mylog");
	private MyBatisUtil(){}
	
	private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();
	private static SqlSessionFactory factory;
	
	static{
		try {
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
			factory=new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	public static SqlSession createSqlSession() {
		SqlSession sqlSession=threadLocal.get();
		if(sqlSession==null){
			sqlSession=factory.openSession();
			threadLocal.set(sqlSession);
		}		
		return sqlSession;
	}
	
	public static void closeSqlSession(SqlSession sqlSession) {
		if(sqlSession!=null){
			sqlSession.close();
			threadLocal.remove();			
		}
	}
	
//  每次创建MybatisUtil都测试一下是否连接成功
//	public static void main(String[] args) {		
//		Connection conn=MyBatisUtil.createSqlSession().getConnection();
//		System.out.println(conn==null?"连接失败":"连接成功");		
//	}
	
}
