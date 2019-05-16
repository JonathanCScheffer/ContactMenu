package Commands;

import java.util.ArrayList;
import java.util.Collections;
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
    }    
    @Override
    public void execute() {
        contactList = ContactList.getInstance();
        ArrayList<Contact> cList = contactList.getContactList();
        if(cList.isEmpty()){
            App.clearScreen();
            App.println("The ContactList is empty.");
            App.println("Press any key to continue...");
            scanner.nextLine();
        }
        else{
            App.clearScreen();
            Collections.sort(cList);
            int option=-1;
            option = getOptions(option);
            if (option==0){
                return;
            }
            sortList(cList, option);
            App.clearScreen();
            App.println("Contacts:");
            App.println("Name - CPF - Email - Address");
            for (Contact c : cList) {
                App.println(c);
            }
            scanner.nextLine();
        }
    }
    /**
     * Method used to receive the sort order from the user.
     * @param option
     * @return
     */
    private int getOptions(int option){
        do{
            App.println("Insert the order :");
            App.println("1 - Alphabetical order");
            App.println("2 - Reversal Alphabetical order");
            App.println("0 - Return to ContactMenu");
            option = scanner.nextInt();
            scanner.nextLine();
        }while(option>2 || option <0);
        return option;
    }
    /**
     * Method used to sort cList{ArrayList<Contact>} based on the user option{int}.
     * @param cList
     * @param option
     */
    private void sortList(ArrayList<Contact> cList,int option){
        switch(option){
            case 1:
                Collections.sort(cList);
                break;
            case 2:
                Collections.sort(cList,Collections.reverseOrder());
                break;
            default:
                return;
        }
    }
}