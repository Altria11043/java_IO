package com.zca.convert;

import java.io.*;
import java.net.URL;

/**
 * 转换流
 * @author Altria
 */
public class Test_Convert_02 {
    public static void main(String[] args) {
        // 操作网路流 下载百度首页源码
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new URL("http://www.baidu.com").openStream(), "utf-8"));
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("baidu.html"),"utf-8"));){
            String msg;
            while((msg=reader.readLine())!=null){
                writer.write(msg);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
