package sec02;

public class LongExample {
    public static void main(String[] args) {
        long myLong = 300000000000000L;
        float myFloat = 3.14F;
        int hexA = 0x41;
        int decA = 65;
        int octA = 0101;
        int binA = 0b01000001;
        char charA = 'A';
        char charUA = '\u0041';

        boolean stop = false;
        if(stop) {
            System.out.println("멈춥니다.");
        } else {
            System.out.println("출발합니다.");
        }

        System.out.println(myLong);
        System.out.println(myFloat);
        System.out.println("-------------------");
        System.out.println(hexA);
        System.out.println(decA);
        System.out.println(octA);
        System.out.println(binA);
        System.out.println("-------------------");
        System.out.println("--------형변환------");
        System.out.println((char)hexA);
        System.out.println((char)decA);
        System.out.println((char)octA);
        System.out.println((char)binA);
        System.out.println("-------------------");
        System.out.println(charA);
        System.out.println((int)charA);
        System.out.println(charUA);
        System.out.println("-------------------");
//        System.out.println((char)0);
//        System.out.println((char)1);
//        System.out.println((char)2);
//        System.out.println((char)3);
//        System.out.println((char)4);

//        for(int i = 0; i < 65536; i++) {
//            System.out.println(i + ": " + (char)i);
//        }

        String str = "나는 \"자바\"를 좋아합나다.";
        System.out.println(str);
        System.out.println("-------------------");
        System.out.println("자바는");
        System.out.println("\n재미있는 \"프로그래밍\" 언어\n");
        System.out.println("입니다.");
        System.out.println("-------------------");
    }
}
