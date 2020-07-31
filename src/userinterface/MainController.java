package userinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.Logic;

public class MainController {

	@FXML
	private ImageView title;

	@FXML
	private Label lb1;

	@FXML
	private Label lb2;

	@FXML
	private Label lb3;

	@FXML
	private Label lb4;

	@FXML
	private PasswordField password1TxtField;
	
	@FXML
	private PasswordField password2TxtField;
	
	@FXML
	private TextField nameTxtField;

	@FXML
	private Button saveButton;
	
    @FXML
    private Label errorLb;

	@FXML
	public void initialize() {

		Logic logic = new Logic();
		errorLb.setVisible(false);

	}

	@FXML
	void save(ActionEvent event) {
		
		String adminName = nameTxtField.getText();
		String password1 = password1TxtField.getText();
		String password2 = password2TxtField.getText();
		
		if(password1.equals(password2)) {
			errorLb.setVisible(false);
		}else {
			errorLb.setVisible(true);
			password1TxtField.setText("");
			password2TxtField.setText("");
		}
	
		
	}
}
