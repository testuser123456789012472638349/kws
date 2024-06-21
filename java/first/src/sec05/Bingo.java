package sec05;

import java.util.Scanner;
// import java.util.*;

public class Bingo {
//    public static final String ANSI_RESET = "\u001B[0m";
//    public static final String ANSI_BLACK = "\u001B[30m";
//    public static final String ANSI_RED = "\u001B[31m";
//    public static final String ANSI_GREEN = "\u001B[32m";
//    public static final String ANSI_YELLOW = "\u001B[33m";
//    public static final String ANSI_BLUE = "\u001B[34m";
//    public static final String ANSI_PURPLE = "\u001B[35m";
//    public static final String ANSI_CYAN = "\u001B[36m";
//    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        final int SIZE = 5;
        int num = 0;

        int[][] bingo = new int[SIZE][SIZE];
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                bingo[i][j] = i * SIZE + j +1;
            }
        }

        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                int a = (int)(Math.random() * SIZE);
                int b = (int)(Math.random() * SIZE);

                int temp = bingo[a][b];
                bingo[a][b] = bingo[i][j];
                bingo[i][j] = temp;
            }
        }

        do {
            for(int i = 0; i < bingo.length; i++) {
                for(int b : bingo[i]) {
                    if(b == 0) {
                        System.out.printf(ConsoleColor.ANSI_RED + "%3d" + ConsoleColor.ANSI_RESET, b);
                        System.out.printf(ConsoleColor.ANSI_RED + "%3d" + ConsoleColor.ANSI_RESET, b);
                    } else  {
                        System.out.printf("%3d", b);
                    }
                }
                System.out.println();
            }

            if(isWin(bingo)) {
                // System.out.println(ANSI_GREEN + "BINGO!!" + ANSI_RESET); Inner Set after call
                System.out.println(ConsoleColor.ANSI_GREEN + "BINGO!!" + ConsoleColor.ANSI_RESET); // after making external enum, call
                break;
            }

            System.out.println();
            System.out.printf("1부터 25의 숫자 입력(종료: 0): ");;

            String temp = sc.nextLine();
            num = Integer.parseInt(temp);
            OUT:
            for(int i = 0; i < SIZE; i++) {
                for(int j = 0; j < SIZE; j++) {
                    if(bingo[i][j] == num) {
                        bingo[i][j] = 0;
                        break OUT;
                    }
                }
            }

            System.out.println("=====================");
            System.out.println();
        } while (num != 0);

        sc.close();
    }

    static boolean isWin(int[][] bingo) {
        boolean result = false;

        int[][][] cons = {
                {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}},
                {{1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}},
                {{2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}},
                {{3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4}},
                {{4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4}},

                {{0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}},
                {{0, 1}, {1, 1}, {2, 1}, {3, 1}, {4, 1}},
                {{0, 2}, {1, 2}, {2, 2}, {3, 2}, {4, 2}},
                {{0, 3}, {1, 3}, {2, 3}, {3, 3}, {4, 3}},
                {{0, 4}, {1, 4}, {2, 4}, {3, 4}, {4, 4}},

                {{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}},
                {{0, 4}, {1, 3}, {2, 2}, {3, 1}, {4, 0}}
        };

        OUT:
        for(int i = 0; i < cons.length; i++) {
            int bin[] = new int[cons[i].length];
            for(int j = 0; j < cons[i].length; j++) {
                //System.out.println(Arrays.toString(cons[i][j]));
                //System.out.println(bingo[cons[i][j][0]][cons[i][j][1]]);
                bin[j] = bingo[cons[i][j][0]][cons[i][j][1]];
            }

            if(bin[0] == 0 && bin[1] == 0 && bin[2] == 0 && bin[3] == 0 && bin[4] == 0) {
                result = true;
                break OUT;
            }
        }
        return result;
    }
}
