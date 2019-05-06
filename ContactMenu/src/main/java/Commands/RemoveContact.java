package Commands;

import java.util.ArrayList;
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
    public enum RemoveType{NAME,CPF};
    Scanner scanner = new Scanner(System.in);
    ContactList contactList;
    ArrayList<Contact> cList = new ArrayList<Contact>();
    private RemoveType removeType;
    public RemoveContact(){
        this.removeType = null;
    }
    public RemoveContact(RemoveType removeType){
        this.removeType = removeType;
        contactList = ContactList.getInstance();
    }
    @Override
    public void execute() {
        if(removeType==RemoveType.CPF){
            App.clearScreen();
            String cpf;
            App.println("Insert the Contact CPF:\n");
            cpf = scanner.nextLine();
            contactList.removeContactbyCPF(cpf);
        }
        else if(removeType==RemoveType.NAME){
            App.clearScreen();
            String name;
            App.println("Insert the Contact Name:\n");
            name = scanner.nextLine();
            contactList.removeContactbyName(name);
        }
        else{
            App.println("Command Not Found");
        }
    }
}