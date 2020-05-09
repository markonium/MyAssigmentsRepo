package eg.edu.alexu.csd.datastructure.mailServer;

public interface IContact {
	public String email();
	public String password();	
	public String name();
	public DLinkedList emailList();
}
