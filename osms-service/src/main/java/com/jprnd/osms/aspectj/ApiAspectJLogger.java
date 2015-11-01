package com.jprnd.osms.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("apiAspectLogger")
@Aspect
public class ApiAspectJLogger {
	private static final Logger logger = LoggerFactory.getLogger(ApiAspectJLogger.class);

	
	@Before("execution(* com.jprnd.osms.api.controller.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		logger.info("start--->" + joinPoint.getSignature().getName() + " params-->" + joinPoint.getArgs() );
	}

	
}
