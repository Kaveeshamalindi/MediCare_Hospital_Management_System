/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Data;
import java.util.ArrayList;
import Hospital.MedicalRecord;

/**
 *
 * @author USER
 */
public interface IMedicalRecord {
    
    public abstract boolean createRecord(MedicalRecord mR);
    public abstract MedicalRecord findRecord(int mRID);
    public abstract boolean cancelRecord(int mRID);
    public abstract boolean updateRecord(MedicalRecord mR);
    public abstract ArrayList<MedicalRecord> getAll();
    
}
