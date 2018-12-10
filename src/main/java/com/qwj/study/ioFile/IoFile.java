/**
 * Copyright (C), 2015-2018
 * FileName: IoFile
 * Author:   qianwenjun
 * Date:     2018/8/7 15:47
 * Description:
 */
package com.qwj.study.ioFile;


import java.io.*;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2018/8/7
 * @since 1.0.0
 */
public class IoFile {



    public void writeData(String card) {

        try{
            File file = new File("/Users/qianwenjun/testWriteData.csv");
            if (!file.exists())
            {
                file.createNewFile();
            }
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "UTF-8"));
            String str="";
            boolean isExist=false;
            while ((str=bufferedReader.readLine())!=null)
            {
                if (str.trim().equals(card))
                {
                    isExist=true;
                    break;
                }
            }
            bufferedReader.close();
            if (!isExist)
            {
                FileOutputStream fos = new FileOutputStream(file.getAbsoluteFile(),true);//true表示在文件末尾追加
                fos.write(card.getBytes());
                fos.write("\n".getBytes());
                fos.close();
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String[] cardArray={"1","2","3","4","5"} ;
        for(String card:cardArray){

            IoFile ioFile = new IoFile();
            ioFile.writeData(card);
        }
    }



}