package com.zca.testFile;

import java.io.File;

/**
 * 面向对象方法：统计文件夹的大小
 */
public class file_Count {
    // 大小
    private long len;
    // 需测试大小的文件路径
    private String path;
    // 根据文件路径获取到文件对象
    private File file;

    public file_Count(String path){
        this.path = path;
        this.file = new File(path);
        count(this.file);
    }

    private void count(File file){
        if (null != file || file.exists()){
            if (file.isFile()){
                len += file.length();
            }else{
                for (File f:file.listFiles()){
                    count(f);
                }
            }
        }
    }

    public long getLen() {
        return len;
    }
}
