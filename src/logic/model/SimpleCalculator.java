package logic.model;

import logic.exception.InvalidConversion;
import logic.exception.InvalidDivision;
import logic.exception.InvalidLogarithm;

public class SimpleCalculator {
	
	private static final Double ZERO = Double.valueOf(0);
	
	private Double first;
	private Double second;
	
	public SimpleCalculator(String first, String second) throws InvalidConversion {
		try {			
			this.first = Double.valueOf(first);
			this.second = Double.valueOf(second);
		} catch (NumberFormatException e) {
			throw new InvalidConversion();
		}
	}
	
	public String add() {
		Double result = first + second;
		return result.toString();
	}
	
	public String sub() {
		Double result = first - second;
		return result.toString();
	}
	
	public String mul() {
		Double result = first * second;
		return result.toString();
	}
	
	public String divide() throws InvalidDivision   {
		if(second.equals(ZERO))
			throw new InvalidDivision();
		Double result = first / second;
		return result.toString();
	}
	
	public String log() throws InvalidLogarithm {
		if(first <= ZERO || second <= ZERO || second.equals(Double.valueOf(1))) {
			throw new InvalidLogarithm();
		}
		Double result = Math.log(first) / Math.log(second);
		return result.toString();
	}
	
	
	

}
