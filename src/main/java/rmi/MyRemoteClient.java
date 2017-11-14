/**
 * Copyright (C), 2015-2017
 * FileName: MyRemoteClient
 * Author:   qianwenjun
 * Date:     2017/11/7 13:21
 * Description: 远程客户端程序
 */
package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈远程客户端程序〉
 *
 * @author qianwenjun
 * @create 2017/11/7
 * @since 1.0.0
 */
public class MyRemoteClient {

    public static void main (String[] args) {

        MyRemoteClient client = new MyRemoteClient();
        client.go();
    }

    public void go () {
        try {
            MyRemote server = (MyRemote) Naming.lookup("rmi://127.0.0.1/Remote Hello");

            String s = server.sayHello();
            System.out.println(s);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}