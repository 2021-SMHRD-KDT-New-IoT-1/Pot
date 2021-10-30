package com.model;

public class PlantVO {
	// 필드(속성)
	private String comment;
	private String pt_nick;
	private String mem_num;

	// 메서드
	public PlantVO(String comment, String pt_nick, String mem_num) {
		this.comment = comment;
		this.pt_nick = pt_nick;
		this.mem_num = mem_num;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPt_nick() {
		return pt_nick;
	}

	public void setPt_nick(String pt_nick) {
		this.pt_nick = pt_nick;
	}

	public String getMem_num() {
		return mem_num;
	}

	public void setMem_num(String mem_num) {
		this.mem_num = mem_num;
	}
}
