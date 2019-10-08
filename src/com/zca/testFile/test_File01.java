package com.zca.testFile;

import java.io.File;

/**
 * 测试File的构造方法
 * @author Altria
 */
public class test_File01 {
    public static void main(String[] args) {
        String path = "E:/Java/java_IO/imgs/01.jpg";

        // 1、直接传入完整路径字符串
        File src = new File(path);
        // 打印图片大小
        System.out.println(src.length());

        // 2、传入父路径和子文件名
        src = new File("E:/Java/java_IO/imgs","01.jpg");
        System.out.println(src.length());

        // 3、传入父对象和子文件名
        src = new File(new File("E:/Java/java_IO/imgs"), "01.jpg");
        System.out.println(src.length());
    }
}
