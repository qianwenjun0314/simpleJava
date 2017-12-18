package com.qwj.study.utils;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Calendar;
import java.util.Date;


/**
 * Created by qianwenjun on 2017/12/6.
 */
public class DateFormatUtilTest {

    private static final Logger logger = LoggerFactory.getLogger(DateFormatUtilTest.class);


    DateFormatUtil dateFormatUtil = new DateFormatUtil();

    @Test
    public void dateTrans() throws Exception {

        Date d = new Date();
        LogUtil.printConsoleLog("d 的结果是：",d);
        Calendar c = Calendar.getInstance();
        LogUtil.printConsoleLog("c 的结果是：",c);
        Long time = System.currentTimeMillis();
        LogUtil.printConsoleLog("time 的结果是：",time);

        //验证了是否所有实例都已经注册在Spring中
//        ApplicationContext context = new AnnotationConfigApplicationContext(DateFormatUtilTest.class);
//        logger.info("是否在spring中注册了dateFormatUtil的实例:{}",context.containsBean("dateFormatUtil"));

        String date = dateFormatUtil.dateTrans(d,dateFormatUtil.TIME_FORMAT_A);
        LogUtil.printConsoleLog("date 的结果是：",date);

    }

}