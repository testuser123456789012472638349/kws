package sec05;

/*
 * 기본타입은 데이터가 직접 메모리에 저장 - 값에 의한 저장(참조)
 *  - 하나만 저장
 * 참조타입은 데이터가 힙에 저장되고 힙의 주소를 메모리에 저장 - 주소에 의한 저장(참조)
 *
 * 스택: 프로그램 순서(메서드)를 저장하는 메모리 - 선입후출(FILO)
 *
 * ==, !=: 주소를 비교(값의 비교가 아님)
 *
 *
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static java.lang.reflect.Array.*;

public class _info {
    public static void main(String[] args) {
        /* 기본, 참조 타입의 차이점 */
        //배열의 이름만 사용하면 힙에 저장된 배열의 주소
        System.out.println(args);
        //char 배열만 저장된 내용을 표시
        char[] myChar = {'A', 'B', 'C', 'D'};
        System.out.println(myChar);

//        System.out.println(args[0]);
//        System.out.println(args[1]);
//        System.out.println(args[2]);

//        if(args.length != 1) {
//            System.out.println("나이를 입력하세요.");
//            return;
//        } else {
//            try {
//                int age = Integer.parseInt(args[0]);
//                if(age >= 18) System.out.println("통과");
//                else System.out.println("미통과");
//                return;
//            } catch (Exception e) {
//                System.out.println("숫자만 입력하세요.");
//                return;
//            }
//
//        }

        int pValue1 = 7;
        int pValue2 = pValue1;

        MyObject oValue1 = new MyObject();
        oValue1.P = 10;
        MyObject oValue2 = oValue1;

        System.out.println(pValue1 + " : " + pValue2); // 7, 7
        pValue2 = 4;
        System.out.println(pValue1 + " : " + pValue2); // 7, 4

        System.out.println(oValue1.P + " : " + oValue2.P); // 10, 10
        oValue2.P = 88;
        System.out.println(oValue1.P + " : " + oValue2.P); // 88, 88
        /**/

        /* 스택 구조
        System.out.println("Main 시작");
        firstMethod();
        System.out.println("Main 끝");
        */

        /* ==, != 비교(주소) */

        pValue1 = 2;
        pValue2 = 2;
        System.out.println(pValue1 == pValue2);

        MyObject m1 = new MyObject();
        MyObject m2 = new MyObject();
        MyObject m3 = null;
        System.out.println(m1 == m2);
        System.out.println(m1.equals(m2)); //false  --> true;
        System.out.println("-------------------------");
        System.out.println(m3 == m2); //false
        // System.out.println(m3.equals(m2)); Error

        int[] a = null;
        System.out.println(a); //null
        a = new int[5];
        a[0] = 3;
        System.out.println(a[0]); //3
        System.out.println("-------------------------");

        //java 배열을 사용하려면 크기를 먼저 선언
        int[] arr = null;
        // arr = new int[i];
        arr = new int[5]; //크기 지정
        if(arr != null) {
            arr[0] = 7;
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 3;
            arr[4] = 4;
            //arr[5] = 6; //Error(out of bounds for length)
            System.out.println(arr[0]);
        }

        int[] ex = {1, 5, 5, 7};
        ex = new int[3];
        ex = new int[] {2, 5, 6, 7};

        arr = new int[10];
        System.out.println(arr[0]);

        System.out.println("-------------------------");
        String s1 = new String("A");
        String s2 = new String("A");
        System.out.println(s1 == s2); //false
        System.out.println(s1.equals(s2)); //true

        System.out.println("-------------------------");
        String strVar1 = "신민철";
        String strVar2 = "신민철";

        if(strVar1 == strVar2) {
            System.out.println("strVar1과 strVar2는 참조가 같음");
        } else {
            System.out.println("strVar1과 strVar2는 참조가 다름");
        }

        if(strVar1.equals(strVar2)) {
            System.out.println("strVar1과 strVar2는 문자열이 같음");
        }
        System.out.println("-------------------------");
        String strVar3 = new String("신민철");
        String strVar4 = new String("신민철");

        if(strVar3 == strVar4) {
            System.out.println("strVar3과 strVar4는 참조가 같음");
        } else {
            System.out.println("strVar3과 strVar4는 참조가 다름");
        }

        if(strVar3.equals(strVar4)) {
            System.out.println("strVar1과 strVar2는 문자열이 같음");
        }
        int[] scores = {83, 90, 87};
