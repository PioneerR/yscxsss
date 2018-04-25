package com.yscxsss.aop;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//若全部采用注解配置AOP时，TheLogger切面实例必须注册到Spring中，否则没有实例也就无法完成相应的功能
@Component("theLogger")
@Aspect
public class TheLogger {

	private static final Logger log=Logger.getLogger(TheLogger.class);
	//通过注解，统一配置切入点
	@Pointcut("execution(* com.yscxsss.service..*.*(..))")
	public void pointcut(){}
	
	//前置增强（不用写pointcut属性）
	/*@Before("pointcut()")
	public void before(JoinPoint jp){
		log.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法。方法参数："
				+Arrays.toString(jp.getArgs()));
	}
	
	//后置增强
	@AfterReturning(pointcut="pointcut()",returning="result")
	public void afterReturning(JoinPoint jp,Object result){
		log.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法。返回值："
				+result);
	}
	
	//异常抛出增强
	@AfterThrowing(pointcut="pointcut()",throwing="e")
	public void afterThrowing(JoinPoint jp,RuntimeException e){
		log.error(jp.getSignature().getName()+"方法发生异常："+e);
	}
	
	//最终增强（不用写pointcut属性）
	@After("pointcut()")
	public void after(JoinPoint jp){
		log.info(jp.getSignature().getName()+"方法结束执行。");
	}*/
	
	//环绕增强
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint jp)throws Throwable{
		//前置增强
		log.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法。参数列表："
				+Arrays.toString(jp.getArgs()));
		try {
			//方法执行后，返回结果
			Object result=jp.proceed();
			//后置增强
			log.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法。方法返回值"
					+result);
			return result;			
		} catch (Exception e) {
			//异常抛出增强
			log.error(jp.getSignature().getName()+"方法发生异常"+e);
			throw e;
		} finally {
			//最终增强
			log.info(jp.getSignature().getName()+"方法执行结束");
		}
	}
	
}
