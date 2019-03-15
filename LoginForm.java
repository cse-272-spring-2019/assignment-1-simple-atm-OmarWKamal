package project1;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginForm{
	Validation validation;
	Stage stage;
	GUI gui;
	Menu menu;
	Scene loginScene;
	Bankacc user2;

	public void setUser(Bankacc user) {
		// TODO Auto-generated method stub
		this.user2 = user;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public Scene getScene() {
		return this.loginScene;
	}
	public void LoginScene(Stage primaryStage) {
		this.stage = primaryStage;
		
	}
	public void LoginScene(){
		//DECLARATIONS
		validation = new Validation();
		menu = new Menu();
		
		//CREATING SCENE
		Label creditcardnumberLabel = new Label("Enter your creditcard number: ");
		Label passwordLabel = new Label("Enter your password: ");
		TextField creditcardnumber = new TextField();
		PasswordField passwordField = new PasswordField();
		Button login = new Button("Login");
		Label validationLabel = new Label();
		GridPane loginpane = new GridPane();
		loginpane.add(creditcardnumberLabel, 0, 0);
		loginpane.add(passwordLabel, 0, 1);
		loginpane.add(creditcardnumber, 1, 0);
		loginpane.add(passwordField, 1, 1);
		loginpane.add(login, 2, 0);
		loginScene = new Scene(loginpane, 800, 600);
		//END OF SCENE
		
		//BUTTON FUNCTION
		login.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				//IF CORRECT GO TO MENU
				String creditcard = creditcardnumber.getText();
				String password = passwordField.getText();
				boolean valid = validation.validate(creditcard, password);
				if(valid) {
					creditcardnumber.clear();
					passwordField.clear();
					stage.setScene(menu.getScene());
				}
				//ELSE PRINT ERROR 
				else {
					validationLabel.setText("Wrong password or username");
					loginpane.add(validationLabel, 5, 5);
				}
				
			}
			
		});
	}
}
