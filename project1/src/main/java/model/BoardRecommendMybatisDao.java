package model;

import org.apache.ibatis.session.SqlSession;

import model.mapper.BoardRecommendMapper;

public class BoardRecommendMybatisDao {

	private Class<BoardRecommendMapper> cls = BoardRecommendMapper.class;

//	public void deleteAll(int board_num) {
//		SqlSession session = MybatisConnection.getConnection();
//		try {
//			session.getMapper(cls).deleteAll(board_num);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			MybatisConnection.close(session);
//		}
//	}
	
}
