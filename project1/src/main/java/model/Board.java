package model;

import java.util.Date;

public class Board {
	private int board_num;
	private String title;
	private String content;
	private int readcnt;
	private int recommendcnt;
	private Date regdate;
	private String boardid;
	private int category_num;
	private String member_id;
	private String thumbnail;
	private int commcnt;
	private int level;

	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCommcnt() {
		return commcnt;
	}

	public void setCommcnt(int commcnt) {
		this.commcnt = commcnt;
	}

	public String getThumbnail() {
	    return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
	    this.thumbnail = thumbnail;
	}
	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public int getRecommendcnt() {
		return recommendcnt;
	}

	public void setRecommendcnt(int recommendcnt) {
		this.recommendcnt = recommendcnt;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getBoardid() {
		return boardid;
	}

	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}

	public int getCategory_num() {
		return category_num;
	}

	public void setCategory_num(int category_num) {
		this.category_num = category_num;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	@Override
	public String toString() {
		return "Board [board_num=" + board_num + ", title=" + title + ", content=" + content + ", readcnt=" + readcnt
				+ ", recommendcnt=" + recommendcnt + ", regdate=" + regdate + ", boardid=" + boardid + ", category_num="
				+ category_num + ", member_id=" + member_id + ", thumbnail=" + thumbnail + ", commcnt=" + commcnt
				+ ", level=" + level + "]";
	}



	
}


   
