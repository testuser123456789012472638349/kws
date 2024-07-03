package Test;

import org.w3c.dom.ls.LSOutput;
import java.util.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Date;

public class Check {
    public static void main(String[] args) {
        Member ob1 = new Member("blue");
        Member ob2 = new Member("blue");
        Member ob3 = new Member("red");

        if(ob1.equals(ob2)) {
            System.out.println("ob1 == ob2");
        } else {
            System.out.println("ob1 != ob2");
        }

        if(ob2.equals(ob3)) {
            System.out.println("ob2 == ob3");
        } else {
            System.out.println("ob2 != ob3");
        }

//        HashMap<Member, String> hashMap = new HashMap<Member, String>();
//
//        hashMap.put(new Member(1), "홍길동");
//
//        String value = hashMap.get(new Member(1));
//        System.out.println(value);

        Object t1 = new Object();
        Date t2 = new Date();
        System.out.println(t1.toString());
        System.out.println(t2.toString());

        Smart t4 = new Smart("구글", "안드로이드");

        String stro = t4.toString();
        System.out.println(stro);

        System.out.println(t4);

        long time1 = System.nanoTime();

        int sum = 0;
        for(int i = 0; i <= 1000000; i++) {
            sum += 1;
        }

        long time2 = System.nanoTime();

        System.out.println("1~1000000 sum : " + sum);
        System.out.println("계산에 " + (time2 - time1) + "나노초가 소요");


//        for(int i = 0; i < 10; i++) {
//            if(i == 5) {
//                System.exit(0); // 종료
//            }
//        }
//        System.out.println("마무리 코드");

        HashMap<Student, String> hashMap = new HashMap<Student, String>();
        hashMap.put(new Student("1"), "95");

        String score = hashMap.get(new Student("1"));
        System.out.println("1번 학생의 총점: " + score);

        Member1 member1= new Member1("blue", "이파란");
        System.out.println(member1);

        byte[] bytes = { 73,32, 108, 111, 118, 101, 32, 121, 111, 117};
        String str = new String(bytes);
        System.out.println( str );

        String str1 = "모든 프로그램은 자바 언어로 개발될 수 있다.";
        int index = str1.indexOf("자바");
        if(index == -1) {
            System.out.println("자바 문자열이 포함되어 있지 않습니다.");
        } else {
            System.out.println("자바 문자열이 포함되어 있습니다.");
            str1 = str1.replace("자바", "Java");
            System.out.println("--->" + str1);
        }

        class StringCovert {
            String strData1 = "200";
            int intData1 = Integer.parseInt(strData1);

            int intData2 = 150;
            String strData2= String.valueOf(intData2);
        }

        Date now = new Date();
        String strNow1 = now.toString();
        System.out.println(strNow1);

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 nn분 ss초");
//        String strnNow2 = sdf.format(now);
//        System.out.println(strnNow2);

        Calendar now1 = Calendar.getInstance();

        int year = now1.get(Calendar.YEAR);
        int month = now1.get(Calendar.MONTH) + 1;
        int day = now1.get(Calendar.DAY_OF_MONTH);
        int week = now1.get(Calendar.DAY_OF_WEEK);
        int amPm = now1.get(Calendar.AM_PM);
        int hour = now1.get(Calendar.HOUR);
        int minute = now1.get(Calendar.MINUTE);
        int second = now1.get(Calendar.SECOND);

        String strWeek = null;
        switch (week) {
            case Calendar.MONDAY:
                strWeek = "월";
                break;
            case Calendar.TUESDAY:
                strWeek = "화";
                break;
            case Calendar.WEDNESDAY:
                strWeek = "수";
                break;
            case Calendar.THURSDAY:
                strWeek = "목";
                break;
            case Calendar.FRIDAY:
                strWeek = "금";
                break;
            case Calendar.SATURDAY:
                strWeek = "토";
                break;
            default:
                strWeek = "일";
        }

        String strAmPM = null;
        if(amPm == Calendar.AM) {
            strAmPM = "오전";
        } else {
            strAmPM = "오후";
        }

        System.out.println(year + "년");
        System.out.println(month + "월");
        System.out.println(day + "일");
        System.out.println(strWeek + "요일");
        System.out.println(strAmPM + " ");
        System.out.println(hour + "시");
        System.out.println(minute + "분");
        System.out.println(second + "초");

        DatePrint aaa = new DatePrint();
        System.out.print(aaa.year + "년 ");
        System.out.print(aaa.strMonth + "월 ");
        System.out.print(aaa.strDayOfMonth + "일 ");
        System.out.print(aaa.StrDayOfWeek + "   ");
        System.out.print(aaa.strHour + "시");
        System.out.print(aaa.strMinute + "분");
    }
}

class Smart {
    private String company;
    private String os;

    Smart(String company, String os) {
        this.company = company;
        this.os = os;
    }

    @Override
    public String toString() {
        return company + " , " + os;
    }
}

class Student {
    private String studenNum;

    Student(String studenNum) {
        this.studenNum = studenNum;
    }

    String getStudentNum() {
        return studenNum;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  Student) {
            Student student = (Student) obj;
            if(studenNum.equals(student.getStudentNum())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return studenNum.hashCode();
    }
}

class Member1 {
    private String id;
    private String name;

    Member1(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " : " + name;
    }
}

class DatePrint {
    Calendar now = Calendar.getInstance();

    int year = now.get(Calendar.YEAR);
    int month = now.get(Calendar.MONTH) + 1;
    String strMonth = (month < 10) ? ("0" + month) : ("" + month);

    int dayOfMonth = now.get(Calendar.DAY_OF_MONTH);
    String strDayOfMonth = (dayOfMonth < 10) ? ("0" + dayOfMonth) : ("" + dayOfMonth);

    String[] dayArray = {"일", "월", "화", "수", "목", "금", "토"};
    int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
    String StrDayOfWeek = dayArray[dayOfWeek - 1] + "요일";

    int hour = now.get(Calendar.HOUR_OF_DAY);
    String strHour = (hour < 10) ? ("0" + hour) : ("" + hour);

    int minute = now.get(Calendar.MINUTE);
    String strMinute = (minute < 10) ? ("0" + minute) : ("" + minute);
}