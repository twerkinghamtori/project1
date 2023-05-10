package model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Board;
import model.BoardRecommend;
import model.Comment;

public interface BoardMapper {
	String sqlcol = "<if test='column != null'>" 		
	+"<if test='col1 != null'> and (${col1} like '%${find}%'</if>"
	+"<if test='col2 == null'> ) </if>"
	+"<if test='col2 != null'> or ${col2} like '%${find}%'</if>"
	+"<if test='col2 != null and col3==null'> ) </if>"
	+"<if test='col3 != null'> or ${col3} like '%${find}%')</if></if>";
	
	@Select({ "<script>",
			"select count(*) from board where boardid=#{boardid} "+sqlcol,
			"</script>"})
	int boardCount(Map<String, Object> map);

	@Select({"<script>" ,"SELECT b.*, (SELECT COUNT(*) FROM comment c WHERE c.board_num = b.board_num) commcnt, m.level "
            + "FROM board b "
            + "LEFT JOIN member m ON b.member_id = m.member_id "
            + "WHERE boardid=#{boardid} " + "<if test='column != null'>" 		
        	+"<if test='col1 != null'> and (${col1} like '%${find}%'</if>"
        	+"<if test='col2 == null'> ) </if>"
        	+"<if test='col2 != null'> or ${col2} like '%${find}%'</if>"
        	+"<if test='col2 != null and col3==null'> ) </if>"
        	+"<if test='col3 != null'> or ${col3} like '%${find}%')</if></if>"
            + "ORDER BY board_num DESC LIMIT #{start},#{limit}",
            "</script>"})
	List<Board> selectlist(Map<String, Object> map);


	@Select({ "<script>",
			"select count(*) from board where boardid=#{boardid} and recommendcnt >= 10 " + sqlcol,
		"</script>"})
	int popularboardCount(Map<String, Object> map);
	
	@Select({"<script>" ,"SELECT b.*, (SELECT COUNT(*) FROM comment c WHERE c.board_num = b.board_num) commcnt, m.level "
            + "FROM board b "
            + "LEFT JOIN member m ON b.member_id = m.member_id "
            + "WHERE boardid=#{boardid} and recommendcnt >= 10" + sqlcol
            + "ORDER BY board_num DESC LIMIT #{start},#{limit}",
            "</script>"})
	List<Board> selectPopularList(Map<String, Object> map);

	@Select("select ifnull(max(board_num),0) from board")
	int maxnum();
	
	@Insert("INSERT INTO board (board_num, title, content, readcnt, recommendcnt, regdate, boardid, category_num, member_id)"
			+ " VALUES (#{board_num}, #{title}, #{content}, 0, 0, now(), #{boardid}, #{category_num}, #{member_id})")
	int insert(Board board);

	@Select("select ifnull(max(comment_num),0) from comment where board_num=#{board_num}")
	int maxcomment_num(int board_num);

	@Insert("insert into comment (comment_num+=1,content,regdate,recommendcnt,member_id, board_num)"
			+ " values (#{comment_num}+=1,#{content},#{regdate},#{recommendcnt},#{member_id},#{board_num})")
	int cominsert(Comment comm);

	@Select("select * from comment where board_num = #{board_num}")
	List<Comment> selectclist(Map<String, Object> map);
	
	@Select({ "<script>",
		"select count(*) from board where recommendcnt >= 10 "+sqlcol,
		"</script>"})
	int bobboardCount(Map<String, Object> map);
	
	@Select({"<script>" ,"SELECT b.*, (SELECT COUNT(*) FROM comment c WHERE c.board_num = b.board_num) commcnt, m.level "
            + "FROM board b "
            + "LEFT JOIN member m ON b.member_id = m.member_id "
            + "WHERE recommendcnt >= 10 " + sqlcol
            + "ORDER BY recommendcnt DESC LIMIT #{start},#{limit}",
            "</script>"})
	List<Board> selectbobList(Map<String, Object> map);

	@Select({ "<script>", "SELECT *, (SELECT COUNT(*) FROM comment c WHERE c.board_num = b.board_num) commcnt"
			+ " FROM board b WHERE board_num = #{value}", "</script>" })
	Board selectOne(int num);
	
	@Update("update board set readcnt = readcnt + 1 where board_num=#{value}")
	void readcntAdd(int num);
	

	@Delete("delete from board where board_num=#{value}")
	int delete(int board_num);


	@Update("update board set category_num=#{category_num}, title=#{title},content=#{content} where board_num=#{board_num}")
	int update(Board board);

	@Select("select * from board where boardid=2 order by regdate desc" )
	List<Board> selectHumor();
	
	@Select("select * from board where boardid=3 order by regdate desc" )
	List<Board> selectSoccer();
	
	@Select("select * from board where boardid=4 order by regdate desc" )
	List<Board> selectFood();
	
	@Select("select * from board where recommendcnt >=10 order by recommendcnt desc" )
	List<Board> selectBest();

	

	@Insert("insert into board_recommend (board_num,member_id) values(#{board_num}, #{member_id})")
	int recommendcnt(BoardRecommend br);

	@Update("update board set recommendcnt = recommendcnt+1 where board_num=#{value}")
	int updaterecommend(int num);

	@Select("SELECT COUNT(*) FROM board_recommend WHERE board_num=#{board_num} AND member_id=#{member_id}")
	int checkRecommend(BoardRecommend br);

	
	@Delete("delete from board_recommend where board_num=#{board_num} and member_id=#{member_id}")
	void unrecommend(BoardRecommend br);

	@Update("update board set recommendcnt = recommendcnt-1 where board_num=#{value}")
	int downrecommend(int num);

}