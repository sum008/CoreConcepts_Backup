package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProducerConsumer {

    public static void main(String[] args) {
        // Consumer example
        List<? super Fruit> consumer = new ArrayList<>();
        consumer.add(new Apple());
        consumer.add(new AsianApple());
        consumer.add(new Banana());
        consumer.add(new Fruit());
        // consumer.add(new Object()); error
        consumer = new ArrayList<Object>();
        // consumer = new ArrayList<AsianApple>(); error

        List<? super Apple> consumer1 = new ArrayList<>();
        List<? super Fruit> con2 = new ArrayList<>();
        consumer1 = con2;

        // Producer example
        List<? extends Apple> producer = new ArrayList<>();
        producer = Arrays.asList(new Apple(), new AsianApple());
        // producer = Arrays.asList(new Apple(),new AsianApple(), new Fruit()); //error,
        // Fruit does not extends Apple
        Apple app = producer.get(1);

    }

}

class Fruit {
    Fruit() {
        System.out.println("in Fruit");
    }
}

class Apple extends Fruit {
    Apple() {
        System.out.println("in Apple");
    }
}

class AsianApple extends Apple {
    AsianApple() {
        System.out.println("in AsianApple");
    }
}

class Banana extends Fruit {
    Banana() {
        System.out.println("in Banana");
    }
}
