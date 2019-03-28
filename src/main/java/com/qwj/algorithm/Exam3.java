/**
 * Copyright (C), 2015-2019
 * FileName: Exam3
 * Author:   qianwenjun
 * Date:     2019/3/18 21:04
 * Description:
 */
package com.qwj.algorithm;

import com.qwj.CommonUtils.ArrayPrint;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/18
 * @since 1.0.0
 */
public class Exam3 {


    //https://leetcode.com/problems/single-number/description/
    //136 给定一个整数数组，其中除了一个元素出现一次，其余都出现两次，找出这个元素
    //循环遍历做异或操作
    public static Integer findOnce(Integer[] arr){
        Integer len = arr.length;
        Integer res = 0;
        for (int i=0;i<len;i++){
            res ^=arr[i];
            System.out.println("arr[i]="+arr[i]+",res="+res);

        }
        return res;
    }


    //众数的，就是说，有一个数它出现的次数大于一半
    //https://leetcode.com/problems/majority-element/description/
    //169 给定一个大小为n的数组，有个元素出现次数不小于n/2，找出这个元素.即是众数
    //维持一个节点坑位major和相应的数目统计count
    //* 如果发现相同节点就累加count，否则就递减count
    //* 最终遍历完成获取到的major即是
    public static Integer findZongshu(Integer[] arrs){

        Integer count = 0;
        Integer num = arrs[0];
        for (int i=0;i<arrs.length;i++){
            if (num==arrs[i]){
                count++;
            }else {
                count--;
                if (count==0){
                    num = arrs[i];
                }
            }
        }

        return num;
    }

    //数组的循环右移
    //解法一：普通移动
    public static Integer[] rightMove(Integer[] arr,int n){

        Integer[] res = new Integer[arr.length];
        int k=0;
        int start = arr.length-n;
        for (int i=start;i<arr.length;i++){
            res[k++] = arr[i];
        }
        for (int i=0;i<start;i++){
            res[k++] = arr[i];
        }
        return res;
    }
    //解法二：三次逆转
    //重定义指定位置的数组进行反转
    public static Integer[] resThree(Integer[] arr,int n){
        reverse(arr,0,arr.length-1);
        ArrayPrint.printArr(arr);
        reverse(arr,0,n-1);
        ArrayPrint.printArr(arr);
        reverse(arr,n,arr.length-1);
        ArrayPrint.printArr(arr);
        return arr;
    }

    public static void reverse(Integer[] arr,int start,int end){

        while (start<end){
            Integer temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
//        Integer[] nums = {1,3,3,4,4,7,9,5,1,5,9};
//        System.out.println(findOnce(nums));

        Integer[] arr = {5,6,7,8,1,2,3,4};
//        ArrayPrint.printArr(rightMove(arr,3));
        resThree(arr,3);
    }

}