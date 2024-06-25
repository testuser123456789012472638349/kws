package sec06;
/**
 * 1) 다음과 같은 멤버변수를 갖는 SutdaCard클래스를 정의하시오.
 *  타입    / 변수명    / 설명
 *  int     / num       / 카드 숫자(1~10 사이의 정수)
 *  boolean / isKwang   / 광(光)이면 true, 아니면 false
 *
 *  ==========================================================
 *
 *
 * 2) 문제 6-1에서 정의한 SutdaCard클래스에 두 개의 생성자와 info() 를 추가해서 실행 결과와 같은 결과를 얻도록 하시오.
 * class Exercise6_2 {
 public static void main(String args[]) {
 SutdaCard card1 = new SutdaCard(3, false);
 SutdaCard card2 = new SutdaCard();
 System. out. println(card1.info());
 System. out. println(card2.info());
 }
 }
 class SutdaCard {
 (1) 알맞은 코드를 넣어 완성하시오
 }
 결과:
 3
 1K
 *
 *  ==========================================================
 *
 *
 * 3) 다음과 같은 멤버변수를 갖는 Student클래스를 정의하시오.
 타 입      변수명     설 명
 String       name    학생이름
 int          ban     반
 int          no      번호
 int          kor     국어점수
 int          eng     영어점수
 int          math    수학점수
 *
 *
 *  ==========================================================
 *
 *
 * 4) 문제3에서 정의한 Student클래스에 다음과 같이 정의된 두 개의 메서드 getTotal() 과 getAverage() 를 추가하시오.
 1. 메서드명 : getTotal
 기 능 : 국어(kor), 영어(eng), 수학(math) 의 점수를 모두 더해서 반환한다.
 반환타입 : int
 매개변수 : 없음
 2. 메서드명 : getAverage
 기 능 : 총점(국어점수+영어점수+수학점수) 을 과목수로 나눈 평균을 구한다
 소수점 : 둘째자리에서 반올림할 것.
 반환타입 : float
 매개변수 : 없음

 class Exercise6_4 {
 public static void main(String args[]) {
 Student s = new Student();
 s. name = " "; 홍길동
 s. ban = 1;
 s. no = 1;
 s. kor = 100;
 s. eng = 60;
 s. math = 76;
 System. out. println(" :"+s. name); 이름
 System. out. println(" :"+s. getTotal()); 총점
 System. out. println(" :"+s. getAverage()); 평균
 }
 }
 class Student {
 (1) 알맞은 코드를 넣어 완성하시오.

 }

 결과:
 이름:홍길동
 총점:236
 평균:78.7

 *
 *
 *  ==========================================================
 *
 *
 * 5)Tv클래스를 주어진 로직대로 완성하시오 .완성한 후에 실행해서 주어진 실행결과 와 일치하는지 확인하라.
 class MyTv {
 boolean isPowerOn;
 int channel;
 int volume;
 final int MAX_VOLUME = 100;
 final int MIN_VOLUME = 0;
 final int MAX_CHANNEL = 100;
 final int MIN_CHANNEL = 1;

 void turnOnOff() {
 // (1) isPowerOn의 값이 true면 false로, false면 true로 바꾼다.
 }

 void volumeUp() {
 // (2) volume의 값이 MAX_VOLUME보다 작을 때만 값을 1 증가시킨다.
 }

 void volumeDown() {
 // (3) volume의 값이 MIN_VOLUME보다 클 때만 값을 1 감소시킨다.
 }

 void channelUp() {
 // (4) channel의 값을 1증가시킨다.
 // 만일 channel이  MAX_CHANNEL이면, channel의 값을 MIN_CHANNEL로 바꾼다.
 }

 void channelDown() {
 // (5) channel의 값을 1감소시킨다.
 // 만일 channel이 MIN_CHANNEL이면, channel의 값을 MAX_CHANNEL로 바꾼다.
 }
 } // class MyTv

 class Exercise6_21 {
 public static void main(String args[]) {
 MyTv t = new MyTv();
 t. channel = 100;
 t. volume = 0;

 System. out. println("CH:"+t. channel+", VOL:"+ t. volume);
 t. channelDown();
 t. volumeDown();
 System. out. println("CH:"+t. channel+", VOL:"+ t. volume);
 t. volume = 100;
 t. channelUp();
 t. volumeUp();
 System. out. println("CH:"+t. channel+", VOL:"+ t. volume);
 }
 }
 결과:
 CH:100, VOL:0
 CH:99, VOL:0
 CH:100, VOL:100
 *
 */
