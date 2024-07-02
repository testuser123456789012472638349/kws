//import static org.junit.Assert.assertArrayEquals;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Test;
//
//import java.util.Arrays;
//
//public class TestTemp {
//
//
//    @Test
//    public void testAdd() {
//        Buyer buyer = new Buyer();
//        buyer.add(new Tv());
//        buyer.add(new Computer());
//
//        Product[] result = new Product[3];
//        result[0] = new Tv();
//        result[1] = new Computer();
//        assertArrayEquals(result, buyer.cart);
//        System.out.println("result: " + Arrays.toString(result));
//        System.out.println(Arrays.toString(buyer.cart));
//    }
//
//    @Test
//    public void testBuy() {
//        Buyer buyer = new Buyer();
//        buyer.buy(new Tv());
//        assertTrue(buyer.money == (1000 - new Tv().price));
//        assertEquals(buyer.cart[0].toString(), "Tv");
//    }
//}
