package com.zcq.weShould.aspect;

import com.google.common.eventbus.AsyncEventBus;
import com.zcq.weShould.handler.SendMsgHandler;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class SendMsgAspect {
    @Autowired
    private AsyncEventBus asyncEventBus;
    @Autowired
    private SendMsgHandler sendMsgHandler;

    @Pointcut("@annotation(com.zcq.weShould.annotation.SendMsg)")
    public void doSomething (){
    }

    @AfterReturning(value = "doSomething()")
    public void sdgh(ProceedingJoinPoint joinpoint) {
        System.out.println("22333332222222222222222");
        MethodSignature sign = (MethodSignature) joinpoint.getSignature();
        Method method = sign.getMethod();
        System.out.print("接受方法："+method.getName()+" 前置日志");
        asyncEventBus.register(sendMsgHandler);
        asyncEventBus.post("rt436");
    }
}
