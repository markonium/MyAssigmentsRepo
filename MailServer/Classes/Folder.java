package eg.edu.alexu.csd.datastructure.mailServer;

public class Folder implements IFolder{
	String folderPath; boolean isTrash;
	public Folder(String path, boolean isTrash) {
		folderPath=path;
		this.isTrash=isTrash;
	}
	public String path() {
		return folderPath;
	}public boolean isTrash() {
		return isTrash;
	}
}
