package model;

public class ComRecommend {
	private int num;
	private String member_id;
	private int comment_num;
	private boolean recommend;
	
	
	public boolean isRecommend() {
		return recommend;
	}

	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getComment_num() {
		return comment_num;
	}

	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}

	@Override
	public String toString() {
		return "ComRecommend [num=" + num + ", member_id=" + member_id + ", comment_num=" + comment_num + ", recommend="
				+ recommend + "]";
	}


}