public class exam {
    public static void main(String[] args) {
        SutudaCard card1 = new SutudaCard(3, false);
        SutudaCard card2 = new SutudaCard();
        System.out.println(card1.info()); //3
        System.out.println(card1); //3 (override)
        System.out.println(card2.info()); //1k

        Student s = new Student();
        s. name = "홍길동";
        s. ban = 1;
        s. no = 1;
        s. kor = 100;
        s. eng = 60;
        s. math = 76;
        System. out. println("이름 :"+s. name);
        System. out. println("총점 :"+s. getTotal());
        System. out. println("평균 :"+s. getAverage());

        MyTv t = new MyTv();
        t.channel = 100;
        t.volume = 0;

        System. out. println("CH:"+t. channel+", VOL:"+ t. volume); //CH:100, VOL:0
        t.channelDown();
        t.volumeDown();
        System. out. println("CH:"+t. channel+", VOL:"+ t. volume); //CH:99, VOL:0
        t.volume = 100;
        t.channelUp();
        t.volumeUp();
        System. out. println("CH:"+t. channel+", VOL:"+ t. volume); //CH:100, VOL:100
    }
}

    class SutudaCard {
        int num;
        boolean isKwang;
        SutudaCard() {
            this(1, true);
        }
        SutudaCard(int num, boolean isKwang) {
            this.num = num;
            this.isKwang = isKwang;
        }
        String info() {
            return num + ( isKwang ? "K" : "");
        }

        @Override
        public String toString() {
            return this.info();
        }
    }

    class Student {
        String       name;    //학생이름
        int          ban;    //     반
        int          no;    //      번호
        int          kor;    //     국어점수
        int          eng;    //     영어점수
        int          math;    //    수학점수

        Student() {}
        Student(String name, int ban, int no, int kor, int eng, int math) {
            this.name = name;
            this.ban = ban;
            this.no = no;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
        int getTotal() {
            return  kor + eng + math;
        }
        float getAverage() {
            return  (int)(getTotal() / 3f * 10 + 0.5f) /10f;
        }

        String info() {
            return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
        }
    }

    class MyTv {
        boolean isPowerOn; //멤버 변수는 false
        int channel;
        int volume;
        final int MAX_VOLUME = 100;
        final int MIN_VOLUME = 0;
        final int MAX_CHANNEL = 100;
        final int MIN_CHANNEL = 1;

        void turnOnOff() {
            // (1) isPowerOn의 값이 true면 false로, false면 true로 바꾼다.
            isPowerOn = !isPowerOn;
            System.out.println("power: " + isPowerOn);
        }
        void volumeUp() {
            // (2) volume의 값이 MAX_VOLUME보다 작을 때만 값을 1 증가시킨다.
            if(volume < MAX_VOLUME) {
                volume++;
            }
        }
        void volumeDown() {
            // (3) volume의 값이 MIN_VOLUME보다 클 때만 값을 1 감소시킨다.
            if(volume > MIN_VOLUME) {
                volume--;
            }
        }
        void channelUp() {
            // (4) channel의 값을 1증가시킨다.
            // 만일 channel이  MAX_CHANNEL이면, channel의 값을 MIN_CHANNEL로 바꾼다.
            if(channel == MAX_CHANNEL) {
                channel = MIN_CHANNEL;
            } else  {
                channel++;
            }
        }
        void channelDown() {
            // (5) channel의 값을 1감소시킨다.
            // 만일 channel이 MIN_CHANNEL이면, channel의 값을 MAX_CHANNEL로 바꾼다.
            if(channel == MIN_CHANNEL) {
                channel = MAX_CHANNEL;
            } else {
                channel--;
            }
        }
    }
