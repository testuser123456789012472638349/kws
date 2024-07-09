package sec11;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * java.lang: import 없이 사용
 * Object
 *
 */
public class _info extends Object {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InterruptedException {
        _info info = new _info();
        int i = 7;
        //boxing: 기본타입을 기본타입의 객체로 자동 변경
        Integer oI = i;
        //unboxing: 기본타입의 객체를 자동으로 기본타입으로 변경
        System.out.println(oI == i);

        Member2 m1 = new Member2("Hong");
        Member2 m2 = new Member2("Go");
        System.out.println(m1.equals(m2));

        System.out.println(Integer.toHexString(m1.hashCode()));
        System.out.println(Integer.toHexString(m2.hashCode()));
        System.out.println(m1.toString());
        System.out.println(m2.toString());

        System.out.println("----------------------------------");

        String str1 = new String("abc");
        String str2 = new String("abc");

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));

        //해싱(hashing): 해시함수를 이용해서 데이터를 관리하는 기법

        //Map은 javascript의 객체{key: value, key: value}
        HashMap<Member2, String> hashMap = new HashMap<>();
        hashMap.put(m1, "홍길동"); //Map은 Key 중복 불가
        hashMap.put(m2, "고길동");
        hashMap.put(new Member2("Kim"), "김길동");

        System.out.println(hashMap);
        System.out.println(hashMap.get(new Member2("Kim")));

        System.out.println("-------------------------------");

        System.out.println(m1);
        System.out.println(m2);

        try {
            if(m1 instanceof Member2) {
                Member2 m4 = (Member2)m1.clone();
                m4.p.x = 100;
                m4.p.y = 100;
                m4.id = "Jo";
                System.out.println(m1);
                System.out.println(m4);
            }
        } catch(CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        if(m1 instanceof Member2) {
            Member2 m5 = m1.deepClone();
            m5.p.x = 20;
            m5.p.y = 20;
            System.out.println(m1);
            System.out.println(m5);
        }

        Class clazz1 = Member2.class;
        System.out.println(clazz1.getName());
        Class class2 = Class.forName("sec11.Member2");
        System.out.println(class2.getName());
        Class class3 = m1.getClass();
        System.out.println(class3.getName());

        Member2 m7 = Member2.class.getDeclaredConstructor(String.class).newInstance("Test");
        System.out.println(m7.p.x);

        System.out.println(class3.getResource("index.txt").getPath());

        int myI = 300;
        Integer myInteger = 300; //박싱
        Integer myInteger2 = 300;
        Integer objInteger = Integer.valueOf("100");

        System.out.println(myInteger + 15);

        int youI = myInteger; //언박싱

        System.out.println(myI == myInteger); //true

        System.out.println(myInteger2 == myInteger); //false

        System.out.println(myInteger2.equals(myInteger)); //true

        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        System.out.println(sdf.format(date));

        System.out.println("--------------------------");

        //시간 끌기 - Exception 설정
        // Thread.sleep(4000);

        //추상객체
        Calendar now = Calendar.getInstance();
        System.out.println(now);
        System.out.println(now.get(Calendar.YEAR));


        //Date과 Calendar 형변환
        //Date => Calendar
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        System.out.println(cal);

        //Calendar => Date
        Date d = new Date(now.getTimeInMillis());
        System.out.println(d);


        //날짜 차이 계산
        // System.out.println((now.getTimeInMillis() - cal.getTimeInMillis()) / 1000);

        long dif = (now.getTimeInMillis() - cal.getTimeInMillis()) / 1000;
        System.out.printf("now: %d, cal: %d의 시간 차는 %d초\n", now.getTimeInMillis(), cal.getTimeInMillis(), dif);

        cal.set(2023, 7, 10);

        dif = (now.getTimeInMillis() - cal.getTimeInMillis()) / 1000;

        System.out.printf("차이를 날수로 계산하면: %d일\n", dif / (24 * 60 * 60));

        System.out.println("----------------------");

        showCalendar(2024, 7);
    }

    static void showCalendar(int year, int month) {
        int startDayOfWeek = 0;
        int EndDay = 0;

        Calendar startDay = Calendar.getInstance();
        Calendar endDay = Calendar.getInstance();

        //시작일 계산
        startDay.set(year, month - 1, 1);

        //마지막 날 계산 - 7월의 마지막 = 8월 1일에서 - 1;
        endDay.set(year, month, 1);
        endDay.add(Calendar.DATE, -1);

        // showDay(startDay);
        // showDay(endDay);

        startDayOfWeek = startDay.get(Calendar.DAY_OF_WEEK);
        EndDay = endDay.get(Calendar.DATE);

        System.out.println(" " + year + "년 " + month + "월");
        System.out.println(" 일 월 화 수 목 금 토");
        for(int i = 1; i < startDayOfWeek; i++) {
            System.out.print("   ");
        }
        for(int i = 1, n = startDayOfWeek; i <= EndDay; i++, n++) {
            System.out.print((i < 10) ? "  " + i : " " + i);
            if(n % 7 == 0) System.out.println();
        }
    }

    static void showDay(Calendar cal) {
        System.out.println(cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DATE) + " - " + cal.get(Calendar.DAY_OF_WEEK));
    }

}

class Position {
    String pos;
    int x;
    int y;

    Position(String pos, int x, int y) {
        this.pos = pos;
        this.x = x;
        this.y = y;
    }
}

class Member2 implements Cloneable {
    String id;
    int age;
    Position p;

    Member2(String id) {
        this.id = id;
        age = 10;
        p = new Position(id, age, age);
    }

    // Member2() {
    //     this("Test");
    // }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Member2) {
            Member2 tmp = (Member2)obj;

            return this.id == tmp.id;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "ID: " + id + ", AGE: " + age + ", Pos.x: " + p.x + ", Pos.y: " + p.y;
    }

    //얕은 복사
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //깊은 복사
    public Member2 deepClone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch(CloneNotSupportedException e) {}
        Member2 m = (Member2)obj;

        m.p = new Position(id, age, age);

        return m;
    }
}