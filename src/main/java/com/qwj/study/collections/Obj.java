/**
 * Copyright (C), 2015-2019
 * FileName: Obj
 * Author:   qianwenjun
 * Date:     2019/3/3 14:14
 * Description:
 */
package com.qwj.study.collections;

import java.net.SocketPermission;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/3
 * @since 1.0.0
 */
public class Obj {


    public void go(){
        Obj adog = new Obj();
//        Obj sameDo = getObject(adog);//object类型对象不能赋值给Dog类型的引用变量。便宜报错
        Obj sameDo = (Obj)getObject(adog);//强转成Dog类型
        if(sameDo instanceof Obj ) {
            System.out.print("true1");
        }
    }
    public Object getObject(Object o){
        if(o instanceof Obj ) {
            System.out.print("true2");
        }
        if(o instanceof Object ) {
            System.out.print("true3");
        }
        return o;//此返回的是一个object类型的。
    }

    public static void main(String[] args) {

       Obj obj = new Obj();
       obj.go();
    }
}