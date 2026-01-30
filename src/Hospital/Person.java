/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hospital;
import java.sql.Date;

/**
 *
 * @author USER
 */
public abstract class Person {
    
    private int personID;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private int contactNumber;
    private String email;
    private String address;

    public Person() {
    }

    public Person(int personID, String firstName, String lastName, Date dateOfBirth, String gender, int contactNumber, String email, String address) {
        this.personID = personID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
    }

    //Used to create MedicalStaff Class Constructor
    public Person(String lastName, String gender, int contactNumber) {
        this.lastName = lastName;
        this.gender = gender;
        this.contactNumber = contactNumber;
    }
    
    //Used to create Administrator Class Constructor
    public Person(String lastName, String gender, String address) {
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
    }
    
    
    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public abstract String getPersonDetails();
    
    public abstract void updateContactInfo(int contactNumber, String email, String address);   
}
