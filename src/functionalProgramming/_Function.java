package functionalProgramming;
import java.util.function.*;

public class _Function {

	public static void main(String[] args) {
		
		UnaryOperator<Integer> increment = value -> {
			System.out.println("in increment "+value);
			return value+=1;
			};
		
		//System.out.println(increment.apply(5));
		
		Function<Integer, Integer> multiply = val -> {
			System.out.println("in multiply "+val);
			return val*10;
			};
		
		//System.out.println(increment.andThen(multiply).apply(5));
		
		System.out.println(increment.andThen(multiply).compose(increment).apply(5));
		
		BiFunction<String, Integer, String> bifun = (val1,val2) -> {
				return val1.repeat(val2);
		};
		
		Function<String, String> upper = val -> val.toUpperCase();
		
		System.out.println(bifun.andThen(upper).apply("test", 3));

	}

}
