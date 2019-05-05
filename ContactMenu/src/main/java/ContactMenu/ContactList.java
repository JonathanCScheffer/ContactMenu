package ContactMenu;

import java.util.ArrayList;
import java.util.Iterator;

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
    public void addContact(String name,String cpf, String email,String address){
        Contact contact = new Contact(name, cpf, email, address);
        contactList.add(contact);
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

    /**
     * Returns an instance of ContactList
     * @return instance
     */
    public static ContactList getInstance(){
        return instance;
    }
}