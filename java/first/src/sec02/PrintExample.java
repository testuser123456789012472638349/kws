package sec02;

public class PrintExample {
    public static void main(String[] args) {
        int value = 123;
        System.out.printf("상품의 가격:%d원\n", value);
        System.out.printf("상품의 가격:%6d원\n", value);
        System.out.printf("상품의 가격:%-6d원\n", value);
        System.out.printf("상품의 가격:%06d원\n", value);

        double area = 3.14159 * 10 * 10;
        System.out.printf("반지름이 %d인 원의 넓이:%10.2f\n", 10, area);

        String name = "홍길동";
        String job = "도적";
        System.out.printf("%6d | %-10s | %10s\n", 1, name, job);

        /*
        * 지시자의 종류와 역할
        * %b : boolean
        * %d : 10진수
        * %o : 8진수
        * %x, %X : 16진수
        * %c : 문자
        * %s : 문자열
        * %n : 줄 바꿈
        *
        * 플래그의 종류와 역할
        * - : 왼쪽 정렬
        * + : +, - 부호 출력
        * 공백(’ ‘) : 음수일 때만 부호 출력
        * 0 : 남은 자리에 0을 채움
        * , : 일정 자릿수마다 구분 문자 표시
        * # : 8진수, 16진수에 접두사 표시
         */

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
    }
}
