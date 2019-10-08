package com.zca.testFile;

import java.io.File;

/**
 * 相对路径和绝对路径
 * @author Altria
 */
public class test_File02 {
    public static void main(String[] args) {
        String path = "E:/Java/java_IO/imgs/01.jpg";

        // 绝对路径
        File f1 = new File(path);
        System.out.println(f1.getAbsolutePath());

        // 相对路径
        File f2 = new File("imgs/01.jpg");
        System.out.println(f2.getAbsolutePath());

        // 当前工程目录
        System.out.println(System.getProperty("user.dir"));
    }
}
