/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Data;
import Hospital.Patient;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface Ipatient {
    public abstract boolean registerPatient(Patient p);
    public abstract Patient findPatient(int pID);
    public abstract boolean removePatient(int pID);
    public abstract boolean updateMedicalInfo(Patient p);
    public abstract ArrayList<Patient> getMedicalHistory();
}
