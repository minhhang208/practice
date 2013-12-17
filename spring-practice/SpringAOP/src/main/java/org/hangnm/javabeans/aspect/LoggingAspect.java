package org.hangnm.javabeans.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;


public class LoggingAspect {
	
	
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJointPoint){
		Object returnValue = null;
		try {
			System.out.println("Before advice");
			returnValue=proceedingJointPoint.proceed();
			System.out.println("After returning");
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("After throwing");
		}
		System.out.println("After finally");
		return returnValue;
	}
	
	public void loggingAdvice(){
			System.out.println("Logging from the advice");
	}
	
	
	
	

	

}
