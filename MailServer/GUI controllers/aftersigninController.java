package eg.edu.alexu.csd.datastructure.mailServer;

import java.io.*;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;



public class aftersigninController {
	@FXML
	Label lname;
	@FXML
	Label draftbtn;
	@FXML
	Button f1;
	@FXML
	Button f2;
	@FXML
	Button f3;
	@FXML
	Button f4;
	@FXML
	Label inboxnew;
	int emailcount;
	int newemailcount;
	public void setlname() throws Exception {
		
		DLinkedList list=App.folderNames;
		f1.setText((String)list.get(0));
		f2.setText((String)list.get(1));
		f3.setText((String)list.get(2));
		f4.setText((String)list.get(3));
		draftbtn.setText("");
		File file=new File("Users/"+App.emailbackup+"/data.txt");
		Scanner in=new Scanner(file);
		in.nextLine();
		String s=in.nextLine();
		in.close();
		lname.setText("Welcome back, "+s+"!");
		App app=new App();
		emailcount=app.countemails("Users/"+App.emailbackup+"/Inbox");
	}public void draftlabel() {
		draftbtn.setText("Email moved to darft!");
	}public void draftlabel2() {
		draftbtn.setText("Email sent successfully!");
	}
	@FXML
	public void SwitchtoSettings(ActionEvent event) throws Exception {
		Parent view2 = FXMLLoader.load(getClass().getResource("settings.fxml"));
	    Scene scene2 = new Scene(view2);
	    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    window.setScene(scene2);
	    window.show();
	}
	@FXML
	public void signout(ActionEvent event) throws IOException {
		Parent view2 = FXMLLoader.load(getClass().getResource("GUI.fxml"));
	    Scene scene2 = new Scene(view2);
	    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    window.setScene(scene2);
	    window.show();
	}@FXML
	public void gotocontact(ActionEvent event) throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("contact.fxml"));
		Parent view2 = loader.load();
	    Scene scene2 = new Scene(view2);
	    
	    ContactController con=loader.getController();
	    con.arrange();
	    con.setbs(1);
	    
	    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    window.setScene(scene2);
	    window.show();
	}public void compose(ActionEvent event)throws Exception {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("chooseemail.fxml"));
		Parent view2 = loader.load();
	    Scene scene2 = new Scene(view2);
	    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    window.setScene(scene2);
	    window.show();
	}public void emails(ActionEvent event)throws Exception	{
		FXMLLoader loader=new FXMLLoader(getClass().getResource("emails.fxml"));
		Parent view2 = loader.load();
	    Scene scene2 = new Scene(view2);
	    
	    emailController con=loader.getController();
	    DLinkedList list =App.folderNames;
	    ObservableList<String> filter=FXCollections.observableArrayList((String)list.get(0),(String)list.get(1),(String)list.get(2),(String)list.get(3));
	    
	    Button temp=(Button)event.getSource();
	    Boolean isTrash=false; Boolean notUserFolder=false;
	    if(temp.getText().equals("Trash")) {
	    	isTrash=true; notUserFolder=true;
	    } if(temp.getText().equals("Inbox")) {
	    	inboxnew.setText("");
	    	notUserFolder=true;
	    } if(temp.getText().equals("Sent")) {
	    	notUserFolder=true;
	    } if(temp.getText().equals("Draft")) {
	    	notUserFolder=true;
	    }
	    con.init1(filter,notUserFolder,temp.getText());
	    con.init2(1,"Users/"+App.emailbackup+"/"+temp.getText(),isTrash,new Filter(null,0),new Sort(3,false));
	    
	    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    window.setScene(scene2);
	    window.show();
	}public void refresh(ActionEvent e)throws Exception {
		App app=new App();
		newemailcount=app.countemails("Users/"+App.emailbackup+"/Inbox");
		int temp=newemailcount-emailcount;
		if(temp!=0) {
			inboxnew.setText(Integer.toString(temp)+" new");
		}
	}
}
