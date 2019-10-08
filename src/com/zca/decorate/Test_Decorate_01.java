package com.zca.decorate;

public class Test_Decorate_01 {
    public static void main(String[] args) {
        Person p = new Person();
        p.say();

        Amplifier am = new Amplifier(p);
        am.say();
    }
}

interface Say{
    void say();
}

class Person implements Say{

    // 属性
    private int voice = 10;

    @Override
    public void say() {
        System.out.println("人的声音为：" + voice + "分呗");
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }
}

class Amplifier implements Say{

    private Person p;

    public Amplifier(Person p) {
        this.p = p;
    }

    @Override
    public void say() {
        System.out.println("人的声音为：" + p.getVoice()*10 + "分呗");
        System.out.println("此乃噪音");
    }
}