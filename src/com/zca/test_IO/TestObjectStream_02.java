package com.zca.test_IO;

import java.io.*;

/**
 * 将文件序列化
 * @author Altria
 */
public class TestObjectStream_02 {
    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("abc.txt")));) {
            oos.writeUTF("不知道为什么会报错");
            oos.writeObject("添加一个自定义类");    // String类已经实现了Serializable类
            oos.writeObject(new Employee("周晨安", 4500.0));   // 如果没有实现就会报错NotSerializableException
            oos.flush();    // 如果不添加flush,会报错EOFException
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("abc.txt")));) {
            String str = ois.readUTF();
            Object msg = ois.readObject();
            Object emp = ois.readObject();
            System.out.println(str);
            if (msg instanceof String){
                String strObj = (String) msg;
                System.out.println(strObj);
            }
            if (emp instanceof Employee){
                Employee empObj = (Employee) emp;
                System.out.println(empObj.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
