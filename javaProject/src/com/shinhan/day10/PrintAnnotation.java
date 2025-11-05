package com.shinhan.day10;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME) // 유지기간
@Target(METHOD) // 적용대상
public @interface PrintAnnotation {
	String value() default "-";
	int number() default 7;
	int number2() default 7;
}
