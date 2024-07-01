import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int sum = 0;
        int sum1 = 0;

        for(int i = 1; i <= 20; i++) {
            if(i % 2 != 0 && i % 3 != 0) {
                sum += i;
            }
        }
        System.out.println(sum);

        for(int i = 1; i <= 10; i++) {
            int a = (1 + i) * i / 2;
            sum1 += a;
        }
        System.out.println(sum1);

        int sum3 = 0, num = 0;

        while (true) {
            num++;
            if(num % 2 == 0) sum3 -= num;
            else sum3 += num;
            if(sum3 >= 100) break;
        }
        System.out.println("Result : " + num);

        for(int i = 0; i <= 10; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.println("*");
            }
            System.out.println();
        }

        int i = 0, j = 0;
        while (i <= 10) {
            j = 0;
            while (j <= i) {
                System.out.println("*");
                j++;
            }
            System.out.println();
            i++;
        }



        for(int a = 1; a <= 6; a++) {
            for(int b = 1; b <= 6; b++) {
                if(a + b == 6) {
                    System.out.println("a: " + a + ", b: " + b);
                }
            }
        }

        for(int c = 0; c <= 10; c++) {
            for(int d = 0; d <= 10; d++) {
                if(2 * c + 4 * d == 10) {
                    System.out.println("a : " + c + " , b: " + d);
                }
            }
        }

        String str = "12345";
        int sum6 = 0;

        for(int e = 0; e < str.length(); e++) {
            sum6 += str.charAt(e) - '0';
        }
        System.out.println("sum6 = " + sum6);

        int num2 = 12345;
        int sum5 = 0;

        while (num2 > 0) {
            sum5 += num2 % 10;
            num2 /= 10;
        }
        System.out.println("sum = " + sum5);

        int num5 = 1;
        int num6 = 1;
        int num7 = 0;
        System.out.print(num5 + " , " + num6);

        for(int k = 0; k < 8; k++) {
            num7 = num5 + num6;
            num5 = num6;
            num6 = num7;

            System.out.print(" , " + num7);
        }

        int mul = 0;

        for(int l = 1; l <= 9; l++) {
            for(int p = 1; p <= 3; p++) {
                mul = l * p;
                System.out.println(l + "*" + p + " = " + l * p);
            }
        }

        String value = "12o34";
        boolean isNumber = true;

        for(int u = 0; u < value.length(); u++) {
            if(!(value.charAt(u) >= 'O' && value.charAt(u) <= '9')) {
                isNumber =false;
                break;
            }
        }
        if(isNumber) {
            System.out.println(value + " 는 숫지입니다.");
        } else {
            System.out.println(value + " 는 숫자가 아닙니다.");
        }

//        int answer = (int)(Math.random() * 100) + 1;
//        int input = 0;
//        int coun = 0;
//
//        java.util.Scanner s = new java.util.Scanner(System.in);
//
//        do{
//            coun++;
//            System.out.print("1과 100사이의 값을 입력하세요 : ");
//            input = s.nextInt();
//
//            if(answer > input) {
//                System.out.println("더 큰 수를 입력하세요");
//            } else if(answer < input) {
//                System.out.println("더 작은 수를 입력하세요");
//            } else {
//                System.out.println("정답 ~~");
//                System.out.println("시도횟수는 " + coun + "번입니다.");
//                break;
//            }
//        }
//        while (true);

        int number = 12321;
        int tmp = number;
        int result = 0;
        while (tmp != 0) {
            result *= 10;
            result += tmp % 10;
            tmp /= 10;
        } if(number == result) System.out.println(number + "는 회문수 입니다.");
        else System.out.println(number + "는 회문수가 아닙니다.");

        // int[] arr[];
        //int[] arr = {1, 2, 3};
        // int[] arr = new int[5];
        //int [] arr = {1, 2, 3, 4, 5};
        //int[] arr[] = new int[3][];

