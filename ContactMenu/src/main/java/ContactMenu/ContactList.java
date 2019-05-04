package ContactMenu;
import java.util.ArrayList;

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

    /**
     * Add a contact to contactList
     * @param contact
     */
    public void addContact(Contact contact){
        contactList.add(contact);
    }

    /**
     * Removes a contact from contactList
     * @param contact
     */
    public void removeContact(Contact contact){
        contactList.remove(contact);
    }

    /**
     * Returns an instance of ContactList
     * @return instance
     */
    public static ContactList getInstance(){
        return instance;
    }
}