/**
 * Copyright (C), 2015-2019
 * FileName: MapStu
 * Author:   qianwenjun
 * Date:     2019/3/22 14:44
 * Description:
 */
package com.qwj.study.DataTypeChange;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/22
 * @since 1.0.0
 */
public class MapStu {

    public static void printMap(){

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");

        System.out.println(map.entrySet());
        System.out.println(map.keySet());
        System.out.println(map.values());

        System.out.println(map.containsKey("key1"));
        System.out.println(map.containsValue("value4"));

    }


    public static void main(String[] args) {

        printMap();
    }

}