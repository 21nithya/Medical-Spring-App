package com.medicalapp.medicalapi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
@Aspect
public class RegisterAop {
	@Before("execution(* com.medicalapp.medicalapi.controller.UserController.login(..))")
	public void logBefore(JoinPoint joinPoint) {

		log.info("logBefore() started");
		log.info("Method Name:" + joinPoint.getSignature().getName());
		log.info("logBefore() completed!");
		log.info("******");
	
}
	@After("execution(* com.medicalapp.medicalapi.controller.UserController.save(..))")
	public void logAfter(JoinPoint joinPoint)//?
	{

		log.info("logAfter() started");
		log.info("Method Name:" + joinPoint.getSignature().getName());
		log.info("logAfter() completed!");
		log.info("******");
	}

	
}
