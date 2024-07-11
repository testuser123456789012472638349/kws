package sec13;

import java.util.*;

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

        System.out.println("====================");

        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("고길동");
        set.add("홍길동");
        System.out.println(set);
        // set.remove("고길동");
        // System.out.println(set);
        for(String name : set) {
            System.out.println(name);
        }
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        list = new ArrayList<>(set);
        System.out.println(list);

        Map<String, Integer> map = new HashMap<>();
        map.put("홍길동", 30);
        map.put("고길동", 10);
        map.put("마길동", 50);
        System.out.println(map.get("홍길동"));
        System.out.println(map);
        // for(Map.Entry<String, Integer> e : map) {

        // }
        Set<String> keySet = map.keySet();
        iterator = keySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            // System.out.println(iterator2.next());
            Map.Entry<String, Integer> me = iterator2.next();
            System.out.println(me.getKey() + " : " + me.getValue());
        }


        System.out.println("==============================");

        Stack<String> stack = new Stack<>();

        // System.out.println(stack.isEmpty());
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");

        for(int i = 0; i < stack.size(); i++) {
            System.out.print("peek: " + stack.peek());
            System.out.println(", get: " + stack.get(i));
        }

        // System.out.println(stack.isEmpty());
        // while (!stack.isEmpty()) {
        //     System.out.println(stack.pop());
        //     System.out.println(stack.isEmpty());
        // }

        System.out.println("out");

        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        queue.offer("4");
        queue.offer("5");

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
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