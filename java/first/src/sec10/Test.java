package sec10;

import java.lang.reflect.Array;

public class Test {
    public static void main(String[] args) {
        try {
            String data1 = args[0];
            String data2 = args[1];
            int value1 = Integer.parseInt(data1);
            int value2 = Integer.parseInt(data2);
            int result = value1 + value2;
            System.out.println(data1 + " + " + data2 + " = " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error Array");
        } catch (Exception e) {
            System.out.println("Can not check");
        } finally {
            System.out.println("Finally");
        }
    }
}
