package Entities;

public class Address {
    private String streetName;
    private String streetNumber;
    private String province;
    private String city;
    
    // Default constructor
    public Address() {}
    
    // Parameterized constructor
    public Address(String streetNumber, String streetName, String city, String province) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
    }
    
    // Getters and Setters
    public String getStreetName() {
        return streetName;
    }
    
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    
    public String getStreetNumber() {
        return streetNumber;
    }
    
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
    
    public String getProvince() {
        return province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    // Utility method to get full address
    public String getFullAddress() {
        StringBuilder fullAddress = new StringBuilder();
        if(streetNumber != null && !streetNumber.isEmpty()) {
            fullAddress.append(streetNumber);
        }
        if(streetName != null && !streetName.isEmpty()) {
            if(fullAddress.length() > 0) fullAddress.append(" ");
            fullAddress.append(streetName);
        }
        if(city != null && !city.isEmpty()) {
            if(fullAddress.length() > 0) fullAddress.append(", ");
            fullAddress.append(city);
        }
        if(province != null && !province.isEmpty()) {
            if(fullAddress.length() > 0) fullAddress.append(", ");
            fullAddress.append(province);
        }
        return fullAddress.toString();
    }
    

    @Override
    public String toString() {
        return "Address{" +
                "streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", fullAddress='" + getFullAddress() + '\'' +
                '}';
    }
}