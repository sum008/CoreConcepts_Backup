package static_test;

public class StaticTest {
	
	public static void print() {
		System.out.println("in static method of StaticTest #######3");
	}

    private static Test2 test2 = new Test2();//will be called at compile time
    private static Test3 test3 = new Test3();

    static {
        System.out.println("StaticTest static block start..");
        new Test();
        System.out.println("StaticTest static block end..");
    }

    private Test1 test1 = new Test1();//will be called when object of StaticTest is created, same as instance block

    {
        new Test();
        System.out.println("Inside StaticTest instance block, will be called before class constructor when object is getting created..");
    }

    public static void main(String[] args) {
    	StaticTest.print();
        System.out.println("Inside StaticTest main..");
        new StaticTest();
        
    }

}

class Test {

    {
        System.out.println("Inside Test class instance block..");
    }

    public Test() {
        System.out.println("Inside Test class const..");
    }
}

class Test1 {

    {
        System.out.println("Inside Test1 class instance block..");
    }

    public Test1() {
        System.out.println("Inside Test1 class const..");
    }
}

class Test2 {

    {
        System.out.println("Inside Test2 class instance block..");
    }

    public Test2() {
        System.out.println("Inside Test2 class const..");
    }
}

class Test3 {

    {
        System.out.println("Inside Test3 class instance block..");
    }

    public Test3() {
        System.out.println("Inside Test3 class const..");
    }
}
