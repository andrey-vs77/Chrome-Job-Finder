package com.sanda.chrome.freelancehunt.aspects;

import com.sanda.chrome.freelancehunt.restful.Requests;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by cdc89 on 05.11.2016.
 */
@Aspect
@Component
public class RequestAspect {
    @Pointcut("execution(* com.sanda.chrome.freelancehunt.restful.Requests.get*(String))")
    public void signRequestMethod() {
    }

    @Around("signRequestMethod()")
    public Object signRequestCall(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();
        Requests currentObject=(Requests)thisJoinPoint.getThis();
        currentObject.signRequest((String) methodArgs[0]);
        Object result = thisJoinPoint.proceed();
        return result;
    }

}
