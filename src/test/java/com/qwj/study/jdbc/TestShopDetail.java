/**
 * Copyright (C), 2015-2017
 * FileName: TestShopDetail
 * Author:   qianwenjun
 * Date:     2017/11/15 17:35
 * Description: 测试校验门店详情
 */
package com.qwj.study.jdbc;


//import org.apache.regexp.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Logger;


/**
 * 〈测试连接数据库〉
 *
 * @author qianwenjun
 * @create 2017/11/15
 * @since 1.0.0
 */
public class TestShopDetail {

//    public static final Logger logger = LoggerFactory.getLogger(TestShopDetail.class);
    public static Logger logger = Logger.getLogger(TestShopDetail.class.toString());

    public static void main (String[] args ) {
        //数据库连接
        String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://192.168.1.160:3306/chediandian?useUnicode=true&characterEncoding=utf8&autoReconnect=true";
        String url = "jdbc:mysql://192.168.1.43:3306/chediandian?useUnicode=true&characterEncoding=utf8&autoReconnect=true";

        String user = "xiaoka";
        String pass = "xiaoka123";

        String queryResult = "";
        String ownerPhone = "10112340029";

        String query = "select * from car_business_owner where owner_phone = '" + ownerPhone + "' and is_deleted = \"0\"";
        Connection mycon = null ;
        Statement mystmt = null;
        ResultSet myresult = null ;

        try {
            mycon = DriverManager.getConnection(url,user,pass);
            logger.info("创建连接成功");
//            System.out.println("创建连接成功");
            mystmt = mycon.createStatement();
            myresult = mystmt.executeQuery(query);
            logger.info("执行sql成功，原始结果为：" + myresult );
            System.out.println("执行sql成功，原始结果为：" + myresult );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while(myresult.next()) {
                queryResult = myresult.getString(1);
                logger.info("结果为：" + queryResult);
                System.out.println("结果为：" + queryResult);
            }
            myresult.close();
            mystmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        try {
//            JsonParser parser1 = new JsonParser();
//            JsonObject queryResultObj = new JsonObject();
//            queryResultObj = (JsonObject) parser1.parse(queryResult);
//
//            System.out.println("historyObj is" + queryResultObj);
//            System.out.println("history is" + queryResult);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

}