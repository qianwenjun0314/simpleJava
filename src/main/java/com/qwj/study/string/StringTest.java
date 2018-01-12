/**
 * Copyright (C), 2015-2018
 * FileName: StringTest
 * Author:   qianwenjun
 * Date:     2018/1/12 17:34
 * Description:
 */
package com.qwj.study.string;

import java.util.Random;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2018/1/12
 * @since 1.0.0
 */
public class StringTest {


    //字符串内容不能改变，每次变化表示的是新建一个string，将新的string引用指向原来的变量
    //有锁，多线程高并发可以使用，均继承的是AbstractStringBuilder父类
    //无锁，单线程使用，效率会更高，均继承的是AbstractStringBuilder父类
    String str = new String();
    StringBuffer strBuffer = new StringBuffer();
    StringBuilder strBuilder = new StringBuilder();


    static final int MAX = 100000;
    static final String[] arr = new String[MAX];


    //使用intern()
    //1、减少了string对象的创建
    //2、创建string对象，增加了intern的使用耗时，但是这个耗时对于更多对象导致内存过多需要gc的耗时可忽略
    public static void main(String[] args) {

//        String s1 = new StringBuilder("go") .append("od").toString();
//        System.out.println(s1.intern() == s1);

        //为长度为10的Integer数组随机赋值
        Integer[] sample = new Integer[10];
        Random random = new Random(1000);
        for (int i = 0; i < sample.length; i++) {
            sample[i] = random.nextInt();
        }
        //记录程序开始时间
        long t = System.currentTimeMillis();
        //使用/不使用intern方法为10万个String赋值，值来自于Integer数组的10个数
        for (int i = 0; i < MAX; i++) {
//            arr[i] = new String(String.valueOf(sample[i % sample.length]));
            arr[i] = new String(String.valueOf(sample[i % sample.length])).intern();
        }
        System.out.println((System.currentTimeMillis() - t) + "ms");
        System.gc();
    }
}