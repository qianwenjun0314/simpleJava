package socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {

	String[] adviceList = {"one","two","three","four","five","six"};
	//客户端->服务端
    //Socket流写入数据的过程：Socket-PrintWriter(sock.getOutputStream)-writer.println(meesage)（使用socket流送出信息）
	public void go(){
		
		try {
			// 创建ServerSocket监听这个端口的所有要求
			ServerSocket serversock = new ServerSocket(5000);
			while(true){
				//接收某个客户端的这个端口的请求
				Socket sock = serversock.accept();
				//使用printwriter将接收的socket流转换成字符流输出
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				//获取client的内容
				String advice = getAdvice();
				writer.println(advice);
				writer.close();				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private String getAdvice(){
		int random = (int)(Math.random()*(adviceList.length));
		return adviceList[random];
	}
	
	public static void main(String[] args){
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	}
}
