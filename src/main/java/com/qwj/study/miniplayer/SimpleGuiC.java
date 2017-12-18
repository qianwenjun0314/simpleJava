package com.qwj.study.miniplayer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.qwj.study.myComponent.MyDrawPanel;

public class SimpleGuiC implements ActionListener{

	JFrame frame = new JFrame();
	JButton button = new JButton("change color");
	JButton button2 = new JButton("change color");

	
	public static void main(String[] args){
		SimpleGuiC gui = new SimpleGuiC();
		gui.go();
	}
	
	public void go(){

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button.addActionListener(this);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		
//		MyDrawPanel drawPanel = new MyDrawPanel();		
//		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		
		frame.setSize(300, 300);
		frame.setVisible(true);

	}
	
	public void actionPerformed(ActionEvent e){
		
//		button.setText("I've click this button");
		System.out.println("start test --qianwenjun");
		
		MyDrawPanel drawPanel = new MyDrawPanel();
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		
		System.out.println("middle test --qianwenjun");
		frame.repaint();
		
		System.out.println("end test --qianwenjun");

	}
}
