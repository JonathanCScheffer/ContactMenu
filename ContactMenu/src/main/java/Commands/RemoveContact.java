package Commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ContactMenu.App;
import ContactMenu.CommandInterface;
import ContactMenu.Contact;
import ContactMenu.ContactList;

/**
 * Command used to remove Contacts from ContactList. Can be performed by RemoveType CPF or NAME.
 * @author = Jonathan Scheffer
 */
public class RemoveContact implements CommandInterface {
    Scanner scanner = new Scanner(System.in);
    ContactList contactList;
    public RemoveContact(){
    }
    @Override
    public void execute() {
        contactList = ContactList.getInstance();
        String contactName;
        ArrayList<Contact> matchedContacts;
        App.clearScreen();
        App.println("Insert the name of the contact that you want to remove:");
        contactName = scanner.nextLine();
        matchedContacts = contactList.searchContact(contactName);
        if (matchedContacts.size() > 0) {
            App.println("The contacts below were found:");
            for (int i = 0; i < matchedContacts.size(); i++) {
                Contact foundedContact = matchedContacts.get(i);
                App.println(i + foundedContact.getName());
            }
            App.println("Select the contacts that you want to change:");
            int option;
            do {
                option = scanner.nextInt();
                scanner.nextLine();
            } while (option > matchedContacts.size() || option < 0);
            Iterator<Contact> itr = contactList.iterator();
            while(itr.hasNext()){
                Contact contact = itr.next();
                if (contact.equals(matchedContacts.get(option))) {
                    itr.remove();
                    App.println("Contact was sucessfully removed!");
                    scanner.nextLine();
                }
            }
        }
    }
}