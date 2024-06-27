package sec08;

/**
 * 인터페이스의 멤버로는 필수(상수), 메서드(추상메서드) 자동으로 변경
 * 인터페이스는 인터페이스를 다중상속할 수 있다.
 * 인터페이스를 사용하는 클래스는 인터페이스를 구현한다고 표현.
 *
 * 클래스가 두 개인 경우 중요한 것은 상속을 받고 덜 중요한 것은 인터페이스를 이용하여 다중상속을 구현
 */

public class _info {
    public static void main(String[] args) {

        D d = new D();
        d.methodA();
        d.methodB();
        System.out.println(d.b);

        Object tv = new Television();

        if(tv instanceof Object) {
            System.out.println("Tv is Object");
        }

        if(tv instanceof Machine) {
            System.out.println("Tv is Machien");
        }

        if(tv instanceof Plastic) {
            System.out.println("Tv is Plastic");
        }

        if(tv instanceof RemoteControl2) {
            System.out.println("Tv is RemoteControl2");
            RemoteControl2 rc = ((RemoteControl2)tv);
            rc.setVolume(100);
        }

        if(tv instanceof Television) {
            System.out.println("Tv is Television");
        }

        RemoteControl2 rc2 = new Audio();
        if(rc2 instanceof Audio) {
            rc2.turnOn();
        }
        rc2 = new Television();
        if(rc2 instanceof Television) {
            rc2.turnOn();
        }
    }
}

interface Machine {
    boolean power = true;

    void onPower();
}

interface Plastic {
    String type = "plastic";
}

interface RemoteControl2 extends Machine, Plastic {
    /*public static final*/ int MAX_VOLUME = 10;
    public static final int MIN_VOLUME = 0;

    /*public abstract*/ void turnOn();
    public abstract void turnOff();
    void setVolume(int volume);

    //JDK 1.8이후 부터 사용 - default, static 메서드 사용
    default void somthing() {}
    static void somthing2() {}
}

//인터페이스는 다중 구현 가능
class Television extends Object implements RemoteControl2 {
    @Override
    public void turnOn() {
        System.out.println("TV ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TV OFF");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("TV volume");
    }

    @Override
    public void onPower() {
        System.out.println("Tv power");
    }
}

class Audio extends Object implements RemoteControl2 {
    @Override
    public void turnOn() {
        System.out.println("Audio ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Audio OFF");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("Audio volume");
    }

    @Override
    public void onPower() {
        System.out.println("Audio power");
    }
}

class A {
    int a;
    void methodA() {
        System.out.println("methodA");
    }
}
class B {
    int b = 100;
    void methodB() {
        System.out.println("methodB");
    }
}
/* 인터페이스는 접두사로 I-로시작하거나 접미사로 -able을 붙임*/
interface IB {
    int b = new B().b;
    void methodB();
}
class D extends A implements IB {
    B cB = new B();

    public void methodB() {
        cB.methodB();
    }
}

/**
 * 인터페이스의 장점
 * - 표준화가 가능
 * - 객체들의 관계 성립
 * - 독립적으로 프로그램 개발(개발 시간 단축)
 */

// mp4, avi, mov....

interface Parserable {
    int parse();
}

class ParserManager {
    public static Parserable getParser(String ext) {
        if(ext.equals("MP4")) {
            return new Mp4Parser(ext);
        } else {
            return new AviParser(ext);
        }
    }
}

class Mp4Parser implements Parserable {
    String ext;

    Mp4Parser(String ext) {
        this.ext = ext;
    }

    public int parse() {
        System.out.println(ext + "재생");
        return 100;
    }
}

class AviParser implements Parserable, IobjB {
    String ext;

    AviParser(String ext) {
        this.ext = ext;
    }

    public int parse() {
        System.out.println(ext + "재생");
        return 100;
    }

    public void methodB() {
        System.out.println("Avi의 methodB");
    }
}

class Player {
    public static void main(String[] args) {
        Parserable parser = ParserManager.getParser("MP4");
        parser.parse();
        parser = ParserManager.getParser("AVI");
        parser.parse();

        objA a = new objA();
        a.useObjB(new objB());
        a.useObjB(new AviParser("MP4"));

        IobjB[] ib = {new objB(), new objD(), new objC(), new AviParser("test")};

        for(IobjB b : ib) {
            b.methodB();
        }

        IobjB cb = new childB();
        cb.methodB();
    }
}

//사용하는 클래스, 제공 클래스

//사용하는 클래스
class objA {
    public void useObjB(IobjB b) {
        b.methodB();
    }
}

interface IobjB {
    void methodB();
}

//제공 클래스
class objB implements IobjB {
    public void methodB() {
        System.out.println("methodB");
    }
}

class childB extends objB {

}

class objC implements IobjB {
    public void methodB() {
        System.out.println("methodC");
    }
}

class objD implements IobjB {
    public void methodB() {
        System.out.println("methodD");
    }
}
