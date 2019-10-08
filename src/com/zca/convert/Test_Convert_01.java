package com.zca.convert;

import java.io.*;

/**
 * 字节流转换成字符流
 * @author Altria
 */
public class Test_Convert_01 {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));){
            String msg = "";
            while(!msg.equals("exit")){
                msg = reader.readLine();
                writer.write(msg);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
