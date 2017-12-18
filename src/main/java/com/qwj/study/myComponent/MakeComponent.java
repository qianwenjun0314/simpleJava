package com.qwj.study.myComponent;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class MakeComponent {

	public void paintComponent(Graphics g){
		
		Image image = new ImageIcon("haha.jpg").getImage();
//		g.drawImage(image, 3, 4, this);
	}
}
