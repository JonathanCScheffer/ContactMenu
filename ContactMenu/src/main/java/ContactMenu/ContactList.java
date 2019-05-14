package ContactMenu;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.regex.Pattern;


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

    /**
     * Removes a contact from contactList by cpf
     * @param contact
     */
    public void removeContactbyCPF(String cpf){
        for (Iterator<Contact> iterator = contactList.iterator(); iterator.hasNext(); ) {
            Contact c = iterator.next();
            if (cpf.equals(c.getCpf())) {
                iterator.remove();
            }
        }        
    }

    /**
     * Remove a contact from contactList by name
     * @param name
     */
    public void removeContactbyName(String name){
        for (Iterator<Contact> iterator = contactList.iterator(); iterator.hasNext(); ) {
            Contact c = iterator.next();
            if (name.equals(c.getName())) {
                iterator.remove();
            }
        }        
    }
    public void removeContact(Contact contact){
        contactList.remove(contact);
    }
    public ArrayList<Contact> searchContact(String contactName){
        ArrayList<Contact> matchedContacts = new ArrayList<Contact>();
        for (Contact contact : contactList) {
            if(Pattern.matches("\\b"+contactName, contact.getName())){
                matchedContacts.add(contact);
            }
        }
        if(matchedContacts.size()>0){
            return matchedContacts;
        }
        else{
            return null;
        }
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