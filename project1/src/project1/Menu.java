package project1;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class Menu{
	//DECLARATIONS
	Scene menuScene;
	LoginForm loginform;
	Stage stage;
	deposit dep;
	Bankacc user3;
	withdraw withdrawal;
	public int j = -1;
	
	//INITIALIZATIONS
	public void setWithdrawal(project1.withdraw withdrawal) {
		// TODO Auto-generated method stub
		this.withdrawal = withdrawal;
	}
	public Scene getScene() {
		return this.menuScene;
	}
	public void setUser(Bankacc user) {
		// TODO Auto-generated method stub
		this.user3 = user;
	}
	public void setLoginform(LoginForm loginform) {
		this.loginform = loginform;
	}
	public void setDeposition(deposit deposition) {
		// TODO Auto-generated method stub
		this.dep = deposition;
	}
	public void menuScene(Stage primaryStage) {
		this.stage = primaryStage;
	}
	//END OF INITIALIZATIONS
	
	
	public void menuScene(){
		dep = new deposit();
		withdrawal = new withdraw();
		loginform = new LoginForm();
		
		//CREATING SCENE
		Button deposit = new Button("Deposit");
		Button withdraw = new Button("Withdraw");
		Button inquiry = new Button("Balance Inquiry");
		Button previous = new Button("Previous");
		Button next = new Button("Next");
		Button logout = new Button("logout");
		Label balanceLabel = new Label();
		GridPane menu = new GridPane();
		menu.add(deposit, 0,0);
		menu.add(withdraw, 0,1);
		menu.add(inquiry, 0,2);
		menu.add(previous, 0,3);
		menu.add(next, 0,4);
		menu.add(logout, 0, 6);
		menu.add(balanceLabel, 2, 8);
		//SHOWING BUTTON WHEN INQUIRY BUTTON IS PRESSED
		previous.setDisable(true);
		next.setDisable(true);
		
		
		menuScene  = new Scene(menu, 800, 600);
		//END OF SCENE
		
		//BUTTONS FUNCTIONS
		inquiry.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
			balanceLabel.setText("");
			j = -1;
			if(user3.getI() == -1) {
				balanceLabel.setText("No balance to show");
			}
			else {
					//balanceLabel.
					balanceLabel.setText("Your balance is: " + user3.getBalance());
				}
			if(user3.getI() > -1) {
				previous.setDisable(false);
				next.setDisable(false);
			}
			}});
		logout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				stage.setScene(loginform.getScene());
			}
		});
		withdraw.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				stage.setScene(withdrawal.getScene());
			}
		});
		deposit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(dep.getScene());
			}
		});	
		previous.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				balanceLabel.setText("");
				j++;
				j = j%(user3.getI() + 1);
				j = j%5;
				next.setDisable(false);
				if(user3.getI() - j == 0 || j == 4) {
					previous.setDisable(true);
				}
				else if(user3.getI() > j) {
					previous.setDisable(false);
				}
				if(j >= 5){
					balanceLabel.setText("Unaccessable");
				}
				else {
					balanceLabel.setText(user3.history.get(user3.getI() - j));
				}
			}
		});

		next.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				balanceLabel.setText("");
				j--;
				j = j%(user3.getI() + 1);
				j = j%5;
				previous.setDisable(false);
				if(user3.getI() - Math.abs(j) == user3.getI()) {
					next.setDisable(true);
				}
				else {
					next.setDisable(false);
				}
				balanceLabel.setText(user3.history.get(user3.getI() - Math.abs(j)));
			}
		});
	}
}
