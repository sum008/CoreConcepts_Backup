package intering;

public class Test {

	public static void main(String[] args) {
		String s1 = "testString";
		String s2 = "testString";
		if(s1 == s2) System.out.println("equals!");
		
		String s3 = new String("xx");
		String s4 = new String("xx");
		if(s3.intern() == s4.intern()) System.out.println("again equals!");
		
		System.out.println(Integer.valueOf(5000) == Integer.valueOf(5000));
	    System.out.println(Integer.valueOf(5000) == new Integer(5000));
	    System.out.println(Integer.valueOf(5000) == 5000);
	    System.out.println(new Integer(5000) == Integer.valueOf(5000));
	}

}
