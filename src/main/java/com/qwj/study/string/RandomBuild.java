/**
 * Copyright (C), 2015-2018
 * FileName: RandomBuild
 * Author:   qianwenjun
 * Date:     2018/8/26 17:02
 * Description:
 */
package com.qwj.study.string;

import java.util.Random;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2018/8/26
 * @since 1.0.0
 */
public class RandomBuild {


    public static void main(String[] args) {

        StringBuffer str1 = new StringBuffer("新用户");
        Integer time = 10;
        for (int i=1;i<time;i++){
            System.out.println("第一种写法="+str1.append(i));

        }

        String prex = "新用户";
        for (int i=1;i<time;i++){
            StringBuffer str2 = new StringBuffer(prex);
            System.out.println("第二种写法="+str2.append(i));
        }

        for (int i=1;i<time;i++){
            String str3 = "新用户"+i;
            System.out.println("第三种写法="+str3);

        }

//        Random ram = new Random(99999);
        for (int i=1;i<time;i++){
            Random ram = new Random(99999);
            String str3 = "新用户"+ram.nextInt(9999999);
            System.out.println("第四种写法="+str3);

        }


    }


}