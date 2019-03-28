/**
 * Copyright (C), 2015-2019
 * FileName: Exam_sort
 * Author:   qianwenjun
 * Date:     2019/3/17 08:42
 * Description:
 */
package com.qwj.algorithm;

import java.util.*;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/17
 * @since 1.0.0
 */
public class Exam_sort {

    //整数数组，截图一个子数组，要求和最大
    //冒泡排序，比较相邻的两个数，有需要的情况交换位置
    //快速排序
    //归并排序



    //冒泡排序
    public static Integer[] bubbleSort(Integer[] arr){

        Integer tem ;

        int len = arr.length;

        for (int i=0;i<len;i++){
            for (int j=i;j>0;j--){
                if (arr[j]<arr[j-1]){
                    tem = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tem;
                }
            }
        }
        return arr;
    }

    //快速排序
    public static Integer[] quickSort2(Integer[] arr,int start,int end){
        if (start>=end){
            return arr;
        }
        Integer key = arr[start];
        int i = start;
        int j = end;
        while (i<j){
            //从左向右，找到第一个比key大的值，此时i=这个位置的索引+1
            while (i<j&&arr[i]<=key){
                i++;
            }
            //从右向左，找到第一个比key小的值，此时j=这个位置索引-1
            while (i<j&&arr[j]>key){
                j--;
            }
            System.out.println("i的值为："+i);
            System.out.println("j的值为："+j);
            if (i<j){
                swap(arr,i,j);
            }
        }
        printArr(arr);
        System.out.println("i的值为："+i);
        System.out.println("j的值为："+j);

        //此时i=j，把最开始和i前面一位进行换。
        swap(arr,start,i-1);
        System.out.println("交换指定位置后");
        printArr(arr);

        //再进行左边的数组和右边的数据进行排序。
        quickSort2(arr,start,i-1);
        quickSort2(arr,i,end);

        return arr;

    }

    //jdk中的sort排序方法
    public static Integer[] jdkSort(Integer[] arr){
        Arrays.sort(arr);
        return arr;

    }


    public static void swap(Integer[] arr,int i,int j){
        Integer temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }




    public static void printArr(Integer[] arr){
        for (Integer n:arr){
            System.out.print(n+"  ");
        }
        System.out.println('\n');
    }

    public static void main(String[] args) {
        Integer[] nums = {9,34,2,5,3,6,7,36,65,4,16,8};

//        Integer[] arr = bubbleSort(nums);
        Integer[] arr = quickSort2(nums,0,11);

        printArr(arr);
    }
}