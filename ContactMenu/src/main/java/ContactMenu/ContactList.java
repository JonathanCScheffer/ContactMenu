package ContactMenu;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;


/**
 * Class that Creates a ContactList using Singleton Design Pattern
 * @author = Jonathan Scheffer
 */
public class ContactList{
    private static final ContactList instance = new ContactList();
    private ArrayList<Contact> contactList = new ArrayList<Contact>();

    private ContactList(){};

    /**
     * Get the ContactList array from ContactList Object
     * @return contactList
     */
    public ArrayList<Contact> getContactList() {
        return this.contactList;
    }

    public void addContact(Contact contact){
        contactList.add(contact);
    }
    /**
     * Add a contact to contactList. All parameters are needed. 
     * @param contact
     */
    public void addContact(String name,String cpf, String email, GregorianCalendar birthday,ArrayList<Address> address){
        contactList.add(new Contact(name, cpf, email,birthday,address));
    }
    /**
     * Add a contact to contactList (without address)
     * @param contact
     */
    public void addContact(String name,String cpf, String email,GregorianCalendar birthday){
        contactList.add(new Contact(name, cpf,email,birthday));
    }

    public void removeContact(Contact contact){
        contactList.remove(contact);
    }
    /**
     * Search contactName of all contacts in contactList.
     * @param contactName
     * @return
     */
    public ArrayList<Contact> searchContact(String contactName){
        ArrayList<Contact> matchedContacts = new ArrayList<Contact>();
        Pattern pattern = Pattern.compile("\\b"+contactName);
        for (Contact contact : contactList) {
            Matcher matcher = pattern.matcher(contact.getName());
            if(matcher.lookingAt()){
                matchedContacts.add(contact);
            }
        }
        return matchedContacts;
    }

    /**
     * Returns an instance of ContactList
     * @return instance
     */
    public static ContactList getInstance(){
        return instance;
    }

	public Iterator<Contact> iterator() {
		return contactList.iterator();
	}
}