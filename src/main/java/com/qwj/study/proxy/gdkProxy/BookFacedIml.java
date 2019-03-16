/**
 * Copyright (C), 2015-2019
 * FileName: BookFacedIml
 * Author:   qianwenjun
 * Date:     2019/3/16 08:37
 * Description:
 */
package com.qwj.study.proxy.gdkProxy;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/16
 * @since 1.0.0
 */
public class BookFacedIml implements BookFaced {

    @Override
    public void addBook() {
        System.out.println("增加图书方法。。。");
    }

}