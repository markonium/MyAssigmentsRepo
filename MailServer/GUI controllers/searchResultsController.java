package eg.edu.alexu.csd.datastructure.mailServer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Node;

public class searchResultsController {
	@FXML
	Button btn;
	Stage stage;
	public void setButton(String s,Stage stage1) {
		stage=stage1;
		btn.setText(s);
	}public void details(ActionEvent event)throws Exception {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("contactDetails.fxml"));
		Parent view2 = loader.load();
	    Scene scene2 = new Scene(view2);
	    
	    ContactDetailController con=loader.getController();
	    con.setData(btn.getText(),stage);
	    
	    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    window.setScene(scene2);
	    window.show();
	}
}
