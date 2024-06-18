package sec00.exam01;

// public 클래스 이름과 파일 이름은 같아야 한다.
// 한 파일에 무제한의 클래스를 생성

/*
 * 변수: 하나의 값만 저장하는 메모리 공간
 * 변수의 선언: 변수를 사용하기전 이름을 지정 - 타입 변수명;
 * int age;
 *
 * 변수의 초기화 - 변수를 사용하기 전에 처음 값을 지정하는 것
 * age = 12;
 * int height = 177;
 *
 * 변수의 이름 규칙
 * 1. 대소문자 구분이 있고 길이의 제한이 없다.
 * 2. 예약어를 사용하지 못해. long, longMyValue, long1
 * 3. 숫자나 특수문자로 시작하지 못함.
 * 4. $, _
 *
 * 관례
 * 1. 클래스의 이름은 대문자로 시작
 * 2. 여러 단어로 되어 있으면 카멜표기법(priceRate) 사용
 * 3. 상수 모두 대문자 새로운 단어는 _를 사용, PRICE_RATE
 */

public class First {
    public static void main(String[] args) {
        int v1 = 15; //로컬 변수 v1
        int v2 = 0;

        if(v1 > 10) {
            // int v2;
            v2 = v1 - 10;
            System.out.println(v2);
        }

        int v3 = v1 + v2 + 5;
        System.out.println(v3);


    }
}
/**
 * <h1 style='color:red'>TEST</h1>
 *
 * <marquee>test</marquee>
 *
 * */

/*
 * <h1>test</h1>
 *
 *
 * */

// 클래스는 변수의 타입
class Test {
    //멤버 변수
    static int x = 7;

    public void toSay() {
        // int x = 14; //로컬 변수
        System.out.println("Hi");
        System.out.println(x);
    }
    // alt + enter - 디버깅용
    // shift + f10 - 메모리의 메인 실행
    // ctrl + shift + f10 - 메인의 위치 변경
    public static void main(String[] args) {

        // int x = 3;
        int y = 5;
        int temp = x;
        System.out.println(x + " : " + y);

        x = y;
        y = temp;

        System.out.println(x + " : " + y);
    }
}