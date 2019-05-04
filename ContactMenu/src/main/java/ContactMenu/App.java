package ContactMenu;

import Commands.DisplayList;

public class App {
	public static void main(String[] args) {
		Control control = new Control();
		Contact contact = new Contact("jorjao", "111.111.111-11", "peipei.com", "viladosnoia");
		ContactList contactList = ContactList.getInstance();
		contactList.addContact(contact);
		CommandInterface displayList = new DisplayList();
		control.setCommand(displayList);
		control.makeCommand();
	}
}