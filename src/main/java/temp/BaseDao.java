package temp;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class BaseDao {

	private Logger log=Logger.getLogger("console");
	private List list=new ArrayList();
	private SqlSession sqlSession=null;
	private Object obj=null;
	
	/**
	 * 获取集合
	 * @param sql
	 * @return
	 */
	public List selectList(String mapper) {
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			list=sqlSession.selectList(mapper);
		} catch (Exception e) {
			log.error(e);
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return list;
	}
	
	/**
	 * 获取单个Object对象
	 * @param sql
	 * @return
	 */
	public Object selectOne(String mapper) {
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			obj=sqlSession.selectOne(mapper);
		} catch (Exception e) {
			log.error(e);
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return obj;
	}
	
	
	
	
}
