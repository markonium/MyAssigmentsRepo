package eg.edu.alexu.csd.datastructure.mailServer;

public class Filter implements IFilter{
	int ind;
	String filter;
	public Filter(String filter, int ind) {
		this.ind=ind;
		this.filter=filter;
	}public int ind() {
		return ind;
	}public String filter() {
		return filter;
	}
}
