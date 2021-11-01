package com.model;

public class CalendarVO {
	// 필드(속성)
	private String pt_num;
	private String date;
	private String state;

	// 메서드
	public CalendarVO(String pt_num, String date, String state) {
		this.pt_num = pt_num;
		this.date = date;
		this.state = state;
	}

	public String getPt_num() {
		return pt_num;
	}

	public void setPt_num(String pt_num) {
		this.pt_num = pt_num;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
