package com.zca.test_IO;

import java.io.*;

/**
 * 对象流
 * 1.先写入后读取
 * 2.读取的顺序和写出的顺序保持一致
 * 3.不是所有的对象都可以序列化,想要序列化必须实现Serializable
 * @author Altria
 */
public class TestObjectStream_01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
        oos.writeUTF("不知道为什么会报错");
        oos.writeObject("添加一个自定义类");    // String类已经实现了Serializable类
        oos.writeObject(new Employee("周晨安", 4500.0));   // 如果没有实现就会报错NotSerializableException
        oos.flush();    // 如果不添加flush,会报错EOFException
        byte[] datas = baos.toByteArray();
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
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
    }
}

class Employee implements java.io.Serializable{
    String name;
    Double salary;

    public Employee(){
    }
    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "name:" + name + " salary:" + salary;
    }
}
