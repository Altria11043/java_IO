package com.zca.test_IO;

import java.io.*;


/**
 * 文件拷贝
 */
public class CopyFile {
    public static void main(String[] args) {
        copy("01.jpg", "02.jpg");
    }

    /**
     * 文件拷贝
     * @param srcPath
     * @param destPath
     */
    public static void copy(String srcPath, String destPath){
        // 创建源
        File src = new File(srcPath);
        File dest = new File(destPath);

        InputStream is = null;
        OutputStream os = null;

        try {
            // 选择流
            is = new FileInputStream(src);
            os = new FileOutputStream(dest, true);

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
        } finally{
            try {
                if (null != is){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null != os){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 文件拷贝
     * @param srcPath
     * @param destPath
     */
    public static void copy2(String srcPath, String destPath){
        // 创建源
        File src = new File(srcPath);
        File dest = new File(destPath);
        // 选择流
        try(InputStream is = new BufferedInputStream(new FileInputStream(src));
            OutputStream os = new BufferedOutputStream(new FileOutputStream(dest, true))) {
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
}
