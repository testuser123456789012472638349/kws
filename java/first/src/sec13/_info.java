package sec13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * 자료 구조
 * 컬렉션 인터페이스
 * List : 순서가 있고 중복 가능
 * Set: 순서가 없고 중복 불가
 * Map: 키와 값의 쌍으로 저장되고 키는 중복 불가
 *
 * 제네릭스: 객체가 많은 객체를 다룰 때 컴파일시 타입 체크용
 * 1. 타입체크와 형변환을 생략가능
 * 2. 안정성을 확보
 */
public class _info {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println(list);
        list.add("홍길동");
        list.add(1, "고길동");
        list.add("박길동");
        list.add("최길동");
        System.out.println(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for(String name : list) {
            System.out.println(name);
        }

        list = new LinkedList<>(list);
        list.remove(2);

        list = new ArrayList<>(list);

        list.remove(0);
        list.remove("고길동");
        System.out.println(list);

        Box<String> mybox = new Box<>();
        mybox.setObj("홍길동");
        System.out.println(mybox.getObj());
    }
}


// class Box {
//     Object obj;

//     void setObj(Object obj) {this.obj = obj;}
//     Object getObj() {return obj;}
// }
class Box<A> {
    A obj;

    void setObj(A obj) {this.obj = obj;}
    A getObj() {return obj;}
}