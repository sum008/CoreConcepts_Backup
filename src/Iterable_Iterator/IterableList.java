package Iterable_Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableList<T> implements Iterable<T> {
    ArrayList<T> list;

    IterableList() {
        list = new ArrayList<>();
    }

    public boolean add(T item) {
        return list.add(item);
    }

    @Override
    public Iterator<T> iterator() {
        return new IterateOverList<>(list);
    }

}

class IterateOverList<T> implements Iterator<T> {

    List<T> iterableList;
    int index;

    public IterateOverList(List<T> list) {
        iterableList = list;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return iterableList.size() > index;
    }

    @Override
    public T next() {
        T item = iterableList.get(index);
        index += 1;
        return item;
    }

}
