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
public class Administrator extends Person {
    
    private int adminID;
    private String accessLevel;
    private String department;
    private Date hireDate;
    private String adminType;

    public Administrator() {
    }

    public Administrator(int adminID, String accessLevel, String department, Date hireDate, String adminType, int personID, String firstName, String lastName, Date dateOfBirth, String gender, int contactNumber, String email, String address) {
        super(personID, firstName, lastName, dateOfBirth, gender, contactNumber, email, address);
        this.adminID = adminID;
        this.accessLevel = accessLevel;
        this.department = department;
        this.hireDate = hireDate;
        this.adminType = adminType;
    }
    
    //Used to create AdministratorUI Constructor
    public Administrator(int adminID,  String lastName, String gender, String address, String accessLevel, String department, Date hireDate, String adminType) {
        super(lastName, gender, address);
        this.adminID = adminID;
        this.accessLevel = accessLevel;
        this.department = department;
        this.hireDate = hireDate;
        this.adminType = adminType;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
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

    public String getAdminType() {
        return adminType;
    }

    public void setAdminType(String adminType) {
        this.adminType = adminType;
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
