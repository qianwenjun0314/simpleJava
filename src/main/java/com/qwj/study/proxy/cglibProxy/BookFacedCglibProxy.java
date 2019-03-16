/**
 * Copyright (C), 2015-2019
 * FileName: BookFacedCglibProxy
 * Author:   qianwenjun
 * Date:     2019/3/16 09:03
 * Description:
 */
package com.qwj.study.proxy.cglibProxy;

//import org.aopalliance.intercept.MethodInterceptor;
//import org.springframework.cglib.proxy.Enhancer;
//import org.springframework.cglib.proxy.MethodProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


import java.lang.reflect.Method;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/16
 * @since 1.0.0
 */
public class BookFacedCglibProxy implements MethodInterceptor {


    private Object target;

    /**
     * 创建代理对象
     *
     * @param target
     * @return
     */
    public Object getInstance (Object target) {

        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        //创建回调方法
        enhancer.setCallback(this);
        return  enhancer.create();

    }

    @Override
    // 回调方法
    public Object intercept (Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("事物开始");
        proxy.invokeSuper(obj, args);
        System.out.println("事物结束");
        return null;
    }


    public static void main(String[] args) {
        BookFacedCglibProxy cglib=new BookFacedCglibProxy();
        BookFacesIml2 bookCglib=(BookFacesIml2)cglib.getInstance(new BookFacesIml2());
        bookCglib.addBook();
    }
}