/**
 * Copyright (C), 2015-2019
 * FileName: RemoteService
 * Author:   qianwenjun
 * Date:     2019/3/16 10:12
 * Description:
 */
package com.qwj.mockiter;

import org.springframework.stereotype.Service;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/16
 * @since 1.0.0
 */
@Service
public class RemoteService {

    public String beMockMethod () {
        System.out.print("原始方法的调用");
        return "原始方法的调用 的返回";
    }

}