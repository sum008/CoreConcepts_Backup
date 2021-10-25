package comparator_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Consumer;

public class Test {

    public static void main(String[] args) {
        List<Computer> lc = new ArrayList<>();
        lc.add(new Computer(16, 40000, "acer"));
        lc.add(new Computer(32, 80000, "asus"));
        lc.add(new Computer(8, 20000, "dell"));
        lc.add(new Computer(4, 20000, "lenovo"));
        // sorting based on Ram(internally implemented Comparable in Computer class)
        // Collections.sort(lc);
        Consumer<Computer> consume = com -> System.out.println(com.toString());
        lc.forEach(consume::accept);

        System.out.println("\n");

        // sorting based on price using Comparator
        // Comparator<Computer> comparator = new Comparator<Computer>() {
        // @Override
        // public int compare(Computer c1, Computer c2) {
        // if (c1.getPrice()>c2.getPrice()) {
        // return 1;
        // } else if (c1.getPrice()<c2.getPrice()) {
        // return -1;
        // }
        // return 0;
        // }
        // };

        // anonymous inner class using lambda
        Comparator<Computer> comparator = (Computer c1, Computer c2) -> {
            if (c1.getPrice() > c2.getPrice()) {
                return 1;
            } else if (c1.getPrice() < c2.getPrice()) {
                return -1;
            }
            return 0;
        };

        System.out.println("TT ");
        Collections.sort(lc, new TT());

        Collections.sort(lc, comparator);
        lc.forEach(consume::accept);

        System.out.println("TT ");

        System.out.println("\n");
        SortedSet<Computer> tset = new TreeSet<>(comparator);
        tset.add(new Computer(16, 40000, "acer"));
        tset.add(new Computer(32, 80000, "asus"));
        tset.add(new Computer(8, 20000, "dell"));
        tset.add(new Computer(64, 10000, "lenovo"));
        System.out.println(tset);

        Comparator<? super Computer> comp = tset.comparator();
        System.out.println(comp.compare(new Computer(16, 40000, "acer"), new Computer(16, 10000, "acer")));

        // extends extends implements
        // set <- SortedSet <- NavigableSet <-- TreeSet
    }
}

class TT implements Comparator<Computer> {

    @Override
    public int compare(Computer c1, Computer c2) {
        if (c1.getPrice() > c2.getPrice()) {
            return 1;
        } else if (c1.getPrice() < c2.getPrice()) {
            return -1;
        }
        return 0;
    }

}

class Computer implements Comparable<Computer> {

    private int ram;
    private int price;
    private String model;

    public Computer(int ram, int price, String model) {
        super();
        this.ram = ram;
        this.price = price;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Computer [ram=" + ram + ", price=" + price + ", model=" + model + "]";
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public int compareTo(Computer computer) {
        if (this.getRam() > computer.getRam()) {
            return 1;
        } else if (this.getRam() < computer.getRam()) {
            return -1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price, ram);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Computer other = (Computer) obj;
        return Objects.equals(model, other.model) && price == other.price && ram == other.ram;
    }
}