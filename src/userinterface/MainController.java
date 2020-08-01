package userinterface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Logic;

public class MainController {

	@FXML
	private ImageView title;

	@FXML
	private Pane sepPane;

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
	private Label emptyErrorLb;

	@FXML
	private Label userLb;

	@FXML
	private ComboBox<String> userComboBox;

	@FXML
	private Button enterButton;
	
    @FXML
    private Button addUserButton;

	private Logic logic;
	private AlertBoxAddUser addUserWindow;

	@FXML
	public void initialize() {

		errorLb.setVisible(false);
		emptyErrorLb.setVisible(false);
		sepPane.setVisible(false);
		

		userComboBox.setVisible(false);
		enterButton.setVisible(false);
		userLb.setVisible(false);
		addUserButton.setVisible(false);

		File file = new File("data/dataa.dat");
		if (file.exists()) {

			lb1.setVisible(false);
			lb2.setVisible(false);
			lb3.setVisible(false);
			lb4.setVisible(false);
			password1TxtField.setVisible(false);
			password2TxtField.setVisible(false);
			nameTxtField.setVisible(false);
			saveButton.setVisible(false);

			userComboBox.setVisible(true);
			enterButton.setVisible(true);
			userLb.setVisible(true);
			
			loadData();
			
		}
		
		addUserWindow = new AlertBoxAddUser();

	}

	@FXML
	void save(ActionEvent event) {

		String adminName = nameTxtField.getText();
		String password1 = password1TxtField.getText();
		String password2 = password2TxtField.getText();

		if ((!adminName.equals("")) && (adminName.length() > 0) && (!password1.equals("")) && (password1.length() > 0)
				&& (!password2.equals("")) && (password2.length() > 0)) {

			emptyErrorLb.setVisible(false);

			if (password1.equals(password2)) {

				errorLb.setVisible(false);
				logic = new Logic(adminName, password1);
				saveData();

				lb1.setVisible(false);
				lb2.setVisible(false);
				lb3.setVisible(false);
				lb4.setVisible(false);
				password1TxtField.setVisible(false);
				password2TxtField.setVisible(false);
				nameTxtField.setVisible(false);
				saveButton.setVisible(false);
				title.setLayoutY(14);

				sepPane.setVisible(true);

			} else {

				errorLb.setVisible(true);
				password1TxtField.setText("");
				password2TxtField.setText("");

			}

		} else {
			emptyErrorLb.setVisible(true);
		}
	}

	public void loadData() {

		File file = new File("data/data.dat");

		try {

			ObjectInputStream io = new ObjectInputStream(new FileInputStream(file));
			logic = (Logic) io.readObject();
			io.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void saveData() {

		try {

			ObjectOutputStream io = new ObjectOutputStream(new FileOutputStream(new File("data/dataa.dat")));
			io.writeObject(logic);
			io.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@FXML
    void addUser(ActionEvent event) {
		addUserWindow.display(this);
    }
	
	public Logic getLogic() {
		return logic;
	}
}
