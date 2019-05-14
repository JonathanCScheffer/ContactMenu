package Commands;

import ContactMenu.CommandInterface;
import ContactMenu.ContactList;
import ContactMenu.Contact;
import java.util.ArrayList;

import ContactMenu.Address;
import ContactMenu.App;

public class PrintTags implements CommandInterface{
    @Override
    public void execute() {
       ContactList contactList =  ContactList.getInstance();
       ArrayList<Contact> cList = contactList.getContactList();
        for (Contact c : cList) {
            ArrayList<Address> aList = c.getAddressList();
            App.println(c.getName());
        }
    }
}