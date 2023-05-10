package model;

import java.util.Date;

public class Comment {

	private int comment_num = 0;
	private Date regdate;
	private int recommendcnt;
	private String member_id;
	private int board_num;
	private String content;
	private int grp;
	private int grpstep;
	private int grplevel;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getComment_num() {
		return comment_num;
	}

	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getRecommendcnt() {
		return recommendcnt;
	}

	public void setRecommendcnt(int recommendcnt) {
		this.recommendcnt = recommendcnt;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	
	public int getGrp() {
		return grp;
	}

	public void setGrp(int grp) {
		this.grp = grp;
	}

	public int getGrpstep() {
		return grpstep;
	}

	public void setGrpstep(int grpstep) {
		this.grpstep = grpstep;
	}

	
	
	public int getGrplevel() {
		return grplevel;
	}

	public void setGrplevel(int grplevel) {
		this.grplevel = grplevel;
	}

	@Override
	public String toString() {
		return "Comment [comment_num=" + comment_num + ", regdate=" + regdate + ", recommendcnt=" + recommendcnt
				+ ", member_id=" + member_id + ", board_num=" + board_num + ", content=" + content + ", grp=" + grp
				+ ", grpstep=" + grpstep + ", grplevel=" + grplevel + "]";
	}

	
	

}
