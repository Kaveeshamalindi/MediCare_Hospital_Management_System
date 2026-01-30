/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Data;
import Hospital.Person;
import Hospital.MedicalStaff;
import Hospital.Doctor;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface IDoctor {
    
    public abstract boolean addDoctor(Doctor d);
    public abstract Doctor findDoctor(int dID);
    public abstract boolean deleteDoctor(int dID);
    public abstract boolean updateDoctor(Doctor d);
    public abstract ArrayList<Doctor> getAll();
}
