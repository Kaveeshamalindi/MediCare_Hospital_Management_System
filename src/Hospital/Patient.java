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
public class Patient extends Person {

    private int patientID;
    private Date registrationDate;
    private String  bloodGroup;
    private String allergies;
    private int emergencyContact;
    private String insuranceInfo;

    public Patient() {
    }

    public Patient(int personID, String firstName, String lastName, Date dateOfBirth, String gender, int contactNumber, int emergencyContact, String email, String address, int patientID, Date registrationDate, String bloodGroup, String allergies, String insuranceInfo) {
        super(personID, firstName, lastName, dateOfBirth, gender, contactNumber, email, address);
        this.patientID = patientID;
        this.registrationDate = registrationDate;
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
        this.emergencyContact = emergencyContact;
        this.insuranceInfo = insuranceInfo;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public int getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(int emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getInsuranceInfo() {
        return insuranceInfo;
    }

    public void setInsuranceInfo(String insuranceInfo) {
        this.insuranceInfo = insuranceInfo;
    }

    @Override
    public String getPersonDetails() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateContactInfo(int contactNumber, String email, String address) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
