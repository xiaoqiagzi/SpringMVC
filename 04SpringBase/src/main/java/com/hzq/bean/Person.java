package com.hzq.bean;

public class Person {
    private String name;
    private int age;
    private Dog dog;
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Dog getDog() {
        return dog;
    }

    public Person(int age, String name, Dog dog) {
        this.age = age;
        this.name = name;
        this.dog = dog;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dog=" + dog +
                '}';
    }
}
