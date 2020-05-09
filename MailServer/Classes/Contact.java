package eg.edu.alexu.csd.datastructure.mailServer;

public class Contact implements IContact{
	public String email,password,name;DLinkedList emailList;
	public Contact(String email, String password, String name, DLinkedList emailList) {
		this.email=email;
		this.password=password;
		this.name=name;
		this.emailList=emailList;
	}public String email() {
		return email;
	}public String password() {
		return password;
	}public String name() {
		return name;
	}public DLinkedList emailList() {
		return emailList;
	}
}
