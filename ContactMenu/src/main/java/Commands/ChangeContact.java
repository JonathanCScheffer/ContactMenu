package Commands;

import java.util.ArrayList;
import java.util.Scanner;

import ContactMenu.Address;
import ContactMenu.Contact;
import ContactMenu.App;
import ContactMenu.CommandInterface;
import ContactMenu.ContactList;

/**
 * Command used to change a contact from ContactList
 * @author = Jonathan Scheffer
 */

public class ChangeContact implements CommandInterface {
    Scanner scanner = new Scanner(System.in);
    ContactList contactList;

    public ChangeContact() {
    }

    @Override
    public void execute() {
        contactList = ContactList.getInstance();
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
                App.println(i +"-"+ foundedContact.getName());
            }
            int option;
            do {
                App.println("Select the contacts that you want to change:");
                App.println("Tap (-1) to exit");
                option = scanner.nextInt();
                scanner.nextLine();
            } while (option > matchedContacts.size()-1 || option < -1);
            if(option==-1){
                return;
            }
            for (Contact contact : contactList.getContactList()) {
                if (contact.equals(matchedContacts.get(option))) {
                    changeContactAttributes(contact);
                    ArrayList<Address> aList = getAddressList(contact);
                    switch (getAddListOption(contact)) {
                    case 1:
                        addContactAdress(contact);
                        App.println("The Contact has been sucessfully changed!");
                        break;
                    case 2:
                        App.println("Choose one of the Addresses to delete:");
                        option = scanner.nextInt();
                        scanner.nextLine();
                        contact.removeContactAdress(aList.get(option));
                        App.println("The Contact has been sucessfully changed!");
                        break;
                    case 3:
                        App.println("The Contact has been sucessfully changed!");
                        scanner.nextLine();
                        break;
                    default:
                        break;
                    }
                }
            }
        } else {
            App.println("No Contact has been found!");
            scanner.nextLine();
        }
    }
    /**
     * Class method used to interact with the user, changing all the selected address parameters.
     * @param contact
     */
    private void addContactAdress(Contact contact){
        App.clearScreen();
        String adrsResidence, adrsComp, adrsCity, adrsState, adrsCEP, adrsID;
        int adrsNumber;
        App.println(App.repeatString("=", 10));
        App.println("ADDRESS MENU");
        App.println(App.repeatString("=", 10));
        App.println("Insert Address fields:");
        App.println("Residence: ");
        adrsResidence = scanner.nextLine();
        App.println("Residence Number: ");
        adrsNumber = scanner.nextInt();
        scanner.nextLine();
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
            Address address = new Address(adrsResidence, adrsNumber, adrsComp, adrsCity, adrsState, adrsCEP, adrsID);
            contact.addContactAdress(address);
        } catch (Exception exception) {
            App.println(exception.toString());
            App.println("Error on Adding Contact to ContactList");
        }
    }
    /**
     * Class method used to interact with the user, changing all the selected contact parameters.
     * @param contact
     */
    private void changeContactAttributes(Contact contact){
        App.println("Contact selected:");
        App.println("Change the contacts parameters.");
        App.println("Current Name: " + contact.getName());
        contact.setName(scanner.nextLine());
        App.clearScreen();
        App.println("Current CPF: " + contact.getCpf());
        String cpfString = scanner.nextLine();
        contact.setCpf(cpfString);
        App.clearScreen();
        App.println("Currente Email: " + contact.getEmail());
        contact.setEmail(scanner.nextLine());
        App.println("Contact Data Sucessfully changed!");
    }
    /**
     * Class method used to interact with the user, asking if want to change the addresses params.
     * @param contact
     * @return
     */
    private int getAddListOption(Contact contact){
        int option = 0;
        App.println("Choose one option:");
        App.println("1 - Add Address");
        App.println("2 - Remove Address");
        App.println("0 - Finish Contact Changes");
        do {
            option = scanner.nextInt();
            scanner.nextLine();
        } while ((option > 2) || (option < 0));
        return option;
    }
    /**
     * Class method used to get all adresses of a contact from ContactList.
     * @param contact
     * @return
     */
    private ArrayList<Address> getAddressList(Contact contact){
        ArrayList<Address> aList = new ArrayList<Address>();
        aList = contact.getAddressList();
        App.println("Current Address List: ");
        int addressIndex = 0;
        for (Address a : aList) {
            App.println(addressIndex + " - " + a.toString());
            addressIndex++;
        }
        return aList;
    }
}