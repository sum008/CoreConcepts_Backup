package tt;

import java.util.Iterator;
import java.util.function.Consumer;

public class Test {

    public static void x() {
        System.out.println("static parent");
    }

    public static void main(String[] args) {
        CustomList<String> s = new CustomList<>();
        System.out.println(s);
        s.add("1");
        s.add("2");
        s.add("3");
//		for (String str:s) {
//			System.out.println(str);
//		}
        Consumer<String> consume = str -> System.out.println(str);
        s.forEach(t -> consume.accept(t));

        Iterator<String> itr = s.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        Test p;

        p = new Pen(5, "red");
//		Test p =new Test();
        p.x();
        p.y();

        p = new Pen1();
//		Test p =new Test();
        p.x();
        p.y();
    }

    public void y() {
        System.out.println("non-static parent");
    }
}

class Pen extends Test {
    int price;
    String color;

    public Pen(int price, String color) {
        this.price = price;
        this.color = color;
    }

    //@Override
    public static void x() {
        System.out.println("pen static base");
    }

    @Override
    public int hashCode() {
        return price;

    }

    public void y() {
        System.out.println("pen non-static base");
    }
}

class Pen1 extends Test {


    //@Override
    public static void x() {
        System.out.println("pen1 static base");
    }

    public void y() {
        System.out.println("pen1 non-static base");
    }
}

