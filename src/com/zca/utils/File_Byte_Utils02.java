package com.zca.utils;

import java.io.*;

public class File_Byte_Utils02 {
    // 对接输入输出流
    public static void copy(InputStream is, OutputStream os){
        // 使用try...with...resource方法，不需要再去手动释放资源了
        try(is; os) {
            // 操作区（进行文件拷贝）
            byte[] bytes = new byte[1024*10];
            int temp = -1;
            while((temp=is.read(bytes))!=-1){
                // 将读取到的字节放入指定的文件中
                os.write(bytes, 0, temp);   // bytes：这里视情况而定，只是正好有个缓存大小的字节数组
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        byte[] datas = null;
        try {
            // 文件到文件
//            InputStream is = new FileInputStream("abc.txt");
//            OutputStream os = new FileOutputStream("abc_copy.txt");
            InputStream is = new BufferedInputStream(new FileInputStream("01.jpg"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            copy(is, baos);
            // 打出拷贝进字节数组的长度
            datas = baos.toByteArray();
            System.out.println(datas.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            InputStream is = new ByteArrayInputStream(datas);
            OutputStream os = new FileOutputStream("02.jpg");
            copy(is, os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
