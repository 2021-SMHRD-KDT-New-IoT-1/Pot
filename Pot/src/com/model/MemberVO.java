package com.model;

public class MemberVO {
	// 필드(속성)
	private String email;
//	private String pw;
	private String tel;
	private String nick;
	private String mem_num;
	
	// 생성자
	public MemberVO(String email, String tel, String nick) {
		this.email = email;
		this.tel = tel;
		this.nick = nick;
	}
	
	public MemberVO(String email, String tel, String nick, String mem_num) {
		this.email = email;
		this.tel = tel;
		this.nick = nick;
		this.mem_num = mem_num;
	}

	// 메서드(get)
	public String getEmail() {
		return email;
	}

	public String getTel() {
		return tel;
	}

	public String getNick() {
		return nick;
	}

	public String getMem_num() {
		return mem_num;
	}

}
