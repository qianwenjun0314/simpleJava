/**
 * Copyright (C), 2015-2019
 * FileName: Exam_link
 * Author:   qianwenjun
 * Date:     2019/3/18 12:48
 * Description:
 */
package com.qwj.algorithm;

import org.apache.poi.ss.formula.functions.T;

import java.util.LinkedList;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/18
 * @since 1.0.0
 */
public class Exam_link {

    //判断单链表是否存在环
    public static Boolean isLoopList(ListNode head){

        ListNode fastPointer;
        ListNode slowPointer;

        fastPointer = head;
        slowPointer = head;

        while (fastPointer != null&& fastPointer.next!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer==fastPointer){
                return true;
            }
        }
        return false;

    }


    //判断链接中是否有中间节点


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode node = head.next;

        int i=3;
        while (i<10){
            node.next = new ListNode(i);
            node = node.next;
        }
        node.next = new ListNode(5);

        System.out.println(isLoopList(head));


    }


}