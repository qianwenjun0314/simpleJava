package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceClient {

	//服务端->客户端
    //Socket流读取数据的过程：Socket-InputStreamReader(sock.getInputStream)-BufferedReader(stream)-readLine
	public void go(){
		try{
			//创建socket，需要：ip+port
			Socket s = new Socket("112.90.154.3",80);
			
			//s.getInputStream()--socket的字节流，利用InputStreamReader转换成字符流
			InputStreamReader streamreader = new InputStreamReader(s.getInputStream());
			//链接BufferedReader
			BufferedReader reader = new BufferedReader(streamreader);
			
			String line = null;
			while((line = reader.readLine()) != null){
				line = reader.readLine();
				System.out.println("my advice is "+ line);
			}
			reader.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args){
		//创建client，并执行go()
		DailyAdviceClient myclient = new DailyAdviceClient();
		myclient.go();
	}
}
