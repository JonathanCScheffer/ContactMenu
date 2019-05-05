package ContactMenu;
import java.util.ArrayList;

/**
 * Class that create a Contact Person
 * @author Jonathan Scheffer
 */
public class Contact{
    private String name;
    private String cpf;
    private String email;
    private ArrayList<String> addressList = new ArrayList<String>();

    /**
     * Contructor for Contact Class. All args are needed.
     */
    public Contact(String name,String cpf,String email,String address){
        super();
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.addressList.add(address);
    }

    /**
     * Getters for Contact atribbutes
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

    public ArrayList<String> getAddressList() {
        return this.addressList;
    }

    /**
     * Add an address to Contact addressList 
     * @param address
     */
    public void addContactAdress(String address){
        addressList.add(address);
    }

    /**
     * Removes an address from Contact addressList
     * @param address
     */
    public void removeContactAdress(String address){
        addressList.remove(address);
    }

    @Override
    public String toString() {
        return this.name +"-"+ this.cpf +"-"+ this.email+"-"+this.addressList.get(0);
    }
}
