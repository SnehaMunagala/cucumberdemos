package com.calculator;

public class Calculator {

	
	public int add(int one, int two) {
		return one + two;
	}
	
	public int diff(int one, int two) {
		if(one > two) {
			return one - two;
		}else {
			return two - one;
		}
	}
	
	public int prod(int one, int two) {
		return one * two;
	}
	
	public int div(int one, int two) {
		if(two <=0) {
			throw new ArithmeticException("Divident should not be zero");
		}else {
			return one/two;
		}
	}
}
