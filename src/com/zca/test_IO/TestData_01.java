package com.zca.test_IO;

import java.io.*;

/**
 * 数据流
 * @author Altria
 */
public class TestData_01 {
    public static void main(String[] args) throws IOException {
        // 写出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeUTF("莫焦躁");
        dos.writeDouble(100.0);
        dos.writeBoolean(true);
        byte[] datas = baos.toByteArray();
        // 读取
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(datas));
        String msg = dis.readUTF();
        Double d = dis.readDouble();
        Boolean b = dis.readBoolean();
        System.out.println(msg);
    }
}
