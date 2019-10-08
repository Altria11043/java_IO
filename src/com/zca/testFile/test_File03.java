package com.zca.testFile;

import java.io.File;

/**
 * 基本方法
 * @author Altria
 */
public class test_File03 {
    public static void main(String[] args) {
        // 绝对路径下
        File f1 = new File("E:/Java/java_IO/imgs/01.jpg");
        System.out.println("名称：" + f1.getName());
        System.out.println("路径：" + f1.getPath());   // 如果创建的时候是相对路径则打印相对路径
        System.out.println("绝对路径：" + f1.getAbsolutePath());
        System.out.println("父路径：" + f1.getParent());

        // 相对路径下
        File f2 = new File("imgs/01.jpg");
        System.out.println("名称：" + f2.getName());
        System.out.println("路径：" + f2.getPath());   // 如果创建的时候是相对路径则打印相对路径
        System.out.println("绝对路径：" + f2.getAbsolutePath());
        System.out.println("父路径：" + f2.getParent());
    }
}
