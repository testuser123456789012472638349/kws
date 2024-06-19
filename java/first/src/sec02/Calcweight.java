package sec02;

import java.util.Scanner;

public class Calcweight {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
            while (true) {
                try {
                    System.out.print("몸무게 입력: ");
                    float weight = Float.parseFloat(scanner.nextLine());
                    System.out.print("신장 입력: ");
                    float height = Float.parseFloat(scanner.nextLine());

                    // System.out.println(weight + " : " + height);

                    float standard = 0;

                    if (height >= 160) {
                        standard = (height - 100) * 0.9f;
                    } else if (height >= 150 && height <= 159) {
                        standard = (height - 150) * 0.5f + 50;
                    } else {
                        standard = height - 100;
                    }

                    float fBmi = (weight - standard) / standard * 100;
                    String sBmi = "";
                    // System.out.println(standard);
                    if (fBmi < 10) {
                        sBmi = "정상";
                    } else if (fBmi >= 10 && fBmi <= 20) {
                        sBmi = "과체중";
                    } else if (fBmi > 20 && fBmi <= 30) {
                        sBmi = "경도비만";
                    } else if (fBmi > 30 && fBmi <= 50) {
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
        scanner.close();
    }
}
