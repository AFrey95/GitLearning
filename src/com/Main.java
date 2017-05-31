package com;

public class Main {
	public static void main(String[] args) {
		Adderator adderator = new Adderator();
		String equation = "8 plus three";
		int result = 0;
		
		try {
			result = adderator.doAdd(equation);
		} catch (Exception e) {
			System.out.println("Couldn't compute '" + equation + "'");
		}
		
		System.out.println(equation + " = " + result);
	}
}
