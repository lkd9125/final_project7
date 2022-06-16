package com.openai.di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
//		Mycal mc = new Mycal();
//		Calculator c = new Calculator();
//		mc.setCal(c); // 이렇게 합쳐서 쓴다
//		mc.setFnum(10);
//		mc.setFsum(4); //di 방식
		
		//spring 방식(xml을 사용하여 DI, IoC 처리)
		String conf = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(conf);
		
		Mycal mc = ctx.getBean("mycal",Mycal.class);
		TestClass tc = ctx.getBean("tc",TestClass.class);
//		
		mc.madd();
		mc.msub();
		mc.mmul();
		mc.mdiv();
		
		
	}

}
