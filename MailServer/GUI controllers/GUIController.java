package eg.edu.alexu.csd.datastructure.mailServer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Node;

public class GUIController {
IApp app=new App();
Miscellaneous ms=new Miscellaneous();
@FXML
TextField email;
@FXML
TextField password;
@FXML
Label invalid;
@FXML
TextField newname;
@FXML
TextField oldpassword;
@FXML
TextField newpassword1;
@FXML
TextField newpassword2;
@FXML
Label settinglabel;
@FXML
Label settinglabel2;
@FXML
Label successfulSignUp;
@FXML
public void signin(ActionEvent event) throws Exception {
	if(app.signin(email.getText(), password.getText())) {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("aftersignin.fxml"));
		Parent view2 = loader.load();
	    Scene scene2 = new Scene(view2);
	    
	    aftersigninController con=loader.getController();
	    con.setlname();
	    
	    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    window.setScene(scene2);
	    window.show();
	}else {
		invalid.setText("Invalid email or password ! please try again");
	}
}
@FXML
public void signupInitializer(ActionEvent event) throws Exception {
	Parent view2 = FXMLLoader.load(getClass().getResource("signup.fxml"));
    Scene scene2 = new Scene(view2);
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene2);
    window.show(); 
}
public void backFromSettings(ActionEvent event) throws Exception {
	FXMLLoader loader=new FXMLLoader(getClass().getResource("aftersignin.fxml"));
	Parent view2 = loader.load();
    Scene scene2 = new Scene(view2);
    
    aftersigninController con=loader.getController();
    con.setlname();
    
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene2);
    window.show();
}

public void changeName(ActionEvent event) throws Exception {
	ms.changename("Users/"+App.emailbackup, newname.getText());
	settinglabel2.setText("Name changed successfully!");
}

public void changePass(ActionEvent event) throws Exception {
	if(oldpassword.getText().equals("")) {
		settinglabel.setText("Old password cannot be blank!");
	}else if(!app.signin(App.emailbackup, oldpassword.getText())) {
		settinglabel.setText("The old password is wrong!");
		settinglabel2.setText("");
	}else if(newpassword1.getText().equals("")) {
		settinglabel.setText("Please choose a new password");
	}else if(newpassword2.getText().equals("")) {
		settinglabel.setText("Please retype your new password");
	}
	else if(newpassword1.getText().equals(newpassword2.getText())) {
		if(oldpassword.getText().equals(newpassword1.getText())) {
			settinglabel.setText("new password cannot be the same as the old password!");
		}else {
			ms.changepass("Users/"+App.emailbackup, newpassword1.getText());
			settinglabel2.setText("Password changed successfully!");
			settinglabel.setText("");
		}
	}else {
		settinglabel.setText("The two new passwords don't match!");
		settinglabel2.setText("");
	}
}public void setSignupFlag() {
	successfulSignUp.setText("Sign up was successful, you may login now!");
}
}
