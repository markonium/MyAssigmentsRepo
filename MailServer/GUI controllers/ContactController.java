package eg.edu.alexu.csd.datastructure.mailServer;
import java.io.*;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ContactController {
@FXML
Label contacterrorlabel;
@FXML
Button b1;
@FXML
CheckBox c1;
@FXML
Button b2;
@FXML
CheckBox c2;
@FXML
Button b3;
@FXML
CheckBox c3;
@FXML
Button b4;
@FXML
CheckBox c4;
@FXML
Button b5;
@FXML
CheckBox c5;
@FXML
Button b6;
@FXML
CheckBox c6;
@FXML
Button b7;
@FXML
CheckBox c7;
@FXML
Button b8;
@FXML
CheckBox c8;
@FXML
Button b9;
@FXML
CheckBox c9;
@FXML
Button b10;
@FXML
CheckBox c10;
@FXML
TextField contactfilter;
int pageBackup=1;
public void setbs(int page)throws IOException {
	Miscellaneous ms=new Miscellaneous();
	ms.QuickSort("Users/"+App.emailbackup+"/Contacts", 0, true, false);
	DLinkedList list=ms.showContact(page);
	pageBackup=page;
	if(list==null) {
		contacterrorlabel.setText("No more pages !");
	}else {
		pageBackup++;
		b1.setText(""); c1.setDisable(true); b1.setDisable(true);
		b2.setText(""); c2.setDisable(true); b2.setDisable(true);
		b3.setText(""); c3.setDisable(true); b3.setDisable(true);
		b4.setText(""); c4.setDisable(true); b4.setDisable(true);
		b5.setText(""); c5.setDisable(true); b5.setDisable(true);
		b6.setText(""); c6.setDisable(true); b6.setDisable(true);
		b7.setText(""); c7.setDisable(true); b7.setDisable(true);
		b8.setText(""); c8.setDisable(true); b8.setDisable(true);
		b9.setText(""); c9.setDisable(true); b9.setDisable(true);
		b10.setText("");  c10.setDisable(true); b10.setDisable(true);
	if(!list.isEmpty()) {
		b1.setDisable(false);
		b1.setText((String)list.get(0)); c1.setDisable(false);
		list.remove(0);
	}if(!list.isEmpty()) {
		b2.setDisable(false);
		b2.setText((String)list.get(0)); c2.setDisable(false);
		list.remove(0);
	}if(!list.isEmpty()) {
		b3.setDisable(false);
		b3.setText((String)list.get(0)); c3.setDisable(false);
		list.remove(0);
	}if(!list.isEmpty()) {
		b4.setDisable(false);
		b4.setText((String)list.get(0)); c4.setDisable(false);
		list.remove(0);
	}if(!list.isEmpty()) {
		b5.setDisable(false);
		b5.setText((String)list.get(0)); c5.setDisable(false);
		list.remove(0);
	}if(!list.isEmpty()) {
		b6.setDisable(false);
		b6.setText((String)list.get(0)); c6.setDisable(false);
		list.remove(0);
	}if(!list.isEmpty()) {
		b7.setDisable(false);
		b7.setText((String)list.get(0)); c7.setDisable(false);
		list.remove(0);
	}if(!list.isEmpty()) {
		b8.setDisable(false);
		b8.setText((String)list.get(0)); c8.setDisable(false);
		list.remove(0);
	}if(!list.isEmpty()) {
		b9.setDisable(false);
		b9.setText((String)list.get(0)); c9.setDisable(false);
		list.remove(0);
	}if(!list.isEmpty()) {
		b10.setDisable(false);
		b10.setText((String)list.get(0)); c10.setDisable(false);
		list.remove(0);
	}
	}
}public void arrange() {
	Miscellaneous ms=new Miscellaneous();
	ms.QuickSort("Users/"+App.emailbackup+"/Contacts", 0, true, false);
}
public void nextPage(ActionEvent event) throws Exception {
	contacterrorlabel.setText("");
	setbs(pageBackup);
}public void prevPage(ActionEvent event) throws Exception {
	contacterrorlabel.setText("");
	pageBackup-=2;
	if(pageBackup>0) {
		setbs(pageBackup);
	}else {
		pageBackup+=2;
		contacterrorlabel.setText("No more pages !");
	}
}public void createcontact(ActionEvent event) throws Exception {
	contacterrorlabel.setText("");
	Parent view2 = FXMLLoader.load(getClass().getResource("createContact.fxml"));
    Scene scene2 = new Scene(view2);
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene2);
    window.show(); 
}public void search(ActionEvent event) throws Exception{
	contacterrorlabel.setText("");
	if(contactfilter.getText().equals("")) {
		contacterrorlabel.setText("Please type a contact name first");
	}else {
		Miscellaneous ms=new Miscellaneous();
		ms.filter("Users/"+App.emailbackup+"/Contacts", contactfilter.getText(), 0, true);
		File file=new File("Users/"+App.emailbackup+"/Contacts/filteredNum.txt");
		Scanner in=new Scanner(file);
		String s=in.next();
		int num=Integer.parseInt(s);
		if(num==0) {
			contacterrorlabel.setText("No results found!");
		}else {

			FXMLLoader loader=new FXMLLoader(getClass().getResource("searchResults.fxml"));
			Parent view2 = loader.load();
		    Scene scene2 = new Scene(view2);
		    Stage temp=(Stage)((Node)event.getSource()).getScene().getWindow();
		    searchResultsController con=loader.getController();
		    con.setButton(contactfilter.getText(),temp);
		    
		    Stage window = new Stage();
		    window.setScene(scene2);
		    window.show();
		}
		in.close();
	}
}public void back(ActionEvent event)throws Exception {
	FXMLLoader loader=new FXMLLoader(getClass().getResource("aftersignin.fxml"));
	Parent view2 = loader.load();
    Scene scene2 = new Scene(view2);
    
    aftersigninController con=loader.getController();
    con.setlname();
    
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene2);
    window.show();
}public void details(ActionEvent event)throws Exception {
	contacterrorlabel.setText("");
	FXMLLoader loader=new FXMLLoader(getClass().getResource("contactDetails.fxml"));
	Parent view2 = loader.load();
    Scene scene2 = new Scene(view2);
    Stage temp=(Stage)((Node)event.getSource()).getScene().getWindow();
    ContactDetailController con=loader.getController();
    con.setData(((Button)event.getSource()).getText(),temp);
    
    Stage window = new Stage();
    window.setScene(scene2);
    window.show();
}public void delete(ActionEvent e) throws Exception{
	contacterrorlabel.setText("");
	Miscellaneous ms=new Miscellaneous();
	DLinkedList list=new DLinkedList();
	if(c1.isSelected()) {
		list.add(b1.getText());
		c1.setSelected(false);
	}if(c2.isSelected()) {
		list.add(b2.getText());
		c2.setSelected(false);
	}if(c3.isSelected()) {
		list.add(b3.getText());
		c3.setSelected(false);
	}if(c4.isSelected()) {
		list.add(b4.getText());
		c4.setSelected(false);
	}if(c5.isSelected()) {
		list.add(b5.getText());
		c5.setSelected(false);
	}if(c6.isSelected()) {
		list.add(b6.getText());
		c6.setSelected(false);
	}if(c7.isSelected()) {
		list.add(b7.getText());
		c7.setSelected(false);
	}if(c8.isSelected()) {
		list.add(b8.getText());
		c8.setSelected(false);
	}if(c9.isSelected()) {
		list.add(b9.getText());
		c9.setSelected(false);
	}if(c10.isSelected()) {
		list.add(b10.getText());
		c10.setSelected(false);
	}if(list.size()==0) {
		contacterrorlabel.setText("Please select a contact first");
	}else {
		ms.deleteContact(list);
		setbs(1);
	}
}public void send(ActionEvent e) throws Exception{
	contacterrorlabel.setText("");
	Miscellaneous ms=new Miscellaneous();
	LinkedQueue queue=new LinkedQueue();
	if(c1.isSelected()) {
		queue.enqueue(ms.getContactEmail(b1.getText()));
		c1.setSelected(false);
	}if(c2.isSelected()) {
		queue.enqueue(ms.getContactEmail(b2.getText()));
		c2.setSelected(false);
	}if(c3.isSelected()) {
		queue.enqueue(ms.getContactEmail(b3.getText()));
		c3.setSelected(false);
	}if(c4.isSelected()) {
		queue.enqueue(ms.getContactEmail(b4.getText()));
		c4.setSelected(false);
	}if(c5.isSelected()) {
		queue.enqueue(ms.getContactEmail(b5.getText()));
		c5.setSelected(false);
	}if(c6.isSelected()) {
		queue.enqueue(ms.getContactEmail(b6.getText()));
		c6.setSelected(false);
	}if(c7.isSelected()) {
		queue.enqueue(ms.getContactEmail(b7.getText()));
		c7.setSelected(false);
	}if(c8.isSelected()) {
		queue.enqueue(ms.getContactEmail(b8.getText()));
		c8.setSelected(false);
	}if(c9.isSelected()) {
		queue.enqueue(ms.getContactEmail(b9.getText()));
		c9.setSelected(false);
	}if(c10.isSelected()) {
		queue.enqueue(ms.getContactEmail(b10.getText()));
		c10.setSelected(false);
	}if(queue.size()==0) {
		contacterrorlabel.setText("Please select a contact first");
	}else {
		Stage temp=(Stage)((Node)e.getSource()).getScene().getWindow();
		FXMLLoader loader=new FXMLLoader(getClass().getResource("compose.fxml"));
		Parent view2 = loader.load();
	    Scene scene2 = new Scene(view2);
	    
	    composeController con=loader.getController();
	    con.init(queue,temp);
	    
	    Stage window = new Stage();
	    window.setScene(scene2);
	    window.show();
	}
}
}
