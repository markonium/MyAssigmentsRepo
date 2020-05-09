package eg.edu.alexu.csd.datastructure.mailServer;

import java.awt.Desktop;
import java.io.File;
import java.util.Scanner;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class edetailController {
	@FXML
	TextArea body;
	@FXML
	TextField name;
	@FXML
	TextField email;
	@FXML
	TextField topic;
	@FXML
	TextField pr;
	@FXML
	ComboBox<String> combo;
	@FXML
	Label errorlabel;
	String path;
	
	public void set(String path)throws Exception {
		
		this.path=path;
		File file=new File(path+"/Attachments");
		String[] arr=file.list();
		for(int i=0; i<arr.length; i++) {
			combo.getItems().add(arr[i]);
		}
		File info=new File(path+"/Info.txt");
		File body1=new File(path+"/Body.txt");
		Scanner in=new Scanner(info);
		topic.setText(in.nextLine());
		name.setText(in.nextLine());
		email.setText(in.nextLine());
		in.nextLine();
		pr.setText(in.nextLine());
		in.close();
		topic.setEditable(false);;
		pr.setEditable(false);
		name.setEditable(false);
		email.setEditable(false);
		body.setEditable(false);
		Scanner in2=new Scanner(body1);
		String s="";
		while(in2.hasNextLine()) {
			s+=in2.nextLine()+"\n";
		}
		in2.close();
		body.setText(s);
	}public void viewAtt(ActionEvent event) throws Exception{
		if(combo.getValue()==null) {
			errorlabel.setText("Choosea an attachment first");
		}else {
			errorlabel.setText("");
			File file=new File(path+"/Attachments/"+combo.getValue());
			Desktop desktop=Desktop.getDesktop();
			desktop.open(file);
		}
	}
}
