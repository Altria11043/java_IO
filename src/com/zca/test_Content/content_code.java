package com.zca.test_Content;

import java.io.UnsupportedEncodingException;

/**
 * 字符串的编码和解码
 * @author Altria
 */
public class content_code {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "编码和解码a";

        // 编码: 字节数组
        // 变长: 16个字节(英文1个,中文3个)
        byte[] datas = msg.getBytes();
        System.out.println(datas.length);
        // 定长: 12个字节
//        datas = msg.getBytes("UTF-16LE");
//        System.out.println(datas.length);
        // 变长: 11个字节(英文1个,中文2个)
//        datas = msg.getBytes("GBK");
//        System.out.println(datas.length);

        // 解码
        String deCondeMsg = new String(datas, 0, datas.length, "utf-8");
        System.out.println(deCondeMsg);

        // 解码出现乱码问题
        // 1)字节数不够
        deCondeMsg = new String(datas, 0, datas.length-2, "utf-8");
        System.out.println(deCondeMsg);

        // 2)字符集不统一
        deCondeMsg = new String(datas, 0, datas.length-2, "gbk");
        System.out.println(deCondeMsg);

    }
}
