package ContactMenu;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Class that create a Contact Person
 * @author Jonathan Scheffer
 */
public class Contact{
    private String name;
    private String cpf;
    private String email;
    private ArrayList<Address> addressList = new ArrayList<Address>();

    /**
     * Contructor for Contact Class. All args are needed.
     */
    public Contact(String name,String cpf,String email,ArrayList<Address> addressList){
        super();
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.addressList = addressList;
    }
    /**
     * Contructor for Contact Class without address{Address}
     */
    public Contact(String name,String cpf,String email){
        super();
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.addressList = null;
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
	public void setName(String name) {
        this.name = name;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
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
     * Search for all addresses in addressesList.Uses Regex
     * @param addressName
     * @return matchedAddresses
     */
    public ArrayList<Address> searchAddresses(String addressName){
        ArrayList<Address> matchedAddreses = new ArrayList<Address>();
        for (Address address : addressList) {
            if(Pattern.matches(addressName, address.getResidence())){
                matchedAddreses.add(address);
            }
        }
        if(matchedAddreses.size()>0){
            return matchedAddreses;
        }
        else{
            return null;
        }
    }

    @Override
    public String toString() {
        if(addressList.size()>0){
            return this.name +"-"+ this.cpf +"-"+ this.email+"-"+this.addressList.get(0);
        }
        else{
            return this.name +"-"+ this.cpf +"-"+ this.email+"-"+"empty";
        }
    }
}
