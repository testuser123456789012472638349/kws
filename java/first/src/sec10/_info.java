package sec10;

/**
 * 에러(Error) - 심각한 오류(메모리 부족(오버플러워), 스택 오버플로워)
 * 예외(Exception) - 경미한 오류(수정 가능)
 *
 * ----
 * 컴파일 에러(일반 예외) - 컴파일시 일어나는 오류
 * 런타임 에러 - 실행시 일어나는 오류
 * 논리적 에러 - 실행는 되는데 값이 틀린 오류
 */
public class _info {
    public static void main(String[] args) throws MyException {

        // testError();
        // testException();

        for(int i = 0; i < 10; i++) {
            // try {
            if(i == 5) throw new MyException();
            // } catch(MyError e) {
            //     System.out.println("처리");
            // }

        }

        System.out.println("메인 종료");
    }

    static void testError() {
        try {
            System.out.println("정상");
        } catch(StackOverflowError e) {
            System.out.println("스택오버플로워");
        }
        finally {
            System.out.println("EXIT");
        }

        System.out.println("테스트 종료");
        testError();
    }

    static void testException() throws MyException {
        try {
            Class clazz = Class.forName("java.lang.String2");
            System.out.println(clazz.getName());
            System.out.println(clazz.getPackageName());
        } catch(ClassNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch(NullPointerException e) {
            System.out.println("Null 참조");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("종료");
        }

        testException();
    }
}

class MyException extends Exception {
    MyException() {
        super("나의 에러");
    }
}
