package Commands;

import ContactMenu.App;
import ContactMenu.CommandInterface;
import ContactMenu.ContactList;

/**
 * Command used to close the Application.
 * @author = Jonathan Scheffer
 */

public class ExitMenu implements CommandInterface{

    ContactList contactList;
    public ExitMenu(){
    }    
    @Override
    public void execute() {
        App.clearScreen();
        App.println("The application is being closed!");
        System.exit(1);
    }
}