//        _info myInfo = new _info(); //클래스 => 객체(인스턴스)
//        int sum = myInfo.add(scores);

        int sum = add(scores); //static 생성 후 _info.(객체 or 인스턴스 삭제 가능)
        System.out.println(sum);

        sum = add(new int[] {5, 8, 9, 8, 9});
        System.out.println(sum);
//        int sum = 0;
//        for(int i = 0; i < scores.length; i++) {
//            sum += scores[i];
//        }
//        System.out.println(sum);

        //배열의 크기가 고정되므로 크기를 조절하기 위해 설정
        //기존 내용을 유지하면서 크기를 조절하는 함수
        //배열의 내용을 표시하는데 마지막 쉼표는 제거
        //배열의 처음은 [ 배열의 끝은 ]

        //배열의 값 중 최고, 최소 값을 표시
        //랜덤
        for(int i = 0; i < 10; i++) {
            System.out.println((int)(Math.random() * 10));
        }

        int[] arr1 = new int[] {1, 2, 3};
        printArray(arr1);

        arr = new int[7];
        printArray(arr);

        arr = changeLen(arr, 100);
        printArray(arr);

        Maxminprice(arr1);

        //배열 섞기
        int[] ten = new int[100];
        for(int i = 0; i < ten.length; i++) {
            ten[i] = i + 1;
        }
        printArray(ten);

        //섞기
//        for(int i = 0; i < 100000; i++) {
//            int temp = (int)(Math.random() * ten.length);
//            int first = ten[0];
//            ten[0] = ten[temp];
//            ten[temp] = first;
//        }

        ten = mixArray(ten);

        printArray(ten);

        //로또
        int lotto[] = new int[6];
        System.out.println("로또 번호");
        for(int i = 0; i < lotto.length; i++) {
            int num = (int)(Math.random() * 45) + 1;
            int count = 1;
            lotto[i] = num;
            for(int j = 0; j < i; j++) {
                ++count;
                if(lotto[i] == lotto[j]) {
                    i--;
                    break;
                }
            }
            System.out.println("로또 번호" + "[" + count + "번] : " + lotto[i]);
        }

        //정렬
        Arrays.sort(ten);
        printArray(ten);
    }

    static int[] mixArray(int[] arr) {
        for(int i = 0; i < arr.length * 2; i++) {
            int temp = (int)(Math.random() * arr.length);
            int first = arr[0];
            arr[0] = arr[temp];
            arr[temp] = first;
        }
        return arr;
    }

    static int[] Maxminprice(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("min: " + min + "  max: " + max);
        return arr;
    }

    static int[] changeLen(int[] arr, int size) {
        int[] temp = new int[size];

        for(int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }

    static void printArray(int[] arr) {
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.printf("[%d, ", arr[i]);
            } else if (i == arr.length - 1) {
                System.out.printf("%d] ", arr[i]);
            } else {
                System.out.printf("%d, ", arr[i]);
            }
        }
        System.out.println();
    }


    static int add(int[] scores) { //인스턴스 메서드
        int sum = 0;
        for(int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return sum;
    }

    static void firstMethod() {
        System.out.println("firstMethod 시작");
        secondMethod();
        System.out.println("firstMethod 끝");
    }

    static void secondMethod() {
        System.out.println("secondMethod 시작");
        System.out.println("secondMethod 끝");
    }
}

class MyObject {
    int P = 0; //맴버 변수(속성)

    @Override
    public boolean equals(Object obj) {
        MyObject temp = (MyObject)obj;
        System.out.println("MyObject equals: " + (this.P == temp.P));
        return this.P == temp.P;
    }
}