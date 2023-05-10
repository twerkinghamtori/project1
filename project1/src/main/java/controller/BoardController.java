package controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import gdu.mskim.MskimRequestMapping;
import gdu.mskim.RequestMapping;
import model.Board;
import model.BoardMybatisDao;
import model.BoardRecommend;
import model.BoardRecommendMybatisDao;
import model.ComRecommend;
import model.Comment;
import model.CommentMybatisDao;
import model.Member;
import model.MemberMybatisDao;

@WebServlet(urlPatterns = {"/board/*"},
initParams = {@WebInitParam(name="view",value="/view/")})
public class BoardController extends MskimRequestMapping {
	private BoardMybatisDao dao = new BoardMybatisDao();
	private CommentMybatisDao cdao = new CommentMybatisDao();
	private MemberMybatisDao mdao = new MemberMybatisDao();
	private BoardRecommendMybatisDao brdao = new BoardRecommendMybatisDao(); 
		@RequestMapping("list")
		public String list(HttpServletRequest request, HttpServletResponse response) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			if (request.getParameter("boardid") != null) {
				// session에 게시판 종류 정보 등록
				request.getSession().setAttribute("boardid", request.getParameter("boardid"));
				request.getSession().setAttribute("pageNum", "1"); // 현재페이지 번호
			}
			String boardid = (String) request.getSession().getAttribute("boardid");
			if (boardid == null)
				boardid = "2";
			int pageNum = 1;
			try {
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
			} catch (NumberFormatException e) {
			}
			String column = request.getParameter("column");
			String find = request.getParameter("find");
			/*
			 * column,find 파라미터 중 한개만 존재하는 경우 두개의 파라미터값은 없는 상태로 설정
			 */
			if (column == null || column.trim().equals("")) {
				column = null;
				find = null;
			}
			if (find == null || find.trim().equals("")) {
				column = null;
				find = null;
			}
			int limit = 10; // 한페이지에 보여질 게시물 건수
			// boardcount : 게시물종류별 게시물 등록건수
			int boardcount = dao.boardCount(boardid, column, find); // 게시판 종류별 전체 게시물등록 건수 리턴
			// list : 현재 페이지에 보여질 게시물 목록.
			List<Board> list = dao.list(boardid, pageNum, limit, column, find);
			for (Board board : list) {
			    String content = board.getContent();
			    Pattern imgPattern = Pattern.compile("<img[^>]+src=\"([^\">]+)\"");
			    Matcher imgMatcher = imgPattern.matcher(content);

			    if (imgMatcher.find()) {
			        String thumbnailUrl = imgMatcher.group(1);
			        board.setThumbnail(thumbnailUrl);
			    }
			}
			int maxpage = (int) ((double) boardcount / limit + 0.95);
			int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
			int endpage = startpage + 9;
			if (endpage > maxpage)
				endpage = maxpage;
			// boardName : 게시판 이름 화면에 출력
			String boardName = null;
			switch (boardid) {
			case "1":
				return "redirect:bobList?boardid=" + boardid;
			case "2":
				boardName = "유머게시판";
				break;
			case "3":
				boardName = "해축게시판";
				break;
			case "4":
				boardName = "음식게시판";
				break;
			}
			int boardnum = boardcount - (pageNum - 1) * limit;
			request.setAttribute("boardName", boardName);
			request.setAttribute("boardcount", boardcount);
			request.setAttribute("boardid", boardid);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("boardnum", boardnum);
			request.setAttribute("list", list);
			request.setAttribute("startpage", startpage);
			request.setAttribute("endpage", endpage);
			request.setAttribute("maxpage", maxpage);
			request.setAttribute("today", new Date());
			return "board/list";
		}

		@RequestMapping("popularList")
		public String popularList(HttpServletRequest request, HttpServletResponse response) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			if (request.getParameter("boardid") != null) {
				// session에 게시판 종류 정보 등록
				request.getSession().setAttribute("boardid", request.getParameter("boardid"));
				request.getSession().setAttribute("pageNum", "1"); // 현재페이지 번호
			}
			String boardid = (String) request.getSession().getAttribute("boardid");
			if (boardid == null)
				boardid = "2";
			int pageNum = 1;
			try {
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
			} catch (NumberFormatException e) {
			}
			String column = request.getParameter("column");
			String find = request.getParameter("find");
			/*
			 * column,find 파라미터 중 한개만 존재하는 경우 두개의 파라미터값은 없는 상태로 설정
			 */
			if (column == null || column.trim().equals("")) {
				column = null;
				find = null;
			}
			if (find == null || find.trim().equals("")) {
				column = null;
				find = null;
			}
			int limit = 10; // 한페이지에 보여질 게시물 건수
			// boardcount : 게시물종류별 게시물 등록건수
			int boardcount = dao.popularboardCount(boardid, column, find); // 게시판 종류별 전체 게시물등록 건수 리턴
			// list : 현재 페이지에 보여질 게시물 목록.
			List<Board> popularList = dao.PopularList(boardid, pageNum, limit, column, find);
			for (Board board : popularList) {
			    String content = board.getContent();
			    Pattern imgPattern = Pattern.compile("<img[^>]+src=\"([^\">]+)\"");
			    Matcher imgMatcher = imgPattern.matcher(content);

			    if (imgMatcher.find()) {
			        String thumbnailUrl = imgMatcher.group(1);
			        board.setThumbnail(thumbnailUrl);
			    }
			}
			int maxpage = (int) ((double) boardcount / limit + 0.95);
			int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
			int endpage = startpage + 9;
			if (endpage > maxpage)
				endpage = maxpage;
			// boardName : 게시판 이름 화면에 출력
			String boardName = null;
			switch (boardid) {
			case "1":
				return "redirect:bobList?boardid=" + boardid;
			case "2":
				boardName = "유머게시판";
				break;
			case "3":
				boardName = "해축게시판";
				break;
			case "4":
				boardName = "음식게시판";
				break;
			}
			int boardnum = boardcount - (pageNum - 1) * limit;
			request.setAttribute("boardName", boardName);
			request.setAttribute("boardcount", boardcount);
			request.setAttribute("boardid", boardid);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("boardnum", boardnum);
			request.setAttribute("popularList", popularList);
			request.setAttribute("startpage", startpage);
			request.setAttribute("endpage", endpage);
			request.setAttribute("maxpage", maxpage);
			request.setAttribute("today", new Date());
			return "board/popularList";
		}


		@RequestMapping("bobList")
		public String bobList(HttpServletRequest request, HttpServletResponse response) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			if (request.getParameter("boardid") != null) {
				// session에 게시판 종류 정보 등록
				request.getSession().setAttribute("boardid", request.getParameter("boardid"));
				request.getSession().setAttribute("pageNum", "1"); // 현재페이지 번호
			}
			String boardid = (String) request.getSession().getAttribute("boardid");
			if (boardid == null)
				boardid = "1";
			int pageNum = 1;
			try {
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
			} catch (NumberFormatException e) {
			}
			String column = request.getParameter("column");
			String find = request.getParameter("find");
			/*
			 * column,find 파라미터 중 한개만 존재하는 경우 두개의 파라미터값은 없는 상태로 설정
			 */
			if (column == null || column.trim().equals("")) {
				column = null;
				find = null;
			}
			if (find == null || find.trim().equals("")) {
				column = null;
				find = null;
			}
			int limit = 10; // 한페이지에 보여질 게시물 건수
			// boardcount : 게시물종류별 게시물 등록건수
			int boardcount = dao.bobboardCount(boardid, column, find); // 게시판 종류별 전체 게시물등록 건수 리턴
			// list : 현재 페이지에 보여질 게시물 목록.
			List<Board> bobList = dao.bobList(boardid, pageNum, limit, column, find);
			for (Board board : bobList) {
			    String content = board.getContent();
			    Pattern imgPattern = Pattern.compile("<img[^>]+src=\"([^\">]+)\"");
			    Matcher imgMatcher = imgPattern.matcher(content);

			    if (imgMatcher.find()) {
			        String thumbnailUrl = imgMatcher.group(1);
			        board.setThumbnail(thumbnailUrl);
			    }
			}
			int maxpage = (int) ((double) boardcount / limit + 0.95);
			int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
			int endpage = startpage + 9;
			if (endpage > maxpage)
				endpage = maxpage;
			// boardName : 게시판 이름 화면에 출력
			String boardName = "베스트게시판";
			int boardnum = boardcount - (pageNum - 1) * limit;
			request.setAttribute("boardName", boardName);
			request.setAttribute("boardcount", boardcount);
			request.setAttribute("boardid", boardid);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("boardnum", boardnum);
			request.setAttribute("bobList", bobList);
			request.setAttribute("startpage", startpage);
			request.setAttribute("endpage", endpage);
			request.setAttribute("maxpage", maxpage);
			request.setAttribute("today", new Date());
			return "board/bobList";
		}


	@RequestMapping("writeForm")
	public String writeForm(HttpServletRequest request,HttpServletResponse response) {
		String boardid = (String) request.getSession().getAttribute("boardid");
		if (boardid == null)
			boardid = "1";
		String login = (String) request.getSession().getAttribute("login");
		
		if(login==null) {
			String msg = "로그인을 하세요.";
			String url ="../member/loginForm";
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			return "alert";
		}
		return "board/writeForm";

	}

	@RequestMapping("write")
	public String write(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String login = (String) request.getSession().getAttribute("login");
		// 파라미터 Board 객체에 저장
		Board board = new Board();
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		String boardid = (String) request.getSession().getAttribute("boardid");
		if (boardid == null)
			boardid = "1";
		board.setBoardid(boardid);
		board.setMember_id(login);
		int num = dao.maxnum();
		board.setBoard_num(++num);
		board.setCategory_num(Integer.parseInt(request.getParameter("category_num")));
		String msg = "게시글 등록 실패";
		String url = "writeForm";
		if (dao.insert(board)) {
			return "redirect:list?boardid=" + boardid;
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "alert";
	}

	@RequestMapping("imgupload")
	public String imgupload(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getServletContext().getRealPath("/") + "/upload/imgfile/";
		File f = new File(path);
		if (!f.exists())
			f.mkdirs();
		int size = 10 * 1024 * 1024;
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, path, size, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ckeditor에서 file의 이름이 upload 임
		String fileName = multi.getFilesystemName("upload");
		request.setAttribute("fileName", fileName);
		return "ckeditor";
	}


	@RequestMapping("deleteForm") //보류
	public String deleteForm(HttpServletRequest request, HttpServletResponse response) {
		String login = (String)request.getSession().getAttribute("login");
		String boardid = (String)request.getSession().getAttribute("boardid");

		return "board/deleteForm";
	}

	@RequestMapping("delete")//보류
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String member_id = (String)request.getSession().getAttribute("login");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		Board b = dao.selectOne(board_num);
		String pass = request.getParameter("pass");
		Member m = mdao.selectOne(member_id);
		String msg = "비밀번호가 틀렸습니다.";
		String url = "deleteForm?board_num="+board_num;
		if(!pass.equals(m.getPass())) {
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			return "alert";
		} else {
			//게시글에 대한 댓글 삭제
//			cdao.deleteAll(board_num);

			//게시글에 대한 추천 정보삭제
//			brdao.deleteAll(board_num);

			// 게시글 삭제
			if (dao.delete(board_num)) {
				url = "list?boardid=" + b.getBoardid();
				return "redirect:" + url;
			} else {
				msg = "게시글 삭제 실패";
				url = "info?board_num=" + board_num;
				request.setAttribute("msg", msg);
				request.setAttribute("url", url);
				return "alert";
			}
		}
	}

	@RequestMapping("updateForm")
	public String updateForm(HttpServletRequest request, HttpServletResponse response) {
		String login = (String)request.getSession().getAttribute("login");
		String boardid = (String)request.getSession().getAttribute("boardid");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		Board b = dao.selectOne(board_num);
		request.setAttribute("b",b);
		return "board/updateForm";
	}

	@RequestMapping("update")
	public String update(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int category_num = Integer.parseInt(request.getParameter("category_num"));
		Board b = dao.selectOne(board_num);
		b.setTitle(title);
		b.setContent(content);
		b.setCategory_num(category_num);
		String msg = null; 
		String url = null;
		if (dao.update(b)) {
			msg = "게시글 수정이 되었습니다.";
			url = "info?board_num=" + b.getBoard_num();
		} else {
			msg = "게시글 수정 실패";
			url = "updateForm?board_num=" + b.getBoard_num();
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "alert";
	}
	
	@RequestMapping("comment")
	public String comment(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// board_num : 게시글 번호
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String url = "info?board_num=" + board_num + "&readcnt=f";
		// 파라미터값 Comment 객체에 저장
		Comment comm = new Comment();
		comm.setBoard_num(board_num); //b.board_num

		String login = (String) request.getSession().getAttribute("login");
		comm.setMember_id(login);
		cdao.grpStepAdd(comm.getGrp(),comm.getGrpstep()); // grpstep 변경
		
		// c.member_id 값 설정
		comm.setContent(request.getParameter("content")); //name="content" 파라미터값 설정
		int comment_num = cdao.maxcomment_num(board_num); // comment_num에 해당하는 최대 comment_num 컬럼의 값
		int grpstep = comm.getGrpstep();
		int grplevel = comm.getGrplevel();
		comm.setComment_num(++comment_num);
		comm.setGrp(comment_num);
		comm.setGrplevel(grplevel);
		
		if (cdao.cominsert(comm)) { // comment 테이블에 insert
			return "redirect:" + url;
		}
		request.setAttribute("msg", "답글 등록시 오류 발생");
		request.setAttribute("url", url);
		return "alert";

	}

	@RequestMapping("commdel")
	public String commdel(HttpServletRequest request, HttpServletResponse response) {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int grp = Integer.parseInt(request.getParameter("grp"));
		String url = "info?board_num=" + board_num + "&readcnt=f";
		if(cdao.delete(board_num,grp)) {
			return "redirect:" + url;
		}
		request.setAttribute("msg", "댓글삭제를 실패하였습니다.");
		request.setAttribute("url", url);
		return "alert";
	}


		@RequestMapping("recommend")
		public String recommend(HttpServletRequest request, HttpServletResponse response) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			String login = (String) request.getSession().getAttribute("login");
			if (login == null) {
				request.setAttribute("msg", "비회원은 추천할 수 없습니다.");
				request.setAttribute("url", "../member/loginForm");
				return "alert";
			}

			int num = Integer.parseInt(request.getParameter("board_num"));
			BoardRecommend br = new BoardRecommend();
			String url = "info?board_num=" + num + "&readcnt=f";
			br.setBoard_num(num);
			br.setMember_id(login);

			int check = dao.checkRecommend(br);

			if (check == 0) {
				// If the user has not recommended the post, add a new recommendation
				dao.recommend(br);
				dao.updaterecommend(num);
				request.setAttribute("msg", "추천이 완료되었습니다!");
				request.setAttribute("url", url);
				return "alert";
			} else {
				// If the user has already recommended the post, remove the recommendation
				dao.unrecommend(br);
				dao.downrecommend(num);
				request.setAttribute("msg", "추천이 취소되었습니다.");
				request.setAttribute("url", url);
				return "alert";
			}
		}

		@RequestMapping("comrecommend")
		public String comrecommend(HttpServletRequest request, HttpServletResponse response) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			String login = (String) request.getSession().getAttribute("login");
			if (login == null) {
				request.setAttribute("msg", "비회원은 추천할 수 없습니다.");
				request.setAttribute("url", "../member/loginForm");
				return "alert";
			}

			int board_num = Integer.parseInt(request.getParameter("board_num"));
			int num = Integer.parseInt(request.getParameter("comment_num"));
			ComRecommend cr = new ComRecommend();
			String url = "info?board_num=" + board_num + "&readcnt=f";
			cr.setComment_num(num);
			cr.setMember_id(login);

			int check = cdao.checkcomRecommend(cr);
			System.out.println(board_num);
			System.out.println(num);
			if (check == 0) {
				// If the user has not recommended the post, add a new recommendation
				cdao.comrecommend(cr);
				cdao.comupdaterecommend(num); 
				request.setAttribute("msg", "댓글추천이 완료되었습니다!");
				request.setAttribute("url", url);
				return "alert";
			} else {
				// If the user has already recommended the post, remove the recommendation
				cdao.comunrecommend(cr);
				cdao.comdownrecommend(num);
				request.setAttribute("msg", "댓글추천이 취소되었습니다.");
				request.setAttribute("url", url);
				return "alert";
				
			}
			
		}

		@RequestMapping("info")
		public String info(HttpServletRequest request, HttpServletResponse response) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			if (request.getParameter("boardid") != null) {
				// session에 게시판 종류 정보 등록
				request.getSession().setAttribute("boardid", request.getParameter("boardid"));
				request.getSession().setAttribute("pageNum", "1"); // 현재페이지 번호
			}
			String login = (String)request.getSession().getAttribute("login");
			String boardid = (String)request.getSession().getAttribute("boardid");
			String readcnt = request.getParameter("readcnt");
			int num = Integer.parseInt(request.getParameter("board_num"));

			String url = "info?board_num=" + num + "&readcnt=f";
			Board b = dao.selectOne(num);
			Member member = mdao.selectOne(b.getMember_id());
			int level = member.getLevel();
			if (readcnt == null || !readcnt.equals("f")) {
				dao.readcntAdd(num);
			}
			boardid = b.getBoardid();
			//category_num : 게시판 분류 화면에 출력
			String category_name = null;
			switch(b.getCategory_num()){
				case 1 : category_name = "유머";break;
				case 2 : category_name = "썰";break;
				case 3 : category_name = "공포";break;
				case 4 : category_name = "감동";break;
				case 5 : category_name = "뉴스";break;
				case 6 : category_name = "루머";break;	
				case 7 : category_name = "움짤";break;
				case 8 : category_name = "분석";break;
				case 9 : category_name = "레시피";break;	
				case 10 : category_name = "맛집";break;	
				case 11 : category_name = "자랑";break;	
			}
			
			// boardName : 게시판 이름 화면에 출력
			String boardName = "베스트게시판";
			switch (b.getBoardid()) {
			case "2":
				boardName = "유머게시판";
				break;
			case "3":
				boardName = "해축게시판";
				break;
			case "4":
				boardName = "음식게시판";
				break;
			}

			int commcount = cdao.commcount(num);
			int pageNum = 1;
			try {
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
			} catch (NumberFormatException e) {	}
			int limit = 10; // 한페이지에 보여질 게시물 건수
			int maxpage = (int) ((double) commcount / limit + 0.95);
			int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
			int endpage = startpage + 9;
			if (endpage > maxpage)
				endpage = maxpage;
			int commnum = commcount - (pageNum - 1) * limit;

		      //댓글 목록 화면에 전달
			  List<Comment> commlist = cdao.selectclist(num, pageNum, limit);
			  List<Comment> top3Comments = commlist.stream()
					    .sorted(Comparator.comparing(Comment::getRecommendcnt).reversed())
					    .limit(3)
					    .collect(Collectors.toList());
     		  request.setAttribute("top3Comments", top3Comments);					
		      request.setAttribute("b",b);
		      request.setAttribute("level", level);
		      request.setAttribute("boardid",boardid);
		      request.setAttribute("boardName",boardName);
		      request.setAttribute("commnum", commnum);
		      request.setAttribute("category_name", category_name);
		      request.setAttribute("commlist",commlist);
			  request.setAttribute("startpage", startpage);
			  request.setAttribute("endpage", endpage);
			  request.setAttribute("maxpage", maxpage);
			  request.setAttribute("pageNum", pageNum);
			  request.setAttribute("commcount", commcount);
		      return "board/info";
		}
		
		@RequestMapping("reply")
		public String reply(HttpServletRequest request, HttpServletResponse response) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			int board_num = Integer.parseInt(request.getParameter("board_num"));
			String url = "info?board_num=" + board_num + "&readcnt=f";
			
			String login = (String) request.getSession().getAttribute("login");
			String content = request.getParameter("content");
			Comment comm = new Comment();
			int comment_num = Integer.parseInt(request.getParameter("comment_num"));
			cdao.grpStepAdd(comm.getGrp(),comm.getGrpstep());
			comm.setMember_id(login);
			comm.setContent(content);
			 int maxcomment_num = cdao.maxcomment_num(board_num);
			comm.setComment_num(++maxcomment_num);
			comm.setGrp(comment_num);
			comm.setGrpstep(Integer.parseInt(request.getParameter("grpstep"))+1);
			comm.setGrplevel(Integer.parseInt(request.getParameter("grplevel"))+1);
			comm.setBoard_num(board_num);
			if (cdao.cominsert(comm)) {
				return "redirect:" + url;
			}
			request.setAttribute("msg", "답글 등록시 오류 발생");
			request.setAttribute("url", url);
			return "alert";
		}
}