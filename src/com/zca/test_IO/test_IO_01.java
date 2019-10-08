package com.zca.test_IO;

import java.io.*;

/**
 * 理解步骤
 * 1.创建源
 * 2.选择流
 * 3.具体操作
 * 4.释放资源
 * @author Altria
 */
public class test_IO_01 {
    public static void main(String[] args) {
        // 1.创建源
        File src = new File("abc.txt");
        InputStream is = null;
        try {
            // 2.选择流
            is = new FileInputStream(src);
            // 3.操作(读取)
            int temp;
            while ((temp=is.read())!=-1){
                System.out.println((char) temp);
            }
//            int data1 = is.read();
//            int data2 = is.read();
//            int data3 = is.read();
//            System.out.println((char)data1);
//            System.out.println((char)data2);
//            System.out.println((char)data3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 4.通知操作系统释放资源
            try {
                if (null != is)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
