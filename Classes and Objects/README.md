# Person Management System

A Java-based Person Management System that demonstrates Object-Oriented Programming concepts including classes, objects, access modifiers, and utility methods. The system generates valid South African ID numbers and manages person information with addresses.

## 📋 Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Class Overview](#class-overview)
- [South African ID Number Format](#south-african-id-number-format)
- [Example Output](#example-output)
- [JSON Output](#json-output)
- [Contributing](#contributing)

## ✨ Features

- **Person Management**: Create and manage person objects with personal information
- **Address Management**: Support for multiple addresses per person
- **SA ID Generation**: Automatically generates valid South African ID numbers
- **Age Calculation**: Automatically calculates age from generated ID numbers
- **JSON Output**: Convert person objects to JSON format
- **Static Counter**: Tracks total number of Person objects created
- **Utility Methods**: Helper methods for ID validation and information extraction

## 📁 Project Structure

```
Classes and Objects/
├── Main.java                    # Main application entry point
├── Entities/
│   ├── Person.java             # Person entity class
│   └── Address.java            # Address entity class
└── Utilities/
    └── Utilities.java          # Utility methods for ID generation and validation
```

## 🔧 Prerequisites

- Java Development Kit (JDK) 8 or higher
- IDE (VS Code, IntelliJ IDEA, Eclipse, etc.)
- Basic understanding of Java OOP concepts

## 🚀 Installation

1. **Clone or Download** the project files to your local machine
2. **Open** the project folder in your preferred IDE
3. **Ensure** your Java environment is properly configured
4. **Compile** the Java files:
   ```bash
   javac -d . Main.java Entities/*.java Utilities/*.java
   ```
5. **Run** the application:
   ```bash
   java Main
   ```

## 💻 Usage

### Creating a Person (Method 1 - Default Constructor)

```java
Person person = new Person();
person.setFirstName("John");
person.setSecondName("William");
person.setLastName("Doe");
person.setGender("Male"); // This automatically generates SA ID

// Create and add address
Address address = new Address();
address.setStreetNumber("123");
address.setStreetName("Main Street");
address.setCity("Johannesburg");
address.setProvince("Gauteng");

List<Address> addresses = new ArrayList<>();
addresses.add(address);
person.setAddresses(addresses);
```

### Creating a Person (Method 2 - Parameterized Constructor)

```java
Address address = new Address("456", "Oak Avenue", "Cape Town", "Western Cape");
Person person = new Person("Sarah", "Jane", "Smith", "Female", address);
```

### Displaying Person Information

```java
// Standard toString format
System.out.println(person.toString());

// JSON format
System.out.println(person.toJson());

// Compact JSON format
System.out.println(person.toCompactJson());
```

## 📚 Class Overview

### Person Class (`Entities/Person.java`)

**Attributes:**
- `id_num` (String): Auto-generated South African ID number
- `firstName` (String): Person's first name
- `secondName` (String): Person's middle name (optional)
- `lastName` (String): Person's last name
- `gender` (String): Person's gender ("Male" or "Female")
- `age` (int): Calculated age based on ID number
- `addresses` (List<Address>): List of person's addresses
- `personCounter` (static int): Total count of Person objects created

**Key Methods:**
- `generatePersonID(String gender)`: Generates valid SA ID number
- `getFullName()`: Returns complete name
- `toJson()`: Converts object to pretty JSON format
- `toCompactJson()`: Converts object to compact JSON format
- `getTotalPeople()`: Static method returning total people created

### Address Class (`Entities/Address.java`)

**Attributes:**
- `streetNumber` (String): Street number
- `streetName` (String): Street name
- `city` (String): City name
- `province` (String): Province name

**Key Methods:**
- `getFullAddress()`: Returns formatted complete address
- `toString()`: String representation of address

### Utilities Class (`Utilities/Utilities.java`)

**Key Methods:**
- `generatePersonID(String gender)`: Creates valid SA ID following YYMMDDGSSSCAZ format
- `updateAge(String id)`: Calculates age from ID number
- `getTodaysDate()`: Gets current date in YYMMDD format
- `getGenderNumber(String gender)`: Returns appropriate gender digit
- `calCheckDigit(String partialID)`: Calculates Luhn algorithm check digit

## 🆔 South African ID Number Format

The system generates valid South African ID numbers following the **YYMMDDGSSSCAZ** format:

| Position | Description | Example |
|----------|-------------|---------|
| YY | Year of birth (last 2 digits) | 25 (for 2025) |
| MM | Month of birth | 09 (September) |
| DD | Day of birth | 27 (27th day) |
| G | Gender digit | 0-4 (Female), 5-9 (Male) |
| SSS | Sequence number | 123 (unique identifier) |
| C | Citizenship | 0 (SA Citizen), 1 (Permanent Resident) |
| A | Race/ID type | 8 (Old format), 9 (New format) |
| Z | Check digit | 1 (Luhn algorithm validation) |

**Example ID:** `2509275123081`
- Born: 25-09-27 (27 September 2025)
- Gender: Male (digit 5)
- Sequence: 123
- SA Citizen: 0
- New format: 8
- Check digit: 1

## 📄 Example Output

### Standard Output
```
Person{id_num='2509275018091', firstName='Gen', secondName='Nine', lastName='Naph', fullName='Gen Nine Naph', gender='Male', age=0, addresses=[Address{streetNumber='21', streetName='Kaynobs', city='Centurion', province='Gauteng', fullAddress='21 Kaynobs, Centurion, Gauteng'}], totalPeople=1}
```

### JSON Output
```json
{
  "id_num": "2509275018091",
  "firstName": "Gen",
  "secondName": "Nine",
  "lastName": "Naph",
  "fullName": "Gen Nine Naph",
  "gender": "Male",
  "age": 0,
  "addresses": [
    {
      "streetNumber": "21",
      "streetName": "Kaynobs",
      "city": "Centurion",
      "province": "Gauteng",
      "fullAddress": "21 Kaynobs, Centurion, Gauteng"
    }
  ],
  "totalPeople": 1
}
```

## 🔧 Key Programming Concepts Demonstrated

### Access Modifiers
- **public**: Accessible from anywhere (`Person` class, `main` method)
- **private**: Accessible within the same class only (instance variables, helper methods)
- **protected**: Accessible within the same package and subclasses

### Variables
- **Instance Variables**: Each object has its own copy (`firstName`, `lastName`, `age`)
- **Static Variables**: Shared among all objects of the class (`personCounter`)

### Methods
- **Instance Methods**: Called on specific objects (`person.getName()`)
- **Static Methods**: Called using class name (`Person.getTotalPeople()`)

### Object-Oriented Features
- **Encapsulation**: Private fields with public getters/setters
- **Constructor Overloading**: Multiple constructors for flexibility
- **Composition**: Person "has-a" Address relationship
- **Utility Classes**: Separate concerns with `Utilities` class

## 🚀 Future Enhancements

- [ ] Add data persistence (file I/O or database)
- [ ] Implement person search functionality
- [ ] Add input validation for addresses
- [ ] Create GUI interface
- [ ] Add unit tests
- [ ] Implement person deletion/modification
- [ ] Add support for international address formats
- [ ] Create REST API endpoints

## 🤝 Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📧 Contact

For questions or suggestions, please create an issue in this repository.

## 📄 License

This project is for educational purposes. Feel free to use and modify as needed.

---

**Note**: This system generates ID numbers for demonstration purposes only. The generated IDs use today's date as the birth date, resulting in age 0 for all generated persons. In a real-world application, you would typically accept birth dates as input parameters.