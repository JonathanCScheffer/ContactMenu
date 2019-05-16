package ContactMenu;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Tools.CPFHandler;

/**
 * Class that create a Contact Person
 * @author Jonathan Scheffer
 */
public class Contact implements Comparable<Contact>{
    private String name;
    private String cpf;
    private String email;
    private GregorianCalendar birthday;
    private ArrayList<Address> addressList = new ArrayList<Address>();

    /**
     * Contructor for Contact Class. All args are needed.
     */
    public Contact(String name,String cpf,String email,GregorianCalendar birthday,ArrayList<Address> addressList){
        super();
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.birthday = birthday;
        this.addressList = addressList;
    }
    /**
     * Contructor for Contact Class without address{Address}
     */
    public Contact(String name,String cpf,String email,GregorianCalendar birthday){
        super();
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.birthday = birthday;
    }

    /**
     * Getters and Setters for Contact atribbutes
     */
    public String getName() {
        return this.name;
    }
    public String getCpf() {
        return this.cpf;
    }
    public String getEmail() {
        return this.email;
    }

    public GregorianCalendar getBirthday() {
        return this.birthday;
    }

    public void setBirthday(GregorianCalendar birthday) {
        this.birthday = birthday;
    }

	public void setName(String name) {
        this.name = name;
    }
    public void setCpf(String cpf) {
        if(CPFHandler.isValid(cpf)){
            this.cpf = cpf;
        }
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public ArrayList<Address> getAddressList() {
        return this.addressList;
    }
    /**
     * Add an address to Contact addressList 
     * @param address
     */
    public void addContactAdress(Address address){
        addressList.add(address);
    }
    /**
     * Removes an address from Contact addressList
     * @param address
     */
    public void removeContactAdress(Address address){
        addressList.remove(address);
    }

    /**
     * Search for all addresses in addressesList. Uses Regex.
     * @param addressName
     * @return matchedAddresses
     */
    public ArrayList<Address> searchAddresses(String addressName){
        ArrayList<Address> matchedAddreses = new ArrayList<Address>();
        Pattern pattern = Pattern.compile("\\b"+addressName);
        for (Address address : addressList) {
            Matcher matcher = pattern.matcher(address.getResidence());
            if(matcher.lookingAt()){
                matchedAddreses.add(address);
            }
        }
        return matchedAddreses;
    }

    @Override
    public String toString() {
        if(addressList.isEmpty()){
            return this.name +"-"+ this.cpf +"-"+ this.email+"-"+"empty";
        }
        else{
            return this.name +"-"+ this.cpf +"-"+ this.email+"-"+this.addressList.get(0);
        }
    }

    @Override
    public int compareTo(Contact contact){
        return this.name.compareToIgnoreCase(contact.name);
    }
}
