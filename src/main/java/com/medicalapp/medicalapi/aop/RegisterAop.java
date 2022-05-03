package com.medicalapp.medicalapi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RegisterAop {
	@Before("execution(* com.medicalapp.medicalapi.controller.UserController.login(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("logBefore() started");
		System.out.println("Method Name:" + joinPoint.getSignature().getName());
		System.out.println("logBefore() completed!");
		System.out.println("******");


}
	
}
