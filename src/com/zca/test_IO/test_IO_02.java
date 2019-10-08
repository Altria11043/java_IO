package com.zca.test_IO;

import java.io.*;

/**
 * 字节输入流
 * 一段一段的读取数据
 * @author Altria
 */
public class test_IO_02 {
    public static void main(String[] args) {
        // 创建源
        File file = new File("abc.txt");

        // 选择流
        InputStream is = null;

        try {
            is = new FileInputStream(file);

            // 操作（分段读取）
            byte[] bytes = new byte[3]; // 缓冲容器
            int temp = -1;  // 接收长度
            while ((temp=is.read(bytes))!=-1){
                // 字节数组-->字符串（解码）
                String str = new String(bytes,0,temp);
                System.out.print(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != is){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
