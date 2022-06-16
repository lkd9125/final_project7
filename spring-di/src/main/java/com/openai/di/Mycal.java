package com.openai.di;

public class Mycal {
	Calculator cal;
	private int fnum;
	private int fsum;
	
	
	public Calculator getCal() {
		return cal;
	}
	public void setCal(Calculator cal) {
		this.cal = cal;
	}
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public int getFsum() {
		return fsum;
	}
	public void setFsum(int fsum) {
		this.fsum = fsum;
	}
	
	//Calculator 메서드를 실행하기 위한 중계 메서드
	public void madd() {
		cal.add(fsum, fnum);	
	}
	public void msub() {
		cal.sub(fsum, fnum);
	}
	public void mmul() {
		cal.mul(fsum, fnum);
	}
	public void mdiv() {
		cal.div(fsum, fnum);
	}
}
