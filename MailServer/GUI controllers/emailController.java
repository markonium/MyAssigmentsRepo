package eg.edu.alexu.csd.datastructure.mailServer;


import java.io.File;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Node;

public class emailController {
@FXML
Label emaillabel;
@FXML
Label errorlabel;
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
TextField search;
@FXML
Label d1;
@FXML
Label s1;
@FXML
Label d2;
@FXML
Label s2;
@FXML
Label d3;
@FXML
Label s3;
@FXML
Label d4;
@FXML
Label s4;
@FXML
Label d5;
@FXML
Label s5;
@FXML
Label d6;
@FXML
Label s6;
@FXML
Label d7;
@FXML
Label s7;
@FXML
Label d8;
@FXML
Label s8;
@FXML
Label d9;
@FXML
Label s9;
@FXML
Label d10;
@FXML
Label s10;
@FXML
Label p1;
@FXML
Label p2;
@FXML
Label p3;
@FXML
Label p4;
@FXML
Label p5;
@FXML
Label p6;
@FXML
Label p7;
@FXML
Label p8;
@FXML
Label p9;
@FXML
Label p10;
@FXML
Label sender;
@FXML
Label mlabel;
@FXML
Label m1;
@FXML
Label m2;
@FXML
Label m3;
@FXML
Label m4;
@FXML
Label m5;
@FXML
Label m6;
@FXML
Label m7;
@FXML
Label m8;
@FXML
Label m9;
@FXML
Label m10;
@FXML
Button del;
@FXML
ComboBox<String> sortcombo;
@FXML
ComboBox<String> searchcombo;
@FXML
ComboBox<String> userfolders;
@FXML
TextField newname;
@FXML
Button newnamebtn;
int pageBackup=1;
int maxPages=0;
Filter filterBackup;
Sort sortBackup;
String pathBackup;
Boolean isTrashBackup;
String name;
public void init1(ObservableList<String> userf,Boolean notUserFolder, String name) {//user folder names is sent
	this.name=name;
	emaillabel.setText(name);
	userfolders.setItems(userf);
	ObservableList<String> filter=FXCollections.observableArrayList("Subject","Name","Email","Date","Priority");
	sortcombo.setItems(filter);
	ObservableList<String> filter1=FXCollections.observableArrayList("Subject","Name","Email","Priority");
	searchcombo.setItems(filter1);
	if(notUserFolder) {
		newname.setDisable(true);
		newnamebtn.setDisable(true);
	}else {
		newname.setDisable(false);
		newnamebtn.setDisable(false);
	}if(name.equals("Trash")) {
		sender.setText("Sender/Receiver");
		mlabel.setText("Sender/Receiver email");
		del.setDisable(true);
	}else if(name.equals("Sent") || name.equals("Draft")) {
		sender.setText("Receiver");
		mlabel.setText("Receiver email");
	}else {
		sender.setText("Sender");
		mlabel.setText("Sender email");
	}
}public void init2(int page,String path,Boolean isTrash,Filter filter,Sort sort)throws Exception{
	errorlabel.setText("");
	filterBackup=filter;
	sortBackup=sort;
	pathBackup=path;
	isTrashBackup=isTrash;
	App app=new App();
	app.setViewingOptions(new Folder(path,isTrash),filter, sort);//setting default sort with date, no filter
	maxPages=app.countEmailPages(path);
	pageBackup=page;
	if(maxPages==0) {
		b1.setText(""); c1.setDisable(true); b1.setDisable(true);s1.setText("");d1.setText("");p1.setText("");m1.setText("");
		b2.setText(""); c2.setDisable(true); b2.setDisable(true);s2.setText("");d2.setText("");p2.setText("");m2.setText("");
		b3.setText(""); c3.setDisable(true); b3.setDisable(true);s3.setText("");d3.setText("");p3.setText("");m3.setText("");
		b4.setText(""); c4.setDisable(true); b4.setDisable(true);s4.setText("");d4.setText("");p4.setText("");m4.setText("");
		b5.setText(""); c5.setDisable(true); b5.setDisable(true);s5.setText("");d5.setText("");p5.setText("");m5.setText("");
		b6.setText(""); c6.setDisable(true); b6.setDisable(true);s6.setText("");d6.setText("");p6.setText("");m6.setText("");
		b7.setText(""); c7.setDisable(true); b7.setDisable(true);s7.setText("");d7.setText("");p7.setText("");m7.setText("");
		b8.setText(""); c8.setDisable(true); b8.setDisable(true);s8.setText("");d8.setText("");p8.setText("");m8.setText("");
		b9.setText(""); c9.setDisable(true); b9.setDisable(true);s9.setText("");d9.setText("");p9.setText("");m9.setText("");
		b10.setText("");  c10.setDisable(true); b10.setDisable(true);s10.setText("");d10.setText("");p10.setText("");m10.setText("");
	}
	if(page>maxPages) {
		errorlabel.setText("No more pages !");
		if(maxPages==0) {
			errorlabel.setText("No results");
		}
	}
	else {
		b1.setText(""); c1.setDisable(true); b1.setDisable(true);s1.setText("");d1.setText("");p1.setText("");m1.setText("");
		b2.setText(""); c2.setDisable(true); b2.setDisable(true);s2.setText("");d2.setText("");p2.setText("");m2.setText("");
		b3.setText(""); c3.setDisable(true); b3.setDisable(true);s3.setText("");d3.setText("");p3.setText("");m3.setText("");
		b4.setText(""); c4.setDisable(true); b4.setDisable(true);s4.setText("");d4.setText("");p4.setText("");m4.setText("");
		b5.setText(""); c5.setDisable(true); b5.setDisable(true);s5.setText("");d5.setText("");p5.setText("");m5.setText("");
		b6.setText(""); c6.setDisable(true); b6.setDisable(true);s6.setText("");d6.setText("");p6.setText("");m6.setText("");
		b7.setText(""); c7.setDisable(true); b7.setDisable(true);s7.setText("");d7.setText("");p7.setText("");m7.setText("");
		b8.setText(""); c8.setDisable(true); b8.setDisable(true);s8.setText("");d8.setText("");p8.setText("");m8.setText("");
		b9.setText(""); c9.setDisable(true); b9.setDisable(true);s9.setText("");d9.setText("");p9.setText("");m9.setText("");
		b10.setText("");  c10.setDisable(true); b10.setDisable(true);s10.setText("");d10.setText("");p10.setText("");m10.setText("");
		IMail emails[]=app.listEmails(page); //now we have e-mails for current page, max 10 e-mails
		DLinkedList list=new DLinkedList();
		pageBackup++;
		for(int i=0; i<emails.length; i++ ) {
			list.add(emails[i]);
		}//now we have a list of e-mails
		if(!list.isEmpty()) {
			Mail email=(Mail)list.get(0);
			File file=new File(path+"/"+email.path()+"/Info.txt");
			Scanner in=new Scanner(file);
			b1.setDisable(false);
			b1.setText(in.nextLine()); c1.setDisable(false);
			s1.setText(in.nextLine());
			m1.setText(in.nextLine());
			d1.setText(in.nextLine());
			p1.setText(in.nextLine());
			in.close();
			list.remove(0);
		}if(!list.isEmpty()) {
			Mail email=(Mail)list.get(0);
			File file=new File(path+"/"+email.path()+"/Info.txt");
			Scanner in=new Scanner(file);
			b2.setDisable(false);
			b2.setText(in.nextLine()); 
			c2.setDisable(false);
			s2.setText(in.nextLine());
			m2.setText(in.nextLine());
			d2.setText(in.nextLine());
			p2.setText(in.nextLine());
			in.close();
			list.remove(0);
		}if(!list.isEmpty()) {
			Mail email=(Mail)list.get(0);
			File file=new File(path+"/"+email.path()+"/Info.txt");
			Scanner in=new Scanner(file);
			b3.setDisable(false);
			b3.setText(in.nextLine()); 
			c3.setDisable(false);
			s3.setText(in.nextLine());
			m3.setText(in.nextLine());
			d3.setText(in.nextLine());
			p3.setText(in.nextLine());
			in.close();
			list.remove(0);
		}if(!list.isEmpty()) {
			Mail email=(Mail)list.get(0);
			File file=new File(path+"/"+email.path()+"/Info.txt");
			Scanner in=new Scanner(file);
			b4.setDisable(false);
			b4.setText(in.nextLine()); 
			c4.setDisable(false);
			s4.setText(in.nextLine());
			m4.setText(in.nextLine());
			d4.setText(in.nextLine());
			p4.setText(in.nextLine());
			in.close();
			list.remove(0);
		}if(!list.isEmpty()) {
			Mail email=(Mail)list.get(0);
			File file=new File(path+"/"+email.path()+"/Info.txt");
			Scanner in=new Scanner(file);
			b5.setDisable(false);
			b5.setText(in.nextLine()); 
			c5.setDisable(false);
			s5.setText(in.nextLine());
			m5.setText(in.nextLine());
			d5.setText(in.nextLine());
			p5.setText(in.nextLine());
			in.close();
			list.remove(0);
		}if(!list.isEmpty()) {
			Mail email=(Mail)list.get(0);
			File file=new File(path+"/"+email.path()+"/Info.txt");
			Scanner in=new Scanner(file);
			b6.setDisable(false);
			b6.setText(in.nextLine()); 
			c6.setDisable(false);
			s6.setText(in.nextLine());
			m6.setText(in.nextLine());
			d6.setText(in.nextLine());
			p6.setText(in.nextLine());
			in.close();
			list.remove(0);
		}if(!list.isEmpty()) {
			Mail email=(Mail)list.get(0);
			File file=new File(path+"/"+email.path()+"/Info.txt");
			Scanner in=new Scanner(file);
			b7.setDisable(false);
			b7.setText(in.nextLine()); 
			c7.setDisable(false);
			s7.setText(in.nextLine());
			m7.setText(in.nextLine());
			d7.setText(in.nextLine());
			p7.setText(in.nextLine());
			in.close();
			list.remove(0);
		}if(!list.isEmpty()) {
			Mail email=(Mail)list.get(0);
			File file=new File(path+"/"+email.path()+"/Info.txt");
			Scanner in=new Scanner(file);
			b8.setDisable(false);
			b8.setText(in.nextLine()); 
			c8.setDisable(false);
			s8.setText(in.nextLine());
			m8.setText(in.nextLine());
			d8.setText(in.nextLine());
			p8.setText(in.nextLine());
			in.close();
			list.remove(0);
		}if(!list.isEmpty()) {
			Mail email=(Mail)list.get(0);
			File file=new File(path+"/"+email.path()+"/Info.txt");
			Scanner in=new Scanner(file);
			b9.setDisable(false);
			b9.setText(in.nextLine()); 
			c9.setDisable(false);
			s9.setText(in.nextLine());
			m9.setText(in.nextLine());
			d9.setText(in.nextLine());
			p9.setText(in.nextLine());
			in.close();
			list.remove(0);
		}if(!list.isEmpty()) {
			Mail email=(Mail)list.get(0);
			File file=new File(path+"/"+email.path()+"/Info.txt");
			Scanner in=new Scanner(file);
			b10.setDisable(false);
			b10.setText(in.nextLine()); 
			c10.setDisable(false);
			s10.setText(in.nextLine());
			m10.setText(in.nextLine());
			d10.setText(in.nextLine());
			p10.setText(in.nextLine());
			in.close();
			list.remove(0);
		}
	}
}public void nextPage(ActionEvent event)throws Exception {
	errorlabel.setText("");
	init2(pageBackup,pathBackup,isTrashBackup,filterBackup,sortBackup);
}public void prevPage(ActionEvent event)throws Exception {
	errorlabel.setText("");
	pageBackup-=2;
	if(pageBackup>0) {
		init2(pageBackup,pathBackup,isTrashBackup,filterBackup,sortBackup);
	}else {
		pageBackup+=2;
		errorlabel.setText("No more pages !");
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
}public void delete(ActionEvent event)throws Exception {
	errorlabel.setText("");
	App app=new App();
	ILinkedList list=new DLinkedList();
	if(c1.isSelected()) {
		String s=getName(d1.getText());
		list.add(new Mail(s,null));
		c1.setSelected(false);
	}if(c2.isSelected()) {
		String s=getName(d2.getText());
		list.add(new Mail(s,null));
		c2.setSelected(false);
	}if(c3.isSelected()) {
		String s=getName(d3.getText());
		list.add(new Mail(s,null));
		c3.setSelected(false);
	}if(c4.isSelected()) {
		String s=getName(d4.getText());
		list.add(new Mail(s,null));
		c4.setSelected(false);
	}if(c5.isSelected()) {
		String s=getName(d5.getText());
		list.add(new Mail(s,null));
		c5.setSelected(false);
	}if(c6.isSelected()) {
		String s=getName(d6.getText());
		list.add(new Mail(s,null));
		c6.setSelected(false);
	}if(c7.isSelected()) {
		String s=getName(d7.getText());
		list.add(new Mail(s,null));
		c7.setSelected(false);
	}if(c8.isSelected()) {
		String s=getName(d8.getText());
		list.add(new Mail(s,null));
		c8.setSelected(false);
	}if(c9.isSelected()) {
		String s=getName(d9.getText());
		list.add(new Mail(s,null));
		c9.setSelected(false);
	}if(c10.isSelected()) {
		String s=getName(d10.getText());
		list.add(new Mail(s,null));
		c10.setSelected(false);
	}if(list.size()==0) {
		errorlabel.setText("Please select emails first");
	}else {
		app.setViewingOptions(new Folder(pathBackup,isTrashBackup),filterBackup, sortBackup);
		app.deleteEmails(list);
		init2(1,pathBackup,isTrashBackup,filterBackup,sortBackup);
		errorlabel.setText("Emails deleted successfully!");
	}
}public void search(ActionEvent event)throws Exception {
	errorlabel.setText("");
	if(searchcombo.getValue()==null) {
		errorlabel.setText("Choose search option first");
	}else {
		String s=searchcombo.getValue();
		int ind=0;
		if(search.getText().equals("")) {
			errorlabel.setText("Type a search word first");
		}else {
			if(s.equals("Name")) {
				ind=1;
			}else if(s.equals("Email")){
				ind=2;
			}else if(s.equals("Priority")) {
				ind=4;
			}init2(1,pathBackup,isTrashBackup,new Filter(search.getText(),ind),sortBackup);
		}
	}
	
}public void sort(ActionEvent event)throws Exception {
	errorlabel.setText("");
	if(sortcombo.getValue()==null) {
		errorlabel.setText("Choose sort option first");
	}else {
		String s=sortcombo.getValue();
		int ind=0;
		if(s.equals("Name")) {
			ind=1;
		}else if(s.equals("Email")){
			ind=2;
		}else if(s.equals("Date")){
			ind=3;
		}else if(s.equals("Priority")) {
			ind=4;
		}init2(1,pathBackup,isTrashBackup,filterBackup,new Sort(ind,false));
	}
	
}public void moveToFolder(ActionEvent event)throws Exception {
	errorlabel.setText("");
	App app=new App();
	ILinkedList list=new DLinkedList();
	String folder=userfolders.getValue();
	if(folder==null) {
		errorlabel.setText("Choose a folder first");
	}else {
		if(c1.isSelected()) {
			String s=getName(d1.getText());
			list.add(new Mail(s,null));
			c1.setSelected(false);
		}if(c2.isSelected()) {
			String s=getName(d2.getText());
			list.add(new Mail(s,null));
			c2.setSelected(false);
		}if(c3.isSelected()) {
			String s=getName(d3.getText());
			list.add(new Mail(s,null));
			c3.setSelected(false);
		}if(c4.isSelected()) {
			String s=getName(d4.getText());
			list.add(new Mail(s,null));
			c4.setSelected(false);
		}if(c5.isSelected()) {
			String s=getName(d5.getText());
			list.add(new Mail(s,null));
			c5.setSelected(false);
		}if(c6.isSelected()) {
			String s=getName(d6.getText());
			list.add(new Mail(s,null));
			c6.setSelected(false);
		}if(c7.isSelected()) {
			String s=getName(d7.getText());
			list.add(new Mail(s,null));
			c7.setSelected(false);
		}if(c8.isSelected()) {
			String s=getName(d8.getText());
			list.add(new Mail(s,null));
			c8.setSelected(false);
		}if(c9.isSelected()) {
			String s=getName(d9.getText());
			list.add(new Mail(s,null));
			c9.setSelected(false);
		}if(c10.isSelected()) {
			String s=getName(d10.getText());
			list.add(new Mail(s,null));
			c10.setSelected(false);
		}if(list.size()==0) {
			errorlabel.setText("Please select emails first");
		}else {
			app.setViewingOptions(new Folder(pathBackup,isTrashBackup),filterBackup, sortBackup);
			app.moveEmails(list, new Folder("Users/"+App.emailbackup+"/"+folder,false));//to be modified
			init2(1,pathBackup,isTrashBackup,filterBackup,sortBackup);
			errorlabel.setText("Emails moved successfully!");
		}
	}
	
}public void rename(ActionEvent event)throws Exception {
	App app=new App();
	Miscellaneous ms=new Miscellaneous();
	if(newname.getText().equals("")) {
		errorlabel.setText("Type the new name first");
	}else if(ms.checkExist2(newname.getText())) {
		errorlabel.setText("Folder already exist");
	}
	else {
		errorlabel.setText("Name changed successfully!");
		emaillabel.setText(newname.getText());
		app.renameFolder(name, newname.getText());
	}
}public void defaultView(ActionEvent event)throws Exception {
	init2(1,pathBackup,isTrashBackup,new Filter(null,0),new Sort(3,false));
}public String getName(String temp) {
	String s="";
	for(int i=0; i<temp.length();i++) {
		if(temp.charAt(i)!='/' && temp.charAt(i)!=':' &&temp.charAt(i)!='.') {
			s+=temp.charAt(i);
		}
	}return s;
}public void viewDetails(ActionEvent event)throws Exception{
	FXMLLoader loader=new FXMLLoader(getClass().getResource("edetails.fxml"));
	Parent view2 = loader.load();
    Scene scene2 = new Scene(view2);
    
    edetailController con=loader.getController();
    Button btn=(Button)event.getSource();
    if(btn.getText().equals(b1.getText())) {
    	con.set(pathBackup+"/"+getName(d1.getText()));
    }else if(btn.getText().equals(b2.getText())) {
    	con.set(pathBackup+"/"+getName(d2.getText()));
    }else if(btn.getText().equals(b3.getText())) {
    	con.set(pathBackup+"/"+getName(d3.getText()));
    }else if(btn.getText().equals(b4.getText())) {
    	con.set(pathBackup+"/"+getName(d4.getText()));
    }else if(btn.getText().equals(b5.getText())) {
    	con.set(pathBackup+"/"+getName(d5.getText()));
    }else if(btn.getText().equals(b6.getText())) {
    	con.set(pathBackup+"/"+getName(d6.getText()));
    }else if(btn.getText().equals(b7.getText())) {
    	con.set(pathBackup+"/"+getName(d7.getText()));
    }else if(btn.getText().equals(b8.getText())) {
    	con.set(pathBackup+"/"+getName(d8.getText()));
    }else if(btn.getText().equals(b9.getText())) {
    	con.set(pathBackup+"/"+getName(d9.getText()));
    }else if(btn.getText().equals(b10.getText())) {
    	con.set(pathBackup+"/"+getName(d10.getText()));
    }
    
    Stage window = new Stage();
    window.setScene(scene2);
    window.show();
}
}
