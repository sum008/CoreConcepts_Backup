package InheritPoly;

public class InheritPoly {

    public static void main(String[] args) {
        // when using inheritance, prefer using child c = new child() as child will have
        // all the parent's method as well as its own methods,
        // so "c" reference will have all the parents as well as child's methods for
        // invoking, even if child don't override parents method,
        // using reference "c" we can call parents method as when we extend class, the
        // parents method is available at compile time,
        // that why we call any class's method by reference because it will get checked
        // at compile time only that the calling method
        // is available in the reference class or not, and which method to call depends
        // on the object(new classname),
        // if the calling method is not present the class for which we are creating the
        // object then it will move one step up and search for the method in parent,
        // and jvm will continue to do this operation as long as it don't find the
        // called method via class reference
        // child1 p = new child2();
        // p.m1();
        // p.m2();
        //
        // child1 c1 = new child1();
        //
        // Parent p1 = new Parent();
        // p1.printFromClass(c1);
        //
        Parent c2 = new child2();
        // System.out.println(c2.hashCode());
        // Q q=c2.returnNonPremitive();
        // q.printA();
        c2.check(2);
        c2.staticMethod();
        // c2.staticMethod();

        // P p = new R();
        // System.out.println(p.a);
    }

}

class P {
    int a = 10;

    protected void printA() {
        System.out.println("Parent a " + a);
    }
}

class R extends P {
    int a = 12;

    protected void printA() {
        System.out.println("R a " + a);
    }
}

class Q extends R {
    int a = 11;

    @Override
    public void printA() {
        System.out.println("clild a " + a);
        System.out.println("Parent a in child a " + super.a);
    }
}

class Parent {

    public Parent() {
        System.out.println("in parent no-arg constructor");
    }

    public static void staticMethod() {
        System.out.println("Parent static method");
    }

    public void m1() {
        System.out.println("in parent m1");
    }

    public void m2() {
        System.out.println("in parent m2");
    }

    public P returnNonPremitive() {
        System.out.println("returnNonPremitive parent");
        return new P();
    }

    public void printFromClass(Parent p) {
        p.print();
    }

    public void print() {
        System.out.println("print from parent");
    }

    public void check(long a) {
        System.out.println("in parent check");
    }
}

class child1 extends Parent {

    // if we comment out no-arg const and leave arg const, compiler will give
    // compile time error as compiler will look
    // for no-arg const in this child class as we are extending this class,
    // so extending means obj of Parent class will also get created when we create
    // obj of Child class, and to create obj, compiler required const,
    // as when we extend, we don't define which const we are referring to,
    // compiler by default looks for no-args const and if compiler don't find one in
    // parent class, compiler throws an error

    // public child1() {
    // System.out.println("in child1 no-arg const");
    // }

    public child1(int a) {
        System.out.println("in child1 arg const");
    }

    public static void staticMethod() {
        System.out.println("child1 static method");
    }

    public void m1() {
        System.out.println("in child1 m1");
    }

    public void m2() {
        System.out.println("in child1 m2");
    }

    public void print() {
        System.out.println("print from child1");
    }

    public Q returnNonPremitive() {
        System.out.println("returnNonPremitive child1");
        return new Q();
    }

    public void check(double a) {
        System.out.println("in child1 check");
    }
}

class child2 extends child1 {

    // when we create object of child class, child class will try to create object
    // of Parent class and for that child class will by default call no-agr const.
    // BUT if the Parent class only have arg const. then Child class will throw
    // compile time error as java bydefault looks for no-args const.
    // Now if we explicitly point to arg const. in child by super(arg1, arg2) then
    // there will be no compiler error as now its pointing to arg const.

    public child2(int x) {
        super(5);
        System.out.println("in child2 const");
    }

    public child2() {
        super(5);
    }

    public static void staticMethod() {
        System.out.println("child2 static method");
    }

    public void m1() {
        System.out.println("in child2 m1");
    }

    public void m2() {
        super.m2(); // will search this method from super of this class, in this case jvm will start
                    // searching from child1, if the method is present in child1,
        // then it will call child1 m2 else jvm will continue its search by moving up a
        // level as long as it don't find the m2 method
        System.out.println("in child2 m2");
    }

    public void print() {
        System.out.println("print from child2");
    }

    public void check(int a) {
        System.out.println("in child2 check");
    }
}
