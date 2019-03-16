/**
 * Copyright (C), 2015-2019
 * FileName: CountImpl
 * Author:   qianwenjun
 * Date:     2019/3/16 08:41
 * Description:
 */
package com.qwj.study.proxy.jintaiProxy;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/16
 * @since 1.0.0
 */
public class CountImpl implements Count {

    @Override
    public void queryCount() {
        System.out.println("查看账户方法...");

    }

    @Override
    public void updateCount() {
        System.out.println("修改账户方法...");

    }
}