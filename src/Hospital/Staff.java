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
public class Staff extends MedicalStaff {

    public Staff() {
    }

    public Staff(int staffID, String lastName, String gender, int contactNumber, String department, Date hireDate, String salary, String workSchedule, String qualifications, String staffType) {
        super(staffID, lastName, gender, contactNumber, department, hireDate, salary, workSchedule, qualifications, staffType);
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
