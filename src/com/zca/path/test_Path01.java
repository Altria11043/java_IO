package com.zca.path;

import java.io.File;

public class test_Path01 {
    public static void main(String[] args) {
        // 这种拼写路径不够兼容
        String path = "E:\\Java\\java_IO\\imgs\\01.jpg";
        System.out.println(path);
        // 以后建议使用以下方法
        path = "E:/Java/java_IO/imgs/01.jpg";
        System.out.println(path);

        // 还有一种比较麻烦的方式
        path = "E:" + File.separator + "Java" + File.separator +
                "java_IO" + File.separator + "imgs" + File.separator +
                "01.jpg";
    }
}
