package eg.edu.alexu.csd.datastructure.mailServer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Node;

public class chooseemailController {
	@FXML
	TextField e1;
	@FXML
	TextField e2;
	@FXML
	TextField e3;
	@FXML
	TextField e4;
	@FXML
	TextField e5;
	@FXML
	TextField e6;
	@FXML
	TextField e7;
	@FXML
	TextField e8;
	@FXML
	TextField e9;
	@FXML
	TextField e10;
	@FXML
	Label error;
	public void compose(ActionEvent event)throws Exception {
		Miscellaneous ms =new Miscellaneous();
		LinkedQueue queue=new LinkedQueue();
		if(e1.getText().equals("") && e2.getText().equals("") && e3.getText().equals("") && e4.getText().equals("") && e5.getText().equals("") && e6.getText().equals("") && e7.getText().equals("") && e8.getText().equals("") && e9.getText().equals("") && e10.getText().equals("")) {
			error.setText("At least one email is required");
		}else if(!ms.checkExist(e1.getText())) {
			error.setText("Email 1 doesn't exist");
		}else if(!ms.checkExist(e2.getText())) {
			error.setText("Email 2 doesn't exist");
		}else if(!ms.checkExist(e3.getText())) {
			error.setText("Email 3 doesn't exist");
		}else if(!ms.checkExist(e4.getText())) {
			error.setText("Email 4 doesn't exist");
		}else if(!ms.checkExist(e5.getText())) {
			error.setText("Email 5 doesn't exist");
		}else if(!ms.checkExist(e6.getText())) {
			error.setText("Email 6 doesn't exist");
		}else if(!ms.checkExist(e7.getText())) {
			error.setText("Email 7 doesn't exist");
		}else if(!ms.checkExist(e8.getText())) {
			error.setText("Email 8 doesn't exist");
		}else if(!ms.checkExist(e9.getText())) {
			error.setText("Email 9 doesn't exist");
		}else if(!ms.checkExist(e10.getText())) {
			error.setText("Email 10 doesn't exist");
		}
		else {
			if(!e1.getText().equals("")) {
				queue.enqueue(e1.getText());
			}if(!e2.getText().equals("")) {
				queue.enqueue(e2.getText());
			}if(!e3.getText().equals("")) {
				queue.enqueue(e3.getText());
			}if(!e4.getText().equals("")) {
				queue.enqueue(e4.getText());
			}if(!e5.getText().equals("")) {
				queue.enqueue(e5.getText());
			}if(!e6.getText().equals("")) {
				queue.enqueue(e6.getText());
			}if(!e7.getText().equals("")) {
				queue.enqueue(e7.getText());
			}if(!e8.getText().equals("")) {
				queue.enqueue(e8.getText());
			}if(!e9.getText().equals("")) {
				queue.enqueue(e9.getText());
			}if(!e10.getText().equals("")) {
				queue.enqueue(e10.getText());
			}Stage temp=(Stage)((Node)event.getSource()).getScene().getWindow();
			FXMLLoader loader=new FXMLLoader(getClass().getResource("compose.fxml"));
			Parent view2 = loader.load();
		    Scene scene2 = new Scene(view2);
		    
		    composeController con=loader.getController();
		    con.init(queue,temp);
		    
		    Stage window = new Stage();
		    window.setScene(scene2);
		    window.show();
		}
	}public void cancel(ActionEvent event)throws Exception {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("aftersignin.fxml"));
		Parent view2 = loader.load();
	    Scene scene2 = new Scene(view2);
	    
	    aftersigninController con=loader.getController();
	    con.setlname();
	    
	    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    window.setScene(scene2);
	    window.show();
	}
}
