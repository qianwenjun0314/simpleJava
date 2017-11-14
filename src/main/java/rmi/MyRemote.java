/**
 * Copyright (C), 2015-2017
 * FileName: MyRemote
 * Author:   qianwenjun
 * Date:     2017/11/7 12:48
 * Description: 创建远程接口
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈创建远程接口〉
 *
 * @author qianwenjun
 * @create 2017/11/7
 * @since 1.0.0
 */
public interface MyRemote extends Remote{

    //remote是个标记性接口，意味这没有方法
    //远程接口定义了客户端可以远程调用的方法，它是个作为服务的多态化类，客户端会调用有实现这个接口stub，
    // 2⃣️这个stub会执行网络和输入输出工作，所以会发生各种问题，客户端必须声明和处理异常来认知这一类风险
    //如果方法在接口中声明异常，调用该方法的所有程序都必须处理或者声明异常
    public String sayHello () throws RemoteException;

    //远程方法的参数和返回值必须是primitive或serialization
    //任何远程方法的参数都会被打包通过网络传输，而这都是通过序列化完成的，返回值也是一样
}