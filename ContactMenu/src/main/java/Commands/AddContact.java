package Commands;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import ContactMenu.Address;
import ContactMenu.App;
import ContactMenu.CommandInterface;
import ContactMenu.ContactList;
import Tools.CPFHandler;
import Tools.CalendarHandler;

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
        String name,cpf,email,birthdayString;
        GregorianCalendar birthday;
        App.println("Insert the Contact data:\n");
        App.println("Name:");
        name = scanner.nextLine();
        App.println("CPF:");
        cpf = scanner.nextLine();
        if(!CPFHandler.isValid(cpf)){
            App.println("The CPF is not valid!");
            App.println("Error on adding a Contact to ContactList");
            scanner.nextLine();
            return;
        }
        App.println("Email:");
        email = scanner.nextLine();
        App.println("Birthday:");
        birthdayString = scanner.nextLine();
        birthday = CalendarHandler.parseDate(birthdayString);
        if(birthday==null){
            App.println("The birthday is not valid!");
            App.println("Error on adding a Contact to ContactList");
            scanner.nextLine();
            return;
        }
        String optString;
        boolean valid=true;
        do{
            App.println("Do you wish to insert an address?Y|N");
            optString = scanner.nextLine();
            optString = optString.toUpperCase();
            if(optString.contentEquals("Y")){
                valid=false;
            }
            if(optString.contentEquals("N")){
                valid=false;
            }
        }
        while(valid);
        if(optString.contentEquals("Y")){
            String adrsResidence, adrsNumber, adrsComp, adrsCity, adrsState, adrsCEP, adrsID;
            int[] adrsNumberInt =  new int[10]; 
            App.println(App.repeatString("=", 10));
            App.println("ADDRESS MENU");
            App.println(App.repeatString("=", 10));
            App.println("Insert Address fields:");
            App.println("Residence:");
            adrsResidence = scanner.nextLine();
            App.println("Residence Number:");
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
                Address address = new Address(adrsResidence, adrsNumberInt, adrsComp, adrsCity, adrsState, adrsCEP, adrsID);
                ArrayList<Address> addressesList= new ArrayList<Address>();
                addressesList.add(address);
                contactList.addContact(name, cpf, email,birthday,addressesList);
                App.println("The Contact" + name + "was sucessfully added to ContactList");
            } catch (Exception exception) {
                App.println(exception.toString());
                App.println("Error on Adding Contact to ContactList");
            }
        } else {
            try {
                contactList.addContact(name, cpf, email,birthday);
                App.clearScreen();
                App.repeatString("=",10);
                App.println("The Contact" + name + "was sucessfully added to ContactList");
                App.repeatString("=",10);
                scanner.nextLine();
            } catch (Exception exception) {
                App.println(exception.toString());
                App.println("Error on Adding Contact to ContactList");
                scanner.nextLine();
            }
        }
    }
}