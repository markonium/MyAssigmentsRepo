package eg.edu.alexu.csd.datastructure.mailServer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EmptyStackException;
import java.util.Scanner;

public class Miscellaneous implements IMiscellaneous{
	DLinkedList list=new DLinkedList();
    public void QuickSort(String path,int topicNum,boolean isContact,boolean isTime) {
    	while(!list.isEmpty()) {
    		list.remove(0);
    	}
    	if(topicNum==4) {
    		PrioritySort(path);
    	}else {
    		File file;
    		if(isTime) {
    			file=new File(path+"/Time.txt");
    		}else {
    			file=new File(path+"/Index.txt");
    		}
        	try {
        		Scanner temp1=new Scanner(file);
            	int lineNum=0;
            	while(temp1.hasNextLine()) {
            		lineNum++;
            		temp1.nextLine();
            	}temp1.close();
            	int Cols;
            	if(isContact) {
            		Cols=1;
            	}else {
            		Cols=5;
            	}String[] arr=new String[Cols];
            	Scanner in=new Scanner(file);
                for(int j=0; j<lineNum/Cols; j++) {
                	for(int i=0; i<Cols; i++) {
                		arr[i]=in.nextLine();
                	}list.add(arr.clone());
                }in.close();
            	//now we have a list with the content of the index file, each node is information about a certain email
                Stack stack = new Stack();
                stack.push(0);
                stack.push(list.size());

                while (!stack.isEmpty()) {
                    int end = (int)stack.pop();
                    int start = (int)stack.pop();
                    if ((end-start)<2) {
                        continue;
                    }
                    int p = start + ((end-start)/2);
                    p = partition(p, start, end, topicNum);

                    stack.push(p + 1);
                    stack.push(end);

                    stack.push(start);
                    stack.push(p);
                }
                if(topicNum==3 || isTime) {//reset arrangement to default 
            		String[] temp; int a=0; int b=list.size()-1;
            		while(a<b) {
            			temp=((String[])list.get(a));
            			list.set(a, ((String[])list.get(b)));
            			list.set(b, temp);
            			a++;b--;
            		}
            	}file.delete();
            	File newFile;
            	if(isTime) {
            		newFile=new File(path+"/Time.txt");
            	}else {
            		newFile=new File(path+"/Index.txt");
            	}
            	File newFile2=new File(path+"/filteredNum.txt");
            	try {
            		newFile.createNewFile();
            		FileWriter fw=new FileWriter(newFile);
            		FileWriter fw2=new FileWriter(newFile2);
            		String[] temp;
            		for(int i=0 ;i<list.size(); i++) {
            			temp=((String[])list.get(i));
            			for(int j=0; j<Cols ;j++) {
            				fw.write(temp[j]+"\n");
            			}
            		}fw2.write("n/a");
            		fw2.close();
            		fw.close();
            	}catch(IOException e){}
        	}catch(FileNotFoundException e) {}
    	}
    }

    /*
     * A method to partition the 2D array
     */
    private int partition(int position, int start, int end, int topicNum) {
        int l = start;
        int h = end - 2;  
        String p = ((String[])list.get(position))[topicNum];
        swapCol(position, end-1);

        while (l < h) {
            if (((String[])list.get(l))[topicNum].compareTo(p)<=0) {
                l++;
            } else if (((String[])list.get(h))[topicNum].compareTo(p)>0) {
                h--;
            } else {
                swapCol(l, h);
            }
        }
        int i = h;
        if (((String[])list.get(h))[topicNum].compareTo(p)<0) {
            i++;
        }
        swapCol(end-1, i);
        return i;
    }

