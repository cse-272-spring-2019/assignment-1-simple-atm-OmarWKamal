package project1;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class deposit{
	Stage stage;
	Scene depositScene;
	Bankacc user4;
	Menu menu;
	public void setUser(Bankacc user) {
		this.user4 = user;
	}
	public Scene getScene() {
		return this.depositScene;
	}
	public void depositScene(Stage primaryStage) {
		this.stage = primaryStage;
	}
	public deposit() {
		TextField deposition = new TextField();
		Button depositButton = new Button("Deposit");
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
		GridPane depositpane = new GridPane();
		depositpane.add(deposition, 0, 0);
		depositpane.add(depositButton, 0, 1);
		depositpane.add(one, 3, 3);
		depositpane.add(two, 4, 3);
		depositpane.add(three, 5, 3);
		depositpane.add(four, 3, 4);
		depositpane.add(five, 4, 4);
		depositpane.add(six, 5, 4);
		depositpane.add(seven, 3, 5);
		depositpane.add(eight, 4, 5);
		depositpane.add(nine, 5, 5);
		depositpane.add(zero, 4, 6);
		depositpane.add(clear, 8, 8);
		depositpane.add(remove, 8, 11);
		//add clear button and remove once char button
		
		remove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {deposition.deleteText(deposition.getLength()-1, deposition.getLength());}});
		clear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {deposition.clear();}});
		//NUMBER BUTTONS FUNCTIONS
		zero.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {deposition.appendText("0");}});
		one.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {deposition.appendText("1");}});
		two.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {  deposition.appendText("2");}});
		three.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {deposition.appendText("3");}});
		four.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {deposition.appendText("4");}});
		five.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {deposition.appendText("5");}});
		six.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {deposition.appendText("6");}});
		seven.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {deposition.appendText("7");}});
		eight.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {deposition.appendText("8");}});
		nine.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {deposition.appendText("9");}});
		//END OF NUMBER BUTTONS FUNCTIONS
		
		depositButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
			//	Long amount = valueOf(deposition.getText());
				String amount = deposition.getText();
				user4.deposit(amount);
				deposition.clear();
				stage.setScene(menu.getScene());
			}});
		
		depositScene = new Scene(depositpane, 800, 600);
		
	}	
	
	public void setMenu(Menu menu2) {
		// TODO Auto-generated method stub
		this.menu = menu2;
	}
}