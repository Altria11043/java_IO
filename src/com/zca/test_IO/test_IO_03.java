package com.zca.test_IO;

import java.io.*;

/**
 * 字节输出流
 * 1、创建源
 * 2、选择流
 * 3、操作（写出内容）
 * 4、释放资源
 * @author Altria
 */
public class test_IO_03 {
    public static void main(String[] args) {
        // 创建源
        File src = new File("dest.txt");
        OutputStream os = null;
        try {
            // 选择流
            os = new FileOutputStream(src, false);
            // 操作
            String msg = "Saber is Altria ";
            byte[] bytes = msg.getBytes();  // 进行编码
            os.write(bytes, 0, bytes.length);
            os.flush(); // 刷新一下，防止数据驻留在缓存中
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                if (null != os){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
