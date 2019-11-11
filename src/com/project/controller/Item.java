package com.project.controller;

public class Item {
	private String key; // 시리얼넘버
	private int length; // text 저장 길이
	private String text; // text
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String raw() { // length만큼 공간 할당
	    StringBuffer padded = new StringBuffer(this.text);
	    while (padded.toString().getBytes().length < this.length) { 
	        padded.append(' '); // 빈 공간을 " "으로 채움
	    }
	    
	    return padded.toString(); // 채워진 문자열 반환
	}

	public static Item create(String key, int length, String text) { // 항목 생성 
		Item item = new Item();
		item.setKey(key);
		item.setLength(length);
		item.setText(text);
		
		return item;
	}
}