package ContactMenu;

public class Address {
    private String residence;
    private int residenceNumber;
    private String complement;
    private String city;
    private String state;
    private String CEP;
    private String addressID;

    public Address(String residence, int residenceNumber, String complement, String city, String state, String CEP, String addressID) {
        this.residence = residence;
        this.residenceNumber = residenceNumber;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.CEP = CEP;
        this.addressID=addressID;
    }

    public String getResidence() {
        return this.residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public int getResidenceNumber() {
        return this.residenceNumber;
    }

    public void setResidenceNumber(int residenceNumber) {
        this.residenceNumber = residenceNumber;
    }

    public String getComplement() {
        return this.complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCEP() {
        return this.CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getAddressID() {
        return this.addressID;
    }

    public void setAddressID(String addressID) {
        this.addressID = addressID;
    }

    @Override
    public String toString() {
        return 
            " residence='" + getResidence() + "'" +
            ", residenceNumber='" + getResidenceNumber() + "'" +
            ", complement='" + getComplement() + "'" +
            ", city='" + getCity() + "'" +
            ", state='" + getState() + "'" +
            ", CEP='" + getCEP() + "'";
    }
}
