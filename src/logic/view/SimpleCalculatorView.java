package logic.view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.bean.OperationBean;
import logic.controller.SimpleCalculatorController;
import logic.exception.InvalidConversion;
import logic.exception.InvalidDivision;
import logic.exception.InvalidLogarithm;
import logic.exception.InvalidOperator;

public class SimpleCalculatorView extends Application {

	private static final String APP_NAME = "MySimpleCalculator";
	private OperationBean bean;

	@FXML
	public Text TextResult;

	@FXML
	public TextField TextFieldFirst;

	@FXML
	public TextField TextFieldOperator;

	@FXML
	public TextField TextFieldSecond;

	@FXML
	public Button ButtonCompute;

	@FXML
	public Button ButtonClear;

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(SimpleCalculatorView.class.getResource("SimpleCalculator.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);

		primaryStage.setTitle(APP_NAME);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void onButtonCompute() {
		this.bean = new OperationBean();
		this.bean.setFirstNumber(TextFieldFirst.getText());
		this.bean.setOperator(TextFieldOperator.getText());
		this.bean.setSecondNumber(TextFieldSecond.getText());
		SimpleCalculatorController controller = new SimpleCalculatorController();
		try {
			controller.compute(this.bean);
			this.printResult();
		} catch (InvalidConversion e) {
			this.printError("Please insert valid number. (e.g. 1, -4, 5.2)");
		} catch (InvalidOperator e) {
			this.printError("Please insert one of the operators indicated.");
		} catch (InvalidDivision e) {
			this.printError("Please insert a valid division.\n(e.g. not divide by 0)");
		} catch (InvalidLogarithm e) {
			this.printError("Please insert a valid logarithm.\n(first > 0 and second > 0 and second != 1)");
		}
	}

	public void onButtonClear() {
		this.clear();
	}

	private void printResult() {
		String result = String.format("%s %s %s = %s", this.bean.getFirstNumber(), this.bean.getOperator(),
				this.bean.getSecondNumber(), this.bean.getResult());
		TextResult.setText(result);
	}

	private void printError(String message) {
		TextResult.setText(message);
	}

	private void clear() {
		TextFieldFirst.setText("");
		TextFieldOperator.setText("");
		TextFieldSecond.setText("");
		TextResult.setText(APP_NAME);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
