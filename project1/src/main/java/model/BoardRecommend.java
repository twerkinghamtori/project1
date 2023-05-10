package model;

public class BoardRecommend {
	private int num;
	private int board_num;
	private String member_id;
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

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	@Override
	public String toString() {
		return "BoardRecommend [num=" + num + ", board_num=" + board_num + ", member_id=" + member_id + ", recommend="
				+ recommend + "]";
	}


}
