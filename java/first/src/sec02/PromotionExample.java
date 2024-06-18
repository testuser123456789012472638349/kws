package sec02;

import java.math.BigDecimal;

public class PromotionExample {
    public static void main(String[] args) {
        //자동 타입 변환
        byte byteValue = 10;
        int intValue = byteValue;
        System.out.println("intValue: " + intValue);

        char charValue = '가';
        intValue = charValue;
        System.out.println("가의 유니코드: " + intValue);

        intValue = 50;
        long longValue = intValue;
        System.out.println("longValue: " + longValue);

        longValue = 100;
        float floatValue = longValue;
        System.out.println("floatValue: " + floatValue);

        floatValue = 100.5F;
        double doubleValue = floatValue;
        System.out.println("doubleValue: " + doubleValue);
        // 강제타입 변환(엄격한 언어)
        int intValue1 = 10;
        byte byteValue1 = (byte)intValue1;
        System.out.println(byteValue1);

        byte x = 10;
        byte y = 10;
        byte result  = (byte)(x + y);
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
        System.out.println(thou); //정확한 값 X

        float myValue = 1.5F + 1.7f;
        System.out.println(myValue);

        // float myValue2 = (float)(1.5F + 1.7);
        double myValue2 = 1.5F + 1.7;
        System.out.println(myValue2);

        int intX = 1;
        int intY = 2;
        System.out.println(intX / (float)intY);

        double d2 = 85.7;
        int i2 = (int)d2;
        double d3 = i2;
        System.out.println(d2);
        System.out.println(i2); //내림
        System.out.println(d3);

        // 실수형은 정밀도 - double float 2배의 정밀도
        float f = 9.1234567f;
        double d4 = 9.1234567;
        System.out.println(f);
        System.out.println(d4);
        System.out.println(0.1 + 0.2);

//        BigDecimal num1 = new BicDecimal(String.valueOf(0.1));
//        BigDecimal num2 = new BigDecimal(String.valueOf(0.2));
//        System.out.println(num1.add(num2));

        //기본타입의 객체들이 존재
        String str1 = "10";
        System.out.println(Integer.parseInt(str1));
        System.out.println(Byte.parseByte(str1));
        System.out.println(Boolean.parseBoolean(str1));


    }
}
