package sec05;

import java.util.Scanner;

public class Free {
    public static void main(String[] args) {
        int[][] mathScores = new int[2][3];
        for(int i = 0; i < mathScores.length; i++) {
            for(int k = 0; k < mathScores[i].length; k++) {
                System.out.println("mathScores["+i+"]["+k+"]=" + mathScores[i][k]);
            }
        }
        System.out.println();
        int[][] englishScores = new int[2][];
        englishScores[0] = new int[2];
        englishScores[1] = new int[3];
        for(int i = 0; i < englishScores.length; i++) {
            for(int k = 0; k < englishScores[i].length; k++) {
                System.out.println("englishScores["+i+"]["+k+"]-" + englishScores[i][k]);
            }
        }
        System.out.println();
        int[][] javaScores = { {95, 80}, {92, 96, 80} };
        for(int i = 0; i < javaScores.length; i++) {
            for (int k = 0; k < javaScores[i].length; k++) {
                System.out.println("javaScores[" + i + "][" + k + "]-" + javaScores[i][k]);
            }
        }
        System.out.println();

        String[] strArray = new String[3];
        strArray[0] = "java";
        strArray[1] = "java";
        strArray[2] = new String("java");

        System.out.println(strArray[0].equals(strArray[2]));


        boolean run = true;
        int studentNum = 0;
        int[] scores = null;
        Scanner scanner = new Scanner(System.in);

        while (run) {
            System.out.println("---------------------------");
            System.out.println("1.학생수 ~~~~");
            System.out.println("---------------------------");
            System.out.println("선택>");

            int selectNo = Integer.parseInt(scanner.nextLine());

            if(selectNo == 1) {
                System.out.println("학생수>");
                studentNum = Integer.parseInt(scanner.nextLine());
                scores = new int[studentNum];
            } else if(selectNo == 2) {
                for(int i = 0; i < scores.length; i++) {
                    System.out.println("scores[" + i + "]>");
                    scores[i] = Integer.parseInt(scanner.nextLine());
                }
            } else if(selectNo == 3) {
                for(int i = 0; i < scores.length; i++) {
                    System.out.println("scores[" + i + "]: >" + scores[i]);
                }
            } else if(selectNo == 4) {
                int max = 0;
                int sum = 0;
                double avg = 0.0;
                for(int i = 0; i < scores.length; i++) {
                    max = (max < scores[i]) ? scores[i] : max;
                    sum += scores[i];
                }
                avg = (double) sum / studentNum;
                System.out.println("최고 점수: " + max);
                System.out.println("평균 점수: " + avg);

            } else if(selectNo == 5) {
                run = false;
            }
            System.out.println("프로그램 종료");
        }
    }
}
