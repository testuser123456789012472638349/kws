package sec06;

import java.util.Arrays;
import java.util.Calendar;

/**
 * 생성자 - 클래스 이름과 같고, 반환 타입이 없음, 자동으로 실행됨, 생성자가 없으면 JVM이 자동으로 추가(사용자가 하나라도 만들면 자동추가 하지 않음)
 * 목적: 필드의 값을 초기화할 때 사용
 *
 * 메서드 오버라이딩 - 상속된 객체의 메소드를 새로 정의
 * 메서드 오버로딩 - 하나의 객체 안의 메소드를 여러개 작성(메서드의 이름 같아야 하나 매개변수의 개수나 타입, 순서가 다름.)
 *
 * 매개변수의 값이 기본타입, 참조타입
 *
 * 객체마다 각각 가지는 값은 인스턴스(instance)
 * 모든 객체가 같이 가지는 값은 스테틱(static)
 */

public class _info {
    public static void main(String[] args) {

        // Car myCar = new Car("S", "R");
        // // myCar.company = "BMW";
        // Car yourCar = new Car();

        // System.out.println(myCar);
        // System.out.println(yourCar);

        // Car[] arrCars = new Car[5]; //Car 배열 선언

        // for(int i = 0; i < arrCars.length; i++) {
        //     arrCars[i] = new Car(); //Car 초기화
        // }

        // System.out.println(Arrays.toString(arrCars));

        //기본타입
        Car car = new Car();
        car.year = 2024;
        System.out.println(car.year); //2024
        car.changeYear(car.year); //3024
        System.out.println(car.year); //2024

        //참조타입
        System.out.println(car.year); //2024
        car.changeYear(car); //3024
        System.out.println(car.year); //3024

        int[] x = {10};

        System.out.println(x[0]); //10
        change(x); //7
        System.out.println(x[0]); //7

        System.out.println(Math.min(100, 20));

        // Car.showYear();
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        // car1.showTier(); //4
        // car2.showTier(); //4
        // car3.showTier(); //4

        // Car.tire = 7;

        // car1.showTier(); //7
        // car2.showTier(); //7
        // car3.showTier(); //7

        Tire t1 = Tire.getInstance();
        Tire t2 = Tire.getInstance();
        Tire t3 = Tire.getInstance();
        Tire t4 = Tire.getInstance();
        System.out.println(t1 == t2);
        System.out.println(t1.equals(t2));
    }

    static void change(int[] x) {
        x[0] = 7;
        System.out.println(x[0]);
        System.out.println(Car.MY_CONST);
    }
}

class Car extends Object {
    String company = "BMW"; //null - 필드, 속성, 멤버 변수
    String color;
    int year;

    //상수
    static final int MY_CONST = 7;

    Calendar c = Calendar.getInstance();
    Calendar b = Calendar.getInstance();

    static int tire = 4;

    void showTier() {
        System.out.println(c == b);
        System.out.println(c.equals(b));
        System.out.println(Math.PI);
        System.out.println(tire);
    }

    // static void showYear() {
    //     System.out.println(year);
    // }

    void changeYear(int year) { //기본타입
        year += 1000;
        System.out.println(year);
    }

    void changeYear(Car car) { //참조타입
        car.year += 1000;
        System.out.println(car.year);
    }

    //오버 로딩
    Car() {
        this("S", "R");
    }
    Car(String company) {
        this(company, "B");
    }
    Car(String company, int year) {
        this(company);
        this.year = year;
    }
    Car(int year, String company) {
        this(company);
        this.year = year;
    }
    Car(String company, String color) {
        this.company = company;
        this.color = color;
        System.out.println("Car 생성자");
    } //생성자


    @Override
    public String toString() {
        String model = "TTS"; //로컬변수, 지역변수 - 초기화가 안됨

        return company + "\nm:" + model + "\nc:" + color;
    }
}
//싱글톤
class Tire {
    private static Tire singleton = new Tire();

    private Tire() {}

    static Tire getInstance() {
        return singleton;
    }
}