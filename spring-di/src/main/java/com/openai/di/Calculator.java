package com.openai.di;

public class Calculator {
	public void add(int a, int b) {
		System.out.println("add()"); // 로그
		int c = a+b;
		System.out.println(a+" + "+b+" = "+c);
	}
	public void sub(int a, int b) {
		System.out.println("sub()"); // 로그
		int c = a-b;
		System.out.println(a+" - "+b+" = "+c);
	}
	public void mul(int a, int b) {
		System.out.println("mul()"); // 로그
		int c = a*b;
		System.out.println(a+" X "+b+" = "+c);
	}
	public void div(int a, int b) {
		System.out.println("div()"); // 로그
		int c = a/b;
		System.out.println(a+" / "+b+" = "+c);
	}
}
