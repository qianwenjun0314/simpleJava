/**
 * Copyright (C), 2015-2017
 * FileName: MyRemoteImpl
 * Author:   qianwenjun
 * Date:     2017/11/7 12:52
 * Description: 远程接口的实现类
 */
package rmi;

import javax.xml.ws.Service;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 〈一句话功能简述〉<br> 
 * 〈远程接口的实现类〉
 *
 * @author qianwenjun
 * @create 2017/11/7
 * @since 1.0.0
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{
    //继承UnicastRemoteObjec，来是impl成为远程对象，可以与远程相关的功能？？

    public String sayHello() throws RemoteException {
        return "Server says hello";
    }

    //因为继承的UnicastRemoteObject类的构造函数中抛出类RemoteException异常，所以我们处理它的唯一方式是对你的实现声明一个构造函数，抛出同样的异常
    public MyRemoteImpl () throws RemoteException{}

    public static void main (String[] args) {
        try {
            MyRemoteImpl server = new MyRemoteImpl();
            //为服务命名，使用java.rmi.Naming的rebind（）来注册服务
            Naming.rebind("Remote Hello", server);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}