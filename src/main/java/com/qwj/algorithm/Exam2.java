/**
 * Copyright (C), 2015-2019
 * FileName: Exam2
 * Author:   qianwenjun
 * Date:     2019/3/18 19:43
 * Description:
 */
package com.qwj.algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/18
 * @since 1.0.0
 */
public class Exam2 {

    //https://leetcode.com/problems/maximum-subarray/description/
    //53 给一个整数数组，查找一个具有最大和的子数组并返回这个最大和
    //数组有正数和负数
    public static Integer findMaxSum(Integer[] arr){

        int maxSum = arr[0];
        int temMaxSum = arr[0];

        for (int i=1;i<arr.length;i++){

            temMaxSum = Math.max(temMaxSum+arr[i],arr[i]);
            maxSum = Math.max(temMaxSum,maxSum);
            System.out.println("i="+i);
            System.out.println("temMaxSum="+temMaxSum+",maxSum="+maxSum);
        }

        return maxSum;
    }



    //合并两个已排序的数组
    public static Integer[] mergeArr(Integer[] arr1,int m,Integer[] arr2,int n){

        int i = m-1;
        int j = n-1;

        int k = m+n-1;
        Integer[] res = new Integer[m+n];
        while (i>-1&&j>-1){
            if (arr1[i]>arr2[j]){
                res[k--] = arr1[i--];

            }else {
                res[k--] = arr2[j--];
            }
        }
        printArr(res);
        if (i>-1){
            for (int a=i;a>=0;a--){
                res[k--] = arr1[a];
            }
        }
        if (j>-1){
            for (int a=j;a>=0;a--){
                res[k] = arr2[a];
            }
        }
        return res;

    }



    //查询子串在给定字符串的起始位置，并返回。如果不匹配返回-1；
    public static Integer findStart(String str,String sonStr) {

        for (int i=0; ;i++){
            for (int j=0;;j++){
                //子数组与主数组位置不相等，则break；相等则继续比较后面位置的字符是否相等
                if (sonStr.charAt(j)!=str.charAt(i+j)){break;}
                if (j==sonStr.length()){return i;}
                if (i+j == str.length()){return -1;}
            }
        }
    }




    public static void printArr(Integer[] arr){
        for (Integer n:arr){
            System.out.print(n+"  ");
        }
        System.out.println('\n');
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1,2,4,5,7,9};
        Integer[] arr2 = {3,6,8};

        Integer[] arr3 = {-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(findMaxSum(arr3));


//        printArr(mergeArr(arr1,6,arr2,3));
        Integer[] res2 = new Integer[5];
        printArr(res2);


    }



}