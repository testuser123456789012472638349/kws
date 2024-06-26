package sec07;


public class Inheritance {
    public static void main(String[] args) {
        Buyer B = new Buyer();

        B.buy(new Tv());
        B.info();
        B.buy(new Computer());
        B.info();
        B.buy(new Tv());
        B.info();
        B.buy(new Computer());
        B.info();
        B.buy(new Tv());
        B.info();
        B.buy(new Computer());
        B.info();B.buy(new Tv());
        B.info();
        B.buy(new Computer());
        B.info();B.buy(new Tv());
        B.info();
        B.buy(new Computer());
        B.info();
    }
}

class Product {
    int price;
    int point;

    Product(int price) {
        this.price = price;
        point = (int)(price / 10);
    }
}

class Tv extends Product {
    Tv() {
        super(100);
    }

    @Override
    public String toString() {
        return "TV";
    }
}

class Computer extends Product {
    Computer() {
        super(200);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}
class Buyer {
    int money = 1000;
    int point = 0;
    int index = 0;
    int max = 5;
    Product[] products = new Product[max];

    void buy(Product p) {
        if (money >= p.price) {
            money -= p.price;
            point += p.point;
            System.out.println(p + "를 구매");
            if (max <= index) {
                Product[] temp = new Product[max + 5];

                System.arraycopy(products, 0, temp, 0, products.length);
                products = temp;
            }
            products[index] = p;
            index++;
        } else {
            System.out.println("잔액이 부족");
            return;
        }
    }

    void info() {
        System.out.printf("잔액: %d, 포인트: %d\n", money, point);
        for (Product p : products) {
            if (p != null) {
                System.out.print("구매 상품: ");
                System.out.print(p + ", ");
            }
        }
        System.out.println();
        System.out.println();
    }
}