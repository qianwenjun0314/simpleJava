/**
 * Copyright (C), 2015-2019
 * FileName: RemoteMockTest
 * Author:   qianwenjun
 * Date:     2019/3/16 10:17
 * Description:
 */
package com.qwj.study.mockiter;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.when;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/16
 * @since 1.0.0
 */
public class RemoteMockTest {

    @InjectMocks
    private RemoteService bdMockService;

    @Mock
    private LockService lockService;

    @BeforeClass
    public void beforeClass(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRemoteMock(){

//        when(lockService.DoService()).thenReturn("mock后的返回");


    }

}