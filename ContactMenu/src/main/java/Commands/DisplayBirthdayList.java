package Commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

import ContactMenu.App;
import ContactMenu.CommandInterface;
import ContactMenu.Contact;
import ContactMenu.ContactList;

public class DisplayBirthdayList implements CommandInterface{

    @Override
    public void execute() {
        ContactList contactList = ContactList.getInstance();
        ArrayList<Contact> cList = new ArrayList<Contact>();
        cList = contactList.getContactList();
        Collections.sort(cList, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                int diaC1 = c1.getBirthday().get(GregorianCalendar.DAY_OF_YEAR);
                int diaC2 = c2.getBirthday().get(GregorianCalendar.DAY_OF_YEAR);
                return Integer.compare(diaC1, diaC2);
            }
        });
        for (Contact c : cList) {
            App.println(c);
        }
    }
}