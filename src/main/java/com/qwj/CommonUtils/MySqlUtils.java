/**
 * Copyright (C), 2015-2018
 * FileName: MySqlUtils
 * Author:   qianwenjun
 * Date:     2018/7/8 14:27
 * Description:
 */
package com.qwj.CommonUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2018/7/8
 * @since 1.0.0
 */
public class MySqlUtils {

    //test 数据库：
    //    host：172.16.80.25
    //    用户名：dev
    //    密码：dev_fas015
    private String  USERNAME;
    private String PASSWORD;
    private String DRIVER = "com.mysql.jdbc.Driver";
    private   String URL;// = "jdbc:mysql://localhost:3306/mydb";
    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet resultSet;

    private MySqlUtils(String username ,String password, String url ) {
        USERNAME = username;
        PASSWORD = password;
        URL = url;
        connection = getConnection();
    }

    /**
     *
     * @param username   用户名
     * @param password   密码
     * @param ip         数据库ip
     * @param port       端口号
     * @param databaseName  数据库名
     */
    public MySqlUtils(String username,String password,String ip,String port,String databaseName){
        this(username,password,"jdbc:mysql://"+ip+":"+port+"/"+databaseName);
    }

    /**
     * test数据库连接
     * @param databaseName 数据库名字
     */
    public MySqlUtils(String databaseName){
        this("dev","dev_fas015","172.16.80.25","3306",databaseName);

    }
    public static MySqlUtils mysqlDuiba(String databaseName){
        return new MySqlUtils("dev","dev_fas015","172.16.80.25","3306",databaseName);

    }
    /**
     * 获得数据库的连接
     * @return
     */
    public Connection getConnection(){
        try {
            try {
                Class.forName(DRIVER);
                System.out.println("数据库连接成功！");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }


    /**
     * 增加、删除、改
     * @param sql        sql语句
     * @param params     参数，替换 ？
     * @return           true or false
     * @throws SQLException
     */
    public boolean update(String sql, Object ...params)throws SQLException{
        boolean flag = false;
        int result = -1;
        pstmt = connection.prepareStatement(sql);
        int index = 1;
        if(params != null && !(params.length==0)){
            for(int i=0; i<params.length; i++){
                pstmt.setObject(index++, params[i]);
            }
        }
        result = pstmt.executeUpdate();
        flag = result > 0 ? true : false;
        return flag;
    }
    /**
     * 查询结果只有一行数据
     * @param sql         sql语句
     * @param params      可变参数，替换 ？
     * @return            map
     * @throws SQLException
     */
    public Map<String, Object> findSimpleResult(String sql, Object ...params) throws SQLException{
        Map<String, Object> map = new HashMap<String, Object>();
        int index  = 1;
        pstmt = connection.prepareStatement(sql);
        if(params != null && !(params.length==0)){
            for(int i=0; i<params.length; i++){
                pstmt.setObject(index++, params[i]);
            }
        }
        resultSet = pstmt.executeQuery();//返回查询结果
        ResultSetMetaData metaData = resultSet.getMetaData();
        int col_len = metaData.getColumnCount();
        while(resultSet.next()){
            for(int i=0; i<col_len; i++ ){
                String cols_name = metaData.getColumnName(i+1);
                Object cols_value = resultSet.getObject(cols_name);
                if(cols_value == null){
                    cols_value = "";
                }
                map.put(cols_name, cols_value);
            }
        }
        return map;
    }

    /**
     * 返回多条数据
     * @param sql           sql语句
     * @param params        可变参数，替换 ？
     * @return              list
     * @throws SQLException
     */
    public List<Map<String, Object>> findModeResult(String sql, Object ...params) throws SQLException{
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        int index = 1;
        pstmt = connection.prepareStatement(sql);
        if(params != null && !(params.length==0)){
            for(int i=0; i<params.length; i++){
                pstmt.setObject(index++, params[i]);
            }
        }
        resultSet = pstmt.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int cols_len = metaData.getColumnCount();
        while(resultSet.next()){
            Map<String, Object> map = new HashMap<String, Object>();
            for(int i=0; i<cols_len; i++){
                String cols_name = metaData.getColumnName(i+1);
                Object cols_value = resultSet.getObject(cols_name);
                if(cols_value == null){
                    cols_value = "";
                }
                map.put(cols_name, cols_value);
            }
            list.add(map);
        }

        return list;
    }
    /**
     * 释放数据库连接
     */
    public void releaseConn(){
        if(resultSet != null){
            try{
                resultSet.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
//		JdbcUtils jdbc = new JdbcUtils("root", "root", "com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/learning");
//
//		Map<String, Object> map = jdbc.findSimpleResult("select * from t_user where USER_ID='1'", null);

        MySqlUtils jdbc = MySqlUtils.mysqlDuiba("");
        Map<String, Object> map = jdbc.findSimpleResult("select * from consumer.consumer_0000 where id = '1539361' \n");
        System.out.println(map);

        jdbc.releaseConn();

    }
}