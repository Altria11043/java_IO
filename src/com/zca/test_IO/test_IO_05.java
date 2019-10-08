package com.zca.test_IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 字符输出流
 * 创建源
 * 选择流
 * 操作
 * 释放资源
 */
public class test_IO_05 {
    public static void main(String[] args) {
        // 创建源
        File dest = new File("dest.txt");

        // 选择流
        Writer writer = null;

        try {
            writer = new FileWriter(dest,true);
            // 操作
            String msg = "周晨安和Altria\r\n";
            // 写法一
//            char[] datas = msg.toCharArray();
//            writer.write(datas,0, datas.length);
            // 写法二
//            writer.write(msg);
            //写法三
            writer.append("周晨安和Altria").append("\r\n");
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != writer){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
