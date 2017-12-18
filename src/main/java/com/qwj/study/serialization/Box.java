package com.qwj.study.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Box implements Serializable {

	private int height;
	private int width;
	
	//当某个实例变量不能或不应该被序列化的时候，就标记为transient
	transient int currentId;
	
	public static void main(String[] args){
		//将对象序列化后输出
		//1、创建对象，2、创建文件输出流，3、创建对象输出流，并链接文件输出流，4、将对象写入对象输出流中
		Box mybox = new Box();
		mybox.setHeight(11);
		mybox.setWidth(2);
		
		
		try {
			System.out.println("start test --qianwenjun");

			FileOutputStream fos = new FileOutputStream("box.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(mybox);
			oos.close();
			System.out.println("end test --qianwenjun");

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
}
