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
public abstract class MedicalStaff extends Person {
    
    private int staffID;
    private String department;
    private Date hireDate;
    private String salary;
    private String workSchedule;
    private String qualifications;
    private String staffType; //Doctor, Nurse, Lab Technician, Addmin

    public MedicalStaff() {
    }

    public MedicalStaff(int staffID, String department, Date hireDate, String salary, String workSchedule, String qualifications, String staffType, int personID, String firstName, String lastName, Date dateOfBirth, String gender, int contactNumber, String email, String address) {
        super(personID, firstName, lastName, dateOfBirth, gender, contactNumber, email, address);
        this.staffID = staffID;
        this.department = department;
        this.hireDate = hireDate;
        this.salary = salary;
        this.workSchedule = workSchedule;
        this.qualifications = qualifications;
        this.staffType = staffType;
    }

    //Used to create Doctor Class Constructor
    public MedicalStaff(int staffID, String salary) {
        this.staffID = staffID;
        this.salary = salary;
    }

    //Used to create MedicalStaffUI Constructor
    public MedicalStaff(int staffID, String lastName, String gender, int contactNumber, String department, Date hireDate, String salary, String workSchedule, String qualifications, String staffType) {
        super(lastName, gender, contactNumber);
        this.staffID = staffID;
        this.department = department;
        this.hireDate = hireDate;
        this.salary = salary;
        this.workSchedule = workSchedule;
        this.qualifications = qualifications;
        this.staffType = staffType;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(String workSchedule) {
        this.workSchedule = workSchedule;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getStaffType() {
        return staffType;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }
    
}
