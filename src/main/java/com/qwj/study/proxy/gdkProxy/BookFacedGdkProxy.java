/**
 * Copyright (C), 2015-2019
 * FileName: BookFacedGdkProxy
 * Author:   qianwenjun
 * Date:     2019/3/16 08:49
 * Description:
 */
package com.qwj.study.proxy.gdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 〈JDK动态代理代理类〉
 *
 * @author qianwenjun
 * @create 2019/3/16
 * @since 1.0.0
 */
public class BookFacedGdkProxy implements InvocationHandler {

    private Object target;
    /**
     * 绑定委托对象并返回一个代理类
     * @param target
     * @return
     */
    public Object bind (Object target) {
        this.target = target;
        //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)
        //将InvocationHandler接口的子类想象成一个代理的最终操作类，替换掉ProxySubject。
        //Proxy类是专门完成代理的操作类，可以通过此类为一个或多个接口动态地生成实现类，此类提供了如下的操作方法：
        //ClassLoader loader：类加载器
        //Class<?>[] interfaces：得到全部的接口
        //InvocationHandler h：得到InvocationHandler接口的子类实例
        /**
         * @param loader：类加载器
         * @param interfaces：得到全部的接口
         * @param h：得到InvocationHandler接口的子类实例
         * @return
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    /**
     *
     *
     * @param  proxy：指被代理的对象。
     * @param  args：方法调用时所需要的参数
     * @param  method：要调用的方法
     * @return
     */

    @Override
    public Object invoke (Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        System.out.println("事物开始");
        //执行方法
        result=method.invoke(target, args);
        System.out.println("事物结束");
        return result;

    }


    public static void main(String[] args) {
        BookFacedGdkProxy proxy = new BookFacedGdkProxy();
        BookFaced bookProxy = (BookFaced) proxy.bind(new BookFacedIml());
        bookProxy.addBook();
    }
}