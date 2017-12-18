package com.qwj.study.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

//服务端接收客户端消息，并传送出来
public class SimpleChatServer {

	ArrayList clientOutputStream;

	public static void main (String[] args) {

		SimpleChatServer server = new SimpleChatServer();
		server.go();
	}

	public class ClientHandler implements Runnable {

		BufferedReader reader;
		Socket sock;

		public ClientHandler (Socket clientSock) {
			try {
				sock = clientSock;
				InputStreamReader sockReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(sockReader);
				System.out.println("creat thread job---缓存读取客户端发送的信息");


			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void run () {
			try {
				System.out.println("start running thread job--服务端将信息告诉给每一个客户端");

				String message = null;
				while((message = reader.readLine()) != null) {
					System.out.println("start  read " + message);
					tellEveryone(message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public void go () {
		clientOutputStream = new ArrayList();
		try {
			ServerSocket serverSock = new ServerSocket(5000);
			System.out.println("start connect serversock");

			Socket clientSock = serverSock.accept();
			PrintWriter serverWriter = new PrintWriter(clientSock.getOutputStream());
			clientOutputStream.add(serverWriter);
			System.out.println("接收到的客户端信息" + clientOutputStream);

			Thread t = new Thread(new ClientHandler(clientSock));
			System.out.println("creat thread,and starting");
			t.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void tellEveryone(String message) {
		Iterator it = clientOutputStream.iterator();
		while(it.hasNext()) {
			PrintWriter writer = (PrintWriter) it.next();
			writer.println(message);
			writer.flush();
		}
	}
}
