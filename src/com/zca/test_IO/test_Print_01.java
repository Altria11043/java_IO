package com.zca.test_IO;

import java.io.*;

public class test_Print_01 {
    public static void main(String[] args) throws IOException {
        PrintStream ps = System.out;
        ps.println("测试打印流");
        ps.println(true);

        ps = new PrintStream(new BufferedOutputStream(
                new FileOutputStream("print_test.txt")), true, "UTF-8");
        ps.println("测试将打印流的内容输入到文本");
        ps.println(false);

        // 重定向输出端,这里将下面要打印的字符串打印到文本中
        System.setOut(ps);
        System.out.println("会把这段字符打印到文件中去");
        // 重定向会控制台
        System.setOut(new PrintStream(new BufferedOutputStream(
                new FileOutputStream(FileDescriptor.out)), true));
        System.out.println("又回到了控制台");

        ps.close();

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("abc.txt")), true);
        pw.println("测试PrintWriter");
        pw.close();
    }
}
