/**
 * Copyright (C), 2015-2019
 * FileName: MyMockTest
 * Author:   qianwenjun
 * Date:     2019/3/18 10:42
 * Description:
 */
package com.qwj.mockiter;

import org.mockito.InOrder;
import org.mockito.verification.VerificationMode;

import java.util.LinkedList;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/18
 * @since 1.0.0
 */
public class MyMockTest {


    public static void main(String[] args) {


        LinkedList<String> mocklist = mock(LinkedList.class);
        System.out.println(mocklist.get(0));

        //模拟获取第一个元素时，返回字符串first。  给特定的方法调用返回固定值在官方说法中称为stub。
        when(mocklist.get(0)).thenReturn("first");
        System.out.println(mocklist.get(0));

        when(mocklist.get(1)).thenThrow(new RuntimeException());
//        System.out.println(mocklist.get(1));


        when(mocklist.get(anyInt())).thenReturn("任意参数匹配返回");
        System.out.println(mocklist.get(5));
        System.out.println(verify(mocklist).get(5));


        //校验方法调用次数
        mocklist.add("1");
        verify(mocklist).add("1");
        System.out.println(verify(mocklist).add("1"));
        verify(mocklist,times(1)).add("1");
        System.out.println(verify(mocklist,times(1)).add("1"));


        //校验方法调用顺序
        mocklist.get(7);
        mocklist.get(8);

        InOrder inOrder = inOrder(mocklist);
        inOrder.verify(mocklist).get(7);
        inOrder.verify(mocklist).get(8);

        //校验方法从未调用过
        verify(mocklist,never()).get(10);

    }

}