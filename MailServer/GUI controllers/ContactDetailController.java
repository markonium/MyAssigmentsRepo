package eg.edu.alexu.csd.datastructure.mailServer;

import java.io.*;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ContactDetailController {
	@FXML 
	Label l1;
	@FXML 
	Label l2;
	@FXML 
	Label l3;
	@FXML 
	Label l4;
	@FXML
	Button s2;
	@FXML
	Button s3;
	Stage prevStage;
	public void setData(String name, Stage stage)throws Exception {
		prevStage=stage;
		File file=new File("Users/"+App.emailbackup+"/Contacts/"+name+"/Data.txt");
		Scanner in=new Scanner(file);
		l1.setText(in.nextLine());
		l2.setText(in.nextLine());
		s2.setDisable(true);
		s3.setDisable(true);
		l3.setText("No email");
		l4.setText("No email");
		if(in.hasNextLine()) {
			l3.setText(in.nextLine());
			s2.setDisable(false);
		}if(in.hasNextLine()) {
			l4.setText(in.nextLine());
			s3.setDisable(false);
		}in.close();
	}public void delete(ActionEvent e)throws Exception {
		Miscellaneous ms=new Miscellaneous();
		DLinkedList list=new DLinkedList();
		list.add(l1.getText());
		ms.deleteContact(list);
		
		FXMLLoader loader=new FXMLLoader(getClass().getResource("contact.fxml"));
		Parent view2 = loader.load();
	    Scene scene2 = new Scene(view2);
	    
	    ContactController con=loader.getController();
	    con.arrange();
	    con.setbs(1);
	    
	    
	    Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
	    prevStage.close();
	    window.setScene(scene2);
	    
	    window.show();
	}public void send1(ActionEvent e) throws Exception{
		LinkedQueue queue=new LinkedQueue();
		queue.enqueue(l2.getText());
		switchScene(queue,e);
	}public void send2(ActionEvent e) throws Exception{
		LinkedQueue queue=new LinkedQueue();
		queue.enqueue(l3.getText());
		switchScene(queue,e);
	}public void send3(ActionEvent e) throws Exception{
		LinkedQueue queue=new LinkedQueue();
		queue.enqueue(l4.getText());
		switchScene(queue,e);
	}public void switchScene(LinkedQueue queue,ActionEvent e)throws Exception {
		
		FXMLLoader loader=new FXMLLoader(getClass().getResource("compose.fxml"));
		Parent view2 = loader.load();
	    Scene scene2 = new Scene(view2);
	    
	    composeController con=loader.getController();
	    con.init(queue,prevStage);
	    
	    Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
	    window.setScene(scene2);
	    window.show();
	}
}
