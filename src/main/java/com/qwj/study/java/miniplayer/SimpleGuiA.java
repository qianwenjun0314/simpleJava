package com.qwj.study.java.miniplayer;

import javax.swing.*;

public class SimpleGuiA {

	public static void main(String [] args){
		//创建frame和widget(button),widget:一些小装置
		JFrame frame = new JFrame();
		JButton button = new JButton("click me");
		
		//程序会在windows关闭的时候吧程序结束掉
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//把widget(button)加载到frame的pane上
		frame.getContentPane().add(button);
		
		//设置frame的大小
		frame.setSize(300, 300);
		
		//显示frame
		frame.setVisible(true);
		
	}
}
