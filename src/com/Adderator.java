package com;
public class Adderator {
	public int doAdd(String operation) throws Exception {
		int[] operands = getOperands(operation);
		return operands[0] + operands[1];
	}
	
	public int[] getOperands(String operation) throws Exception {
		String[] operands = new String[2];
		
		
		//remove "plus" or "+"
		int plusIdx = operation.indexOf("plus");
		if(plusIdx != -1) {
			operation = operation.substring(0, plusIdx-1) + operation.substring(plusIdx + 4);
			
		} else {
			plusIdx = operation.indexOf("+");
			if(plusIdx != -1) {
				operation = operation.substring(0, plusIdx-1) + operation.substring(plusIdx+1);
			}
		}
		
//		System.out.println("Removed plus: " + operation);
		
		int spaceIdx = operation.indexOf(" ");
		operands[0] = operation.substring(0, spaceIdx).trim();
		operands[1] = operation.substring(spaceIdx+1).trim();
		
//		System.out.println("Strings: " + operands[0] + ", " + operands[1]);
		
		return toInts(operands);
	}

	public int[] toInts(String[] operandsStr) throws Exception {
		int[] operands = new int[2];
		String[] nums = {"zero", "one", "two", "three", "four", "five",
						"six", "seven", "eight", "nine", "ten"
		};
		
		
		for(int i = 0; i < 2; i++) {
			//if already a number
			try {
				int o = Integer.parseInt(operandsStr[i]);
				operands[i] = o;
			} catch(NumberFormatException e) {
				//if a string
				boolean parsed = false;
				for(int j = 0; j < nums.length; j++) {
					if(nums[j].equalsIgnoreCase(operandsStr[i])) {
						operands[i] = j;
						parsed = true;
					}
				}
				if(!parsed) {
					throw new Exception();
				}
			}
		}
		
//		System.out.println("Ints: " + operands[0] + ", " + operands[1]);
		return operands;
	}
}
