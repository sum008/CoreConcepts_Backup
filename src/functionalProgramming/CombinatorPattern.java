package functionalProgramming;

import java.util.function.Function;
import functionalProgramming.CombinatorPattern.*;

public interface CombinatorPattern extends Function<Customer, ValidationResult> {
	
	static CombinatorPattern validatePhone() {
		return customer -> customer.getPhone().startsWith("+91") ? 
				ValidationResult.SUCCESS : 
					ValidationResult.PHONE_VALIDATION_FAILED;
	}
	
	//two return statements just like isEmailValid()
//	static CombinatorPattern validateEmail() {
//		return customer -> {return customer.getEmail().contains("@") ? 
//				ValidationResult.SUCCESS : 
//					ValidationResult.EMAIL_VALIDATION_FAILED;};
//	}

	static CombinatorPattern validateEmail() {
		return customer -> customer.getEmail().contains("@") ? 
				ValidationResult.SUCCESS : 
					ValidationResult.EMAIL_VALIDATION_FAILED;
	}
	//these methods are same, validateEmail is shot version of isEmailValid, internally java omits new CombinatorPattern() line and method override line if
	//we use lambda for implementation
	static CombinatorPattern isEmailValid() {
		  return new CombinatorPattern() {
		    @Override
		    public ValidationResult apply(Customer customer) {
		      return customer.getEmail().contains("@") ? ValidationResult.SUCCESS : ValidationResult.EMAIL_VALIDATION_FAILED;
		    }
		  };
		}
	
	//there are two return statements here because 1st return statement is for new CombinatorPattern()(interface implementation), and 2nd is for 
	//the implemented method(apply) return, as we multiple lines of code, we need to use {} these brackets with explicit return statement,
	// if we had only one line of code, then we could have omitted return statement like validateEmail() method
	default CombinatorPattern and(CombinatorPattern other) {
		return customer -> {
			ValidationResult result = this.apply(customer);
			return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
		};
	}
	
	enum ValidationResult {
		SUCCESS, PHONE_VALIDATION_FAILED, EMAIL_VALIDATION_FAILED
	}
}
