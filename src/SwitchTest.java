public class SwitchTest {

    public void Test(int test) {
        switch (test) {
        case 1:
            System.out.println("this is 1");
            break;
        case 2:
            System.out.println("this is 2");
            break;
        case 3:
            System.out.println("this is 3");
            break;
        default:
            System.out.println("none of these " + test);
        }
    }

}
