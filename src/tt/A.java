package tt;

interface int1 {
    int t = 10;

    default void x() {
        System.out.println("in int1");
    }
}

interface int2 {
    default void x() {
        System.out.println("in int2");
    }
}

public class A implements int1, int2 {

    @Override
    public void x() {
        System.out.println(int1.t);
        System.out.println("in A");
        int1.super.x();
        int2.super.x();
    }

}

