package com.liam.aop.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

import com.liam.aop.utils.JsonUtils;

@Aspect
public class LogAdvice {
	
	@Before("@annotation(log)")
	public void logBefore(JoinPoint joinPoint, Log log){
		Object[] args = joinPoint.getArgs();
		StringBuilder sb = new StringBuilder();
		if (args!=null) {
			for (Object arg : args) {
				sb.append(JsonUtils.toStr(arg));
			}
		}
		getLogger(joinPoint).info(String.format("start invoke [%s], params = [%s]", new Object[]{getMethodName(joinPoint), sb.toString()}));
	}

	@After("@annotation(log)")
	public void logAfter(JoinPoint joinPoint, Log log){
		getLogger(joinPoint).info(String.format("complete invoke [%s]",new Object[]{ getMethodName(joinPoint)}));
	}

	@AfterThrowing(value = "@annotation(log)", throwing = "ex")
	public void logAfterThrowingException(JoinPoint joinPoint, Log log,Exception ex) throws Throwable {
		getLogger(joinPoint).error(String.format("error occurred when invoking [%s]",new Object[]{ getMethodName(joinPoint)}), ex);
		throw ex;
	}

	private Logger getLogger(JoinPoint joinPoint) {
		return Logger.getLogger(getFullClassName(joinPoint));
	}
	private String getMethodName(JoinPoint joinPoint) {
		return ((MethodSignature) joinPoint.getSignature()).getName();
	}
	private String getFullClassName(JoinPoint joinPoint) {
		return joinPoint.getTarget().getClass().getName();
	}
}
