package com.qwj.study.myComponent;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MyDrawPanel extends JPanel {

	//这个方法时由系统调用的，绝不是自己调用！！！
	//这个方法的参数graphics对象是跟屏幕相关的对象，我们无法自己取得对象，需由系统传递
	//我们可以调用repaint()方法要求系统重新绘制图案，让系统重新调用paintComponent()方法
	@Override
	public void paintComponent(Graphics g){
		//图一，白底黄色小正方形
//		g.setColor(Color.yellow);//设置颜色
//		g.fillRect(20, 50, 100, 100);//设置形状大小，前两个参数时起点的坐标，后面两个参数分别时宽度和高度
//		
		//图二，默认底和圆形按钮
//		g.fillRect(0, 0, this.getHeight(), this.getWidth());
//		
//		int red = (int)(Math.random()*255);
//		int yellow = (int)(Math.random()*255);
//		int green = (int)(Math.random()*255);
//		
//		Color randomColor = new Color(red,yellow,green);
//		g.fillOval(70, 70, 100, 100);
		
		//图三，2d图形
		Graphics2D g2d = (Graphics2D) g;
		//前三个参数；起点位置和颜色；后三个参数：终点位置和颜色
		GradientPaint gradient = new GradientPaint(70,70,Color.blue,150,150,Color.orange);
		g2d.setPaint(gradient);
		g2d.fillOval(70, 70, 100, 100);
		
		
	}
}
