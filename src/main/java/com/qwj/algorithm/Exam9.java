/**
 * Copyright (C), 2015-2019
 * FileName: Exam9
 * Author:   qianwenjun
 * Date:     2019/3/19 21:12
 * Description:
 */
package com.qwj.algorithm;

import com.qwj.CommonUtils.ArrayPrint;
import org.apache.commons.lang.StringUtils;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/19
 * @since 1.0.0
 */
public class Exam9 {

    //https://leetcode.com/problems/add-strings/
    //415 两个大字符串数字之和----(字符串假如都是数字，不包含特殊符号或字母)
    //在平常的业务中也许会有很大的数字无法使用int或者long来存储了，
    // 那么只能存储成string类型，当需要两个这样的数字相加的时候，怎么办呢？
    //1、位数较小的补全；2、定义长度n+1的数组，每位换成整数依次相加放入数组；3、放入规则，%10余数放低位，/10高位放前一位
    public static String addStr(String num1,String num2){

        int a = num1.length();
        int b = num2.length();

        if (a>b){
            num2 = StringUtils.leftPad(num2,a,"0");
        }else {
            num1 = StringUtils.leftPad(num1,b,"0");
        }

        int len = num1.length();
        System.out.println("num1="+num1);
        System.out.println("num2="+num2);

        System.out.println("len="+len);
        Integer[] num3 = new Integer[len+1];
        num3[len]=0;
        for (int i=len-1;i>=0;i--){
            int m1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
            int m2 = Integer.parseInt(String.valueOf(num2.charAt(i)));

            int m3 = num3[i+1];

            int temp = m1+m2+m3;
            num3[i+1] = temp%10;
            num3[i] = temp/10;
        }

        ArrayPrint.printArr(num3);
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<num3.length;i++){
            if(i==0&&num3[i]==0){continue;}
            sb.append(num3[i]);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String num1 = "789";
        String num2 = "5463";
        System.out.println(addStr(num1,num2));
    }

}