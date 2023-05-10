package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.mapper.BoardMapper;

public class BoardMybatisDao {
	private Class<BoardMapper> cls = BoardMapper.class;
	private Map<String,Object> map = new HashMap<>();

	public int boardCount(String boardid, String column, String find) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			map.clear();
			map.put("boardid", boardid);
			map.put("column", column);
			if (column != null) {
				String[] cols = column.split(",");
				switch (cols.length) {
				case 3:
					map.put("col3", cols[2].trim());
				case 2:
					map.put("col2", cols[1].trim());
				case 1:
					map.put("col1", cols[0].trim());
				}
				map.put("find", find);
			}
			return session.getMapper(cls).boardCount(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return 0;
	}

	public List<Board> list(String boardid, int pageNum, int limit, String column, String find) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			map.clear();
			map.put("boardid", boardid);
			map.put("start", (pageNum - 1) * limit);
			map.put("limit", limit);
			if ("member_id".equals(column)) {
                column = "b.member_id";
            }
			map.put("column", column);
			if (column != null) {
				String[] cols = column.split(",");
				switch (cols.length) {
				case 3:
					map.put("col3", cols[2].trim());
				case 2:
					map.put("col2", cols[1].trim());
				case 1:
					map.put("col1", cols[0].trim());
				}
				map.put("find", find);
				System.out.println(Arrays.toString(cols));
			}
			
			return session.getMapper(cls).selectlist(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return null;
	}

	public int popularboardCount(String boardid, String column, String find) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			map.clear();
			map.put("boardid", boardid);
			map.put("column", column);
			if (column != null) {
				String[] cols = column.split(",");
				switch (cols.length) {
				case 3:
					map.put("col3", cols[2].trim());
				case 2:
					map.put("col2", cols[1].trim());
				case 1:
					map.put("col1", cols[0].trim());
				}
				map.put("find", find);
			}
			return session.getMapper(cls).popularboardCount(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return 0;
	}

	public List<Board> PopularList(String boardid, int pageNum, int limit, String column, String find) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			map.clear();
			map.put("boardid", boardid);
			map.put("start", (pageNum - 1) * limit);
			map.put("limit", limit);
			map.put("column", column);
			if (column != null) {
				String[] cols = column.split(",");
				switch (cols.length) {
				case 3:
					map.put("col3", cols[2].trim());
				case 2:
					map.put("col2", cols[1].trim());
				case 1:
					map.put("col1", cols[0].trim());
				}
				map.put("find", find);
			}
			return session.getMapper(cls).selectPopularList(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return null;
	}

	public int bobboardCount(String boardid, String column, String find) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			map.clear();
			map.put("boardid", boardid);
			map.put("column", column);
			if (column != null) {
				String[] cols = column.split(",");
				switch (cols.length) {
				case 3:
					map.put("col3", cols[2].trim());
				case 2:
					map.put("col2", cols[1].trim());
				case 1:
					map.put("col1", cols[0].trim());
				}
				map.put("find", find);
			}
			return session.getMapper(cls).bobboardCount(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return 0;
	}

	public List<Board> bobList(String boardid, int pageNum, int limit, String column, String find) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			map.clear();
			map.put("boardid", boardid);
			map.put("start", (pageNum - 1) * limit);
			map.put("limit", limit);
			map.put("column", column);
			if (column != null) {
				String[] cols = column.split(",");
				switch (cols.length) {
				case 3:
					map.put("col3", cols[2].trim());
				case 2:
					map.put("col2", cols[1].trim());
				case 1:
					map.put("col1", cols[0].trim());
				}
				map.put("find", find);
			}
			return session.getMapper(cls).selectbobList(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return null;
	}

	public int maxnum() {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).maxnum();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return 0;
	}

	public boolean insert(Board board) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).insert(board) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return false;
	}

	public Board selectOne(int num) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).selectOne(num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return null;
	}

	public void readcntAdd(int num) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			session.getMapper(cls).readcntAdd(num);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
	}

	public boolean delete(int board_num) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			int cnt = session.getMapper(cls).delete(board_num);
			if (cnt > 0) return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return false;
	}

	public boolean update(Board board) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).update(board) > 0;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return false;
	}

	public int recommend(BoardRecommend br) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).recommendcnt(br);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return -1;
	}

	public int updaterecommend(int num) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).updaterecommend(num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return -1;
	}

	public int checkRecommend(BoardRecommend br) {
		SqlSession session = MybatisConnection.getConnection();
		int result = -1;
		try {
			result = session.getMapper(cls).checkRecommend(br);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return result;
	}

	public void unrecommend(BoardRecommend br) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			session.getMapper(cls).unrecommend(br);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
	}
	
	public List<Board> selectHumor() {
	    SqlSession session = MybatisConnection.getConnection();
	    try {
	        return session.getMapper(cls).selectHumor();
	    } catch(Exception e ) {
	        e.printStackTrace();
	    } finally {
	        MybatisConnection.close(session);
	    }
	    return null;
	}

	public void downrecommend(int num) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			session.getMapper(cls).downrecommend(num);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
	}

	public List<Board> selectSoccer() {
	    SqlSession session = MybatisConnection.getConnection();
	    try {
	        return session.getMapper(cls).selectSoccer();
	    } catch(Exception e ) {
	        e.printStackTrace();
	    } finally {
	        MybatisConnection.close(session);
	    }
	    return null;
	}

	public List<Board> selectFood() {
	    SqlSession session = MybatisConnection.getConnection();
	    try {
	        return session.getMapper(cls).selectFood();
	    } catch(Exception e ) {
	        e.printStackTrace();
	    } finally {
	        MybatisConnection.close(session);
	    }
	    return null;
	}

	public List<Board> selectBest() {
		   SqlSession session = MybatisConnection.getConnection();
		    try {
		        return session.getMapper(cls).selectBest();
		    } catch(Exception e ) {
		        e.printStackTrace();
		    } finally {
		        MybatisConnection.close(session);
		    }
		    return null;
	}
}