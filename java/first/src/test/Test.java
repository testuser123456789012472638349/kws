package test;

public class Test {
    public static void main(String[] args) {
       int x = 2;
       int y = 5;
       char c = 'A';

        System.out.println(1 + x <<33);
        System.out.println(y >= 5 || x < 0 && x > 2);
        System.out.println(y += 10 - x++);
        System.out.println(x+=2);
        System.out.println(!('A' <= c && c <='Z'));
        System.out.println('C'-c);
        System.out.println('5'-'0');
        System.out.println(c+1);
        System.out.println(++c);
        System.out.println(c++);
        System.out.println(c);

        int numOfApples = 123;
        int sizeOfBucket = 10;
        int numOfBucket = (int)(numOfApples / sizeOfBucket) + 1;

        System.out.println(numOfBucket);

        int num = 10;
        System.out.println(num > 0 ? "양수" : "음수");

        int num1 = 456;
        System.out.println(Math.floor(num1 * 0.01) * 100);

        int num2 = 333;
        System.out.println((int)(num2/10f) * 10 + 1);

        int num3 = 24;
        System.out.println(num3 + (-num3 % 10 + 10) - num3);

        int fa = 100;
        float celcius = (int)((5/9f * (fa - 32)) * 100 + 0.5) / 100f;

        System.out.println("Fahrenheit: " + fa);
        System.out.println("Celcius: " + celcius);
    }

    static void System(String Aaa) {
        System.out.println("keyword" + Aaa);
    }
}