package static_test;

public class TestStatic {

    // static {
    // System.out.println("in static block");
    // byte b = -128;
    // }

    {
        System.out.println("in instance block");
    }

    public static void main(String[] args) {
        System.out.println("in main");
        new TestStatic();
    }

    static {
        System.out.println("in static block");
        byte b = -128;
    }

}
