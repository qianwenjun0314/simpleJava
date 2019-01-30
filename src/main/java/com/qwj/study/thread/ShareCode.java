/**
 * Copyright (C), 2015-2019
 * FileName: ShareCode
 * Author:   qianwenjun
 * Date:     2019/1/11 18:13
 * Description:
 */
package com.qwj.study.thread;

import java.math.BigInteger;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/1/11
 * @since 1.0.0
 */
public class ShareCode {


    public static void main(String[] args) {
//        String newEncryptCid = encryptCid.substring(1, encryptCid.length());
//        long reInt = Long.parseLong(new BigInteger(newEncryptCid, 36).toString(10));
//        reInt = (reInt - 56L) / 2L;
//        return reInt > 0L ? reInt : 0L;

        for(int i=1;i<10;i++){
            for (int j=1;j<10;j++){
                if (i>j){
                    System.out.print(i+"*"+j+"="+i*j+"\t");
                }else if(i==j) {
                    System.out.println(i+"*"+j+"="+i*j);
                }else {
                    continue;
                }
            }
        }

    }



}