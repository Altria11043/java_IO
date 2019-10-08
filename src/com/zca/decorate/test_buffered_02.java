package com.zca.decorate;

import java.io.*;

/**
 * 字符缓冲流
 * 与字节缓冲流有些区别
 * @author Altria
 */
public class test_buffered_02 {
    public static void main(String[] args) {
//        TestBufferedReader("abc.txt");
        TestBufferedWriter("dest.txt","我要去编程", true);
    }

    public static void TestBufferedReader(String path){
        // 创建源
        File src = new File(path);
        // 选择流
        try(BufferedReader reader = new BufferedReader(new FileReader(src))){
            String line = null;
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void TestBufferedWriter(String path, String count, boolean append){
        File dest = new File(path);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(dest, append))){
            bw.write(count);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
