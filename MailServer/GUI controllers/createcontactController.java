package eg.edu.alexu.csd.datastructure.mailServer;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Node;

public class createcontactController {
	@FXML
	TextField contactname;
	@FXML
	TextField contactemail1;
	@FXML
	TextField contactemail2;
	@FXML
	TextField contactemail3;
	@FXML
	Label elabel;
	@FXML
	Label elabel1;
	public void createContact1(ActionEvent event) {
		Miscellaneous ms=new Miscellaneous();
		if(contactname.getText().equals("")) {
			elabel.setText("Please enter the contact name");
		}else if(contactemail1.getText().equals("")) {
			elabel.setText("Please enter the contact email");
		}else if(!ms.checker(contactemail1.getText())) {
			elabel.setText("Please enter a valid email!");
		}else if(!ms.checkExist(contactemail1.getText())){
			elabel.setText("Email 1 doesn't exist");
		}else if(!ms.checkExist(contactemail2.getText())){
			elabel.setText("Email 2 doesn't exist");
		}else if(!ms.checkExist(contactemail3.getText())){
			elabel.setText("Email 3 doesn't exist");
		}else {
			DLinkedList emailList=new DLinkedList();
			emailList.add(contactemail1.getText());
			if(!contactemail2.getText().equals("")) {
				emailList.add(contactemail2.getText());
			}if(!contactemail3.getText().equals("")) {
				emailList.add(contactemail3.getText());
			}
			IContact contact=new Contact(null,null,contactname.getText(),emailList);
			boolean check=ms.createContact("Users/"+App.emailbackup+"/Contacts", contact);
			if(!check) {
				elabel.setText("Contact name already exist!");
			}else {
				elabel.setText("");
				elabel1.setText("Contact created successfully!");
			}			
		}
	}public void back(ActionEvent event) throws Exception {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("contact.fxml"));
		Parent view2 = loader.load();
	    Scene scene2 = new Scene(view2);
	    
	    ContactController con=loader.getController();
	    con.setbs(1);
	    
	    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    window.setScene(scene2);
	    window.show(); 
	}
}
