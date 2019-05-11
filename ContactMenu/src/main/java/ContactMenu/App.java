package ContactMenu;

import Commands.*;
import Commands.RemoveContact.RemoveType;

import java.util.Scanner;
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
		CommandInterface removeContactbyName = new RemoveContact(RemoveType.NAME);
		CommandInterface removeContactbyCPF = new RemoveContact(RemoveType.CPF);
		CommandInterface changeContact =  new ChangeContact();
		CommandInterface exitMenu = new ExitMenu();
		menuOptions.put("1", displayList);
		menuOptions.put("2", addContact);
		menuOptions.put("3", changeContact);
		menuOptions.put("3.1",removeContactbyName);
		menuOptions.put("3.2",removeContactbyCPF);
		menuOptions.put("5", exitMenu);
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
		App.println("3 - Remove Contact:");
		App.println("	3.1 - Remove Contact by Name");
		App.println("	3.2 - Remove Contact by CPF");
		App.println("4 - Order ContactList");
		App.println("5 - Exit ContactList menu");
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
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	/**
	 * Method used to Interface all the prints on the Console.
	 * @param str
	 */
	public static void println(Object str){
		System.out.println(str);
	}
}