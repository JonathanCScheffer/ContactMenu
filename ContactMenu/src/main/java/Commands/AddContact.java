package Commands;

import java.util.Scanner;

import ContactMenu.App;
import ContactMenu.CommandInterface;
import ContactMenu.ContactList;

/**
 * Command used Add a contact to ContactList
 * @author = Jonathan Scheffer
 */

public class AddContact implements CommandInterface{
    Scanner scanner = new Scanner(System.in);
    ContactList contactList;
    public AddContact(){
        contactList = ContactList.getInstance();
    }    
    @Override
    public void execute() {
        App.clearScreen();
        String name,cpf,address,email;
        App.println("Insert the Contact data:\n");
        App.println("Name:");
        name = scanner.nextLine();
        App.println("CPF:");
        cpf = scanner.nextLine();
        App.println("Address:");
        address = scanner.nextLine();
        App.println("Email:");
        email = scanner.nextLine();
        contactList.addContact(name, cpf, email, address);
    }
}