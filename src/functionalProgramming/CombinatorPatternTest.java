package functionalProgramming;

public class CombinatorPatternTest {

	public static void main(String[] args) {
		Customer cus = new Customer("test","test@gmail","+91098776", "MALE");
		
		System.out.println(CombinatorPattern.validateEmail().and(CombinatorPattern.validatePhone()).apply(cus));
		
		TestInterfaceTest.check().add(3);
		int a = TestInterfaceTest.check2().add(4);
		System.out.println(a);
		
	}

}
