package com.zca.test_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CopyDir {
    public static void main(String[] args) {
        dirCopy("E:/Java/java_IO/test", "E:/Java/java_IO/test01");
    }

    public static void dirCopy(String srcPath, String destPath){
        File src = new File(srcPath);
        File dest = new File(destPath);
        if (!dest.exists()){    // 判断是否存在，如果存在就返回false
            dest.mkdirs();
        }
        // 这里进行递归
        for (File f: src.listFiles()){
            if (f.isFile()){
                fileCopy(f.getPath(), destPath + File.separator + f.getName());
            }else{
                dirCopy(f.getPath(), destPath + File.separator + f.getName());
            }
        }
    }

    /**
     * 文件拷贝
     * @param srcPath
     * @param destPath
     */
    public static void fileCopy(String srcPath, String destPath){
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
}
