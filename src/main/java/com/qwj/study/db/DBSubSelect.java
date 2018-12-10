/**
 * Copyright (C), 2015-2018
 * FileName: DBSubSelect
 * Author:   qianwenjun
 * Date:     2018/7/8 14:48
 * Description:
 */
package com.qwj.study.db;

import com.alibaba.fastjson.JSON;
import com.qwj.CommonUtils.MySqlUtils;

import java.sql.SQLException;
import java.util.*;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2018/7/8
 * @since 1.0.0
 */
public class DBSubSelect {


    MySqlUtils jdbc = new MySqlUtils("");

    public  Set<Long> findConsumerId() {

        Set<Long> consumerIds = new HashSet<Long>();

        try {
            List<Map<String,Object>> results = jdbc.findModeResult("select * from consumer_account_log.tb_consumer_accounts_log where  biz_type = '8' and gmt_create > '2018-07-07 00:00:00' and gmt_create < '2018-07-07 23:59:59'\n");
            for (Map<String,Object> res :results) {
                consumerIds.add(Long.valueOf(res.get("consumer_id").toString()));
            }
            System.out.println("consumerIds=" + consumerIds.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return consumerIds;
    }

    public Map<String,String> getDbName (Set<Long> consumerIds) {

//        StringBuilder dbPrefix = new StringBuilder("consumer.consumer_");
//        List<Map<String,S>> maps = new ArrayList<Map<String, StringBuilder>>();
        Map<String,String> map = new HashMap<String, String>();

        Iterator it = consumerIds.iterator();
        while(it.hasNext()){
            String ss = it.next().toString();
//            System.out.println("it.hasNext()"+ss);
            Long b = 10000000L;
            Long dbPostfix = Long.valueOf(ss)/b;
            System.out.println(dbPostfix);
            if (dbPostfix.intValue()<100){
                String dbName = "consumer.consumer_00"+ dbPostfix;
                map.put(ss,dbName);
            }else if (dbPostfix.intValue()<1000){
                String dbName = "consumer.consumer_0"+ dbPostfix;
                map.put(ss,dbName);
            }else {
                String dbName = "consumer.consumer_"+ dbPostfix;
                map.put(ss,dbName);
            }

            String tag = String.format("%04d", Long.parseLong(ss) % 1024);


        }
        System.out.println("map" + JSON.toJSONString(map));
        return map;
    }


    public List<Map<String,Object>> getSubResult(Map<String,String> map) {

        List<Map<String,Object>> results = new ArrayList<Map<String, Object>>();
        try{
            for (Map.Entry<String,String> entry:map.entrySet()){
                String  sql = "select * from " + entry.getValue() + " where id = '" + entry.getKey() + "'";
//                System.out.println(sql);
                Map<String,Object> res = jdbc.findSimpleResult(sql);
                results.add(res);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("results的结果为" + JSON.toJSONString(results));
        return results;

    }



    public static void main(String[] args) {

//        DBSubSelect dbSubSelect = new DBSubSelect();
//        Set<Long> consumerIds = new HashSet<Long>();
//        consumerIds = dbSubSelect.findConsumerId();
//
//        Map<String,String> maps = new HashMap<String, String>();
//        maps = dbSubSelect.getDbName(consumerIds);
//
//        List<Map<String,Object>> subResults = new ArrayList<Map<String, Object>>();
//
//        subResults = dbSubSelect.getSubResult(maps);



        Long a = 1539361L;
        Long b = 1024L;
        String dbName = "";

        Long postFix = a%b;
        System.out.println(postFix);

        if (postFix.intValue()<100){
            dbName = "consumer.consumer_00" + postFix;

        }else{
            dbName = "consumer.consumer_0" + postFix;
        }
        System.out.println(dbName);

    }







}