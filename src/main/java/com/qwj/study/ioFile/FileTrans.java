package com.qwj.study.ioFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class FileTrans {
	
//	private File file ;
	private void saveFile(){

		//将文本写入
		//1、新建FileWriter，2、新建BufferedWriter,并链接到FileWriter，3、将字符串写入BufferedWriter,注意分隔符
		//“／”表示分隔一条条数据，到时候可以依据这个符号用split做切割 “\n”表示换行
		try {
			File file = new File("song.txt");
			FileWriter myfilew = new FileWriter(file);
			BufferedWriter filewriter = new BufferedWriter(myfilew);

			filewriter.write("taotai"+"/");
			filewriter.write("eson"+"/");
			filewriter.write("good"+"/");
			filewriter.write("six minutem"+"\n");
			
			filewriter.write("daohuaxiang"+"/");
			filewriter.write("jay"+"/");
			filewriter.write("simple"+"/");
			filewriter.write("five minutem"+"\n");

			filewriter.write("niaideren"+"/");
			filewriter.write("chunchun"+"/");
			filewriter.write("great"+"/");
			filewriter.write("four minutem"+"\n");

			filewriter.write("hongmeigui"+"/");
			filewriter.write("eson"+"/");
			filewriter.write("great"+"/");
			filewriter.write("four minutem"+"\n");

			filewriter.write("shinian"+"/");
			filewriter.write("eson"+"/");
			filewriter.write("great"+"/");
			filewriter.write("four minutem"+"\n");

			filewriter.write("shuangjiegun"+"/");
			filewriter.write("jay"+"/");
			filewriter.write("simple"+"/");
			filewriter.write("five minutem"+"\n");

			filewriter.write("shuangjiegun"+"/");
			filewriter.write("jay"+"/");
			filewriter.write("simple"+"/");
			filewriter.write("five minutem"+"\n");

			filewriter.write("shuangjiegun1"+"/");
			filewriter.write("jay"+"/");
			filewriter.write("simple"+"/");
			filewriter.write("five minutem"+"\n");

			filewriter.write("shuangjiegun"+"/");
			filewriter.write("jay1"+"/");
			filewriter.write("simple"+"/");
			filewriter.write("five minutem"+"\n");


			
			filewriter.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String[] args) {
		try {
			// 读取文件内容
			//1、创建file，文件路径，2、创建filereader，读取文件，3、创建bufferreader，缓存读取内容
//			File file1 = new File("file1.txt");
			
			//创建file，指的是创建一个fiel对象，指向fiel.txt文件（此文件必须存在）
			File file = new File("song.txt");
			System.out.println(file);
			FileTrans filetrans = new FileTrans();
			filetrans.saveFile();
			FileReader myfiler = new  FileReader(file);
			BufferedReader reader = new BufferedReader(myfiler);
			
			String line = null;
			while((line = reader.readLine()) != null){
//				System.out.println(line);
				String[] card = line.split("/");
				System.out.println(card[0]);
				System.out.println(card[1]+"\n");
			}
			reader.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
