package eg.edu.alexu.csd.datastructure.mailServer;

public class Mail implements IMail{
	String path; String senderEmail;
	public Mail(String path, String senderEmail) {
		this.path=path;
		this.senderEmail=senderEmail;
	}public String path() {
		return path;
	}public String senderEmail() {
		return senderEmail;
	}
}
