package com.zca.random;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机读取和写入
 * @author Altria
 */
public class TestRandom {
    public static void main(String[] args) throws IOException {
        // 进行分块处理
        // 先要知道文件的大小
        File file = new File("baidu.html");
        long len = file.length();

        // 每块分多大: 1024
        int blockSize = 1024;
        // 有几块
        int size = (int)Math.ceil(len*1.0/blockSize);// 如果这里不添加*1.0, 算出来的结果与实际不符
        // 起始位置
        int beginPos = 0;
        // 实际大小
        int actualSize = (int)(blockSize>len?len:blockSize);
        for (int i=0;i<size;i++){
            // 计算每块的起始位置
            beginPos = i*blockSize;
            if(i == size-1){
                actualSize = (int)len;
            }else{
                actualSize = blockSize;
                len -= actualSize;
            }
            TestRandom02(i, beginPos, actualSize);
        }
    }

    public static void TestRandom01() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("baidu.html"), "r");
        // 随机读取
        raf.seek(4);
        byte[] flush = new byte[1024];
        int len = -1;
        while((len=raf.read(flush))!=-1){
            System.out.println(new String(flush, 0, len));
        }
        raf.close();
    }

    // 分块思想: 起始大小和实际大小
    public static void TestRandom02(int i, int beginPos, int actualSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("baidu.html"), "r");
        // 随机读取
        raf.seek(beginPos);

        // 操作
        byte[] flush = new byte[1024];// 缓冲器
        int len = -1;
        while((len=raf.read(flush))!=-1){
            if (actualSize > len){
                System.out.println(new String(flush, 0, len));
                actualSize -= len;
            }else{
                System.out.println(new String(flush, 0, actualSize));
                break;
            }
        }
        raf.close();
    }
}