    /**
     * Utility method to swap two numbers in given array
     * @param i
     * @param j
     */
    private void swapCol(int i, int j) {
    	String []temp=((String[])list.get(i));
    	list.set(i, ((String[])list.get(j)));
    	list.set(j, temp);
    }
    public boolean checker(String email){
        int i;
        char x;
        boolean good =true;
        if(email.length()<16) {
        	return false;
        }
        String tag="@mailserver.com";
        char []arr1=tag.toCharArray();
        char[]arr2=email.toCharArray();
        for (i=1;i<=arr1.length;i++){
            if(arr1[arr1.length-i]!=arr2[arr2.length-i]){
                good=false;
            }if(Character.isUpperCase(arr2[arr2.length-i])) {
            	good=false;
            }
        }
        for (int j=i;j<=arr2.length;j++){
            x=arr2[arr2.length-j];
            if(x==' '){
                good=false;
            }
            if(!Character.isDigit(x) && !Character.isAlphabetic(x) && x!='_'){
                good=false;
            }
        }
        return good;
    }
    public boolean BinarySearch(File file,String want,int ind,boolean isContact) throws FileNotFoundException {
    	DLinkedList tem=new DLinkedList(); //the new file will be filterNum as well
        String holder;
        boolean good=false;
        int x=0;
        Stack s=new Stack();
        Stack s2=new Stack();
        Scanner in=new Scanner(file);
        while (in.hasNextLine()) {
            tem.add(in.nextLine());
        }in.close();
        if(isContact) {
            while (!tem.isEmpty()) {
                  s.push(tem.get(0));
                  tem.remove(0);
            }
        }else{
              while (!tem.isEmpty()){
                  s.push(tem.get(ind));
                  tem.remove(0);
                  tem.remove(0);
                  tem.remove(0);
                  tem.remove(0);
                  tem.remove(0);
              }
        }
        while (true){
            if(s.size()%2==0) {x=s.size()/2;}
            if(s.size()%2!=0)  {x=(s.size()/2)+1;}
            for(int i=0;i<x-1;i++){
                s2.push(s.pop());
            }try {
            	holder=(String)s.peek();
            }catch(EmptyStackException e) {
            	return false;
            }
            
            if(want.compareTo(holder)==0){
                good=true;
                break;
            }else if(want.compareTo(holder)<0){
                s.pop();
                if(s.size()==0){break;}
                while (!s2.isEmpty()){s2.pop();}
            }else if(want.compareTo(holder)>0){
                s.pop();
                if(s.size()==0){break;}
                while (!s.isEmpty()){s.pop();}
                while (!s2.isEmpty()){s.push(s2.pop());}
            }
        }
        return good;
    }
    /**
     * This method sort the e-mails according to priority
     * @param path The path of the index file
     */
    public void PrioritySort(String path) {
    	File file=new File(path+"/Index.txt");
    	PriorityQueue queue=new PriorityQueue();
		try {
    		Scanner temp1=new Scanner(file);
        	int lineNum=0;
        	while(temp1.hasNextLine()) {
        		lineNum++;
        		temp1.nextLine();
        	}temp1.close();
        	int Cols=5;
        	String[] arr=new String[Cols];
        	Scanner in=new Scanner(file);
        	String temp="";
            for(int j=0; j<lineNum/Cols; j++) {
            	for(int i=0; i<Cols; i++) {
            		temp=in.nextLine();
            		arr[i]=temp;
            	}queue.insert(arr.clone(), Integer.parseInt(temp));//temp is now the key
            }in.close();
            file.delete();
        	File newFile=new File(path+"/Index.txt");
        	File newFile2=new File(path+"/filteredNum.txt");
        	try {
        		newFile.createNewFile();
        		FileWriter fw=new FileWriter(newFile);
        		FileWriter fw2=new FileWriter(newFile2);
        		String[] temp2;
        		int size=queue.size();
        		for(int i=0 ;i<size; i++) {
        			temp2=((String[])queue.removeMin());
        			for(int j=0; j<Cols ;j++) {
        				fw.write(temp2[j]+"\n");
        			}
        		}fw2.write("n/a");
        		fw2.close();
        		fw.close();
        	}catch(IOException e){
        		System.out.println("Error");
        	}
		} catch (FileNotFoundException e) {}
    }
    public void filter(String path,String filter,int ind,boolean isContact) throws FileNotFoundException {
        int l;
        /*
        if this is a contact then we set ind to zero to always check the first element
        then we set l which is the number of lines we are going to put from our hold linked list into another one
        so if its a contact we are going to read one line and if not then we are going to read all five lines
         */
        QuickSort(path,ind,isContact,false);
        File file =new File(path+"/Index.txt");
        if(BinarySearch(file, filter, ind, isContact)) {
        	if(isContact){
                ind=0;
                l=1;
            }else{
                l=5;
            }
            /*
            here we initialize the counter and create  the linked lists
             */
            int count=0;
            DLinkedList hold=new DLinkedList();
            DLinkedList temp = new DLinkedList();
            DLinkedList end= new DLinkedList();
            Scanner in =new Scanner(file);
            /*
            we read all lines in the hold linked list
             */
            while (in.hasNextLine()){
                hold.add(in.nextLine());
            }in.close();
            /*
            we set this loop to work until the hold linked list is empty
             */
            while (!hold.isEmpty()){
                /*
                we store the value of the line we are going to compare to our word
                which can be from zero to four if it isn't a contact and zero if it is
                 */
                String t=(String)hold.get(ind);
                /*
                here we check if the string we have is equal to the string we want
                 */
                if(t.equals(filter)){
                    /*
                    if they are equal we empty the first five element if its not a contact and the first one if its
                    in the final linked list and we do that by adding the first element from hold into end and then we remove
                    it from hold and repeat that l time so that the new first l element are those of the next info
                    then we increase the count because we did find a a match
                     */
                    for(int i=0;i<l;i++){
                        end.add(hold.get(0));
                        hold.remove(0);
                    }
                    count++;
                }else{
                    /*
                    if they are not equal then we add the first l element to our temp list to add them later to the end of our
                    final list
                     */
                    for(int i=0;i<l;i++){
                        temp.add(hold.get(0));
                        hold.remove(0);
                    }
                }
            }
            /*
            here we just add the elements that got stored in temp because they didn't match to the end of the
            final linked list
             */
            while (!temp.isEmpty()){
                end.add(temp.get(0));
                temp.remove(0);
            }file.delete();
            File newFile1=new File(path+"/Index.txt");
            File newFile2=new File(path+"/filteredNum.txt");
            try {
            	FileWriter fw1=new FileWriter(newFile1);
            	FileWriter fw2=new FileWriter(newFile2);
                while (!end.isEmpty()){
                    fw1.write((String)end.get(0)+"\n");
                    end.remove(0);
                }fw1.close();
                fw2.write(Integer.toString(count));
                fw2.close();
            }catch(IOException e) {}
        }else {
        	File newFile2=new File(path+"/filteredNum.txt");
            try {
            	FileWriter fw2=new FileWriter(newFile2);
                fw2.write("0");
                fw2.close();
            }catch(IOException e) {}
        }
    }public boolean createContact(String path, IContact contact){//path to contact folder
    	File file=new File(path+"/"+contact.name());
    	Path path1=file.toPath();
    	if(Files.exists(path1)) {
			return false;
		}else {
			file.mkdir();
    		File file2=new File(path+"/"+contact.name()+"/Data.txt");
    		DLinkedList list=contact.emailList();
    		try {
				file2.createNewFile();
				Writer wr=new BufferedWriter(new FileWriter(path+"/"+contact.name()+"/Data.txt",true));
				wr.append(contact.name()+"\n");
				while(!list.isEmpty()) {
					wr.append((String)list.get(0)+"\n");
					list.remove(0);
				}wr.close();
				Writer wr2=new BufferedWriter(new FileWriter(path+"/Index.txt",true));
				wr2.append(contact.name()+"\n");
				wr2.close();
			} catch (IOException e) {}
		}return true;
    }public void deleteContact(DLinkedList contactNames) {
    	App app=new App();
    	for(int i=0;i<contactNames.size();i++) {
    		File file=new File("Users/"+App.emailbackup+"/Contacts/"+(String)contactNames.get(i));
    		app.deleteDir(file);
    	}try {
			uindex(contactNames);
		} catch (IOException e) {}
    }public void uindex(DLinkedList contactNames) throws IOException {
    	File file=new File("Users/"+App.emailbackup+"/Contacts/Index.txt");
    	File file2=new File("Users/"+App.emailbackup+"/Contacts/tempIndex.txt");
    	Writer wr=new BufferedWriter(new FileWriter("Users/"+App.emailbackup+"/Contacts/tempIndex.txt",true));
    	file2.createNewFile();
    	Scanner in=new Scanner(file);
    	while(in.hasNextLine()) {
    		int found=0;
    		String s=in.nextLine();
    		for(int i=0; i<contactNames.size(); i++) {
    			String name=(String)contactNames.get(i);
    			if(s.equals(name)){
    				found=1;
    				break;
    			}
    		}if(found==0) {
    			wr.append(s+"\n");
    		}
    	}
    	in.close();
    	wr.close();
    	file.delete();
    	File newFile =new File("Users/"+App.emailbackup+"/Contacts/Index.txt");
    	file2.renameTo(newFile);
    }
    
    
    public void changename(String path,String name) throws IOException {
    	File file1 =new File(path+"/data.txt");
    	Scanner in=new Scanner(file1);
    	File file2 =new File(path+"/datatemp.txt");
    	file2.createNewFile();
    	FileWriter fw=new FileWriter(file2);
    	fw.write(in.nextLine()+"\n");
    	fw.write(name);
    	fw.close();
    	in.close();
    	file1.delete();
    	File file3 =new File(path+"/data.txt");
    	file2.renameTo(file3);
    }public void changepass(String path,String pass) throws IOException {
    	File file1 =new File(path+"/data.txt");
    	Scanner in=new Scanner(file1);
    	File file2 =new File(path+"/datatemp.txt");
    	file2.createNewFile();
    	FileWriter fw=new FileWriter(file2);
    	fw.write(pass);
    	in.nextLine();
    	fw.write("\n"+in.nextLine());
    	fw.close();
    	in.close();
    	file1.delete();
    	File file3 =new File(path+"/data.txt");
    	file2.renameTo(file3);
    }public DLinkedList showContact(int page) throws FileNotFoundException {
    	DLinkedList list =new DLinkedList();
    	DLinkedList list2 =new DLinkedList();
    	File file=new File("Users/"+App.emailbackup+"/Contacts/Index.txt");
    	Scanner in=new Scanner(file);
    	while(in.hasNextLine()) {
    		list.add(in.nextLine());
    	}in.close();
    	int i=(page-1)*10; int count=0;
    	if(i<list.size()) {
    		while(i<list.size() && count<=10) {
    			count++;
    			list2.add(list.get(i));
    			i++;
    		}return list2;
    	}else {return null;}
    }public boolean checkExist(String email) {
    	File file=new File("Users/"+email);
		Path path=file.toPath();
		if(Files.exists(path)) {
			return true;
		}else {
			return false;
		}
    }public boolean checkExist2(String name) {
    	File file=new File("Users/"+App.emailbackup+"/"+name);
		Path path=file.toPath();
		if(Files.exists(path)) {
			return true;
		}else {
			return false;
		}
    }
    public String getContactEmail(String name)throws Exception {
    	File file=new File("Users/"+App.emailbackup+"/Contacts/"+name+"/Data.txt");
    	Scanner in =new Scanner(file);
    	in.nextLine();
    	String s=in.nextLine();
    	in.close();
    	return s;
    }
}
