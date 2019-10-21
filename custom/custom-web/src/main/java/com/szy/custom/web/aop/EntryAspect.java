package com.szy.custom.web.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EntryAspect {

    private static Logger logger = LoggerFactory.getLogger(EntryAspect.class);


    /**
     * 接口调入前加载,打印入参
     * @param joinPoint
     */
    @Before(value = "execution(public * com.szy.custom.web.remote.impl.*.*(..))")
    public void before(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        StringBuilder params = new StringBuilder();
        for (Object obj : args) {
            params.append(obj).append(",");
        }
        logger.info("类名:{},方法名:{},入参:{}", className, methodName, params.toString());
    }

    @Around(value = "execution(public * com.szy.custom.web.remote.impl.*.*(..))")
    public Object catchAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e){
            String className = proceedingJoinPoint.getTarget().getClass().getName();
            String methodName = proceedingJoinPoint.getSignature().getName();
            logger.error("类名:{},方法名{}发生了异常！{}", className, methodName, e);
        }
        return result;
    }

    /**
     * 返回结果打印
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "execution(public * com.szy.custom.web.remote.impl.*.*(..))",returning="result")
    public void after(JoinPoint joinPoint, Object result){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("类名:{},方法名{},返回结果:{}", className, methodName, result);
    }
}
