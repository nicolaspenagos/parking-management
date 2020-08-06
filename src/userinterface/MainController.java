package userinterface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Logic;
import model.Register;
import model.User;
import threads.GUIUpdateControllThread;
import threads.TimeThread;

public class MainController {

	private static final int LIMIT = 1;

	@FXML
	private ImageView title;

	@FXML
	private Pane sepPane;

	@FXML
	private Label av1;

	@FXML
	private Label av2;

	@FXML
	private Label av3;

	@FXML
	private Label avR;

	@FXML
	private Label avH;

	@FXML
	private Label avP;

	@FXML
	private Label avT;

	@FXML
	private Label lb1;

	@FXML
	private Label lb2;

	@FXML
	private Label lb3;

	@FXML
	private Label lb4;

	@FXML
	private Label timeLb;

	@FXML
	private PasswordField password1TxtField;

	@FXML
	private PasswordField password2TxtField;

	@FXML
	private TextField nameTxtField;

	@FXML
	private Button saveButton;

	@FXML
	private Button cancelButton;

	@FXML
	private Button confirmButton;

	@FXML
	private Label errorLb;

	@FXML
	private Label emptyErrorLb;

	@FXML
	private Label emptyUserErrorLb;

	@FXML
	private Label currentUserLb;

	@FXML
	private Label userLb;

	@FXML
	private ComboBox<String> userComboBox;

	@FXML
	private Button enterButton;

	@FXML
	private Button reportButton;

	@FXML
	private Button exitButton;

	@FXML
	private Button enterVehicleButton;

	@FXML
	private Button removeVehicleButton;

	@FXML
	private Pane sepPane1;

	@FXML
	private Pane sepPane11;

	@FXML
	private Pane sepPane111;

	@FXML
	private Pane sepPane1111;

	@FXML
	private Pane sepPane11111;

	@FXML
	private Pane sepPane111111;

	@FXML
	private Pane sepPane2;

	@FXML
	private Pane sepPane3;

	@FXML
	private Pane sepPane4;

	@FXML
	private MenuItem addUserMenuBar;

	@FXML
	private Label ivLb4;

	@FXML
	private TextField p1;

	@FXML
	private Label ivLb6;

	@FXML
	private TextField p2;

	@FXML
	private TextField p3;

	@FXML
	private TextField p4;

	@FXML
	private TextField p5;

	@FXML
	private TextField p6;

	@FXML
	private ComboBox<String> type;

	@FXML
	private Label ivLb5;

	@FXML
	private Label ivLb1;

	@FXML
	private Label av0;

	@FXML
	private Label ivLb3;

	@FXML
	private MenuBar menubar;

	@FXML
	private Label addVehicleErrorLabel;

	@FXML
	private Button cancelButton1;

	@FXML
	private Button confirmButton1;

	private Logic logic;
	private AlertBoxAddUser addUserWindow;
	private String date;
	private String currentPlate;
	private Calendar currentDate;
	private String currentResponsable;
	private String currentType;

