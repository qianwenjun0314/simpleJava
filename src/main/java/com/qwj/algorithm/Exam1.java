/**
 * Copyright (C), 2015-2019
 * FileName: Exam1
 * Author:   qianwenjun
 * Date:     2019/3/16 21:20
 * Description:
 */
package com.qwj.algorithm;

import groovy.json.internal.Chr;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/16
 * @since 1.0.0
 */
public class Exam1 {


    //数组比较，求最小值
    public static Integer getMinNum(Integer[] arr){

        Integer min = arr[0];
        for (int i=1;i<arr.length;i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }


    //数组比较，求第3个最小值
    public static Integer get3thMinNum(Integer[] arr){

        //若是判断最大，赋值null；
        Integer firstMin = Integer.MAX_VALUE;
        Integer secondMin = Integer.MAX_VALUE;
        Integer thirdMin = Integer.MAX_VALUE;

        for (Integer n:arr){
            if (n.equals(firstMin)||n.equals(secondMin)||n.equals(thirdMin)){
                continue;
            }else if (n<firstMin){
                thirdMin = secondMin;
                secondMin = firstMin;
                firstMin = n;
            }else if (n<secondMin){
                thirdMin = secondMin;
                secondMin = n;
            }else if (n<thirdMin){
                thirdMin = n;
            }
        }

        return thirdMin;

    }

    //第k个最小值
    public static Integer getKthMinNum(Integer[] nums,int k){

//        int k=3;
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0;i<k;i++){
            list.add(Integer.MAX_VALUE);
        }
        System.out.println(list);
        for (Integer n:nums){
            for (int i=0;i<list.size();i++){
                if (n<list.get(i)){
                    list.add(i,n);
                    break;
                }

            }
        }
        System.out.println(list);

        //转set为什么顺序乱掉，hashSet没有顺序
        Set<Integer> hashSet = new HashSet<Integer>();
        for (Integer n:list){
            hashSet.add(n);
        }
        System.out.println(hashSet);

        Set<Integer> treeSet = new TreeSet<Integer>();
        for (Integer n:list){
            treeSet.add(n);
        }
        System.out.println(treeSet);

        return (Integer)treeSet.toArray()[k-1];
    }



    //反转数字
    public static Integer reverseNum(Integer num){
        Integer result = num%10;
        while (num>0){
            if ((num/10)==0){
                break;
            }
            result = result*10+(num/10)%10;
            num = num/10;
        }
        return result;

    }


    public static Integer reverseNum2(Integer num){
        StringBuilder str = new StringBuilder(String.valueOf(num));
        Integer res = Integer.valueOf(str.reverse().toString());
        System.out.println(res);
        return res;


    }

    //反转字符串
    public static String reseveStr(String str){

        char[] chars = str.toCharArray();
        char[] chars1 = new char[chars.length];
        int j=0;
        for (int i=chars.length;i>0;i--){
            chars1[j] = chars[i-1];
            j++;
        }
        //return chars.toString();错误写法
//        return new String(chars1);

        String str1 = new String();
        str1 = String.valueOf(chars1);
        return str1;
    }


    //判断是否是回文
    public static Boolean huiwen(String str){

        char[] chars = str.toCharArray();

        if (chars==null||chars.length==0){
            return false;
        }else {
            int i=0;
            int j=chars.length-1;

            while (i<j){
                if (chars[i]!=chars[j]){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    //判断一个数字是否是回文
    public static Boolean huiwenNum(Integer num){

        String temp = String.valueOf(num);

//        String sb = new String(temp);

        StringBuffer sb = new StringBuffer(temp);

        Boolean equals = sb.reverse().toString().equals(temp);
        if (equals){
            System.out.println("是回文");
        }else {
            System.out.println("不是回文");
        }
        return equals;

    }


    //字符串倒转，以空格为间隔，倒转一句字符串内容
    public static String reveseStrBySpace(String str){
        String[] strArr = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i=strArr.length-1;i>=0;i--){
            if (i==0){
                sb.append(strArr[i]);
            }else {
                sb.append(strArr[i]);
                sb.append(" ");
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {

        Integer[] arr = {100,3,4,7,3,7,8,9,10};
        System.out.println(getMinNum(arr));
        System.out.println(get3thMinNum(arr));
        System.out.println(getKthMinNum(arr,3));

        Integer num = 36472628;
        System.out.println(reverseNum(num));
        System.out.println("第二种方法"+reverseNum2(num));

        String str = "shwyeurioxbcn";
        System.out.println(reseveStr(str));


        String str1 = "123676321";
        String str2 = "123678321";
        System.out.println(huiwen(str1));
        System.out.println(huiwen(str2));


        String str3 = "I am a girl";
        System.out.println(reveseStrBySpace(str3));



    }
}