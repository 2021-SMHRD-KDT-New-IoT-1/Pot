package com.model;

public class PlantVO {
	// 필드(속성)
	private String comment;
	private String pt_nick;
	private String mem_num;
	private String pt_num;
	private int humidity;

	// 메서드
	public PlantVO(String comment, String pt_nick, String mem_num) {
		this.comment = comment;
		this.pt_nick = pt_nick;
		this.mem_num = mem_num;
	}
	
	public PlantVO(String comment, String pt_nick, String mem_num, String pt_num) {
		this.comment = comment;
		this.pt_nick = pt_nick;
		this.mem_num = mem_num;
		this.pt_num = pt_num;
	}
	
	public PlantVO(String pt_num, int humidity) {
		this.pt_num = pt_num;
		this.humidity = humidity;
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

	public String getPt_num() {
		return pt_num;
	}

	public void setPt_num(String pt_num) {
		this.pt_num = pt_num;
	}
}
