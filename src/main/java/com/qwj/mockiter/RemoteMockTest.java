/**
 * Copyright (C), 2015-2019
 * FileName: RemoteMockTest
 * Author:   qianwenjun
 * Date:     2019/3/16 10:17
 * Description:
 */
package com.qwj.mockiter;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/16
 * @since 1.0.0
 */
public class RemoteMockTest {

    @InjectMocks
    //需要被注入在mock代理服务中的服务。
    // 比如lockService中有调用remoteService的方法，
    // 此时想mock调用remoteService方法的返回，则需要将这个服务注入在mock的代理服务中
    private RemoteService remoteService;

    @Mock//需要被代理的服务。
    private LockService lockService;

    @BeforeClass
    public void beforeClass(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRemoteMock(){

        when(lockService.doService()).thenReturn("mock后的返回");
        System.out.println(lockService.doService());


    }

}