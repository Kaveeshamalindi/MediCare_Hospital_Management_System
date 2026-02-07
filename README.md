# MediCare Hospital Management System

## Introduction

The system is developed using a three-tier (3D) architecture, which is organized into User, Hospital and Data. The User package includes graphical user interfaces. That provides a high-level user-friendly experience for users. The Hospital package contains object-oriented classes, including Administrator, Appointment, Bill, Doctor, Lab, MedicalRecord, MedicalStaff, Patient, Person, and Staff. The Data package is responsible for file handling. However, that provides benefits including faster development, improved scalability, reliability and security in the system 

## Application of Object-Oriented Programming

Java is used for Object-Oriented Programming. That style is closer to the real-world scenarios, such as a Hospital Management System (HMS). The structure contains objects, classes, methods and attributes. That consists of main principles such as Object, Class, Abstraction, Inheritance, Encapsulation and Polymorphism

### Object 

Objects have characteristics which are used to describe them. These characteristics are known as attributes. An attribute defines the current state of an object. 

In this system, P is an object of the Patient class. This object contains patient-specific data.
```
Patient p=new Patient(pID, firstName, lastName, dateOfBirth,gender, contactNumber, emergencyContact, email, address, patientID, registrationDate, bloodGroup,nallergies, insuranceInfo);
```
Moreover, the code below represents a data handler object in the DoctorProfile JFrame Form. object dfDB is created from the DoctorFileDB class, which is used for handling patient-related data operations using file handling techniques. 

```
dfDB=new DoctorFileDB();
```

### Class

Classes can be described as a blueprint for an object.

```
public class Appointment {
	//class variables and methods
}
```

### Abstraction

Data abstraction provides an essential feature to the outside without including implementation details. For example, abstraction is used in the Person abstract class. 

```
public abstract class Person {
	//abstract class variables and methods
}
```

### Inheritance

Inheritance is the process that is used to gain properties (variables and methods) from one class to another. It provides to manage information in hierarchical order. The class inheriting the properties of another is the subclass, and the class whose properties are inherited is the superclass.

```
public class Administrator extends Person {
	//subclass variables and methods
}
```

### Encapsulation

Encapsulation refers to wrapping data and methods into a class. The variables of one class will be hidden from the other classes and accessible only through the methods of the current class. That is called data hiding. To achieve encapsulation in this project, declare the class’s variable as private and provide public setter and getter methods to modify and view the variable’s values. 

```
private int personID;
public int getPersonID() {
        return personID;
}
public void setPersonID(int personID) {
        this.personID = personID;
}  
```

### Polymorphism

Polymorphism refers to the idea of having many forms. This project uses method overriding and overloading. 

In overriding, a subclass can implement a superclass method based on its requirements. That is called run-time polymorphism.

```
public interface IDoctor {
    public abstract boolean addDoctor(Doctor d);
}
```

In the IDoctor interface, the abstract method IDoctor was used to hide information, and DoctorFileDB implemented it. 

```
public class DoctorFileDB implements IDoctor {
	//database implementation
}

@Override
public boolean addDoctor(Doctor d) {
       //File Handling code with try-catch block    
}
```
## Main Functions

The system consists of login portals, main role portals, menu bars, and data input interfaces. That supports users to work easily on the MediCare Hospital Management System. 

### System Login

The system offers separate user login options, including portals for doctors, nurses, lab technicians, and administrators. That ensures the system is secure from unauthorized login access and provides a more secure system for users. When the user enters the correct User Name or password, the user is directed to the relevant role's main portal. When a user logs in with an invalid User Name or password, it displays a dialog box with “Incorrect User Name or Password”.

```
if (userName.equals("Admin")&&(password.equals("123"))){
            AdminMain aUI = new AdminMain();
            aUI.setVisible(true);
            this.setVisible(false);
} else {
            JOptionPane.showMessageDialog(rootPane, "Incorrect User Name or Password");
}
```
The above code snippet shows how to secure a system by using an if-else condition.

### System Structure

The system employs a three-tier (3D) architecture, organized into User, Hospital, and Data tiers. 

The User package includes graphical user interfaces. The Hospital package contains classes, which involve the Object-Oriented Programming (OOP) Principle. The Data package is responsible for the file handling process of the system. 

### Role Portals

After a user successfully logs in, the system will be directed to the relevant role’s Portals. That consists of the menu bar, function buttons and the Logout button. The Logout button returns to the main login screen. The function buttons are directed to the specific operation interfaces. That interface consists of the data handle buttons and the Exit button. The Exit button again returns to the relevant role’s Portals. Moreover, CRUD Operations allow a system to create, read, update and delete data effectively using GUIs. The menu bar has two menus: Help and Options. The Help menu supports opening the user manual and directs to the main login screen. The Options menu can be used to access the functions. All menu items are supported with the shortcuts.


## User Manual

The system consists of a user manual to understand how to correctly use the system. That avoids user confusion. That provides system screenshots and demonstrates videos to enhance user experience. Those allow step-by-step guidance for users.

## Test Document

That includes the test plan, test cases and test results with explanations. The test document proves the system works accurately and reliably. That supports verifying that all the functions work correctly.  

## Conclusion

The document successfully represented the expected tasks, including the principle of Object-Oriented Programming concept (OOP), main functionalities of the system with proper explanation, a user-friendly manual and a test document.
The MediCare Hospital Management System (HMS) distributed various functions for users, such as maintaining medical records, keeping lab test records, scheduling appointments and generating bills, creating patient profiles, registering doctors and medical staff and much more. All the functions are involved with user-friendly graphical user interfaces (GUIs) with proper file and exception handling.
The user manual navigates the user without system crashes. That includes system screenshots and screen capture videos to enhance the user experience. 
The developer tested the system using unit testing and integration testing methods. The recommendation of the system will be applied in the near future by learning new technical skills such as Spring Boot, CSS, HTML, JavaScript and REST APIs, etc.  Then, the system will be implemented into a web application with more functionalities to deliver a better experience for users. That will allow users to access from any location.  
In conclusion, the MediCare project achieves an error-free, effective, user-friendly GUI application using the Java programming language. This will support hospital management efficiency, reliability, and productivity. The user feedbacks were encouraged to contribute more effort to the projects. This software project is a strong foundation for the developer to enhance knowledge and skills.

Don't forget to hit the ⭐ if you like this repo.

