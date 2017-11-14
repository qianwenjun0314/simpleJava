package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameSaveTest {

	public static void main(String[] args){
		GameCharacter one = new GameCharacter(10,"one",new String[] {"one","two","three"});
		GameCharacter four = new GameCharacter(40,"four",new String[] {"four","five","six"});
		GameCharacter seven = new GameCharacter(70,"seven",new String[] {"seven","eoght","nine"});
		
		//解序列化
		//1、创建序列化文件引入流对象，并将存在文件作为参数，2、创建对象引入流对象，并链接序列化文件引入流
		//3、将对象引入流对象读出，顺序读出，4、将读出object类型对象，强转成我们需要的对象类型
		
		//先序列化保存
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("game.ser"));
			oos.writeObject(one);
			oos.writeObject(four);
			oos.writeObject(seven);
			
			System.out.println("输出序列化文件");
			System.out.println(oos);
			oos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		//设定为null，则无法存取堆上的这些对象，只能重新创建
		one = null;
		four = null;
		seven = null;
		
		try{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("game.ser"));
			GameCharacter oneReader = (GameCharacter)is.readObject();
			GameCharacter fourReader = (GameCharacter)is.readObject();
			GameCharacter sevenReader = (GameCharacter)is.readObject();
			
			System.out.println("读取序列化文件");
			System.out.println(is);

			System.out.println("one's type is "+ oneReader.getType());
			System.out.println("four's type is "+ fourReader.getType());
			System.out.println("seven's type is "+ sevenReader.getType());

		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
