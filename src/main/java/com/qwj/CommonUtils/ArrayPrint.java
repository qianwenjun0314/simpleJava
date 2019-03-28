/**
 * Copyright (C), 2015-2019
 * FileName: ArrayPrint
 * Author:   qianwenjun
 * Date:     2019/3/19 20:21
 * Description:
 */
package com.qwj.CommonUtils;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/19
 * @since 1.0.0
 */
public class ArrayPrint {

    public static void printArr(Integer[] arr){
        for (Integer n:arr){
            System.out.print(n+"  ");
        }
        System.out.println('\n');
    }

}