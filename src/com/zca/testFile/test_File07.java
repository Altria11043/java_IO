package com.zca.testFile;

import java.io.File;

/**
 * 递归读取当前文件夹下的所有目录
 * 递归统计当前文件夹的大小
 * @author
 */
public class test_File07 {
    public static void main(String[] args) {
        File f = new File("E:/Java/java_IO/src");
        recursionFile(f,0);
        count(f);
        System.out.println(len);
        System.out.println(new file_Count("E:/Java/java_IO/src").getLen());
    }

    public static void recursionFile(File file, int deep){
        for (int i=0; i<deep;i++)
            System.out.print("-");
        System.out.println(file.getName());
        if (file == null || !file.exists()){
            return;
        }else if (file.isDirectory()){
            for (File f:file.listFiles()){
                recursionFile(f, deep+1);
            }
        }
    }

    private static long len = 0;

    public static void count(File file){
        if (null != file || file.exists()){
            if (file.isFile()){
                len = len + file.length();
            }else{
                for (File f:file.listFiles()){
                    count(f);
                }
            }
        }
    }
}
