package project1;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class withdraw{
	Stage stage;
	Scene withdrawScene;
	Bankacc user5;
	Menu menu;
	public void setUser(Bankacc user) {
		this.user5 = user;
	}
	public void setMenu(Menu menu2) {
		// TODO Auto-generated method stub
		this.menu = menu2;
	}
	public void withdrawScene(Stage primaryStage) {
		this.stage = primaryStage;
	}
	public withdraw() {
		TextField withdrawal = new TextField();
		Button withdrawButton = new Button("Withdraw");
		Button one = new Button("1");
		Button two = new Button("2");
		Button three = new Button("3");
		Button four = new Button("4");
		Button five = new Button("5");
		Button six = new Button("6");
		Button seven = new Button("7");
		Button eight = new Button("8");
		Button nine = new Button("9");
		Button zero = new Button("0");
		Button clear = new Button("Clear");
		Button remove = new Button("Remove");
		Label error = new Label();
		GridPane withdrawpane = new GridPane();
		withdrawpane.add(withdrawal, 0, 0);
		withdrawpane.add(withdrawButton, 0, 1);
		withdrawpane.add(one, 3, 3);
		withdrawpane.add(two, 4, 3);
		withdrawpane.add(three, 5, 3);
		withdrawpane.add(four, 3, 4);
		withdrawpane.add(five, 4, 4);
		withdrawpane.add(six, 5, 4);
		withdrawpane.add(seven, 3, 5);
		withdrawpane.add(eight, 4, 5);
		withdrawpane.add(nine, 5, 5);
		withdrawpane.add(zero, 4, 6);
		withdrawpane.add(clear, 8, 8);
		withdrawpane.add(remove, 8, 10);
		//add clear button and remove once char button
		
		remove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {withdrawal.deleteText(withdrawal.getLength()-1, withdrawal.getLength());}});
		clear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {withdrawal.clear();}});
		//NUMBER BUTTONS FUNCTIONS
		zero.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {withdrawal.appendText("0");}});
		one.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {withdrawal.appendText("1");}});
		two.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {  withdrawal.appendText("2");}});
		three.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {withdrawal.appendText("3");}});
		four.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {withdrawal.appendText("4");}});
		five.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {withdrawal.appendText("5");}});
		six.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {withdrawal.appendText("6");}});
		seven.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {withdrawal.appendText("7");}});
		eight.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {withdrawal.appendText("8");}});
		nine.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {withdrawal.appendText("9");}});
		//END OF NUMBER BUTTONS FUNCTIONS
		
		withdrawButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String amount = (withdrawal.getText());
				long h = valueOf(amount);
				if(h > user5.getBalance()) {
					error.setText("Please Enter a valid amount");
					withdrawpane.add(error, 12, 12);
				}
				else {
				user5.withdraw(amount);
				withdrawal.clear();
				stage.setScene(menu.getScene());
				}}});
		
		withdrawScene = new Scene(withdrawpane, 800, 600);
		
	}	

	public Scene getScene() {
		return this.withdrawScene;
	}
	public  Long valueOf(String text) {
		Long x = (long) 0;
		int j =-1;
		for(int i = text.length()-1; i >= 0; i--)
		{	
			j++;
			x = (long) (x + (text.charAt(i) - '0') * Math.pow(10, j));
		}
		return x;
	}
}