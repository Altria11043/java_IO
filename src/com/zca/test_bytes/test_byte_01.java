package com.zca.test_bytes;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组输入流
 * @author Altria
 */
public class test_byte_01 {
    public static void main(String[] args) {
        // 创建源
        byte[] src = "talk is cheap show me the code".getBytes();
        // 选择流(使用字节数组输入流，因为这里不是读取文件所以不需要进行异常处理)
        InputStream is = new ByteArrayInputStream(src);
        byte[] flush = new byte[1024];
        int len = -1;
        try{
            while((len=is.read(flush))!=-1){
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
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
