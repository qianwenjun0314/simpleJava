/**
 * Copyright (C), 2015-2019
 * FileName: Exam_find
 * Author:   qianwenjun
 * Date:     2019/3/17 14:12
 * Description:
 */
package com.qwj.algorithm;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/17
 * @since 1.0.0
 */
public class Exam_find {

    //二分查找-非递归
    public static int findNum(Integer[] arr,Integer n){

        int len = arr.length;

        int start = 0;
        int end = len-1;

        while (start<=end){
            int mid = (start+end)/2;
            if (arr[mid]==n){
                return mid;
            }else if (arr[mid]>n){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return start;

    }





    public static void main(String[] args) {
        Integer[] nums = {1,2,4,7,9,13,24,67,89,100};

        System.out.println(findNum(nums,3));
    }

}