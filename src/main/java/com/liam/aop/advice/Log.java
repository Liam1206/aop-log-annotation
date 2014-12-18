package com.liam.aop.advice;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface Log {
	  public abstract boolean logBefore();
	  public abstract boolean logAfter();
}
