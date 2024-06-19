package sec02;


//java.lang - 자동 import

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 02-2 기본 타입
 * 변수 - 문자타입, 숫자타입 - 정수, 실수
 * 기본형 - 순수 값을 저장, 참조형 - 값의 주소를 저장
 * 논리형 - boolean(1byte)
 * 문자형 - char(2byte)
 * 숫자형 - byte(1byte), short(2byte), int(4byte) - 기본, long(8byte)
 * 실수형 - float(4byte), double(8byte) - 기본
 *
 * 상수(const)
 * final 타입 대문자_ = 10;
 *
 * 리터럴(literal) - 순수 값
 * 접두사 - 2진수: 0b(0B), 8진수: 0, 16진수: 0x(0X)
 * 접미사 - long: l(L), float: f(F)
 *
 * 실수 - e(E) 지수표기
 *
 * String 객체(문자열)
 * 속성, 메서드
 *
 * 이스케이프 문자: 문자열에서 특수 문자를 사용
 *
 * 오버플러워(Overflower) - 연산에서 경계를 넘는 값을 처리
 *
 * 02-3 타입의 크기
 * byte(boolean) < short(char) < int < long < float < double
 *
 * 타입 변환
 * 작은 타입을 큰 타입에는 자동 변환
 * 큰 타입을 작은 타입에 넣기 위해서는 설정이 필요(강제 변환)
 *
 *
 * int보다 작은 타입의 연산의 결과는 int
 * long과의 연산의 결과는 long
 *
 *
 * 컴파일 단계 - 바이너리 파일(.class)을 만들기 위한 단계
 * 런타임 단계 - 자바 가상 머진(JVM)에 의해 작동되는 단계
 *
 * 02-4 변수와 시스템 입출력
 * 표준 입출력 - System.out(출력), System.in(입력)
 * 형식화된 문자열
 * %b - boolean
 * %d - 10진수
 * %o - 8진수
 * %x, %X - 16진수
 * %f, %F - float
 * %e, %E - 지수
 * %c - 문자
 * %s - 문자열
 */


