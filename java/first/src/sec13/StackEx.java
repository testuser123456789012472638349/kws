package sec13;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 스택 사용 예: 쌍기호 검사, 브라우저 앞/뒤, undo/redo
 * 큐 사용 예: 최근 문서, 인쇄대기, 버퍼
 */
public class StackEx {
    public static void main(String[] args) {
        Stack<String> ex = new Stack<>();
        String str = "((test)ㅅㄷㅈㄴㅅ)ㅈ)ㅁㄷ)";
        //EmptyStackException

        System.out.println("문장: " + str);

        try {
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c == '(') {
                    ex.push(c + "");
                } else if(c == ')') {
                    ex.pop();
                }
            }
            if(ex.isEmpty()) {
                System.out.println("정상");
            } else {
                System.out.println("비정상");
            }
        } catch(EmptyStackException e) {
            System.out.println("비정상");
        }

    }
}
