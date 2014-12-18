package com.liam.aop.aspect.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liam.aop.service.TestService;

public class AopLogAnnotationTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");  
        TestService testService = (TestService)ctx.getBean("testService");  
        testService.test("abc","123");
	}
}
