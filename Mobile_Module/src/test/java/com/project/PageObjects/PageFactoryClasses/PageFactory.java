package com.project.PageObjects.PageFactoryClasses;

import com.project.Utilities.LoggingHandler;

import java.lang.reflect.Proxy;

class PageFactory {

    @SuppressWarnings("unchecked")
    static <T> T wrap(T instance, Class<T> itf){
        return (T) Proxy.newProxyInstance(
                itf.getClassLoader(), new Class<?>[]{itf}, new LoggingHandler(instance)
        );
    }
}