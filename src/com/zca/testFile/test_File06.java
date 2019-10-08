package com.zca.testFile;

import java.io.File;

/**
 * 创建目录
 * @author Altria
 */
public class test_File06 {
    public static void main(String[] args) {
        File dir = new File("E:/Java/java_IO/test/dir");
        // 创建有两种方法：
        // 1、mkdir()：如果父目录不存在则会创建失败
        // 2、mkdirs()：如果父目录不存在则创建父目录在创建当前目录
        boolean flag = dir.mkdirs();
        System.out.println(flag);


        // 获取到下级目录中的文件列表
        File dir2 = new File("E:/Java/java_IO/src");
        String[] subNames = dir2.list();
        for (String s:subNames){
            System.out.println(s);
        }

        // 获取到下级目录中的文件对象
        File[] subFile = dir2.listFiles();
        for (File s:subFile){
            System.out.println(s.getAbsolutePath());
        }

    }
}
