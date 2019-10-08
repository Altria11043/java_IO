package com.zca.testFile;

import java.io.File;
import java.io.IOException;

/**
 * 其他方法
 * @author Altria
 */
public class test_File05 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("E:/Java/java_IO/imgs/01.jpg");
        // 打印文件长度
        System.out.println("文件长度：" + f1.length());

        // 创建文件
        File f2 = new File("E:/Java/java_IO/imgs/01.txt");
        boolean flag = f2.createNewFile();  // 不存在才创建
        System.out.println(flag);

        // 删除新创建的文件
        boolean flag2 = f2.delete();
        System.out.println(flag2);
    }
}
