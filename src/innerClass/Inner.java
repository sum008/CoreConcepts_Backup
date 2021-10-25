package innerClass;

public class Inner {

    public static void main(String... arg) {

        OuterClass<? extends Number> oc;
        OuterClass<Long> occ = new OuterClass<>();
        oc = occ;
        occ.getInnerClass(11L).print(22L);
        occ.getInnerClass().print();
    }
}

class OuterClass<T> {

    public InnerClass<T> getInnerClass(T tt) {
        return new InnerClass<>(tt);
    }

    public InnerClass<T> getInnerClass() {
        return new InnerClass<>();
    }

    class InnerClass<E> {

        InnerClass() {
        }

        InnerClass(E e) {
            System.out.println("In InnerClass const.. " + e);
            this.print(e);
        }

        public void print(E e) {
            System.out.println("In InnerClass print " + e);
        }

        public void print() {
            System.out.println("In InnerClass print without method param");
        }
    }
}

/*
 * public static void main(String... arg) { Inner in=new Inner();; OuterClass<?
 * extends Number> oc; OuterClass<Long> occ = in.new OuterClass<>(); oc=occ;
 * //oc.getInnerClass(11L).print(22L); }
 * 
 * 
 * class OuterClass<T> {
 * 
 * public InnerClass<T> getInnerClass(T tt) { return new InnerClass<>(tt); }
 * 
 * class InnerClass<E> {
 * 
 * InnerClass() { }
 * 
 * InnerClass(E e) { System.out.println("In InnerClass const.. "+e);
 * this.print(e); }
 * 
 * public void print(E e) { System.out.println("In InnerClass print "+e); } } }
 * }
 */
