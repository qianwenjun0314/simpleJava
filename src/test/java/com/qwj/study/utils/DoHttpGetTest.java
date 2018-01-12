/**
 * Copyright (C), 2015-2017
 * FileName: DoHttpGetTest
 * Author:   qianwenjun
 * Date:     2017/12/12 15:31
 * Description: httpGet请求测试
 */
package com.qwj.study.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.qwj.CommonUtils.HttpRequestUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈httpGet请求测试〉
 *
 * @author qianwenjun
 * @create 2017/12/12
 * @since 1.0.0
 */
public class DoHttpGetTest {

    @Test
    public void doHttpGet() throws Exception {

        HttpRequestUtil util = new HttpRequestUtil();

        Map<String,Object> params = new HashMap<String, Object>();
        String cookies = null;
        String url = "http://www.baidu.com";

        String response = util.doHttpGet(url,params,cookies);
//        HttpEntity entity = response.getEntity();
        System.out.println("response is " + response);
//        System.out.println("entity is " + entity);

    }

    @Test
    public void doGetPartPics() throws Exception {
        HttpRequestUtil util = new HttpRequestUtil();

        Map<String,Object> params = new HashMap<String, Object>();
        params.put("carModelId","608");
        params.put("categoryId","9");
        params.put("categoryName","动力总成及组件");
        params.put("type","1");

        String url = "https://cs.ddyc.com/cloud-stock/epc/getPartPics";
        String cookie = null;
        String response = util.doHttpGet(url,params,getLogonCookie());

        response = response.substring(0,response.length()-2);

        JSONObject responseObject = new JSONObject();
        responseObject = JSONObject.parseObject(response);
        //判断response是否成功
        System.out.println("status:" + responseObject.get("success").toString());

        //把Response内的Entity内容转换成String
        System.out.println("result:" + response);

    }

    public String getLogonCookie() {
        String cookie = null;
        HttpRequestUtil util = new HttpRequestUtil();

        String url = "https://cs.ddyc.com/cloud-stock/user/login";
        JsonObject params = new JsonObject();
        params.addProperty("phone","13735532621");
        params.addProperty("password","xiaoka123");

        CloseableHttpResponse response = util.doHttpPost(url,params,cookie);
        if (response != null) {
            cookie = response.getFirstHeader("Set-Cookie").getValue();
        }
        return cookie;
    }
}