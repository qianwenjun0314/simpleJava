/**
 * Copyright (C), 2015-2019
 * FileName: TestCollection
 * Author:   qianwenjun
 * Date:     2019/3/3 21:09
 * Description:
 */
package com.qwj.study.collections;

import java.util.ArrayList;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2019/3/3
 * @since 1.0.0
 */
public class TestCollection {

    public void go(){
        Animal[] animals = {new Dog(),new Cat(),new Dog()};
        Dog[] dogs = {new Dog(),new Dog(),new Dog()};
        takeAnimals(animals);
        takeAnimals(dogs);
    }

    public void takeAnimals(Animal[] animals){
        for (Animal a:animals){
            a.eat();
        }

    }

    public void go2(){
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());

        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        takeAnimals2(animals);
        //编译报错，由于集合的类型校验，是在编译期间。集合参数化，只能是一一对应的关系。
//        takeAnimals2(dogs);//编译不通过
//        takeAnimals4(animals);//编译不通过
        takeAnimals4(dogs);
        takeAnimals7(animals);
        takeAnimals7(dogs);
    }

    public void takeAnimals2(ArrayList<Animal> animals){
        for (Animal a:animals){
            a.eat();
        }
    }
    public void takeAnimals4(ArrayList<Dog> dogs){
        for (Dog a:dogs){
            a.eat();
        }
    }
    //采用万能字符实现多态化集合参数类型的校验
    public void takeAnimals7(ArrayList<? extends Animal> animals){
        for (Animal a:animals){
            a.eat();
        }
    }

    public void go3(){
        Dog[] dogs = {new Dog(),new Dog(),new Dog()};
        takeAnimals3(dogs);
    }

    public void takeAnimals3(Animal[] animals){
        //编译通过，但是执行会报错，因为数组的类型校验是运行期间，不允许往dog类型的数组里添加Cat类型的对象
        animals[0] = new Cat();

    }


    public void go5(){
        Animal animal = new Animal();
        Dog dog = new Dog();
        takeAnimals5(dog);//向上转型，把子类的对象直接赋给父类的引用，成功的
//        takeAnimals6(animal);
        takeAnimals6((Dog) animal);
    }

    public void takeAnimals5(Animal animal){
    }

    public void takeAnimals6(Dog dog){

    }

    public static void main(String[] args) {
        new TestCollection().go3();

    }
}