package client;
import javafx.application.Application;

import javafx.stage.Stage;

import java.util.Vector;

import gui.ClientConnectionController;
import gui.SearchSubscriberController;
import client.ClientController;

public class ClientUI extends Application {
	public static ClientController chat; //only one instance

	public static void main( String args[] ) throws Exception
	   { 
		    launch(args);  
	   } 
	 
	 @Override
	    public void start(Stage primaryStage) throws Exception {
	        ClientConnectionController connectionFrame = new ClientConnectionController();
	        connectionFrame.start(primaryStage);
	    }
	 // מתודה שתקרא אחרי שהמשתמש יזין את פרטי ההתחברות
	    public static void initChat(String host, int port) throws Exception {
	        chat = new ClientController(host, port);
	    }
	
	
}
