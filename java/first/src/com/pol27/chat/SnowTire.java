package com.pol27.chat;

import sec07.*;

public class SnowTire extends A {
    public SnowTire() {
        super(); //상속 후에는 부모의 생성자를 실행
        System.out.println("SnowTire");
        super.method();
    }

    public static void main(String[] args) {
        DmbCellPhone aa = new DmbCellPhone("자바폰", "검정", 3);

        System.out.println("model" + aa.model);
        System.out.println("color" + aa.color);

        System.out.println("channel" + aa.channel);

        aa.powerOn();
        aa.turnOnDmb();
    }
}



class CellPhone {
    String model;
    String color;

    void powerOn() {
        System.out.println("On power");
    }
}

class DmbCellPhone extends CellPhone {
    int channel;

    DmbCellPhone(String model, String color, int channel) {
        this.model = model;
        this.color = color;
        this.channel = channel;
    }

    void turnOnDmb() {
        System.out.println("channel" + channel + "start");
    }
}

class People {
    public String name;
    public String ssn;

    //People() {}

    People(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }
}

class Student extends People {
    public int studentNo;

    Student(String name, String ssn, int studentNo) {
        super(name, ssn);
        this.studentNo = studentNo;
    }
}

