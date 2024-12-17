package gui;

import java.net.URL;

import client.ChatClient;
import client.ClientController;
import client.ClientUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClientConnectionController {
	@FXML
	private TextField id_IP;

	@FXML
	private Label errorLabel;
	
	 @FXML
	    private Button SENDID;
	 @FXML
	 public void Search(ActionEvent event) throws Exception {
	     String host = id_IP.getText();
	     
	     // בדיקת תקינות ה-IP
	     if (host.trim().isEmpty()) {
	         errorLabel.setText("Please enter IP address");
	         return;
	     }
	     
	     try {
	         ClientUI.initChat(host,5555);
	         Stage primaryStage = new Stage();
	         SearchSubscriberController searchFrame = new SearchSubscriberController();
	         searchFrame.start(primaryStage);
	         ((Node) event.getSource()).getScene().getWindow().hide();
	     } catch (Exception e) {
	         errorLabel.setText("Connection Failed");
	     }
	 }

//	public void start(Stage primaryStage) throws Exception {
//		Parent root = FXMLLoader.load(getClass().getResource("ClientConnection.fxml"));
//		Scene scene = new Scene(root);
//		primaryStage.setTitle("SubscriberIP");
//		primaryStage.setScene(scene);
//		primaryStage.show();
//	}
	 public void start(Stage primaryStage) {
		    try {
		        // בדיקת הנתיב ל-FXML
		        URL fxmlLocation = getClass().getResource("/gui/Connect.fxml");
		        System.out.println("FXML Location: " + fxmlLocation); // הדפסה לניפוי שגיאות
		        
		        if (fxmlLocation == null) {
		            throw new RuntimeException("FXML file not found at /gui/Connect.fxml");
		        }

		        // טעינת ה-FXML
		        FXMLLoader loader = new FXMLLoader(fxmlLocation);
		        Parent root = loader.load();

		        // הגדרת הסצנה והצגת המסך
		        Scene scene = new Scene(root);
		        primaryStage.setTitle("Connection Frame");
		        primaryStage.setScene(scene);
		        primaryStage.show();

		    } catch (Exception e) {
		        e.printStackTrace(); // הדפסת השגיאה לניפוי שגיאות
		    }
		}

}
