package com.zca.testFile;

import java.io.File;

/**
 * 文件的状态
 * @author Altria
 */
public class test_File04 {
    public static void main(String[] args) {
        File f1 = new File("E:/Java/java_IO/imgs/01.jpg");
        System.out.println("是否存在：" + f1.exists());
        System.out.println("是否是文件：" + f1.isFile());
        System.out.println("是否是文件夹：" + f1.isDirectory());

        System.out.println("=======================================");
        File f2 = new File("imgs/01.jpg");
        System.out.println("是否存在：" + f2.exists());
        System.out.println("是否是文件：" + f2.isFile());
        System.out.println("是否是文件夹：" + f2.isDirectory());

        System.out.println("=======================================");
        File f3 = new File("E:/Java/java_IO");
        System.out.println("是否存在：" + f3.exists());
        System.out.println("是否是文件：" + f3.isFile());
        System.out.println("是否是文件夹：" + f3.isDirectory());



    }
}
