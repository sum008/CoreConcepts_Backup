package functionalProgramming;

public interface TestInterfaceTest extends TestInterface {

	static TestInterfaceTest check() {
		return new TestInterfaceTest() {

			@Override
			public int add(int a) {
				System.out.println(a+2);
				return a+2;
			}

//			@Override
//			public void sub(int a) {
//				
//			}
		};
	}
	
	//works because interface TestInterface only have one declared method, if I uncomment sub(), it will fail
	//the return here is for the implementation of TestInterface and as -> val+2 is one liner, we don't need return statement for that
	static TestInterfaceTest check2() {
		return val -> val+2;
	}
	
	//with two return statement, 2nd one is for implemented method(add)
//	static TestInterfaceTest check3() {
//		return val -> {return val+2;};
//	}
	
//	static CombinatorPattern isEmailValid() {
//		  return new CombinatorPattern() {
//		    @Override
//		    public ValidationResult apply(Customer customer) {
//		      return customer.getEmail().contains("@") ? ValidationResult.SUCCESS : ValidationResult.EMAIL_VALIDATION_FAILED;
//		    }
//		  };
//		}
	
//	static CombinatorPattern validateEmail() {
//		return customer -> customer.getEmail().contains("@") ? 
//				ValidationResult.SUCCESS : 
//					ValidationResult.EMAIL_VALIDATION_FAILED;
//	}
}