public class _Info {
    public static void main(String[] args) throws IOException {
        /* 변수의 타입과 변환 시작
        final short TO_DATE = -129;

        // TO_DATE = 77;

        System.out.println(TO_DATE);

        long myLong = 30000000000L;

        float myFloat = 3.14F;

        int hexA = 0x41;
        int decA = 65;
        int octA = 0101;
        int binA = 0b01000001;
        char charA = 'A';
        char charUA = '\u0041';

        System.out.println(hexA);
        System.out.println(decA);
        System.out.println(octA);
        System.out.println(binA);
        System.out.println((char)hexA);
        System.out.println((char)decA);
        System.out.println((char)octA);
        System.out.println((char)binA);
        System.out.println(charA);
        System.out.println((int)charA);
        System.out.println(charUA);

        for(int i = 0; i < 65536; i++) {
            System.out.println(i + ": " + (char)i);
        }

        String str = "나는\t \"자바\"를 좋아합니다.";
        System.out.println(str);

        byte minByte = -128;
        byte maxByte = 127;

        //오버플로워 처리
        System.out.println((byte)(minByte - 1)); // 127
        System.out.println((byte)(maxByte + 1)); //-128

        long longValue = 50000000000L;
        System.out.println(longValue);
        float floatValue = longValue;
        System.out.println(floatValue);
        double doubleValue = longValue;
        System.out.println(doubleValue);

        System.out.println(longValue == floatValue);
        System.out.println(longValue == doubleValue);

        int intValue = 10;
        //엄격한 언어
        byte byteValue = (byte) intValue;
        System.out.println(byteValue);

        byte x = 10;
        byte y = 10;
        byte result = (byte)(x + y);
        System.out.println(result);

        char c = 'c';
        char d = 'd';
        int e = c + d;
        System.out.println(c);
        System.out.println(e);
        System.out.println((char)e);

        byte bValue = 10 + 29;
        System.out.println(bValue);

        byte thou = (byte)1000L;
        System.out.println(thou);

        float myValue = 1.5F + 1.7f;
        System.out.println(myValue);

        double myValue2 = 1.5F + 1.7;
        System.out.println(myValue2);

        int intX = 1;
        int intY = 2;
        System.out.println((intX / (float)intY));

        double d2 = 85.7;
        int i2 = (int)d2;
        double d3 = i2;
        System.out.println(d2);
        System.out.println(i2);
        System.out.println(d3);

        // 실수형은 정밀도 - double는 float 2배의 정밀도
        float f = 9.1234567f;
        double d4 = 9.1234567;
        System.out.println(f);
        System.out.println(d4);
        System.out.println(0.1 + 0.2);

        BigDecimal num1 = new BigDecimal(String.valueOf(0.1));
        BigDecimal num2 = new BigDecimal(String.valueOf(0.2));
        System.out.println(num1.add(num2));

        //기본타입의 객체들이 존재
        String str1 = "10";
        System.out.println(Integer.parseInt(str1));
        System.out.println(Byte.parseByte(str1));
        System.out.println(Boolean.parseBoolean(str1));
        변수의 타입과 변환 끝 */

        /*변수와 시스텝 입출력 시작
        System.out.printf("이름: %1$s, 나이: %2$d%n", "홍길동", 25);

        byte b = 1;
        short s = 2;
        char c = 'A';
        int i = 10;
        long l = 100_000_000_000L;
        long hex = 0xFFFF_FFFF_FFFF_FFFFL;
        int oct = 010;
        int h = 0x10;
        int bin = 0b10;

        System.out.printf("%d%n", b);
        System.out.printf("%d%n", s);
        System.out.printf("%d%n", (int)c);
        System.out.printf("%d%n", i);
        System.out.printf("%d%n", l);
        System.out.printf("%d%n", hex);
        System.out.printf("%d%n", oct);
        System.out.printf("%d%n", h);
        System.out.printf("%d%n", bin);

        System.out.printf("%o%n", b);
        System.out.printf("[%-5o]%n", s);
        System.out.printf("%o%n", (int)c);
        System.out.printf("%o%n", i);
        System.out.printf("%o%n", l);
        System.out.printf("%o%n", hex);
        System.out.printf("%o%n", oct);
        System.out.printf("%o%n", h);
        System.out.printf("%o%n", bin);

        System.out.printf("%x%n", b);
        System.out.printf("%x%n", s);
        System.out.printf("%x%n", (int)c);
        System.out.printf("%x%n", i);
        System.out.printf("%x%n", l);
        System.out.printf("%x%n", hex);
        System.out.printf("%x%n", oct);
        System.out.printf("%x%n", h);
        System.out.printf("%x%n", bin);

        // int keyCode;

        // while(true) {
        //     keyCode = System.in.read();
        //     System.out.printf("%d: %c\n", keyCode, (char)keyCode);

        //     if(keyCode == 113) {
        //         break;
        //     }
        // }

        Scanner scanner = new Scanner(System.in, "UTF-8")   ;
        String inputData = scanner.nextLine();
        System.out.println(inputData);
        //기본 타입 비교 ==
        System.out.println(inputData == "A"); //false
        //객체(참조) 타입 비교 equals
        System.out.println(inputData.equals("A")); //true
        scanner.close();

        // for(int ci = 0; ci < 123; ci++) {
        //     System.out.println(ci + ": " + (char)ci);
        // }

        System.out.println("A" == "A");
        String s1 = "A";
        System.out.println("A" == s1);
        String s2 = new String("A");
        System.out.println(s2);
        System.out.println(s1 == s2); //false
        //객체를 비교할 때는 Object객체의 equalus메서드를 사용
        System.out.println(s1.equals(s2)); //true

        변수와 시스텝 입출력 끝 */

        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                System.out.print("몸무게 입력: ");
                float weight = Float.parseFloat(scanner.nextLine());
                System.out.print("신장 입력: ");
                float height = Float.parseFloat(scanner.nextLine());

                // System.out.println(weight + " : " + height);

                float standard = 0;

                if(height >= 160) {
                    standard = (height - 100) * 0.9f;
                } else if(height >= 150 && height <= 159) {
                    standard = (height - 150) * 0.5f + 50;
                } else {
                    standard = height - 100;
                }

                float fBmi = (weight - standard) / standard * 100;
                String sBmi = "";
                // System.out.println(standard);
                if(fBmi < 10) {
                    sBmi = "정상";
                } else if(fBmi >= 10 && fBmi <= 20) {
                    sBmi = "과체중";
                } else if(fBmi > 20 && fBmi <= 30) {
                    sBmi = "경도비만";
                } else if(fBmi > 30 && fBmi <= 50) {
                    sBmi = "중등도 비만";
                } else {
                    sBmi = "고도비만";
                }

                System.out.printf("신장 %3.2f에 따른 표준체중은 %3.2f입니다.\n", height, standard);
                System.out.printf("BMI: %3.0f%% / 결과: %s", fBmi, sBmi);

                System.out.println();
                System.out.println();
            } catch(Exception e) {
                break;
            }
        }


        // scanner.close();
    }
}