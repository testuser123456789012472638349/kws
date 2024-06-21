package sec05;

import java.util.Arrays;
import java.util.Scanner;

public class Words {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        OUT:
        while (true) {
            int cntRight = 0;
            int cntWrong = 0;

            String[][] words = {
                    {"student", "학생"},
                    {"class", "객체/학급/수업"},
                    {"book", "책"}
            };

            for(int i = 0; i < words.length; i++) {
                System.out.printf("%d. %s의 뜻(종료: 나가기 or 종료)? ", i + 1, words[i][0]);
                String answer = (sc.nextLine()).trim();

                if(answer.equals("나가기") || answer.equals("종료")) break OUT;

                String[] rights = words[i][1].split("/");
                boolean right = false;
                for(String a : rights) {
                    if(answer.equals(a)) {
                        cntRight++;
                        System.out.print("정답");
                        right = true;
                        break;
                    }
                }

                if(!right) {
                    cntWrong++;
                    System.out.printf("오답 - 정답: %s", Arrays.toString(rights));
                }
                System.out.println();
            }

            System.out.println("=====================");
            System.out.printf("전체 정답 수 : %d, 오답수 : %d,정답률 %3.2f%%\n", cntRight, cntWrong, (cntRight / (float) words.length * 100));
            System.out.println("=====================");
            System.out.println();
        }
        sc.close();
    }
}
