package eg.edu.alexu.csd.datastructure.mailServer;

import java.io.File;
import java.io.FileNotFoundException;

public interface IMiscellaneous {
	/**
	 * A method to sort the index file based on what the user want to sort
	 * @param path The index file path 
	 * @param topicNum The index of what the user want to arrange in the index file
	 * @param isContact Indicate whether you are arranging a contact index file
	 */
	public void QuickSort(String path,int topicNum,boolean isContact,boolean isTime);
	/**
     * This method checks whether the given email is valid or not
     * @param email The email to be checked
     */
	public boolean checker(String email);
	/**
     * This method perform binary search
     * @param file The text file to search
     * @param want The string to search for in the text file
     * @param index The index of object to be searched
     * @param isContact Indicates whether the search is to be applied on contacts 
     */
	public boolean BinarySearch(File file, String want, int index, boolean isContact) throws FileNotFoundException;
	/**
	 * This method applies the filter
	 * @param path The index file path
	 * @param filter The filter to be applied
	 * @param ind Indicates whether the filter is about the email topic or not 
	 * @param isContact Indicates whether the filter is to be applied on contacts 
	 */
	public void filter(String path,String filter,int ind,boolean isContact) throws FileNotFoundException;
	/**
     * This method sort the e-mails according to priority
     * @param path The path of the index file
     */
    public void PrioritySort(String path);
    /**
     * This method is used to create new contact
     * @param path The path of the contact folder
     * @param contact The contact to be add
     */
    public boolean createContact(String path, IContact contact);
    /**
     * This method checks if the e-mail exists
     * @param email The e-mail to be checked
     */
    public boolean checkExist(String email);
}
