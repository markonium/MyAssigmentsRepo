package eg.edu.alexu.csd.datastructure.mailServer;

import java.io.*;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class App implements IApp{
	 IFolder folderBackup; int oldMailsDeleted=0; public static String emailbackup;public static String passbackup;public static DLinkedList folderNames=new DLinkedList();
	 public boolean signup(IContact contact){
			File users =new File("Users");
			users.mkdir();
	        try {
	        	File file = new File("Users/"+contact.email());
	        	if (!file.mkdir()) {
	        		return false;
	        	}File data=new File("Users/"+contact.email()+"/data.txt");
	        	try {
	        		FileWriter fw=new FileWriter(data);
	        		fw.write(contact.password()+"\n");
	        		fw.write(contact.name());
	        		fw.close();
	        	}catch(IOException e){
	        		file.delete();
	        		throw new RuntimeException("An error occured !");
	        	}File inbox=new File("Users/"+contact.email()+"/Inbox");
	        	File sent=new File("Users/"+contact.email()+"/Sent");
	        	File draft=new File("Users/"+contact.email()+"/Draft");
	        	File trash=new File("Users/"+contact.email()+"/Trash");
	        	File f1=new File("Users/"+contact.email()+"/Folder1");
	        	File f2=new File("Users/"+contact.email()+"/Folder2");
	        	File f3=new File("Users/"+contact.email()+"/Folder3");
	        	File f4=new File("Users/"+contact.email()+"/Folder4");
	        	File contacts=new File("Users/"+contact.email()+"/Contacts");
	        	f1.mkdir();
	        	f2.mkdir();
	        	f3.mkdir();
	        	f4.mkdir();
	        	inbox.mkdir();
	        	sent.mkdir();
	        	draft.mkdir();
	        	trash.mkdir();
	        	contacts.mkdir();
	        	File index1=new File("Users/"+contact.email()+"/Inbox/Index.txt");
	        	File index2=new File("Users/"+contact.email()+"/Sent/Index.txt");
	        	File index3=new File("Users/"+contact.email()+"/Draft/Index.txt");
	        	File index4=new File("Users/"+contact.email()+"/Trash/Index.txt");
	        	File index5=new File("Users/"+contact.email()+"/Contacts/Index.txt");
	        	File index6=new File("Users/"+contact.email()+"/Folder1/Index.txt");
	        	File index7=new File("Users/"+contact.email()+"/Folder2/Index.txt");
	        	File index8=new File("Users/"+contact.email()+"/Folder3/Index.txt");
	        	File index9=new File("Users/"+contact.email()+"/Folder4/Index.txt");
	        	File b1=new File("Users/"+contact.email()+"/Inbox/Backup.txt");
	        	File b2=new File("Users/"+contact.email()+"/Sent/Backup.txt");
	        	File b3=new File("Users/"+contact.email()+"/Draft/Backup.txt");
	        	File b5=new File("Users/"+contact.email()+"/Trash/Time.txt");
	        	File b4=new File("Users/"+contact.email()+"/Contacts/Backup.txt");
	        	File b6=new File("Users/"+contact.email()+"/Contacts/Backup.txt");
	        	File b7=new File("Users/"+contact.email()+"/Contacts/Backup.txt");
	        	File b8=new File("Users/"+contact.email()+"/Contacts/Backup.txt");
	        	File b9=new File("Users/"+contact.email()+"/Contacts/Backup.txt");
	        	File b=new File("Users/"+contact.email()+"/FolderNames.txt");
	        	
	        	try {
	        		
	        		index1.createNewFile();
	        		index2.createNewFile();
	        		index3.createNewFile();
	        		index4.createNewFile();
	        		index5.createNewFile();
	        		index6.createNewFile();
	        		index7.createNewFile();
	        		index8.createNewFile();
	        		index9.createNewFile();
	        		b.createNewFile();
	        		b1.createNewFile();
	        		b2.createNewFile();
	        		b3.createNewFile();
	        		b4.createNewFile();
	        		b5.createNewFile();
	        		b6.createNewFile();
	        		b7.createNewFile();
	        		b8.createNewFile();
	        		b9.createNewFile();
	        		Writer wr=new BufferedWriter(new FileWriter("Users/"+contact.email()+"/FolderNames.txt",true));
	        		wr.append("Folder1\n");
	        		wr.append("Folder2\n");
	        		wr.append("Folder3\n");
	        		wr.append("Folder4\n");
	        		wr.close();
	        		FileWriter fw1=new FileWriter(b1);
	        		FileWriter fw2=new FileWriter(b2);
	        		FileWriter fw3=new FileWriter(b3);
	        		FileWriter fw4=new FileWriter(b4);
	        		fw1.write(contact.email()); fw1.close();
	        		fw2.write(contact.email()); fw2.close();
	        		fw3.write(contact.email()); fw3.close();
	        		fw4.write(contact.email()); fw4.close();
	        	}catch(IOException e) {}
	        }catch (SecurityException e){
	            throw new RuntimeException("An error occured !");
	        }return true;
	 }
	 public boolean signin(String email,String password){
		    emailbackup=email; passbackup=password;
		 	Scanner in;
	        try {
	        	File file=new File("Users/"+email+"/data.txt");
	            in=new Scanner(file);
	        }catch (FileNotFoundException e){
	            return false;
	        }if(password.equals(in.nextLine())) {
	        	in.close();
	        	try {
	        		File file2=new File("Users/"+email+"/FolderNames.txt");
		        	Scanner in2=new Scanner(file2);
		        	while(!folderNames.isEmpty()) {
		        		folderNames.remove(0);
		        	}
		        	while(in2.hasNextLine()) {
		        		folderNames.add(in2.nextLine());
		        	}in2.close();
	        	}catch(Exception e) {}
	        	return true;
	        }in.close();
	        return false;   
	 }
	 public void setViewingOptions(IFolder folder, IFilter filter, ISort sort) {
		 folderBackup=new Folder(folder.path(), folder.isTrash());
		 Miscellaneous m=new Miscellaneous();
		 boolean isContact=sort.isContact();
		 m.QuickSort(folder.path(), sort.topicNum(), isContact,false);
		 if(filter.filter()!=null) {
			 try {
				m.filter(folder.path(),filter.filter(), filter.ind(), isContact);
			} catch (FileNotFoundException e) {}
		 }
	 }public IMail[] listEmails(int page) {
		 if(folderBackup.isTrash() && oldMailsDeleted==0) {
			 checkTimeOfDeletion(folderBackup.path());
		 }
		 File file3 =new File(folderBackup.path()+"/Index.txt");
		 File file2 =new File(folderBackup.path()+"/filteredNum.txt");
		 File file =new File(folderBackup.path()+"/temp.txt");
		 try {
			file.createNewFile();
		 }catch (IOException e1) {}
		 String s; int size; int index=0;
		 DLinkedList list=new DLinkedList();
		 IMail[] mail=null;
		 try {
			Scanner in2=new Scanner(file2);
			s=in2.nextLine();
			in2.close();
			Scanner in3=new Scanner(file3);
			
			
			if(!s.equals("n/a")) {
				 try {
					FileWriter t=new FileWriter(file);
					for(int i=0; i<5*Integer.parseInt(s); i++) {
						 t.write(in3.nextLine()+"\n");
					}
					t.close();//now temp.txt holds the e-mails to be processed
				} catch (IOException e) {}
			}else {
				file=file3;
			}
			in3.close();
			
			
			Scanner in=new Scanner(file);
			//paging 10 e-mails/page
			for(int i=0; i<50*(page-1) ; i++) {
				in.nextLine(); //assuming that only existing page number will be sent as a parameter even if the e-mails are filtered
			}int check=0;//this variable insures that max of 10 email / page will be shown
			while(in.hasNextLine() && check<=50) {
				list.add(in.nextLine());
				check++;
			}//now list carry the data of the index file 1 line/node
			in.close();
			size=list.size()/5;
			mail=new IMail[size];
			while(list.size()>4) {
				String temp=(String)list.get(3);
				for(int i=0; i<5; i++) {
					list.remove(0);
				}
				String path="";
				for(int i=0; i<temp.length(); i++) {
					if(temp.charAt(i)!='/' && temp.charAt(i)!=':' && temp.charAt(i)!='.') {
						path+=temp.charAt(i);
					}
				}//now we have the email path
				mail[index]=new Mail(path,null);
				index++;
			}
		 }catch (FileNotFoundException e) {}
		 File file4 =new File(folderBackup.path()+"/temp.txt");
		 file4.delete();
		 return mail;
	 }public void deleteEmails(ILinkedList mails) {//mails is a linked list contain IMail
		 File fileTemp=new File(folderBackup.path()+"/Backup.txt");
		 try {
			Scanner in = new Scanner(fileTemp);
			String email=in.nextLine();//file owner email
			in.close();
			for(int i=0; i<mails.size(); i++){//you have to sort the e-mails default before calling this method
				 Mail mail=(Mail)mails.get(i);
				 File from=new File(folderBackup.path()+"/"+mail.path);//now we have the first email path
				 File to=new File("Users/"+email+"/Trash/"+mail.path);
				 File info=new File(folderBackup.path()+"/"+mail.path+"/Info.txt");
				 try {
					Writer wr=new BufferedWriter(new FileWriter("Users/"+email+"/Trash/Index.txt",true));
					Writer wr2=new BufferedWriter(new FileWriter("Users/"+email+"/Trash/Time.txt",true));
					Scanner in2=new Scanner(info);
					while(in2.hasNextLine()) {
						wr.append(in2.nextLine()+"\n");
					}in2.close();
					LocalDateTime now=LocalDateTime.now();
					
					wr2.append(now.toString()+"\n");
					wr2.append(mail.path()+"\n");
					wr2.append(".\n");
					wr2.append(".\n");
					wr2.append(".\n");
					
					wr2.close();
					wr.close();
				 }catch (IOException e) {}
				 from.renameTo(to);
			}updateIndex(mails);
		}catch (FileNotFoundException e) {}
	 }public void updateIndex(ILinkedList mails) {
		 File file=new File(folderBackup.path()+"/tempIndex.txt");
		 File file2=new File(folderBackup.path()+"/Index.txt");
		 DLinkedList list=new DLinkedList();
		 try {
			Scanner in = new Scanner(file2);
			while(in.hasNextLine()) {
				list.add(in.nextLine());
			}in.close();
		 }catch (FileNotFoundException e1) {}
		 try {
			file.createNewFile();
			FileWriter fw=new FileWriter(file);
			for(int i=3; i<list.size(); i+=5) {
				int found=0;
				for(int k=0 ; k<mails.size(); k++) {
					Mail mail=(Mail)mails.get(k);
					String temp=mail.path(); String date="";
					for(int j=0; j<temp.length(); j++) {
						if(j==4||j==6) {
							date+="/"+temp.charAt(j);
						}else if(j==11 || j==13) {
							date+=":"+temp.charAt(j);
						}else if(j==15) {
							date+="."+temp.charAt(j);
						}else {
							date+=temp.charAt(j);
						}
					}found=0;
					if(date.equals((String)list.get(i))) {
						found=1;
						break;
					}
				}if(found==0) {
					for(int j=i-3; j<=i+1; j++) {
						fw.write((String)list.get(j)+"\n");
					}
				}
			}file2.delete();
			File file3=new File(folderBackup.path()+"/Index.txt");
			fw.close();
			file.renameTo(file3);	
		} catch (IOException e) {} 
	 }public void checkTimeOfDeletion(String path) {//trash path + it needs index file arranged default
		 Miscellaneous ms=new Miscellaneous();
		 ms.QuickSort(folderBackup.path(),1,false,true);
		 oldMailsDeleted=1;
		 File file1=new File(path+"/Time.txt");
		 File file2=new File(path+"/Index.txt");
		 File file3=new File(path+"/tempTime.txt");
		 File file4=new File(path+"/tempIndex.txt");
		 DLinkedList list1=new DLinkedList();//for time.txt
		 DLinkedList list2=new DLinkedList();//for index.txt
		 try {
			file3.createNewFile();
			file4.createNewFile();
			Scanner in1=new Scanner(file1);
			Scanner in2=new Scanner(file2);
			Writer wr1=new BufferedWriter(new FileWriter(path+"/tempTime.txt",true));
			Writer wr2=new BufferedWriter(new FileWriter(path+"/tempIndex.txt",true));
			while(in1.hasNextLine()) {//loading time in a list
				list1.add(in1.nextLine());
			}
			while(in2.hasNextLine()) {//loading index in a list
				list2.add(in2.nextLine());
			}
			LocalDateTime now=LocalDateTime.now(); //current time
			//to be compared with time in the list
			for(int i=0; i<list1.size(); i+=5) {
				LocalDateTime deletionDate=LocalDateTime.parse((String)list1.get(i));
				Duration duration=Duration.between(now, deletionDate);
				long timeInSec=Math.abs(duration.toSeconds());
				if(timeInSec>=2592000) {
					File tempFile=new File(path+"/"+(String)list1.get(i+1));
					deleteDir(tempFile);
				}else {
					for(int j=i; j<i+5; j++) {
						wr1.append((String)list1.get(j)+"\n");
						wr2.append((String)list2.get(j)+"\n");
					}
				}
			}
			in1.close();
			in2.close();
			wr1.close();
			wr2.close();
		} catch (IOException e) {}
		file1.delete();
		file2.delete();
		File file1new=new File(path+"/Time.txt");
		File file2new=new File(path+"/Index.txt");
		file3.renameTo(file1new);
		file4.renameTo(file2new);
	 }public void deleteDir(File dir) {
		 File[] listFiles = dir.listFiles();
		 for(File file : listFiles){
			if(file.isDirectory()) {
				deleteDir(file);
			}else {
				file.delete();
			}
		}dir.delete();
	 }
	 public void moveEmails(ILinkedList mails, IFolder des) {
		 updateIndex(mails);
		 for(int i=0; i<mails.size(); i++) {//iterate through the mails
			 Mail mail=(Mail)mails.get(i);
			 File file1=new File(folderBackup.path()+"/"+mail.path());
			 File file2=new File(des.path()+"/"+mail.path());
			 file1.renameTo(file2);
			 File file3=new File(des.path()+"/"+mail.path()+"/Info.txt"); 
			 try {
				Scanner in=new Scanner(file3);
				Writer wr=new BufferedWriter(new FileWriter(des.path()+"/Index.txt",true));
				while(in.hasNextLine()) {
					wr.append(in.nextLine()+"\n");
				}
				in.close();
				wr.close();
			 }catch (IOException e) {}
		 }
	 }public void createEmail(String senderEmail ,String priority, String topic, String body, LinkedQueue receiver, SLinkedList attachments, boolean isDraft) {
		 while(!receiver.isEmpty()) {//assuming only valid receivers are sent
			 	String r=(String)receiver.dequeue();
				LocalDateTime now=LocalDateTime.now();
				DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyyMMdd HHmmssSSSSSSSSS");
				String s=f.format(now);
				File file1;
				File file2;
				File bodyFile;
				File InfoFile;
				if(isDraft) {
					file1=new File("Users/"+senderEmail+"/Draft/"+s);
					file2=new File("Users/"+senderEmail+"/Draft/"+s+"/Attachments"); //attachments folder created
					bodyFile=new File("Users/"+senderEmail+"/Draft/"+s+"/Body.txt");
					InfoFile=new File("Users/"+senderEmail+"/Draft/"+s+"/Info.txt");
				}else {
					file1=new File("Users/"+senderEmail+"/Sent/"+s);
					file2=new File("Users/"+senderEmail+"/Sent/"+s+"/Attachments"); //attachments folder created
					bodyFile=new File("Users/"+senderEmail+"/Sent/"+s+"/Body.txt");
					InfoFile=new File("Users/"+senderEmail+"/Sent/"+s+"/Info.txt");
				}
				file1.mkdir();//email folder is created in sent directory
				file2.mkdir();
				try {
					for(int z=1; z<=attachments.size(); z++) {
						File att=(File)attachments.get(z);
						File to;
						if(isDraft) {
							to=new File("Users/"+senderEmail+"/Draft/"+s+"/Attachments/"+att.getName());
						}else {
							to=new File("Users/"+senderEmail+"/Sent/"+s+"/Attachments/"+att.getName());
						}
						Files.copy(att.toPath(), to.toPath());
					}
					bodyFile.createNewFile();//info ,body files created as text files
					InfoFile.createNewFile();
					Writer wr1;
					Writer wr2;
					Writer wr3;
					if(isDraft) {
						wr1=new BufferedWriter(new FileWriter("Users/"+senderEmail+"/Draft/"+s+"/Body.txt",true));
						wr2=new BufferedWriter(new FileWriter("Users/"+senderEmail+"/Draft/"+s+"/Info.txt",true));
						wr3=new BufferedWriter(new FileWriter("Users/"+senderEmail+"/Draft/Index.txt",true));
					}else {
						wr1=new BufferedWriter(new FileWriter("Users/"+senderEmail+"/Sent/"+s+"/Body.txt",true));
						wr2=new BufferedWriter(new FileWriter("Users/"+senderEmail+"/Sent/"+s+"/Info.txt",true));
						wr3=new BufferedWriter(new FileWriter("Users/"+senderEmail+"/Sent/Index.txt",true));
					}
					wr1.append(body);
					DateTimeFormatter f2=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSSSSSSSS");
					String s2=f2.format(now);
					File temp=new File("Users/"+r+"/data.txt");
					Scanner in=new Scanner(temp);
					in.nextLine();
					wr2.append(topic+"\n");
					wr3.append(topic+"\n");
					String ss=in.nextLine();
					wr2.append(ss+"\n"); //navigating to receiver name
					wr3.append(ss+"\n");
					wr2.append(r+"\n");//receiver email
					wr3.append(r+"\n");
					wr2.append(s2+"\n");//time
					wr3.append(s2+"\n");
					wr2.append(priority+"\n");
					wr3.append(priority+"\n");
					in.close();
					wr1.close();
					wr2.close();
					wr3.close();
					Mail email=new Mail(s,senderEmail);
					if(!isDraft) {
						compose(email);
					}
					//call compose here
				} catch (IOException e) {}
		 }
	 }public boolean compose(IMail email) {
		 try {
			File file1=new File("Users/"+email.senderEmail()+"/Sent/"+email.path()+"/Info.txt");
			File file3=new File("Users/"+email.senderEmail()+"/Sent/"+email.path());
			Scanner in1=new Scanner(file1);
			in1.nextLine();
			in1.nextLine();
			String ss=in1.nextLine();
			File file2=new File("Users/"+ss+"/Inbox/"+email.path());
			file2.mkdir(); //creating the email file in receiver's inbox 
			in1.close();
			Scanner in2=new Scanner(file1);
			Writer wr1=new BufferedWriter(new FileWriter("Users/"+ss+"/Inbox/Index.txt",true));
			while(in2.hasNextLine()) {
				wr1.append(in2.nextLine()+"\n");//filling index
			}
			in2.close();
			wr1.close();
			copyDirectory(file3, file2);
			//--------------------------------------
			Miscellaneous ms=new Miscellaneous();
			ms.QuickSort("Users/"+ss+"/Inbox", 3, false, false);//arranged based on date
			File fileinf=new File("Users/"+ss+"/Inbox/"+email.path()+"/Info.txt");
			File fileind=new File("Users/"+ss+"/Inbox/Index.txt");
			Scanner info=new Scanner(fileinf);
			Scanner index=new Scanner(fileind);
			File fileinfn=new File("Users/"+ss+"/Inbox/"+email.path()+"/Infon.txt");
			File fileindn=new File("Users/"+ss+"/Inbox/Indexn.txt");
			fileinfn.createNewFile();
			fileindn.createNewFile();
			Writer wrinf=new BufferedWriter(new FileWriter("Users/"+ss+"/Inbox/"+email.path()+"/Infon.txt",true));
			Writer wrind=new BufferedWriter(new FileWriter("Users/"+ss+"/Inbox/Indexn.txt",true));
			File senderData=new File("Users/"+email.senderEmail()+"/data.txt");
			Scanner data=new Scanner(senderData);
			data.nextLine();
			String name=data.nextLine();
			wrinf.append(info.nextLine()+"\n");
			info.nextLine();//name line
			wrind.append(index.nextLine()+"\n");
			index.nextLine();//name line
			wrinf.append(name+"\n");//sender name
			info.nextLine();
			wrind.append(name+"\n");//sender name
			index.nextLine();
			String z=email.senderEmail();
			wrinf.append(z+"\n");//sender name
			wrind.append(z+"\n");
			while(info.hasNext()) {
				wrinf.append(info.nextLine()+"\n");
			}while(index.hasNext()) {
				wrind.append(index.nextLine()+"\n");
			}
			data.close();
			wrinf.close();
			wrind.close();
			info.close();
			index.close();
			fileinf.delete();
			fileind.delete();
			File fileinfnn=new File("Users/"+ss+"/Inbox/"+email.path()+"/Info.txt");
			File fileindnn=new File("Users/"+ss+"/Inbox/Index.txt");
			fileinfn.renameTo(fileinfnn);
			fileindn.renameTo(fileindnn);
			//--------------------------------------
		} catch (IOException e) {
			return false;
		}
		return true;
	 }public static void copyDirectory(File dir, File dis)throws IOException {
	        if (dir.isDirectory()) {
	            copyDirectoryRecursively(dir, dis);
	        } else {
	            Files.copy(dir.toPath(), dis.toPath());
	        }
	 }
	private static void copyDirectoryRecursively(File dir, File dis)throws IOException {
	        if (!dis.exists()) {
	            dis.mkdir();
	        }
	        for (String child : dir.list()) {
	            copyDirectory(new File(dir, child), new File(dis, child));
	        }
	}public int countEmailPages(String path)throws Exception {
		File file1=new File(path+"/filteredNum.txt");
		Scanner in1=new Scanner(file1);
		String s=in1.nextLine();
		in1.close();
		if(!s.equals("n/a")) {
			int emnum=Integer.parseInt(s);
			if(emnum%10==0) {
				return emnum/10;
			}else {
				return (emnum/10)+1;
			}
		}else {
			File file2=new File(path+"/Index.txt");
			int lineNum=0;
			Scanner in2=new Scanner(file2);
			while(in2.hasNextLine()) {
				lineNum++;
				in2.nextLine();
			}in2.close();
			int emnum=lineNum/5;
			if(emnum%10==0) {
				return emnum/10;
			}else {
				return (emnum/10)+1;
			}
		}
	}public void renameFolder(String name, String newName)throws Exception {
		File from=new File("Users/"+emailbackup+"/"+name);
		File to=new File("Users/"+emailbackup+"/"+newName);
		File oldNames=new File("Users/"+emailbackup+"/FolderNames.txt");
		File newNames=new File("Users/"+emailbackup+"/newFolderNames.txt");
		newNames.createNewFile();
		Scanner in = new Scanner(oldNames);
		Writer wr=new BufferedWriter(new FileWriter("Users/"+emailbackup+"/newFolderNames.txt",true));

		while(in.hasNextLine()) {
			String s=in.nextLine();
			if(s.equals(name)) {
				wr.append(newName+"\n");
			}else {
				wr.append(s+"\n");
			}
		}
		in.close();
		wr.close();
		oldNames.delete();
		File temp=new File("Users/"+emailbackup+"/FolderNames.txt");
		newNames.renameTo(temp);
		copyDirectory(from,to);
		deleteDir(from);
		signin(emailbackup,passbackup);
	}public int countemails(String path)throws Exception {
		File file=new File(path+"/Index.txt");
		Scanner in=new Scanner(file);
		int count=0;
		while(in.hasNextLine()) {
			in.nextLine();
			count++;
		}in.close();
		return count/5;
	}
}
