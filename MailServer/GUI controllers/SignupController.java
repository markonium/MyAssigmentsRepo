package eg.edu.alexu.csd.datastructure.mailServer;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class SignupController {
	@FXML
	TextField semail;
	@FXML
	TextField spassword1;
	@FXML
	TextField spassword2;
	@FXML
	TextField sname;
	@FXML
	Label slabel;
	@FXML
	Label successfulSignUp;
	public void signup(ActionEvent event) throws Exception {
		Miscellaneous ms=new Miscellaneous();
		App app=new App();
		if(sname.getText().equals("")) {
			slabel.setText("Please fill in your name");
		}else if(semail.getText().equals("")) {
			slabel.setText("Please fill in your email");
		}else if(!ms.checker(semail.getText())) {
			slabel.setText("Invalid email! Please choose a valid email ex: example@mailserver.com");
		}else if(spassword1.getText().equals("")) {
			slabel.setText("Please fill in your password");
		}else if(spassword2.getText().equals("")) {
			slabel.setText("Please retype your password");
		}else if(spassword1.getText().length()<8) {
			slabel.setText("Your password must be at least 8 characters");
		}else if(!spassword1.getText().equals(spassword2.getText())) {
			slabel.setText("The two passwords don't match");
		}else {
			if(ms.checkExist(semail.getText())) {
				slabel.setText("Email already taken!");
			}else {
				IContact contact=new Contact(semail.getText(),spassword1.getText(),sname.getText(),null);
		    	app.signup(contact);
				FXMLLoader loader=new FXMLLoader(getClass().getResource("GUI.fxml"));
				Parent view2 = loader.load();
			    Scene scene2 = new Scene(view2);
			    
			    GUIController con=loader.getController();
			    con.setSignupFlag();
			    
			    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			    window.setScene(scene2);
			    window.show();	
			}
		}
	}
	@FXML
	public void signupCancel(ActionEvent event) throws Exception {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("GUI.fxml"));
		Parent view2 = loader.load();
	    Scene scene2 = new Scene(view2);
	    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    window.setScene(scene2);
	    window.show(); 
	}
}
