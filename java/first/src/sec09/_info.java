package sec09;

import java.awt.*;
import java.awt.event.*;
/**
 * 익명 객체
 * - 선언과 생성이 동시에 일어어남. (조상 객체나 인터페이스를 이용)
 * - 단 하나의 클래스나 인터페이스를 구현함.
 * - 일회용
 *
 * JUnit - 단위 테스트용 프레임워크
 */
public class _info {
    public static void main(String[] args) {
        A a = new A();
        A.B ab = a.new B();
        System.out.println(ab.field1);
        ab.method1();

        a.methodA();

        A.C ac = new A.C();
        ac.method2();

        a.mehotdLocal();

        Outter o = new Outter();
        o.method1(7);
    }
}

class A {
    //캡슐화
    class B {
        B() {}
        int field1;
        void method1() {
            System.out.println("A.B method1");
        }
    }

    static class C {
        C() {}
        int field2;
        void method2() {
            System.out.println("A.C method2");
        }
    }

    void methodA() {
        B b = new B();
        b.method1();

        C ac = new C();
        ac.method2();
    }
    void mehotdLocal() {
        class D {
            D() {}
            int field1;
            void mehotd1() {
                System.out.println("D mehotd1");
            }
        }

        D d = new D();
        d.mehotd1();
        d.field1 = 100;
        System.out.println(d.field1);
    }


}


class A2 {
    B field1 = new B();
    C field2 = new C();

    void method1() {
        B var1 = new B();
        C var2 = new C();
    }

    // static B field3 = new B();
    static C field4 = new C();

    static void method2() {
        // B b = new B();
        C c = new C();
    }

    class B {}
    static class C {}
}

class Outter {
    int value = 10;

    void method1(final int arg) {
        int localVariable = 1;

        class Inner {
            int value = 20;

            void mehtod() {
                int value = 30;
                // localVariable = 34;
                int result = arg + localVariable;
                System.out.println(result);

                System.out.println("outter value: " + Outter.this.value);
                System.out.println("Inner value: " + this.value);
                System.out.println("Inner method value: " + value);
            }
        }

        Inner i = new Inner();
        i.mehtod();
    }
}

class Person {
    void wake() {
        System.out.println("7시에 일어납니다.");
    }
}

class Anonymous {
    Person field = new Person() {
        void work() {
            System.out.println("출근합니다.");
        }
        @Override
        void wake() {
            System.out.println("6시에 일어납니다.");
            work();
        }
    };

    void method2(Person person) {
        person.wake();
    }

    public static void main(String[] args) {
        Anonymous anony = new Anonymous();
        anony.field.wake();
        anony.method2(new Person() {
            void study() {
                System.out.println("공부합니다.");
            }
            @Override
            void wake() {
                System.out.println("8시 일어납니다.");
                study();
            }
        });

        Frame f = new Frame();
        Button b = new Button("Click");

        f.setVisible(true);
        f.setSize(300, 250);
        f.setLayout(null);
        b.setLocation(new Point(100, 100));
        b.setSize(100, 50);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("click");
            }
        });
        f.add(b);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().setVisible(false);
                e.getWindow().dispose();
                System.out.println("exit");
                System.exit(0);
            }
        });
    }
}