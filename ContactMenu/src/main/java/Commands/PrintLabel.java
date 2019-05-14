package Commands;

import java.util.ArrayList;
import java.util.Scanner;

import ContactMenu.Address;
import ContactMenu.App;
import ContactMenu.CommandInterface;
import ContactMenu.Contact;
import ContactMenu.ContactList;

/**
 * Command used Add a contact to ContactList
 * 
 * @author = Jean Rafael Martins
 */

public class PrintLabel implements CommandInterface {
    Scanner scanner = new Scanner(System.in);
    ContactList contactList;

    public PrintLabel() {
        contactList = ContactList.getInstance();
    }

    @Override
    public void execute() {
        String contactName;
        ArrayList<Contact> matchedContacts;
        ArrayList<Contact> cList = contactList.getContactList();
        if (cList.isEmpty()) {
            App.clearScreen();
            App.println("The ContactList is empty.");
            App.println("Press any key to continue...");
            scanner.nextLine();
        } else {
            App.clearScreen();
            App.println("Type the Name:");
            do { 
                contactName = scanner.nextLine();
                matchedContacts = contactList.searchContact(contactName);
                App.println("No Contact has been found!");
                } while (matchedContacts == null);
            if (matchedContacts.size() > 0) {
                App.clearScreen();
                App.println("The contacts below were found:");
                for (int i = 0; i < matchedContacts.size(); i++) {
                    Contact foundedContact = matchedContacts.get(i);
                    App.println(i + " - " + foundedContact.getName());
                }
                App.println("Choose one option:");
                int option;
                do {
                    option = scanner.nextInt();
                } while (option > matchedContacts.size() || option < 0);
                for (Contact contact : contactList.getContactList()) {
                    if (contact.equals(matchedContacts.get(option))) {
                        App.clearScreen();
                        App.println("Contact selected");          
                        ArrayList<Address> aList = new ArrayList<Address>();
                        aList = contact.getAddressList();
                        App.println("Current Address List: ");
                        int addressIndex = 0;
                        for (Address a : aList) {
                            App.println(addressIndex + " - " + a.toString());
                            addressIndex++;
                        }
                        App.println("Choose one option:");
                        do {
                            option = scanner.nextInt();
                        } while ((option > addressIndex) || (option < 0));
                        String adrsResidence, adrsCity, adrsState, adrsCEP;
                        int adrsNumber;
                        App.clearScreen();
                        adrsResidence = aList.get(option).getResidence();
                        adrsNumber = aList.get(option).getResidenceNumber();
                        adrsCity = aList.get(option).getCity();
                        adrsState = aList.get(option).getState();
                        adrsCEP = aList.get(option).getCEP();

                        App.println(contact.getName());
                        App.println(adrsResidence + ", " + Integer.toString(adrsNumber));
                        App.println(adrsCity + " - " + adrsState);
                        App.println("CEP " + adrsCEP);

                    }
                }
            } else {
                App.println("No Contact has been found!");
            }
        }
    }
} 