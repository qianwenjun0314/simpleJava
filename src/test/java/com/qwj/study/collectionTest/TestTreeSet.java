/**
 * Copyright (C), 2015-2017
 * FileName: TestTreeSet
 * Author:   qianwenjun
 * Date:     2017/11/4 20:53
 * Description: 研究TreeSet排序
 */
package com.qwj.study.collectionTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈研究TreeSet排序〉
 *
 * @author qianwenjun
 * @create 2017/11/4
 * @since 1.0.0
 */
public class TestTreeSet {

    public  void go () {

//        ArrayList<Dog> dogs = new ArrayList<Animal>();
        ArrayList<? super Dog> dogs = new ArrayList<Animal>();

        ArrayList<Dog> dogs1 = new ArrayList<Dog>();
        List<Dog> dogs2 = dogs1;
        List<Dog> dogs3 = new ArrayList<Dog>();


//        ArrayList<Animal> animals1 = ArrayList<Dog>();
//        ArrayList<? extends Animal> animals2 = ArrayList<Dog>();

        ArrayList<Animal> animals3 = new ArrayList<Animal>();
        List<Animal> list = new ArrayList<Animal>();

        //对于范型，类型参数指的是要声明引用类型和创建对象类型要保持一致
        //若要对于这种强制关系弱化，需要使用通配符（？）
//        List<Animal> list1 = new ArrayList<Dog>();
        List<? extends Animal> list2 = new ArrayList<Dog>();
        List<?> list3 = new ArrayList<Dog>();
        List<? super Dog> list4 = new ArrayList<Animal>();
        //List<Obj> list4 = new ArrayList<Obj>();

        //这个是作为add（Dog d）的使用多态机制，但是在实际调用lis这个引用变量的时候使用的是Dog类型的方法，不能使用LittleDog类型的方法
//        list4.add(new Animal());
        list4.add(new LitterDog());
        //list4.get(0).play();

//        ArrayList<Animal> animales1 = dogs1;


        ArrayList<Object> objects = new ArrayList<Object>();
        List<Object> objList = objects;
//        ArrayList<Object> objs = new ArrayList<Dog>();


    }

}