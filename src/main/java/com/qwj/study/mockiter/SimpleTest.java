/**
 * Copyright (C), 2015-2019
 * FileName: SimpleTest
 * Author:   qianwenjun
 * Date:     2019/3/16 10:09
 * Description:
 */
package com.qwj.study.mockiter;

import static org.mockito.Mockito.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/16
 * @since 1.0.0
 */
public class SimpleTest {

    @Test
    public void simpleTest(){

        //创建mock对象，参数可以是类，也可以是接口
        List<String> list = mock(List.class);

        //设置方法的预期返回值
        when(list.get(0)).thenReturn("helloworld");

        String result = list.get(0);

        //验证方法调用(是否调用了get(0))
        verify(list).get(0);

        //junit测试
        Assert.assertEquals("helloworld", result);
        Assert.assertEquals("helloworld1", result);

    }
}