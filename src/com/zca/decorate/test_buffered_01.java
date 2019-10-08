package com.zca.decorate;

import java.io.*;

/**
 * 字节缓冲流
 * @author Altria
 */
public class test_buffered_01 {
    public static void main(String[] args) {
        File src = new File("abc.txt");
        try(InputStream is = new BufferedInputStream(new FileInputStream(src))){
            byte[] flush = new byte[1024];
            int len = -1;
            while((len=is.read(flush))!=-1){
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
