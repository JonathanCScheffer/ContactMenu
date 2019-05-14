package ContactMenu;

import Commands.*;
import Tools.CalendarHandler;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class used to Create and Manage the Console User Interface.
 * @author = Jonathan Scheffer
 */
public class App {
	/**
	 * Entry point of application
	 */
	public static void main(String[] args) {
		Map<String,CommandInterface> menuOptions = new HashMap<String,CommandInterface>();
		Control control = new Control();
		CommandInterface displayList = new DisplayList();
		CommandInterface addContact = new AddContact();
		CommandInterface removeContact = new RemoveContact();
		CommandInterface changeContact =  new ChangeContact();
		CommandInterface displayBirthdayList = new DisplayBirthdayList();
		CommandInterface printLabel = new PrintLabel();
		CommandInterface exitMenu = new ExitMenu();
		menuOptions.put("1", displayList);
		menuOptions.put("2", addContact);
		menuOptions.put("3", changeContact);
		menuOptions.put("4", removeContact);
		menuOptions.put("5", displayBirthdayList);
		menuOptions.put("6", printLabel);
		menuOptions.put("0", exitMenu);

		ContactList contactList = ContactList.getInstance();
		ArrayList<Address> addressesList1 = new ArrayList<Address>();
		Address address1 = new Address("Rua Xaxim", 10, "Alto", "Pinho", "PR", "80000-100", "Casa");
		addressesList1.add(address1);
		contactList.addContact("Andre", "565.846.354-81", "andre@com", CalendarHandler.parseDate("01/12/99"),
				addressesList1);

		ArrayList<Address> addressesList3 = new ArrayList<Address>();
		Address address3 = new Address("Rua Alto", 10, "Hauer", "Vila", "MS", "60607-123", "Predio");
		addressesList3.add(address3);
		contactList.addContact("Noe", "977.897.276-13", "noe@gg", CalendarHandler.parseDate("25/08/01"),
				addressesList3);

		ArrayList<Address> addressesList2 = new ArrayList<Address>();
		Address address2 = new Address("Rua Alto", 10, "Centro", "Cyti", "RN", "52124-076", "Chacara");
		addressesList2.add(address2);
		contactList.addContact("Jose", "837.306.676-67", "jose@com", CalendarHandler.parseDate("12/03/74"),
				addressesList2);

		ArrayList<Address> addressesList4 = new ArrayList<Address>();
		Address address4 = new Address("Rua Alto", 10, "Centro", "Cyti", "RN", "52124-076", "Chacara");
		addressesList4.add(address2);
		contactList.addContact("Rodriguks", "052.679.851-39", "rodrigo@com", CalendarHandler.parseDate("07/01/96"),
				addressesList4);

		ArrayList<Address> addressesList5 = new ArrayList<Address>();
		Address address5 = new Address("Rua Alto", 10, "Centro", "Cyti", "RN", "52124-076", "Chacara");
		Address address6 = new Address("Rua Luz", 10, "Wesley", "Cajuru", "CB", "12354-076", "Rancho");
		addressesList5.add(address5);
		addressesList5.add(address6);
		contactList.addContact("Jeaoun", "085.436.309-24", "jean@com", CalendarHandler.parseDate("26/01/74"),
				addressesList5);

		Scanner scanner = new Scanner(System.in);
		String userInput;
		while(true){
			do{
				clearScreen();
				displayMenu();
				userInput = scanner.nextLine();
			}
			while(!menuOptions.containsKey(userInput));
			control.setCommand(menuOptions.get(userInput));
			control.makeCommand();
		}
	}
	/**
	 * Method to Create a Console User Interface
	 */
	public static void displayMenu(){
		App.println(repeatString("=",50));
		App.println("Welcome to ContactList Menu!");
		App.println(repeatString("=",50));
		App.println("Select one of the options below:");
		App.println("1 - Display ContactList");
		App.println("2 - Add Contact");
		App.println("3 - Change Contact");
		App.println("4 - Remove Contact");
		App.println("5 - Display Birthday List");
		App.println("6 - PrintTags");
		App.println("0 - Exit ContactList menu");
	}
	/**
	 * Method used to repeat a String string int times times
	 * @param string
	 * @param times
	 * @return
	 */
	public static String repeatString(String string,int times){
		return new String(new char[times]).replace("\0", string);
	}

	/**
	 * Method used to clear Console Screen. Similar to cls(Windows Promt) and clear(Bash).
	 */
	public static void clearScreen(){
		for(int i = 0; i <= 50; i++){
			System.out.println();		
		}
		//System.out.print("\033[H\033[2J");
		//System.out.flush();
	}

	/**
	 * Method used to Interface all the prints on the Console.
	 * @param str
	 */
	public static void println(Object str){
		System.out.println(str);
	}
}