//        int[][] arr = {
//                {5, 5, 5, 5, 5},
//                {10, 10, 10},
//                {20, 20, 20, 20},
//                {30, 30}
//        };
//        System.out.println(arr[3][1]);
//        System.out.println(arr[3].length);

        int[] arr = {10, 20, 30, 40, 50};
        int sum8 = 0;

        for(int y = 0; y < arr.length; y++) {
            sum8 += arr[y];
        }

        System.out.println("sum = " + sum8);

        int[][] arr1 = {{5, 5, 5, 5, 5}, {10, 10, 10, 10, 10}, {20, 20, 20, 20, 20}, {30, 30, 30, 30, 30}};

        int total = 0;
        float average = 0;

        for(int r = 0; r < arr1.length; r++) {
            for(int w = 0; w < arr1[r].length; w++) {
                total += arr1[r][w];
            }
        }

        average = (float)total / (arr1.length * arr1[0].length);


        // System.out.println(arr1[0].length);
        System.out.println("total = " + total);
        System.out.println("average = " + average);

        int[] ballArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] ball3 = new int[3];

        for(int s = 0; s < ballArr.length; s++) {
            int d = (int)(Math.random() * ballArr.length);
            int tmp1 = 0;

            tmp1 = ballArr[s];
            ballArr[s] = ballArr[d];
            ballArr[d] = tmp1;
        }

        for(int z = 0; z < 3; z++) {
            ball3[z] = ballArr[z];
        }

        for(int g = 0; g < ball3.length; g++) {
            System.out.println(ball3[g]);
        }

        StudaCard card1 = new StudaCard(3, false);
        StudaCard card2 = new StudaCard();

        System.out.println(card1.info());
        System.out.println(card2.info());

        Student s= new Student();
        s.name = "홍길동";
        s.ban = 1;
        s.no = 1;
        s.kor = 100;
        s.eng = 60;
        s.math = 76;

        System.out.println("이름: " + s.name);
        System.out.println("총점: " + s.getTotal());
        System.out.println("평균: " + s.getAverage());

        System.out.println(getDistance(1,1,2,2));

        MyPoint p = new MyPoint(1, 1);
        System.out.println(p.getDistanace2(2,2));

        int [] orginal = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(java.util.Arrays.toString(orginal));

        int[] result4 = shuffle(orginal);
        System.out.println(java.util.Arrays.toString(orginal));

//        Robot[] arr5 = { new DanceRobot(), new SingRobot(), new DrawRobot() };
//        for(int q = 0; q < arr5.length; q++) {
//            action(arr[i]);
//        }
    }

    static double getDistance(int x, int y, int x1, int y1) {
        double d = 0;
        double f = 0;
        d = Math.pow(x1 - d, 2);
        f = Math.pow(y1 - f, 2);
        return Math.sqrt(d + f);
    }


     static int[] shuffle(int[] arr5) {
        for(int i = 0; i < arr5.length; i++) {
            int n = new Random().nextInt(9);
            int tmp6 = arr5[i];
            arr5[i] = arr5[n];
            arr5[n] = tmp6;
        }
        return arr5;
    }

}

class StudaCard {
    int num;
    boolean isboolean;

    StudaCard() {
        this(1, true);
    }
    StudaCard(int num, boolean isboolean) {
        this.num = num;
        this.isboolean = isboolean;
    }

    String info() {
        if(this.isboolean) return "Chater5 " + this.num + "K";
        else return this.num + " ";
    }
}

class Student {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    int getTotal() {
        return kor + eng + math;
    }

    float getAverage() {
        float tmp3 = (float) getTotal() / 3;
        return (Math.round(tmp3 * 10f)) / 10f;
    }
}

class MyPoint {
    int x;
    int y;

    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double getDistanace2(int x, int y) {
        double x1 = 0;
        double y1 = 0;
        double a = Math.pow(x1 - x, 2);
        double b = Math.pow(y1 - y, 2);
        return Math.sqrt(a + b);
    }
}

abstract class Unit {
    int x, y;
    abstract void move(int x, int y);
    void stop() {}
}

class Marine extends Unit {
    void move(int x, int y) {}
    void stimPack() {}
}

class Tank extends Unit {
    void move(int x, int y) {}
    void changeMode() {}
}

class Dropship extends Unit {
    void move(int x, int y) {}
    void load() {}
    void unload() {}
}

//public static void action(Robot r) {
//    if(r instanceof DanceRobot) {
//        ((DanceRobot) r).dance();
//    } else if(r instanceof SingRobot) {
//        ((SingRobot) r).sing();
//    } else if(r instanceof DrawRobot) {
//        ((DrawRobot) r).draw();
//    }
//}
//class Robot {}
//class DanceRobot extends Robot {
//    void dance() {
//        System.out.println("Dancing");
//    }
//}
//class SingRobot extends Robot {
//    void sing() {
//        System.out.println("singing");
//    }
//}
//class DrawRobot extends Robot {
//    void draw() {
//        System.out.println("Drawing");
//    }
//}



