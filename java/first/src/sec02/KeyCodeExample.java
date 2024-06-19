package sec02;

import java.util.Scanner;

public class KeyCodeExample {
    public static void main(String[] args) throws Exception{
        int keyCode;
//        keyCode = System.in.read();
//        System.out.println("keyCode: " + keyCode);

//        while(true) {
//            keyCode = System.in.read();
//            System.out.println("keyCode: " + keyCode);
//        }
//        while(true) {
//            keyCode = System.in.read();
//            System.out.println("keyCode: " + keyCode);
//            if(keyCode == 113) {
//                break;
//            }
//        }
//        System.out.println("종료");

        Scanner scanner = new Scanner(System.in);
        String inputData;

        while (true) {
            inputData = scanner.nextLine();
            System.out.println("입력된 문자열: \"" + inputData + "\"");
            if(inputData.equals("q")) {
                break;
            }
        }
        System.out.println("종료");
    }
}
