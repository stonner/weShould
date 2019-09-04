package com.zcq.weShould.config;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.Executors;

@Component
public class AsynEventBusConfig {

    @Autowired
    private ApplicationContext context;

    @Bean
    @ConditionalOnMissingBean(AsyncEventBus.class)
    AsyncEventBus asyncEventBus() {
        AsyncEventBus asyncEventBus = new AsyncEventBus(Executors.newFixedThreadPool(5));
        Reflections reflections = new Reflections("com.zcq.weShould", new MethodAnnotationsScanner());
        Set<Method> methods = reflections.getMethodsAnnotatedWith(Subscribe.class);
        if (null != methods ) {
            for(Method method : methods) {
                try {
                    asyncEventBus.register(context.getBean(method.getDeclaringClass()));
                }catch (Exception e ) {
                    //register subscribe class error
                }
            }
        }

        return asyncEventBus;
    }
}