	@FXML
	public void initialize() {

		currentUserLb.setVisible(false);
		errorLb.setVisible(false);
		emptyErrorLb.setVisible(false);
		sepPane.setVisible(false);
		emptyUserErrorLb.setVisible(false);
		timeLb.setVisible(false);
		timeLb.setText("");
		exitButton.setVisible(false);
		exitButton.setGraphic(new ImageView(new Image("/images/exit-01.png")));
		reportButton.setGraphic(new ImageView(new Image("/images/report.png")));
		enterVehicleButton.setGraphic(new ImageView(new Image("/images/enterV.png")));
		removeVehicleButton.setGraphic(new ImageView(new Image("/images/exitV-01.png")));

		addVehicleErrorLabel.setVisible(false);
		cancelButton1.setVisible(false);
		confirmButton1.setVisible(false);
		sepPane2.setVisible(false);
		sepPane3.setVisible(false);
		sepPane4.setVisible(false);

		av0.setVisible(false);
		av1.setVisible(false);
		av2.setVisible(false);
		av3.setVisible(false);

		avH.setVisible(false);
		avP.setVisible(false);
		avR.setVisible(false);
		avT.setVisible(false);

		enterVehicleButton.setVisible(false);
		removeVehicleButton.setVisible(false);

		// cancelButton.setGraphic(new ImageView(new Image("/images/cancel-01.png")));
		cancelButton.setVisible(false);
		// confirmButton.setGraphic(new ImageView(new Image("/images/confirm-01.png")));
		confirmButton.setVisible(false);

		addUserMenuBar.setDisable(true);

		String style = "-fx-font-weight: bold; -fx-background-color: SNOW;";
		menubar.setStyle(style);

		sepPane1.setVisible(false);
		sepPane11.setVisible(false);
		sepPane111.setVisible(false);
		sepPane1111.setVisible(false);
		sepPane111111.setVisible(false);

		p1.setVisible(false);
		p2.setVisible(false);
		p3.setVisible(false);
		p4.setVisible(false);
		p5.setVisible(false);
		p6.setVisible(false);

		p1.lengthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (p1.getText().length() >= LIMIT) {

						// if it's 11th character then just setText to previous
						// one
						p1.setText(p1.getText().substring(0, LIMIT).toUpperCase());
						if (!Character.isLetter(p1.getText().charAt(0)))
							p1.setText("");

					}
				}
			}
		});

		p2.lengthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (p2.getText().length() >= LIMIT) {

						// if it's 11th character then just setText to previous
						// one
						p2.setText(p2.getText().substring(0, LIMIT).toUpperCase());
						if (!Character.isLetter(p2.getText().charAt(0)))
							p2.setText("");

					}
				}
			}
		});

		p3.lengthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (p3.getText().length() >= LIMIT) {

						// if it's 11th character then just setText to previous
						// one
						p3.setText(p3.getText().substring(0, LIMIT).toUpperCase());
						if (!Character.isLetter(p3.getText().charAt(0)))
							p3.setText("");

					}
				}
			}
		});

		p4.lengthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (p4.getText().length() >= LIMIT) {

						// if it's 11th character then just setText to previous
						// one
						p4.setText(p4.getText().substring(0, LIMIT).toUpperCase());
						if (!Character.isDigit(p4.getText().charAt(0)))
							p4.setText("");

					}
				}
			}
		});

		p5.lengthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (p5.getText().length() >= LIMIT) {

						// if it's 11th character then just setText to previous
						// one
						p5.setText(p5.getText().substring(0, LIMIT).toUpperCase());
						if (!Character.isDigit(p5.getText().charAt(0)))
							p5.setText("");

					}
				}
			}
		});

		p6.lengthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (p6.getText().length() >= LIMIT) {

						// if it's 11th character then just setText to previous
						// one
						p6.setText(p6.getText().substring(0, LIMIT).toUpperCase());
						if (!Character.isDigit(p6.getText().charAt(0)))
							p6.setText("");

					}
				}
			}
		});

		ivLb1.setVisible(false);
		av0.setVisible(false);
		ivLb3.setVisible(false);
		ivLb4.setVisible(false);
		ivLb5.setVisible(false);
		ivLb6.setVisible(false);

		type.setVisible(false);

		GUIUpdateControllThread guiThread = new GUIUpdateControllThread(this);
		guiThread.setDaemon(true);
		guiThread.start();

		TimeThread timeThread = new TimeThread(this);
		timeThread.setDaemon(true);
		timeThread.start();

		userComboBox.setVisible(false);
		enterButton.setVisible(false);
		userLb.setVisible(false);
		reportButton.setVisible(false);

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

			addUserMenuBar.setDisable(false);

			userComboBox.setVisible(true);
			enterButton.setVisible(true);
			userLb.setVisible(true);

			loadData();
			updateComboBox();

		}

		addUserWindow = new AlertBoxAddUser();

	}

	public void update() {
		timeLb.setText(date);
	}

	public void updateTime() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		date = dateFormat.format(cal.getTime());

	}

	@FXML
	void enter(ActionEvent event) {

		if (userComboBox.getValue() != null) {

			logic.setCurrentUser(logic.searchUser(userComboBox.getValue()));
			currentUserLb.setText("RESPONSABLE:  " + logic.getCurrentUser().getName().toUpperCase());

			userLb.setVisible(false);
			userComboBox.setVisible(false);
			enterButton.setVisible(false);
			emptyUserErrorLb.setVisible(false);
			reportButton.setVisible(true);
			title.setLayoutY(43.0);
			sepPane.setVisible(true);
			timeLb.setVisible(true);
			exitButton.setVisible(true);
			currentUserLb.setVisible(true);

			sepPane1.setVisible(true);
			sepPane11.setVisible(true);
			sepPane111.setVisible(true);
			sepPane1111.setVisible(true);
			sepPane11111.setVisible(true);
			sepPane111111.setVisible(true);

			sepPane2.setVisible(true);
			sepPane3.setVisible(true);
			sepPane4.setVisible(true);

			enterVehicleButton.setVisible(true);
			removeVehicleButton.setVisible(true);

		} else {

			emptyUserErrorLb.setVisible(true);
		}

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
				title.setLayoutY(43.0);

				timeLb.setVisible(true);

				sepPane1.setVisible(true);
				sepPane11.setVisible(true);
				sepPane111.setVisible(true);
				sepPane1111.setVisible(true);
				sepPane11111.setVisible(true);
				sepPane111111.setVisible(true);

				sepPane2.setVisible(true);
				sepPane3.setVisible(true);
				sepPane4.setVisible(true);

				enterVehicleButton.setVisible(true);
				removeVehicleButton.setVisible(true);

				exitButton.setVisible(true);
				currentUserLb.setVisible(true);
				currentUserLb.setText(logic.getAdmin().getName());

				sepPane.setVisible(true);
				reportButton.setVisible(true);

				addUserMenuBar.setDisable(false);

				updateComboBox();

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

		File file = new File("data/dataa.dat");

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

	@FXML
	void addUserMenuBar(ActionEvent event) {
		addUserWindow.display(this);
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
		// addUserWindow.display(this);
	}

	public void createUser(String name) {

		logic.addUser(name);
		saveData();
		updateComboBox();

	}

	public Logic getLogic() {
		return logic;
	}

	public void updateComboBox() {

		ArrayList<User> users = logic.getWorkers();

		List<String> namesList = new ArrayList<String>();

		String admin = logic.getAdmin().getName().toUpperCase();
		namesList.add(admin);

		for (int i = 0; i < users.size(); i++) {
			namesList.add(users.get(i).getName().toUpperCase());
		}

		userComboBox.setItems(FXCollections.observableArrayList(namesList));

	}

	@FXML
	void registerVehicle(ActionEvent event) {

		/*
		p1.setVisible(true);
		p2.setVisible(true);
		p3.setVisible(true);
		p4.setVisible(true);
		p5.setVisible(true);
		p6.setVisible(true);

		p1.setText("");
		p2.setText("");
		p3.setText("");
		p4.setText("");
		p5.setText("");
		p6.setText("");

		type.setValue("");

		ivLb1.setVisible(true);
		ivLb3.setVisible(true);
		ivLb4.setVisible(true);
		ivLb5.setVisible(true);
		ivLb6.setVisible(true);

		type.setVisible(true);

		enterVehicleButton.setVisible(false);
		removeVehicleButton.setVisible(false);

		cancelButton.setVisible(true);
		confirmButton.setVisible(true);
		// logic.AddVehicle(Calendar.getInstance());
		 * */
		
		 setVisibleRegisterVehicle(true);
	}

	@FXML
	void exit(ActionEvent event) {

		userLb.setVisible(true);
		userComboBox.setVisible(true);
		enterButton.setVisible(true);
		title.setLayoutY(191.0);

		sepPane.setVisible(false);
		sepPane1.setVisible(false);
		sepPane11.setVisible(false);
		sepPane111.setVisible(false);
		sepPane1111.setVisible(false);
		sepPane111111.setVisible(false);
		reportButton.setVisible(false);
		exitButton.setVisible(false);
		currentUserLb.setVisible(false);
		timeLb.setVisible(false);

		enterVehicleButton.setVisible(false);
		removeVehicleButton.setVisible(false);

		p1.setVisible(false);
		p2.setVisible(false);
		p3.setVisible(false);
		p4.setVisible(false);
		p5.setVisible(false);
		p6.setVisible(false);

		ivLb1.setVisible(false);
		av0.setVisible(false);
		ivLb3.setVisible(false);
		ivLb4.setVisible(false);
		ivLb5.setVisible(false);
		ivLb6.setVisible(false);

		type.setVisible(false);

		sepPane4.setVisible(false);
		sepPane2.setVisible(false);
		sepPane3.setVisible(false);

		enterVehicleButton.setVisible(false);
		removeVehicleButton.setVisible(false);

		cancelButton.setVisible(false);
		confirmButton.setVisible(false);

	}

	@FXML
	void cancel(ActionEvent event) {
		p1.setVisible(false);
		p2.setVisible(false);
		p3.setVisible(false);
		p4.setVisible(false);
		p5.setVisible(false);
		p6.setVisible(false);

		av0.setVisible(false);
		av1.setVisible(false);
		av2.setVisible(false);
		av3.setVisible(false);

		avH.setVisible(false);
		avP.setVisible(false);
		avR.setVisible(false);
		avT.setVisible(false);

		ivLb1.setVisible(false);
		av0.setVisible(false);
		ivLb3.setVisible(false);
		ivLb4.setVisible(false);
		ivLb5.setVisible(false);
		ivLb6.setVisible(false);

		type.setVisible(false);
		addVehicleErrorLabel.setVisible(false);

		enterVehicleButton.setVisible(true);
		removeVehicleButton.setVisible(true);

		cancelButton.setVisible(false);
		confirmButton.setVisible(false);
	}

	@FXML
	void addVehicle(ActionEvent event) {

		if (!p1.getText().equals("") && !p2.getText().equals("") && !p3.getText().equals("") && !p4.getText().equals("")
				&& !p5.getText().equals("") && !p6.getText().equals("") && !type.getValue().equals("")) {

			addVehicleErrorLabel.setVisible(false);
			p1.setVisible(false);
			p2.setVisible(false);
			p3.setVisible(false);
			p4.setVisible(false);
			p5.setVisible(false);
			p6.setVisible(false);

			ivLb1.setVisible(false);
			av0.setVisible(false);
			ivLb3.setVisible(false);
			ivLb4.setVisible(false);
			ivLb5.setVisible(false);
			ivLb6.setVisible(false);

			type.setVisible(false);

			currentPlate = p1.getText() + p2.getText() + p3.getText() + "-" + p4.getText() + p5.getText()
					+ p6.getText();
			currentResponsable = logic.getCurrentUser().getName();
			currentType = type.getValue();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			currentDate = Calendar.getInstance();
			String sDate = dateFormat.format(currentDate.getTime());

			ivLb1.setText("Por favor verifique que los datos ingresados son correctos:");
			ivLb1.setVisible(true);

		
			
			setConfirmationVehicleVisible(true);;
		
			avR.setText(currentResponsable);
			avH.setText(sDate);
			avT.setText(currentType);
			avP.setText(currentPlate);

		

		} else {

			addVehicleErrorLabel.setVisible(true);

		}
	}

	@FXML
	void okAdd(ActionEvent event) {
		
		setConfirmationVehicleVisible(false);
		ivLb1.setVisible(false);
		cancelButton1.setVisible(false);
		confirmButton1.setVisible(false);
		cancelButton.setVisible(false);
		confirmButton.setVisible(false);
		enterVehicleButton.setVisible(true);
		removeVehicleButton.setVisible(true);
		
		logic.addRegister(currentDate, currentPlate, currentResponsable, currentType);
		
	}

	@FXML
	void cancel1(ActionEvent event) {
		setVisibleRegisterVehicle(true);
		setConfirmationVehicleVisible(false);
	}
	
	public void setVisibleRegisterVehicle(boolean val) {
		
		p1.setVisible(val);
		p2.setVisible(val);
		p3.setVisible(val);
		p4.setVisible(val);
		p5.setVisible(val);
		p6.setVisible(val);

		p1.setText("");
		p2.setText("");
		p3.setText("");
		p4.setText("");
		p5.setText("");
		p6.setText("");

		type.setValue("");

		ivLb1.setVisible(val);
		ivLb3.setVisible(val);
		ivLb4.setVisible(val);
		ivLb5.setVisible(val);
		ivLb6.setVisible(val);

		type.setVisible(val);

		enterVehicleButton.setVisible(val);
		removeVehicleButton.setVisible(val);

		cancelButton.setVisible(val);
		confirmButton.setVisible(val);
		
		enterVehicleButton.setVisible(!val);
		removeVehicleButton.setVisible(!val);
		
		ivLb1.setText("Por favor registre los siguientes datos para ingresar un vehículo:");
		ivLb1.setVisible(val);

		
	}
	
	public void setConfirmationVehicleVisible(boolean val) {

		ivLb1.setText("Por favor verifique que los datos ingresados son correctos:");
		ivLb1.setVisible(true);

		av0.setVisible(val);
		av1.setVisible(val);
		av2.setVisible(val);
		av3.setVisible(val);

		avH.setVisible(val);
		avP.setVisible(val);
		avR.setVisible(val);
		avT.setVisible(val);
		
		cancelButton1.setVisible(val);
		cancelButton.setVisible(!val);
		
		confirmButton.setVisible(!val);
		confirmButton1.setVisible(val);
	}

}
