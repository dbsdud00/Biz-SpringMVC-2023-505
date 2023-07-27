package com.callor.rent.config;

class DataA {
	public String name;
	public int age;
}
public class ClassExA {
	
	public static void add(DataA data) {
		data.name = "홍길동";
		data.age = 30;
	}
	public static void add(int num) {
		num=100;
	}
	public static void main(String[] args) {
		DataA data = new DataA();
		data.name = "이몽룡";
		data.age = 16;
		
		System.out.println(data.name);
		System.out.println(data.age);
		int num1 = 200;
		add(num1);
		add(data);
		// 여기에서 data.name, data
		// 여기서에 num1은?
	}
}
