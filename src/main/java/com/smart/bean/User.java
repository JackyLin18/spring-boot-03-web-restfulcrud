package com.smart.bean;

public class User {
    private String username;
    private Integer age;
    private Boolean isBoss;
    private Car car;

    public User(){}

    public User(String username, Integer age, Boolean isBoss, Car car) {
        this.username = username;
        this.age = age;
        this.isBoss = isBoss;
        this.car = car;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return isBoss;
    }

    public void setBoss(Boolean boss) {
        isBoss = boss;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", isBoss=" + isBoss +
                ", car=" + car +
                '}';
    }
}
