package com.qwj.study.socket;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleChatClientA {

	Socket sock;
	PrintWriter writer;
	JTextField outgoing;
	
	public void go(){
		JFrame frame = new JFrame("Simple chat client");
		JPanel mainpanel = new JPanel();
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("send");
		
		sendButton.addActionListener(new SendMessageListener());
		mainpanel.add(outgoing);
		mainpanel.add(sendButton);
		frame.getContentPane().add(BorderLayout.CENTER,mainpanel);
		
		//初始化setUpNetworking
		setUpWorking();
		
		frame.setSize(300, 300);
		frame.setVisible(true);				
	}
	
	//建立socket和printWriter实例变量
	public void setUpWorking(){
		try {
			Socket sock = new Socket("127.0.0.1",5000);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("networking established");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public class SendMessageListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			try{
				writer.println(outgoing.getText());
				writer.flush();
			}catch(Exception e){
				e.printStackTrace();
			}
			outgoing.setText("ok");
			outgoing.requestFocus();
		}
	}
	
	public static void main(String[] args){
		SimpleChatClientA simpleclient = new SimpleChatClientA();
		simpleclient.go();
	}
	
	
}
