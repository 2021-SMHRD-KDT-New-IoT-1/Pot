package com.model;

public class HumidityVO {
	// �ʵ�
	private int mysensor;
	
	public HumidityVO(int mysensor){
		this.mysensor = mysensor;
	}
	
	public int getMysensor() {
		return mysensor;
	}
	
	public void setMysensor_b(int mysensor) {
		this.mysensor = mysensor;
	}
	
	public String toString_b() {
		return "SensorVO [mysensor_b=" + mysensor + "]";
	}
}
