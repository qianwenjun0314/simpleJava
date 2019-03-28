/**
 * Copyright (C), 2015-2019
 * FileName: Exam15
 * Author:   qianwenjun
 * Date:     2019/3/21 10:59
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
public class Exam15 {


    //https://leetcode.com/problems/largest-number-at-least-twice-of-others/
    //747 查找数组中最大元素是否大于其他所有元素的两倍
    //解法1：存储最大和次大（只与这两个有关）;只要最大的比次大的两倍还要大，就满足这个条件
    public static Integer findMax(Integer[] arr){

        Integer maxFirst = Integer.MIN_VALUE;
        Integer maxSecond = Integer.MIN_VALUE;

        for (int i=0;i<arr.length;i++){
            if (arr[i]>maxFirst){
                maxSecond = maxFirst;
                maxFirst = arr[i];
            }else if (arr[i]>maxSecond){
                maxSecond = arr[i];
            }
        }

        if (maxFirst>maxSecond*2){
            return maxFirst;
        }else {
            return null;
        }
    }


    public static void main(String[] args) {

        Integer[] nums = {9,34,2,5,3,6,7,36,73,4,16,8};
        System.out.println(findMax(nums));
    }

}