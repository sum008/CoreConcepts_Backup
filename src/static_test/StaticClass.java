package static_test;

public class StaticClass {

	public static void main(String[] args) {
		Test t = new Test();
		t.print();
		
		Test2 t2 = new StaticClass().new Test2();
		t2.print();
	}
	
	private static class Test { //static inner class
		void print() {
			System.out.println("test");
		}
	}
	
	private class Test2 {
		void print() {
			System.out.println("test2");
		}
	}
}


	
