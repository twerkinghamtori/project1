package model;
/*
 * Bean 클래스 
 * 프로퍼티(property) 
 *   get 프로퍼티 : getId() -> id (get 프로퍼티)
 *                getXxx => xxx
 *   set 프로퍼티 : setId(Object) -> id(set 프로퍼티)
 *                setAbc => abc
 */
public class Member {
	private String member_id;
	private String pass;
	private String tel;
	private String email;
	private int exp;
	private int level;

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Member [member_id=" + member_id + ", pass=" + pass + ", tel=" + tel + ", email=" + email + ", exp="
				+ exp + ", level=" + level + "]";
	}

	}
