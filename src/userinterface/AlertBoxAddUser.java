package userinterface;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBoxAddUser {

	public AlertBoxAddUser() {

	}

	public void display(MainController mc) {

		Stage window = new Stage();

		ImageView image = new ImageView(new Image("/images/user.png"));
		window.initModality(Modality.APPLICATION_MODAL);
		window.setWidth(450);
		window.setHeight(300);
		window.getIcons().add(new Image("/images/icon.png"));
		window.setResizable(false);

		VBox layout = new VBox(6);
		layout.setStyle("-fx-background-color: #E6EFF7;");

		Label Lb1 = new Label();
		Lb1.setStyle("-fx-font-size: 13pt;");
		Lb1.setText("Digite la contraseña de administrador");

		Label Lb2 = new Label();
		Lb2.setStyle("-fx-font-size: 13pt;");
		Lb2.setText("para añadir usuario:");

		Label space1 = new Label();
		PasswordField passwordTxtField = new PasswordField();
		passwordTxtField.setMaxWidth(200);
		
		Button passwordButton = new Button();
		passwordButton.setStyle("-fx-font-weight: bold;");
		passwordButton.setText("Confirmar");
		
		TextField name = new TextField();
		name.setMaxWidth(200);
		
		Button save = new Button();
		save.setStyle("-fx-font-weight: bold;");
		save.setText("Guardar");
		
		
		
		passwordButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				if(passwordTxtField.getText().equals(mc.getLogic().getPassword())) {
					
					layout.getChildren().clear();
					Lb2.setText("Digite el nombre del nuevo usuario");
					Lb1.setText(" ");
					layout.getChildren().addAll(image, Lb2, Lb1, name, save);
					
				}else {
					
					String style = "-fx-font-size: 12pt; -fx-text-fill: RED;";
					space1.setStyle(style);
					space1.setText("* Contraseña incorrecta *");
					
				}
			}
		});
		
		save.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				if(!name.getText().equals("") && name.getText().length() > 1) {
					mc.createUser(name.getText());
				}else {
					
				}
			}
		});

		layout.getChildren().addAll(image, Lb1, Lb2, space1 ,passwordTxtField,  passwordButton);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);

		window.setScene(scene);
		window.showAndWait();

	}

}
