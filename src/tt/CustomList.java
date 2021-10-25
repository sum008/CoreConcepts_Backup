package tt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<T> implements Iterable<T> {

    private List<T> cList = new ArrayList<>();

    public void add(T item) {
        cList.add(item);
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(this.cList);
    }

    public class ListIterator<E> implements Iterator<E> {

        private List<E> list;
        private int currrentIndex = 0;

        public ListIterator(List<E> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return this.list.size() >= this.currrentIndex + 1;
        }

        @Override
        public E next() {
            E val = this.list.get(currrentIndex);
            this.currrentIndex++;
            return val;
        }

    }

}
