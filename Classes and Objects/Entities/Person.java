package Entities;

import java.util.ArrayList;
import java.util.List;

import Utilities.Utilities;

public class Person {
    private String id_num, firstName, secondName, lastName, gender;
    private int age = 0;
    private List<Address> addresses;
    private static int personCounter = 0;
    private Utilities utils;

    // Person constructor with parameters
    public Person(String firstName, String secondName, String lastName, String gender, Address address) {
        this.utils = new Utilities();
        this.firstName = firstName;
        if (secondName != null) {
            this.secondName = secondName; // Considering that not all persons can have middle names
        }
        this.lastName = lastName;
        this.gender = gender;
        this.id_num = utils.generatePersonID(gender);
        this.addresses = new ArrayList<>();
        if (address != null) {
            this.addresses.add(address);
        }
        this.age = utils.updateAge(this.id_num);
        personCounter++;
    }

    // Default constructor
    public Person() {
        this.utils = new Utilities();
        this.addresses = new ArrayList<>();
        personCounter++;
    }

    // Setters and Getters
    public String getId_num() {
        return id_num;
    }

    public void setId_num(String id_num) {
        if (this.utils == null) {
            this.utils = new Utilities();
        }
        this.id_num = utils.generatePersonID(id_num);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        if (this.utils == null) {
            this.utils = new Utilities();
        }
        this.id_num = utils.generatePersonID(gender);
        this.age = utils.updateAge(this.id_num);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public static int getTotalPeople() {
        return personCounter;
    }

    // Get full name utility method
    public String getFullName() {
        StringBuilder fullName = new StringBuilder();
        if (firstName != null)
            fullName.append(firstName);
        if (secondName != null && !secondName.isEmpty()) {
            if (fullName.length() > 0)
                fullName.append(" ");
            fullName.append(secondName);
        }
        if (lastName != null) {
            if (fullName.length() > 0)
                fullName.append(" ");
            fullName.append(lastName);
        }
        return fullName.toString();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id_num='" + id_num + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", addresses=" + addresses +
                ", totalPeople=" + personCounter +
                '}';
    }

    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("  \"id_num\": \"").append(id_num != null ? id_num : "").append("\",\n");
        json.append("  \"firstName\": \"").append(firstName != null ? firstName : "").append("\",\n");
        json.append("  \"secondName\": \"").append(secondName != null ? secondName : "").append("\",\n");
        json.append("  \"lastName\": \"").append(lastName != null ? lastName : "").append("\",\n");
        json.append("  \"fullName\": \"").append(getFullName()).append("\",\n");
        json.append("  \"gender\": \"").append(gender != null ? gender : "").append("\",\n");
        json.append("  \"age\": ").append(age).append(",\n");
        json.append("  \"addresses\": [\n");

        if (addresses != null && !addresses.isEmpty()) {
            for (int i = 0; i < addresses.size(); i++) {
                Address addr = addresses.get(i);
                json.append("    {\n");
                json.append("      \"streetNumber\": \"")
                        .append(addr.getStreetNumber() != null ? addr.getStreetNumber() : "").append("\",\n");
                json.append("      \"streetName\": \"").append(addr.getStreetName() != null ? addr.getStreetName() : "")
                        .append("\",\n");
                json.append("      \"city\": \"").append(addr.getCity() != null ? addr.getCity() : "").append("\",\n");
                json.append("      \"province\": \"").append(addr.getProvince() != null ? addr.getProvince() : "")
                        .append("\",\n");
                json.append("      \"fullAddress\": \"").append(addr.getFullAddress()).append("\"\n");
                json.append("    }");

                if (i < addresses.size() - 1) {
                    json.append(",");
                }
                json.append("\n");
            }
        }

        json.append("  ],\n");
        json.append("  \"totalPeople\": ").append(getTotalPeople()).append("\n");
        json.append("}");

        return json.toString();
    }

    public String toCompactJson() {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"id_num\":\"").append(id_num != null ? id_num : "").append("\",");
        json.append("\"firstName\":\"").append(firstName != null ? firstName : "").append("\",");
        json.append("\"secondName\":\"").append(secondName != null ? secondName : "").append("\",");
        json.append("\"lastName\":\"").append(lastName != null ? lastName : "").append("\",");
        json.append("\"fullName\":\"").append(getFullName()).append("\",");
        json.append("\"gender\":\"").append(gender != null ? gender : "").append("\",");
        json.append("\"age\":").append(age).append(",");
        json.append("\"addresses\":[");

        if (addresses != null && !addresses.isEmpty()) {
            for (int i = 0; i < addresses.size(); i++) {
                Address addr = addresses.get(i);
                json.append("{");
                json.append("\"streetNumber\":\"").append(addr.getStreetNumber() != null ? addr.getStreetNumber() : "")
                        .append("\",");
                json.append("\"streetName\":\"").append(addr.getStreetName() != null ? addr.getStreetName() : "")
                        .append("\",");
                json.append("\"city\":\"").append(addr.getCity() != null ? addr.getCity() : "").append("\",");
                json.append("\"province\":\"").append(addr.getProvince() != null ? addr.getProvince() : "")
                        .append("\",");
                json.append("\"fullAddress\":\"").append(addr.getFullAddress()).append("\"");
                json.append("}");

                if (i < addresses.size() - 1) {
                    json.append(",");
                }
            }
        }

        json.append("],");
        json.append("\"totalPeople\":").append(getTotalPeople());
        json.append("}");

        return json.toString();
    }
}