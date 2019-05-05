package Commands;

import java.util.ArrayList;
import java.util.Scanner;

import ContactMenu.App;
import ContactMenu.CommandInterface;
import ContactMenu.Contact;
import ContactMenu.ContactList;

/**
 * DisplayList menu command. This command Implements the toString() methods for all contacts in ContactList.
 * @author = Jonathan Scheffer
 */

public class DisplayList implements CommandInterface{
    Scanner scanner = new Scanner(System.in);
    ContactList contactList;
    public DisplayList(){
        contactList = ContactList.getInstance();
    }    
    @Override
    public void execute() {
        ArrayList<Contact> cList = contactList.getContactList();
        if(cList.isEmpty()){
            App.clearScreen();
            App.println("The ContactList is empty.");
            App.println("Press any key to continue...");
            scanner.nextLine();
        }
        else{
            App.clearScreen();
            App.println("Contacts:");
            App.println("Name - CPF - Email - Address");
            for (Contact c : cList) {
                System.out.println(c);
            }
            scanner.nextLine();
        }
    }
}