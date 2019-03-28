/**
 * Copyright (C), 2015-2019
 * FileName: Exam20
 * Author:   qianwenjun
 * Date:     2019/3/21 11:45
 * Description:
 */
package com.qwj.algorithm;

import java.util.Arrays;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/21
 * @since 1.0.0
 */
public class Exam20 {



    //https://leetcode.com/problems/n-repeated-element-in-size-2n-array/description/
    //961 给定一个2N长度的数组，包含N+1个不同的元素，其实一个元素重复N次，找出这个元素
    //根据N个数字的排布规律
    //解法1：排序，遍历找出相邻元素相等的数
    public static Integer findNTimes(Integer[] arr){

        Arrays.sort(arr);
        for (int i=0;i<arr.length;i++){
            if (arr[i]==arr[i+1]){
                return arr[i];
            }
        }
        return null;
    }

    //冒泡排序
    public static Integer[] bubbleSort(Integer[] arr){

        Integer temp = null;
        for (int i=0;i<arr.length;i++){
            if (arr[i]>arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        return arr;
    }
}