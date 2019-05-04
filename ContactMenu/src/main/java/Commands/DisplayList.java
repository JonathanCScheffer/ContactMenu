package Commands;

import java.util.ArrayList;

import ContactMenu.CommandInterface;
import ContactMenu.Contact;
import ContactMenu.ContactList;

/**
 * DisplayList menu command. This command Implements the toString() methods for all contacts in ContactList.
 * @author = Jonathan Scheffer
 */

public class DisplayList implements CommandInterface{

    ContactList contactList;
    public DisplayList(){
        contactList = ContactList.getInstance();
    }    
    @Override
    public void execute() {
        ArrayList<Contact> cList = contactList.getContactList();
        for (Contact c : cList) {
            System.out.println(c);
        }
    }
}