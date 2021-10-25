public class Test {
    public static void main(String[] args) {
        // B a = new B();
        // a.xx();
        Z z = new Z();
        z.print();
        z.sum();
    }
}

class A {
    public void print() throws Exception {
        System.out.println("in A");
    }

    public void xx() {
        System.out.println("in A xx");
    }
}

class B extends A {

    @Override
    public void print() {
        System.out.println("in B");
    }
}

interface X {
    default void print() {
        System.out.println("in interface X print");
    }

    void sum();
}

interface Y {
    default void print() {
        System.out.println("in interface Y print");
    }

    void sum();
}

class Z implements X, Y {
    @Override
    public void print() {
        X.super.print();
        Y.super.print();
    }

    @Override
    public void sum() {
        System.out.println("in sum");

    }

}

// cannot extend multiple abstract class, will cause diamond problem
// abstract class P {
// abstract void a();

// void b() {
// System.out.println("in P b()");
// }
// }

// abstract class C {
// abstract void a();
// }

// class child extends P,C
// {

// }

// @Override
// void a() {
// // TODO Auto-generated method stub

// }
