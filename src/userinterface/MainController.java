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

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Logic;
import model.User;
import threads.GUIUpdateControllThread;
import threads.TimeThread;

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
	private Label errorLb;

	@FXML
	private Label emptyErrorLb;
	

    @FXML
    private Label emptyUserErrorLb;

	@FXML
	private Label userLb;

	@FXML
	private ComboBox<String> userComboBox;

	@FXML
	private Button enterButton;
	
    @FXML
    private Button addUserButton;
    
    @FXML
    private Button exitButton;
    
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
    private MenuBar menubar;
    
	private Logic logic;
	private AlertBoxAddUser addUserWindow;
	private String date;

	@FXML
	public void initialize() {

		errorLb.setVisible(false);
		emptyErrorLb.setVisible(false);
		sepPane.setVisible(false);
		emptyUserErrorLb.setVisible(false);
		timeLb.setVisible(false);
		timeLb.setText("");
		exitButton.setVisible(false);
		exitButton.setGraphic(new ImageView(new Image("/images/exit-01.png")));
		
		String style = "-fx-font-weight: bold; -fx-background-color: SNOW;";
		menubar.setStyle(style);
		
		sepPane1.setVisible(false);
		sepPane11.setVisible(false);
		sepPane111.setVisible(false);
		sepPane1111.setVisible(false);
		
		GUIUpdateControllThread guiThread = new GUIUpdateControllThread(this); 
    	guiThread.setDaemon(true);
    	guiThread.start();
    	
    	TimeThread timeThread = new TimeThread(this);
    	timeThread.setDaemon(true);
    	timeThread.start();

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
    	
    	if(userComboBox.getValue()!=null) {
    		
    		userLb.setVisible(false);
        	userComboBox.setVisible(false);
        	enterButton.setVisible(false);
        	emptyUserErrorLb.setVisible(false);
        	addUserButton.setVisible(true);
        	title.setLayoutY(43.0);
        	sepPane.setVisible(true);
        	timeLb.setVisible(true);
        	exitButton.setVisible(true);
        	
        	sepPane1.setVisible(true);
			sepPane11.setVisible(true);
			sepPane111.setVisible(true);
			sepPane1111.setVisible(true);
			sepPane11111.setVisible(true);
        	
    	}else {
    		
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
				title.setLayoutY(14);

				sepPane.setVisible(true);
				addUserButton.setVisible(true);
				
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
		//addUserWindow.display(this);
    }
	
	public void createUser(String name) {
		logic.addUser(name);
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
}
