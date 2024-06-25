package sec07;

import java.io.IOException;

/**
 * 클래스 상속관계, 집합(포함)관계
 *
 * 상속관계: is-a (-은-이다.)
 * 집합관계: has-a(-은-을 가진다.)
 *
 * 원은 모양이다.
 * 사각형은 모양이다.(상속)
 * 원은 점이다.
 * 원은 점을 포함한다.(집합)
 *
 * 상속의 이유
 * 코드의 재사용
 * 다형성
 */

public class _info {
    public static void main(String[] args) throws IOException {
        B b = new B();
        //try {
          b.method();
        //} catch (IOException e) {}

        Circle c = new Circle();
        c.draw();

        A1 a1 = new B1();
        a1.sayA1();
        A1 a2 = new C1();
        ((C1)a2).sayC1();
        A1 a3 = new D1();
        a3.sayA1();
        A1 a4 = new E1();
        a4.sayA1();

        A1[] arr = {a1, a2, a3, a4};
        for(A1 a : arr) {
            a.sayA1();
            if(a instanceof B1) {
                ((B1)a).sayA1();
            }

            if(a instanceof C1) {
                ((C1)a).sayC1();
            }

            if(a instanceof D1) {
                ((D1)a).sayD1();
            }

            if(a instanceof E1) {
                ((E1)a).sayE1();
            }
        }
        System.out.println("===================================");

        Car car = new Car();
        for(int i = 1; i <= 5; i++) {
            int problemLocation = car.run();
            System.out.println(problemLocation);

            switch (problemLocation) {
                case 1:
                    System.out.println("앞왼쪽 HankookTire로 교체");
                    car.frontLeftTire = new HankookTire("앞왼쪽", 15);
                    break;
                case 2:
                    System.out.println("앞오른쪽 KumhoTire로 교체");
                    car.frontRightTire = new KumhoTire("앞오른쪽", 13);
                    break;
                case 3:
                    System.out.println("뒤왼쪽 HankookTire로 교체");
                    car.backLeftTire = new HankookTire("뒤왼쪽", 14);
                    break;
                case 4:
                    System.out.println("뒤오른쪽 KumhoTire로 교체");
                    car.backRightTire = new KumhoTire("뒤오른쪽", 17);
                    break;
                default:
                    break;
            }
            System.out.println("----------------------------");
        }

    }
}

//class A {
//    static int s = 100;
//    private int a = 7;
//    A() {}
//    int method()  throws IOException  {
//        System.out.println("A method" + a);
//        return 10;
//    }
//}
//
class B extends A {
    B() {
        super();
    }

    @Override //애너테이션
    public int method() {
        System.out.println(A.s);
        int a = super.method();
        System.out.println("B method" + a);
        return a;
    }
}

class Circle extends Shape {
    Point o = new Point(100,20);
    Circle() {
        super("blue");
    }
    @Override
    void draw() {
        super.draw();
        System.out.println("Circle");
    }
}

class Point {
    int x;
    int y;

    Point() {}
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Shape {
    String color = "red";
    Shape() {
        this("red");
    }
    Shape(String color) {
        this.color = color;
    }
    void draw() {
        System.out.println(color);
    }
}

class A1{
    void sayA1() {
        System.out.println("say A1");
    }
}

class B1 extends A1{
    @Override
    void sayA1() {
        System.out.println("say B1");
    }
}
class C1 extends A1{
    void sayC1() {
        System.out.println("say C1");
    }
}

class D1 extends B1{
    void sayD1() {
        System.out.println("say D1");
    }
}
class E1 extends C1{
    void sayE1() {
        System.out.println("say E1");
    }
}

class House {
    Man[] mans;

    House() {}

    void enterHouse(Man[] mans) {
        this.mans = mans;
        for(Man m : mans) {
            System.out.println(m.getName());
        }
    }

    public static void main(String[] args) {
        Man hong = new Hong("홍길동");
        Man son = new Son("손오공");

        House home = new House();
        home.enterHouse(new Man[] {hong, son});


    }
}

class Man {
    String name;

    Man(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Hong extends Man {
    Hong(String name) {
        super(name);
    }
}
class Son extends Man {
    Son(String name) {
        super(name);
    }
}

class Animal {}

class Dog extends Animal {}
class Cat extends Animal {}
