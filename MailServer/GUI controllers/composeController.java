package eg.edu.alexu.csd.datastructure.mailServer;

import java.util.List;
import java.io.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Node;

public class composeController {
LinkedQueue queue = new LinkedQueue();
SLinkedList att=new SLinkedList();
@FXML
TextField topic;
@FXML
TextField priority;
@FXML
TextArea body;
@FXML
Button num;
@FXML
Label attnum;
@FXML
Button browse;
@FXML
Label error;
Stage temp;
public void init(LinkedQueue q,Stage prev) {
	temp=prev;
	queue=q;
	num.setText(Integer.toString(queue.size)+" Users");
}public void cancel(ActionEvent event)throws Exception {
	temp.close();
	App app=new App();
	FXMLLoader loader=new FXMLLoader(getClass().getResource("aftersignin.fxml"));
	Parent view2 = loader.load();
    Scene scene2 = new Scene(view2);
    
    aftersigninController con=loader.getController();
    con.setlname();
    if(!topic.getText().equals("") && !body.getText().equals("")) {
    	if(priority.getText().equals("")) {
    		priority.setText("1");
    	}
    	con.draftlabel();
    	app.createEmail(App.emailbackup, priority.getText(), topic.getText(), body.getText(), queue, att, true);
    }
    
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene2);
    window.show();
}public void send(ActionEvent event) throws Exception{
	App app=new App();
	String p =priority.getText();
	if(!p.equals("1") && !p.equals("2") && !p.equals("3") && !p.equals("4") && !p.equals("5") && !p.equals("6") && !p.equals("7") &&!p.equals("8") && !p.equals("9") && !p.equals("10") && !p.equals("")) {
		error.setText("Priority can be between 1 and 10 only");
	}
	else if(!topic.getText().equals("") && !body.getText().equals("")) {
    	if(priority.getText().equals("")) {
    		priority.setText("1");
    	}
    	app.createEmail(App.emailbackup, priority.getText(), topic.getText(), body.getText(), queue, att, false);
    	temp.close();
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("aftersignin.fxml"));
    	Parent view2 = loader.load();
        Scene scene2 = new Scene(view2);
        
        aftersigninController con=loader.getController();
        con.setlname();
        con.draftlabel2();
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }else {
    	error.setText("Email body and topic can't be empty");
    }
    
}public void browse(ActionEvent event) {
	FileChooser fc=new FileChooser();
	List<File> att1=fc.showOpenMultipleDialog(null);
	for(int i=0; i<att1.size(); i++) {
		att.add(att1.get(i));
	}attnum.setText(Integer.toString(att1.size())+" attachment(s) selected");
}public void num(ActionEvent event)throws Exception {
	FXMLLoader loader=new FXMLLoader(getClass().getResource("composeother.fxml"));
	Parent view2 = loader.load();
    Scene scene2 = new Scene(view2);
    
    composeOtherController con=loader.getController();
    con.set(queue,temp);
    
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene2);
    window.show();
}
}
