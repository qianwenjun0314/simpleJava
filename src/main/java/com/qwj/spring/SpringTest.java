/**
 * Copyright (C), 2015-2019
 * FileName: SpringTest
 * Author:   qianwenjun
 * Date:     2019/3/20 17:10
 * Description:
 */
package com.qwj.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/20
 * @since 1.0.0
 */
public class SpringTest {

    @Autowired
    BeanFactory beanFactory ;

    @Autowired
    FactoryBean factoryBean;

}