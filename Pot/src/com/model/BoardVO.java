package com.model;

public class BoardVO {
	// 필드
	String bo_num;
	String date;
	String title;
	String content;
	String mem_num;

	// 메서드
	public BoardVO(String bo_num, String date, String title, String content, String mem_num) {
		this.bo_num = bo_num;
		this.date = date;
		this.title = title;
		this.content = content;
		this.mem_num = mem_num;
	}

	public String getBo_num() {
		return bo_num;
	}

	public void setBo_num(String bo_num) {
		this.bo_num = bo_num;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getMem_num() {
		return mem_num;
	}

	public void setMem_num(String mem_num) {
		this.mem_num = mem_num;
	}

}
