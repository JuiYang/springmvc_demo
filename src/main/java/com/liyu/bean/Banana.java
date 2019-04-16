package com.liyu.bean;

import lombok.Data;

@Data
public class Banana {
    private String name;
    private String brand;

    public Banana(){}

    public void init(){
        System.out.println("init method ...");
    }

    public void destroy(){
        System.out.println("destroy method ...");
    }
}
