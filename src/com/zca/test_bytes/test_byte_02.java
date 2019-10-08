package com.zca.test_bytes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 字节数组输出流
 * @author Altria
 */
public class test_byte_02 {
    public static void main(String[] args) {
        // 创建源 因为不需要所以为空，保证风格统一
        byte[] dest = null;
        // 选择流 不关联源
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            // 操作
            String msg = "talk is cheap show me the code";
            byte[] datas = msg.getBytes();
            baos.write(datas, 0, datas.length);
            baos.flush();

            // 获取数据
            dest = baos.toByteArray();
            System.out.println(dest.length + "-->" + new String(dest, 0, dest.length));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != baos){
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
