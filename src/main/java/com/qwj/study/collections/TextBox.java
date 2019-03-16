/**
 * Copyright (C), 2015-2019
 * FileName: TextBox
 * Author:   qianwenjun
 * Date:     2019/3/3 16:43
 * Description:
 */
package com.qwj.study.collections;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/3
 * @since 1.0.0
 */
public class TextBox {

    Integer i;
    int j;

    public void  go(){
        j = i;
        System.out.print(i);
        System.out.print(j);

    }

    public static void main(String[] args) {
        TextBox x = new TextBox();
        x.go();
    }

}