package eg.edu.alexu.csd.datastructure.mailServer;

public class Sort implements ISort{
	int topicNum;
	boolean isContact;
	public Sort(int topicNum, boolean isContact) {
		this.topicNum=topicNum;
		this.isContact=isContact;
	}public int topicNum() {
		return topicNum;
	}public boolean isContact() {
		return isContact;
	}
}
