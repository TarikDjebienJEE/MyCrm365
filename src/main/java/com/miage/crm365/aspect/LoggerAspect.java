package com.miage.crm365.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * @author acraske
 */
@Aspect
public class LoggerAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @After("execution(* com.miage..*.*(..))")
    public void doLogAfterMethod(JoinPoint pJoinPoint)
    {
        if(pJoinPoint != null)
        {
            logger.info("[END]"
                    + pJoinPoint.getSignature().getDeclaringTypeName()
                    + "."
                    + pJoinPoint.getSignature().getName());
        }
    }

    @Before("execution(* com.miage..*.*(..))")
    public void doBefore(JoinPoint pJoinPoint)
    {
        if(pJoinPoint != null)
        {
            logger.info("[BEGIN]"
                    + pJoinPoint.getSignature().getDeclaringTypeName()
                    + "."
                    + pJoinPoint.getSignature().getName());
            if(pJoinPoint.getArgs() != null)
            {
                int iOcc = 1;
                for(Object iArgument : pJoinPoint.getArgs())
                {
                    logger.info("Argument [" + iOcc +"] : "
                            + iArgument);
                    iOcc++;
                }
            }
        }
    }
}
