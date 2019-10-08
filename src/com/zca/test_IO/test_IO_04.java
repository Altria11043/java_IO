package com.zca.test_IO;

import java.io.*;

/**
 * 字符输入流
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 */
public class test_IO_04 {
    public static void main(String[] args) {
        // 创建源
        File src = new File("abc.txt");
        // 选择流
        Reader reader = null;

        try {
            reader = new FileReader(src);
            // 操作（分段读取）
            char[] flush = new char[1024];
            int len = -1;
            while((len=reader.read(flush))!=-1){
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != reader){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
