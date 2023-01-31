package com.app.taskmanagement.model;

public class CountType {
	
	private Long count;
	private String type;
	
	CountType(){
		
	}

	public CountType(Long count, String type) {
		
		this.count = count;
		this.type = type;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CountType [count=" + count + ", type=" + type + "]";
	}
    
	
	
	 
}
