/**
 * Copyright (C), 2015-2019
 * FileName: LockService
 * Author:   qianwenjun
 * Date:     2019/3/16 10:24
 * Description:
 */
package com.qwj.study.mockiter;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/16
 * @since 1.0.0
 */
public class LockService {

    @Autowired
    private RemoteService remoteService;


    public String DoService () {
        String result = null;
        result = remoteService.beMockMethod();

        return result;
    }

}