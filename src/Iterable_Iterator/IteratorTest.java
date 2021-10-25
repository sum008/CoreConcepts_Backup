package Iterable_Iterator;

import java.util.Iterator;

public class IteratorTest {

    public static void main(String[] args) {
        IterableList<Integer> iList = new IterableList<>();
        iList.add(5);
        iList.add(2);
        iList.add(4);
        iList.add(7);
        iList.add(51);
        iList.add(22);

        for (Integer item : iList) {
            System.out.println(item);
        }
        Iterator<Integer> iterator = iList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
