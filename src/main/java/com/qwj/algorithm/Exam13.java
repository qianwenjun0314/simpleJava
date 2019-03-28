/**
 * Copyright (C), 2015-2019
 * FileName: Exam13
 * Author:   qianwenjun
 * Date:     2019/3/21 10:50
 * Description:
 */
package com.qwj.algorithm;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/21
 * @since 1.0.0
 */
public class Exam13 {


    //633 给定一个非负整数，判断是否可表示为 a^2 + b^2 的形式

    public static Integer isForm(Integer num){

        for (int i=0;i<(int)Math.sqrt(num);i++){
            if (i*i==num){
                return i;
            }else {
                int c = num-i*i;
                int n = (int) Math.sqrt(c);
                if (n*n==c){
                    return n;
                }else {
                    return null;
                }

            }
        }
        return null;
    }


    public static void main(String[] args) {
        Integer num = 24;
        System.out.println(isForm(num));
    }
}