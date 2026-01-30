/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Data;
import Hospital.Person;
import Hospital.MedicalStaff;
import Hospital.Staff;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface IStaff {
    
    public abstract boolean addRecord(Staff s);
    public abstract Staff findRecord(int sID);
    public abstract boolean deleteRecord(int sID);
    public abstract boolean updateRecord(Staff s);
    public abstract ArrayList<Staff> getAll();
}
