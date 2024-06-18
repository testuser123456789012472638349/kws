package sec02;

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
 * 타입의 크기
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
 * 런타임 단계 - 자바 가상머신(JVM)에 의해 작동되는 단계
 */



 public class _Info {
    public static void main(String[] args) {
        final short To_DATE = -129;

        // To_DATE = 77;

        System.out.println(To_DATE);

        byte minByte = -128;
        byte maxByte = 127;
        //오버플로워 처리
        System.out.println((byte)(minByte - 1)); //127
        System.out.println((byte)(maxByte + 1)); //-128
    }
}
