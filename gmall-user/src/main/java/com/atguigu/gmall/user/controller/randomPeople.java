package com.atguigu.gmall.user.controller;

import java.util.Random;

public class randomPeople {
    public static void main(String[] args) {
        Random col=new Random();//列
        Random row=new Random();//行
        int lie = col.nextInt(4) + 1;
        int hang = row.nextInt(8) + 1;
        System.out.println("有请第"+lie+"列第"+hang+"行的同学回答问题！！！");
    }
}
