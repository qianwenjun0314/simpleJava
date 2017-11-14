package socket;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class SimpleChatClient {

	Socket sock;
	PrintWriter writer;
	BufferedReader reader;
	JTextField outgoing;
	JTextArea incoming;
		
	public void go(){
		JFrame frame = new JFrame("Simple chat client");
		JPanel mainpanel = new JPanel();
		
		//设置输入框
		outgoing = new JTextField(20);
		//设置按钮
		JButton sendButton = new JButton("send");
		sendButton.addActionListener(new SendMessageListener());
		//设置显示框
		incoming = new JTextArea(15,20);
		incoming.setText("接收服务端信息"+"\n");
		incoming.setLineWrap(true);
		incoming.setWrapStyleWord(true);
		incoming.setEditable(false);
		JScrollPane qScroller = new JScrollPane(incoming);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		mainpanel.add(qScroller);
		mainpanel.add(outgoing);
		mainpanel.add(sendButton);
		

		//初始化setUpNetworking
		setUpWorking();
		
		Thread readerThread = new Thread(new IncomingReader());
		readerThread.start();
		
		frame.getContentPane().add(BorderLayout.CENTER,mainpanel);		
		frame.setSize(300, 350);
		frame.setVisible(true);				
	}
	
	//建立socket和printWriter实例变量
	public void setUpWorking(){
		try {
			Socket sock = new Socket("127.0.0.1",5000);
			writer = new PrintWriter(sock.getOutputStream());
			
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(streamReader);
			
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
	
	public class IncomingReader implements Runnable{
		public void run(){
			String line = null;
			try {
				while((line = reader.readLine()) != null){
				System.out.println("read " + line);
				incoming.append(line + "\n");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		SimpleChatClient simpleclient = new SimpleChatClient();
		simpleclient.go();
	}
	
	
}

