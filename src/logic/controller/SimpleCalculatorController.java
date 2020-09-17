package logic.controller;

import logic.bean.OperationBean;
import logic.exception.InvalidConversion;
import logic.exception.InvalidDivision;
import logic.exception.InvalidLogarithm;
import logic.exception.InvalidOperator;
import logic.model.SimpleCalculator;

public class SimpleCalculatorController {
	
	public void compute(OperationBean bean) throws InvalidConversion, InvalidDivision, InvalidLogarithm, InvalidOperator  {
		SimpleCalculator calc = new SimpleCalculator(bean.getFirstNumber(), bean.getSecondNumber());
		switch (bean.getOperator()) {
		case "+":
			bean.setResult(calc.add());
			break;
		case "-":
			bean.setResult(calc.sub());
			break;
		case "*":
			bean.setResult(calc.mul()); 
			break;
		case "/":
			bean.setResult(calc.divide());
			break;
		case "log":
			bean.setResult(calc.log());
			break;
		default:
			throw new InvalidOperator();
		}
	}

}
