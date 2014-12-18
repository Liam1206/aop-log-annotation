package com.liam.aop.service.impl;

import com.liam.aop.advice.Log;
import com.liam.aop.service.TestService;

public class TestServiceImpl implements TestService {

	@Log(logAfter = true, logBefore = true)
	public void test(String param1,String param2) {
		System.out.println("do something...................");
//		throw new IllegalArgumentException();
	}

}
