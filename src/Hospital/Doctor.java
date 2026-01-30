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
public class Doctor extends MedicalStaff {
    
    private String specialization;
    private String consultationFee;
    private String licenseNumber;
    private String yearsOfExperience;

    public Doctor() {
    }

    public Doctor(String specialization, String consultationFee, String licenseNumber, String yearsOfExperience, int staffID, String department, Date hireDate, String salary, String workSchedule, String qualifications, String staffType, int personID, String firstName, String lastName, Date dateOfBirth, String gender, int contactNumber, String email, String address) {
        super(staffID, department, hireDate, salary, workSchedule, qualifications, staffType, personID, firstName, lastName, dateOfBirth, gender, contactNumber, email, address);
        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.licenseNumber = licenseNumber;
        this.yearsOfExperience = yearsOfExperience;
    }

    
    //Overload the constructor
    public Doctor(int staffID, String specialization, String consultationFee, String licenseNumber, String yearsOfExperience,String salary) {
        super(staffID, salary);
        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.licenseNumber = licenseNumber;
        this.yearsOfExperience = yearsOfExperience;
    }
    

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(String consultationFee) {
        this.consultationFee = consultationFee;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String getPersonDetails() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateContactInfo(int contactNumber, String email, String address) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
