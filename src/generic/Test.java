package generic;

import java.io.Serializable;
import java.util.*;

interface Container<T> {
    void set(T t);

    T get();
}

public class Test {

    public static void main(String[] args) {
        Container<List<Integer>> lisContainer = new Store<>();
        lisContainer.set(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(lisContainer.get());

        Container<String> stringContainer = new Store<>();
        stringContainer.set("test");
        System.out.println(stringContainer.get());

        List<String> strings1 = Arrays.asList("1", "2", "3");
        List<Integer> temp = Arrays.asList(1, 2, 3);
        List<Integer> strings2 = Arrays.asList(2, 3, 4);

        System.out.println("########## Golam ##########");
        System.out.println(new Gloam<>().glom(strings1, temp));
        // Object o = new ArrayList<String>();
        // List<String> l=(List<String>)o;
        // l.add("sdfsdf");
        // System.out.println(l);

        // Check<String> s = new Check<>();
        // s.sum("test");

        // Child c = new Child();
        // Parent p = (Child)c;
        // p.print("data");

        List<Float> lk = Arrays.asList(1.1F, 2.1F, 3.1F, 4.1F);
        List<? extends Number> lkr = new ArrayList<>();
        lkr = lk;
        System.out.println(lkr);

        // List<Number> gg = new ArrayList<>();
        // gg=lk;

        List<Integer> l = Arrays.asList(1, 2, 3, 4);
        for (Integer i : l) {
            int x = i + 1;// autoboxing
            System.out.println(x);
        }
        List x = new ArrayList();
        x.add(1);
        x.add("wer");
        System.out.println(x);

        Parent<Integer> p = new Parent<>();
        Float ig = 7.5F;
        p.print(0);
        Integer u = 5;
        Parent.staticMethod(u);
        Parent.staticMethod2("test");

        X<?> xx;
        xx = new X<Integer>();
        xx = new X<Float>();
        xx = new X<Double>();
        xx = new X<Long>();
        xx = new X<Number>();
        System.out.println(xx);
        xx.pprint(2);

        Z<Long> z = new Z<>();
        z.pp(5, 'a');
        z.qq(5L);

        // TT<?> tq = new TT<>();
        //// Object o="Dsfsf";
        // tq.tt(5L); //because the generic type is a wildcard, compiler won't know at
        // compile time if the data being passed to the method is correct data or not,
        // //so to avoid runtime error, compiler is throwing an error.
        //
        // List<?> lis = new ArrayList<>();
        // lis.add("wre"); //compiler don't know if the data being added in list is in
        // correct format or not as in future if adding is allowed, one can add integer
        // or string,
        // and is someone try to access data and expecting it to be string but it comes
        // out to be integer, java will throw classCastException at runtime as compiler
        // will do explicit casting of integer to string..

        List<? super Number> l1; // consumer
        List<? extends Number> l2; // producer

        List<Number> nbr;
        nbr = Arrays.asList(1, 2L, 3.5);
        // List<String> str;
        // str=Arrays.asList("as","fd");
        // l1=str;
        l1 = nbr;
        System.out.println(l1);
        // l1=Arrays.asList("S",1);
        l2 = Arrays.asList(1, 2.5);
        Collections.copy(l1, l2);
        System.out.println(l1);

        // List<?> lll = new ArrayList<>();
        // lll.add(2);
    }
}

class Y implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) { // bridge method will be created at compile time because type erasure
                                                 // wont do its work as type here is Integer,
        // so to make this generic method a raw method(as all generic
        // classes/methods/interfaces got converted to raw type[simple object type]),
        // the bridge method in turn will call this method

        // public int compare(Object o1, Object o2) { //bridge method
        // return compare(Integer o1, Integer o2);
        // }
        return 0;

        // Below is the byte code of this method and bridge method

        // public int compare(java.lang.Integer, java.lang.Integer);
        // descriptor: (Ljava/lang/Integer;Ljava/lang/Integer;)I
        // flags: ACC_PUBLIC
        // Code:
        // stack=1, locals=3, args_size=3
        // 0: iconst_0
        // 1: ireturn
        // LineNumberTable:
        // line 83: 0
        // LocalVariableTable:
        // Start Length Slot Name Signature
        // 0 2 0 this Lgeneric/Y;
        // 0 2 1 o1 Ljava/lang/Integer;
        // 0 2 2 o2 Ljava/lang/Integer;

        // public int compare(java.lang.Object, java.lang.Object);
        // descriptor: (Ljava/lang/Object;Ljava/lang/Object;)I
        // flags: ACC_PUBLIC, ACC_BRIDGE, ACC_SYNTHETIC
        // Code:
        // stack=3, locals=3, args_size=3
        // 0: aload_0
        // 1: aload_1
        // 2: checkcast #22 // class java/lang/Integer
        // 5: aload_2
        // 6: checkcast #22 // class java/lang/Integer
        // 9: invokevirtual #24 // Method
        // compare:(Ljava/lang/Integer;Ljava/lang/Integer;)I
        // 12: ireturn
        // LineNumberTable:
        // line 1: 0
        // LocalVariableTable:
        // Start Length Slot Name Signature
        // }
    }
}

class TT<T> {
    public void tt(T t) {
        System.out.println("in TT's tt " + t);
    }
}

class Z<T extends Number> {
    public <U extends Number, V extends Serializable> void pp(U u, V v) {
        System.out.println("in Z's pp " + u + " " + v);
    }

    public void qq(T t) {
        System.out.println("in Z's qq " + t);
    }
}

class X<T extends Number> {

    public X() {
        System.out.println("in X Constructor " + this.getClass().getGenericSuperclass());
    }

    public <K extends Number> void pprint(K t) { // will take only those parameter type who extends Number,
        // witness type is present before return type, it will make sure of this rule
        System.out.println("In X " + t);
    }
}

class Parent<T extends Number> {
    public static <U extends Number> void staticMethod(U t) {
        System.out.println(t + " in parent staticMethod");
    }

    public static <U> void staticMethod2(U t) {
        System.out.println(t + " in parent staticMethod2");
    }

    public void print(T data) {
        System.out.println("In Parent " + data);
    }

    // public <V extends Integer> void superTest(V data) {} -> unnecessary as
    // Integer
    // is final type and no class can extends Integer
}

class Child extends Parent<Integer> {
    public void print(Integer data) {
        System.out.println("In Child " + data);
    }

    public <T> void check(T data) {
        System.out.println("In Child " + data);
    }
}

class Check<T> {
    public void sum(T t) {
        Integer i = (Integer) t;
        System.out.println(i);
    }
}

class Store<T> implements Container<T> {
    private T t;

    @Override
    public void set(T t) {
        this.t = t;
    }

    @Override
    public T get() {
        return this.t;
    }

}

class Gloam<T> {

    String glom(Collection<?> objs1, Collection<?> objs2) {
        return "collection";
    }

    int glom(List<Integer> ints, List<Integer> list2) {
        System.out.println("List");
        return 1;
    }

    // after type erasure the below method parameters will be same, so compiler will
    // throw error

    /*
     * String glom(List<?> objs1,List<?> objs2) { return "collection"; }
     * 
     * int glom(List <Integer> ints, List<Integer> list2 ) {
     * System.out.println("List"); return 1; }
     */
}
