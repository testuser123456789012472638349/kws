//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // ATL + ENTER 에러 발생시 사용
    // SHIFT + F10 실행
    public static void main(String[] args) {
        int hour = 3;
        int minute = 5;
        System.out.println(hour + "시간" + minute + "분");

        int totalMinute = (hour*60) + minute;
        System.out.println("총" + totalMinute + "분");
    }
}