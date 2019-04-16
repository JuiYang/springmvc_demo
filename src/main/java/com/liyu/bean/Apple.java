package com.liyu.bean;

import lombok.Data;

@Data
public class Apple {
    private String name;
    private Banana banana;

    public Apple(){}
}
