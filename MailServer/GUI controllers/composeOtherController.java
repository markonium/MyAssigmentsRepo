package eg.edu.alexu.csd.datastructure.mailServer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class composeOtherController {
	@FXML
	Button e1;
	@FXML
	Button e2;
	@FXML
	Button e3;
	@FXML
	Button e4;
	@FXML
	Button e5;
	@FXML
	Button e6;
	@FXML
	Button e7;
	@FXML
	Button e8;
	@FXML
	Button e9;
	@FXML
	Button e10;
	LinkedQueue q=new LinkedQueue();
	Stage temp;
	public void set(LinkedQueue q1,Stage st) {
		temp=st;
		LinkedQueue queue=new LinkedQueue();
		while(!q1.isEmpty()) {
			String s=(String)q1.dequeue();
			q.enqueue(s);
			queue.enqueue(s);
		}
		if(!queue.isEmpty()) {
			e1.setText((String)queue.dequeue());
		}if(!queue.isEmpty()) {
			e2.setText((String)queue.dequeue());
		}if(!queue.isEmpty()) {
			e3.setText((String)queue.dequeue());
		}if(!queue.isEmpty()) {
			e4.setText((String)queue.dequeue());
		}if(!queue.isEmpty()) {
			e5.setText((String)queue.dequeue());
		}if(!queue.isEmpty()) {
			e6.setText((String)queue.dequeue());
		}if(!queue.isEmpty()) {
			e7.setText((String)queue.dequeue());
		}if(!queue.isEmpty()) {
			e8.setText((String)queue.dequeue());
		}if(!queue.isEmpty()) {
			e9.setText((String)queue.dequeue());
		}if(!queue.isEmpty()) {
			e10.setText((String)queue.dequeue());
		}
	}public void back(ActionEvent e)throws Exception {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("compose.fxml"));
		Parent view2 = loader.load();
	    Scene scene2 = new Scene(view2);
	    
	    composeController con=loader.getController();
	    con.init(q,temp);
	    
	    Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
	    window.setScene(scene2);
	    window.show();
	}
}
