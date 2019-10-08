package com.zca.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 面向对象思想,封装,分割
 * @author ALtria
 */
public class SpiltFile {
    // 获取文件
    private File src;
    // 目的地
    private String destDir;
    // 所有分割后的文件存储路径
    private List<String> destPaths;
    // 每块大小
    private int blockSize;
    // 块数
    private int size;

    public SpiltFile(String srcPath,String destDir, int blockSize) {
        this.src = new File(srcPath);
        this.destDir = destDir;
        this.blockSize = blockSize;
        this.destPaths = new ArrayList<String>();
        init();
    }

    // 将一些基本信息初始化
    private void init(){
        // 总长度
        long len = this.src.length();
        // 块数多少
        this.size = (int)Math.ceil(len*1.0/this.blockSize);
        // 算出路径
        for (int i=0;i<size;i++){
            this.destPaths.add(this.destDir + "/" + i + "_" + this.src.getName());
        }
    }

    /**
     * 分割
     * 1.计算起始位置
     * 2.分割
     */
    public void split() throws IOException {
        // 进行分块处理
        long len = src.length();
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
            System.out.println(i + "-->" + actualSize);
            TestRandom02(i, beginPos, actualSize);
        }
    }

    // 分块思想: 起始大小和实际大小
    private void TestRandom02(int i, int beginPos, int actualSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(this.src, "r");
        RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i), "rw");
        // 随机读取
        raf.seek(beginPos);
        // 操作
        byte[] flush = new byte[1024];// 缓冲器
        int len = -1;
        while((len=raf.read(flush))!=-1){
            if (actualSize > len){
                raf2.write(flush, 0, len);
                actualSize -= len;
            }else{
                raf2.write(flush, 0, actualSize);
                break;
            }
        }
        raf2.close();
        raf.close();
    }

    // 文件合并
    public void merge(String destPath) {
        try(OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath, true));){
            // 方法一:
//            for (int i=0;i<destPaths.size();i++){
//                InputStream is = new BufferedInputStream(new FileInputStream(destPaths.get(i)));
//                byte[] flush = new byte[blockSize];
//                int len = -1;
//                while((len=is.read(flush))!=-1){
//                    os.write(flush,0,len);
//                }
//                os.flush();
//                is.close();
//            }
            // 方法二:
            Vector<InputStream> vi = new Vector<>();
            for (int i=0; i<destPaths.size();i++){
                vi.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));
            }
            SequenceInputStream sis = new SequenceInputStream(vi.elements());
            byte[] flush = new byte[blockSize];
            int len = -1;
            while((len=sis.read(flush))!=-1){
                os.write(flush,0,len);
            }
            os.flush();
            sis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        SpiltFile sf = new SpiltFile("01.jpg", "test",1024*20);
        sf.split();
        sf.merge("01_merge.jpg");
    }
}
