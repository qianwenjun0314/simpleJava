package com.qwj.study.java.miniplayer;

import java.awt.event.*;

import javax.swing.*;

//代表这SimpleGuiB就是一个ActionListener，事件只会通知有实现ActionListener的类
public class SimpleGuiB implements ActionListener {

	JButton button;
	
	public static void main(String[] args){
		
		System.out.println("start test --qianwenjun");
		SimpleGuiB gui = new SimpleGuiB();
		gui.go();
		
	}
	
	public void go(){
		JFrame frame = new JFrame();
		button = new JButton("click me");
		
		//向按钮注册监听
		button.addActionListener(this);
		
		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setVisible(true);
		
	}
	
	//ActionEvent是event对象，回头调用接口的方法时把event当作参数传进去，会把event的信息带给listener
	//ActionEvent是个携带事件数据的载体；比如程序中有多个按钮，按键处理内容一样，但是不用针对每个按键写个处理方法
	//所以当收到事件时，可以设计成通过事件对象的信息来判断时哪一个按钮发了事件
	public void actionPerformed(ActionEvent e) {
		// 实现actionlistener接口的方法---这是真正处理事件的方法
		button.setText("I've click this button");
		
		
	}
	
	

}
