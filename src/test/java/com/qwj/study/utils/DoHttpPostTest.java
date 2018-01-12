/**
 * Copyright (C), 2015-2017
 * FileName: DoHttpPostTest
 * Author:   qianwenjun
 * Date:     2017/12/12 14:50
 * Description: httpPost请求测试
 */
package com.qwj.study.utils;

import com.google.gson.JsonObject;
import com.qwj.CommonUtils.HttpRequestUtil;
import com.qwj.CommonUtils.LogUtil;
import org.apache.http.HeaderIterator;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**
 * 〈httpPost请求测试〉
 *
 * @author qianwenjun
 * @create 2017/12/12
 * @since 1.0.0
 */
public class DoHttpPostTest {

    @Test
    public void doHttpPost() throws Exception {
        HttpRequestUtil util = new HttpRequestUtil();

        String url = "https://cs.ddyc.com/cloud-stock/user/login";
//        String params = "{\"phone\": \"13735532621\", \"password\": \"xiaoka123\"}";
        JsonObject params = new JsonObject();
        params.addProperty("phone","13735532621");
        params.addProperty("password","xiaoka123");

        String cookie = null;

        //判断response是否成功
        CloseableHttpResponse response = util.doHttpPost(url,params,cookie);
//        System.out.println("status:" + response.getStatusLine().getStatusCode());
        LogUtil.printInfoLog("status:" , response.getStatusLine().getStatusCode());

        //把Response内的Entity内容转换成String
        String result = EntityUtils.toString(response.getEntity());
//        System.out.println("result:" + result);
        LogUtil.printInfoLog("result:" + result);

        //获取响应的head信息
//        System.out.println("headers:" );
        LogUtil.printInfoLog("headers:");
        HeaderIterator iterator = response.headerIterator();
        while (iterator.hasNext()) {
//            System.out.println("\t" + iterator.next());
            LogUtil.printInfoLog("\t" , iterator.next());
            LogUtil.printConsoleLog("\t" , iterator.next());

        }
    }
}