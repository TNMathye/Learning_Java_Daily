import java.util.ArrayList;
import java.util.List;

import Entities.Address;
import Entities.Person;

public class Main {
    /*
     * Access Modifiers => Controls the visibility and access levels
     *  1 - public : accessible from anywhere
     *  2 - private : accessible within the same class only
     *  3 - protected: accessible within the same package and subclasses
     * 
     * Variables
     *  1 - Instance Variables : Each object of the class has its own copy
     *  2 - Static Variables : The value is shared amongst the objects of the class, meaning only
     *                          one copy exists for the entire class
     * Methods
     *  1 - Instance Methods : must be called on a specific object. user1.getName().
     *                         Have access to both instance and static variables
     *                         Can call other instance methods and static methods
     *  2 - Static Methods : Must be called only using the class name, doesn't require no object of the class to be created. User.getTotalUsers()
     *                       Can only directly access static variables and other static methods
     *                       To access instance data from static methods, you need an object reference. Meaning to access a value of an instance var named fullNames,
     *                       in a static method, you will need to call user1.getFullNames()
     */
    public static void main(String[] args){
        // Method 1: Using default constructor
        Person person = new Person();
        Address address = new Address();
        List<Address> addresses = new ArrayList<>();
        
        // Set person details
        person.setFirstName("Gen");
        person.setSecondName("Nine");
        person.setLastName("Naph");
        person.setGender("Male"); // This will generate the ID
        
        // Set address details
        address.setStreetNumber("21");
        address.setStreetName("Kaynobs");
        address.setProvince("Gauteng");
        address.setCity("Centurion");
        addresses.add(address);
        person.setAddresses(addresses);

        System.out.println("=== Person created with default constructor ===");
        System.out.println(person.toString());
        System.out.println("Total people created: " + Person.getTotalPeople());
        System.out.println(person.toJson());
        System.out.println(person.toCompactJson());
        System.out.println();
        
        // Method 2: Using parameterized constructor
        Address address2 = new Address("123", "Main Street", "Johannesburg", "Gauteng");
        Person person2 = new Person("Sarah", "Jane", "Smith", "Female", address2);
        
        System.out.println("=== Person created with parameterized constructor ===");
        System.out.println(person2.toString());
        System.out.println();
        
        // Method 3: Create multiple people to test counter
        Person person3 = new Person("John", null, "Doe", "Male", null);
        Person person4 = new Person("Alice", "Marie", "Johnson", "Female", 
                                  new Address("456", "Oak Avenue", "Cape Town", "Western Cape"));
        
        System.out.println("=== Multiple people created ===");
        System.out.println("Person 3: " + person3.getFullName() + " (ID: " + person3.getId_num() + ")");
        System.out.println("Person 4: " + person4.getFullName() + " (ID: " + person4.getId_num() + ")");
        System.out.println("Total people created: " + Person.getTotalPeople());
        System.out.println();
        
        // Test address functionality
        System.out.println("=== Address Details ===");
        System.out.println("Full Address: " + address2.getFullAddress());
        System.out.println("Address Object: " + address2.toString());
    }
}