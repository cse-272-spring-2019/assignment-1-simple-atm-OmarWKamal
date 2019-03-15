package project1;

import javafx.application.Application;
import javafx.stage.Stage;

public class GUI extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ATM");
		
		
		//CREATING PROJECT OBJECTS
		LoginForm loginform = new LoginForm();
		Menu menu = new Menu();
		deposit deposition = new deposit();
		Bankacc user = new Bankacc();
		withdraw withdrawal = new withdraw();
		
		
		//SENDING OBJECTS TO CLASSES TO ACCESS METHODS AND ATTRIBUTES
		loginform.setUser(user);
		loginform.LoginScene();
		menu.menuScene();
		menu.setUser(user);
		deposition.setUser(user);
		withdrawal.setUser(user);
		
		loginform.LoginScene(primaryStage);
		menu.menuScene(primaryStage);
		deposition.depositScene(primaryStage);
		withdrawal.withdrawScene(primaryStage);
		
		
		loginform.setMenu(menu);
		menu.setLoginform(loginform);
		deposition.setMenu(menu);
		withdrawal.setMenu(menu);
		menu.setWithdrawal(withdrawal);
		menu.setDeposition(deposition);
		
		primaryStage.setScene(loginform.getScene());
		primaryStage.show();
	}
}