package logic.bean;

public class OperationBean {

	private String firstNumber;
	private String operator;
	private String secondNumber;
	private String result;

	public String getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(String firstNumber) {
		assert firstNumber != null;
		this.firstNumber = firstNumber;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		assert operator != null;
		this.operator = operator;
	}

	public String getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(String secondNumber) {
		assert operator != null;
		this.secondNumber = secondNumber;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		assert result != null;
		this.result = result;
	}

}
