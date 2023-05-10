package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.mapper.CommentMapper;

public class CommentMybatisDao {
   private Class<CommentMapper> cls = CommentMapper.class;
   private Map<String,Object> map = new HashMap<>();
   public int maxcomment_num(int board_num) {
      SqlSession session = MybatisConnection.getConnection();
      try {
         return session.getMapper(cls).maxcomment_num(board_num);
      } catch(Exception e){
         e.printStackTrace();
      } finally {
         MybatisConnection.close(session);
      }
      return 0;
   }

   public boolean cominsert(Comment comm) {
      SqlSession session = MybatisConnection.getConnection();
      try {
         return session.getMapper(cls).cominsert(comm) > 0;
      } catch(Exception e){
         e.printStackTrace();
      } finally {
         MybatisConnection.close(session);
      }
      return false;
   }

   public List<Comment> selectclist(int board_num, int pageNum, int limit) {
      SqlSession session = MybatisConnection.getConnection();
      try {
    	  map.clear();
    	  map.put("board_num", board_num);
    	  map.put("start", (pageNum - 1) * limit);
		  map.put("limit", limit);
         return session.getMapper(cls).selectclist(map);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         MybatisConnection.close(session);
      }
      return null;
   }

//   public void deleteAll(int board_num) {
//      SqlSession session = MybatisConnection.getConnection();
//      try {
//         session.getMapper(cls).deleteAll(board_num);
//      }catch(Exception e) {
//         e.printStackTrace();
//      }finally {
//         MybatisConnection.close(session);
//      }
//   }

   public boolean delete(int board_num,int grp) {
      SqlSession session = MybatisConnection.getConnection();
      try {
         int cnt = session.getMapper(cls).delete(board_num,grp);
         if(cnt > 0) return true;
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         MybatisConnection.close(session);
      }
      return false;
   }

public int checkcomRecommend(ComRecommend cr) {
	SqlSession session = MybatisConnection.getConnection();
	int result = -1;
	try {
		result = session.getMapper(cls).checkcomRecommend(cr);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		MybatisConnection.close(session);
	}
	return result;
}

public int comrecommend(ComRecommend cr) {
	SqlSession session = MybatisConnection.getConnection();
	try {
	 return session.getMapper(cls).comrecommendcnt(cr);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		MybatisConnection.close(session);
	}
	return -1;
}

public int comupdaterecommend(int num) {
	SqlSession session = MybatisConnection.getConnection();
	try {
		return session.getMapper(cls).comupdaterecommend(num);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		MybatisConnection.close(session);
	}
	return -1;
	
}

public void comunrecommend(ComRecommend cr) {
	SqlSession session = MybatisConnection.getConnection();
	try {
		session.getMapper(cls).comunrecommend(cr);
		session.commit();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		MybatisConnection.close(session);
	}
	
}

public void comdownrecommend(int num) {
	SqlSession session = MybatisConnection.getConnection();
	try {
		session.getMapper(cls).comdownrecommend(num);
		session.commit();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		MybatisConnection.close(session);
	}
	
}

public Comment selectOne(int comment_num) {
	SqlSession session = MybatisConnection.getConnection();
	try {
		session.getMapper(cls).selectOne(comment_num);
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		MybatisConnection.close(session);
	}
	return null;
}

public void grpStepAdd(int grp, int grpstep ) {
	SqlSession session = MybatisConnection.getConnection();
	try {
		session.getMapper(cls).grpStepAdd(grp,grpstep);
	} catch(Exception e) {
    e.printStackTrace();
  } finally {
		MybatisConnection.close(session);
	}
}

public int commcount(int num) {
	SqlSession session = MybatisConnection.getConnection();
	try {
	return session.getMapper(cls).commcount(num);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		MybatisConnection.close(session);
	}
	return 0;
}

}