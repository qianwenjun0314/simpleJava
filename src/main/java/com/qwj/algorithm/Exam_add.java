/**
 * Copyright (C), 2015-2019
 * FileName: Exam_add
 * Author:   qianwenjun
 * Date:     2019/3/17 18:59
 * Description:
 */
package com.qwj.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/17
 * @since 1.0.0
 */
public class Exam_add {

    //数组里，是否有任意两个数的合为指定的值
    public static Integer findNum(Integer[] arr,Integer sum){
        Map<Integer,Object> arrMap = new HashMap<Integer, Object>();
        for (Integer n:arr){
            arrMap.put(n,true);
        }

        for (int i=0;i<arr.length;i++){
            int tem = sum-arr[i];
            if (arrMap.containsKey(tem)){
               return tem;
            }
        }
        return null;
    }


    public static Integer findNum2(Integer[] arr,Integer sum){
        int len = arr.length;
        for (int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                if (i==j){
                    continue;
                }else if (arr[i]+arr[j]==sum){
                    return arr[j];
                }
            }
        }
        return null;
    }


    //判断一个数是否为素数
    public static Boolean isSu(Integer num){

        for(int i=2;i<Math.sqrt(num);i++){
            if ((num%i)==0){
                return false;
            }
        }
        return true;
    }

    //判断值是否是3的n次方的形式，1*3*3*3，所以先对3取余，若等于0，继续处于3循环，若取余不等于0，判断是否等于1，否则不是3的n次方
    public static Boolean isPowOfThree(Integer num){

        while ((num!=0)&&(num%3==0)){
            num = num/3;
        }
        if (num==1){
            return true;
        }else {
            return false;
        }
    }


    //判断x是否可以由a*a+b*b的形式。循环的次数为sqrt(x)
    public static Integer[] isForm(Integer num){
        for (int i=1;i<Math.sqrt(num);i++){
            for (int j=1;j<Math.sqrt(num);j++){
                if (i*i+j*j==num){
                    Integer[] res = {i,j};
                    return res;
                }
            }
        }

        return null;
    }


    public static Integer[] isForm2(Integer num){
        for (int i=0;i<Math.sqrt(num);i++){
            int tem = (int)Math.sqrt(num-i*i);
            if (tem*tem==num-i*i){
                Integer[] res = {i,tem};
                return res;
            }
        }
        return null;
    }

    public static void printArr(Integer[] arr){
        for (Integer n:arr){
            System.out.print(n+"  ");
        }
        System.out.println('\n');
    }
    public static void main(String[] args) {
        Integer[] nums = {9,34,2,5,3,6,7,36,65,4,16,8};

        System.out.println(findNum(nums,101));
        System.out.println(findNum2(nums,101));

        System.out.println(isSu(7));
        System.out.println(isPowOfThree(28));

        System.out.println();
        printArr(isForm(50));

        printArr(isForm2(49));


    }

}