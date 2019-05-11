package Commands;

import java.util.ArrayList;
import java.util.Scanner;

import ContactMenu.Address;
import ContactMenu.Contact;
import ContactMenu.App;
import ContactMenu.CommandInterface;
import ContactMenu.ContactList;
import Tools.CPFHandler;

/**
 * Command used Add a contact to ContactList
 * 
 * @author = Jonathan Scheffer
 */

public class ChangeContact implements CommandInterface {
    Scanner scanner = new Scanner(System.in);
    ContactList contactList;

    public ChangeContact() {
        contactList = ContactList.getInstance();
    }

    @Override
    public void execute() {
        String contactName;
        ArrayList<Contact> matchedContacts;
        App.clearScreen();
        App.println("Insert the name of the contact that you want to change:");
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
            } while (option>matchedContacts.size()||option<0);
            for (Contact contact : contactList.getContactList()) {
                if (contact.equals(matchedContacts.get(option))) {
                    App.clearScreen();
                    App.println("Contact selected:");
                    App.println("Change the contacts parameters.");
                    App.println("Current Name: " + contact.getName());
                    contact.setName(scanner.nextLine());
                    App.println("Current CPF: " + contact.getCpf());
                    contact.setCpf(scanner.nextLine());
                    App.clearScreen();
                    App.println("Currente Email: " + contact.getEmail());
                    contact.setEmail(scanner.nextLine());
                    App.clearScreen();
                    ArrayList<Address> aList = new ArrayList<Address>();
                    aList = contact.getAddressList();
                    App.println("Current Address List: ");
                    int addressIndex = 0;
                    for (Address a : aList) {
                        App.println(addressIndex+" - "+ a.toString());
                        addressIndex++;
                    }
                    App.println("Choose one option:");
                    App.println("1 - Add Address");
                    App.println("2 - Remove Address");
                    App.println("0 - Finish Contact Changes");
                    do {
                        option = scanner.nextInt();
                    } while ((option>2)||(option<0));
                    switch (option) {
                    case 1:
                        App.clearScreen();
                        String adrsResidence, adrsNumber, adrsComp, adrsCity, adrsState, adrsCEP, adrsID;
                        int[] adrsNumberInt = new int[10];
                        App.println(App.repeatString("=", 10));
                        App.println("ADDRESS MENU");
                        App.println(App.repeatString("=", 10));
                        App.println("Insert Address fields:");
                        App.println("Residence: ");
                        adrsResidence = scanner.nextLine();
                        App.println("Residence Number: ");
                        adrsNumber = scanner.nextLine();
                        for (int i = 0, j = 0; i < adrsNumber.length(); i++) {
                            char c = adrsNumber.charAt(i);
                            if (!CPFHandler.tryParseInt(c)) {
                                App.println("The Address number is not valid!");
                                App.println("Error on adding a Contact to ContactList");
                                scanner.nextLine();
                                return;
                            } else {
                                int num = Character.getNumericValue(c);
                                adrsNumberInt[j] = num;
                            }
                        }
                        App.println("Complement:");
                        adrsComp = scanner.nextLine();
                        App.println("City:");
                        adrsCity = scanner.nextLine();
                        App.println("State:");
                        adrsState = scanner.nextLine();
                        App.println("CEP:");
                        adrsCEP = scanner.nextLine();
                        App.println("Identifycation:");
                        adrsID = scanner.nextLine();
                        try {
                            Address address = new Address(adrsResidence, adrsNumberInt, adrsComp, adrsCity, adrsState,
                                    adrsCEP, adrsID);
                            contact.addContactAdress(address);
                        } catch (Exception exception) {
                            App.println(exception.toString());
                            App.println("Error on Adding Contact to ContactList");
                        }
                    case 2:
                        App.println("Choose one of the Addresses to delete:");
                        do {
                            option = scanner.nextInt();
                        } while (option < 0 || option > addressIndex);
                        contact.removeContactAdress(aList.get(addressIndex));
                    case 3:
                        App.println("The Contact has been sucessfully changed!");
                        scanner.nextLine();
                    }
                }
            }
        } else {
            App.println("No Contact has been found!");
        }
    }
}