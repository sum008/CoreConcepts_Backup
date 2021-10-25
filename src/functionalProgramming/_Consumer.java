package functionalProgramming;

import java.util.function.*;

public class _Consumer {

	public static void main(String[] args) {
		Consumer<String> formatInput = val -> System.out.println(val.repeat(3));

		BiConsumer<String, Integer> biconsume = (val1, val2) -> System.out.println(val1.repeat(val2));

		biconsume.accept("test", 3);

		Predicate<String> p = val -> val.length() > 5;

		System.out.println(p.negate().test("1234567"));
	}

}
