/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Data;
import java.util.ArrayList;
import Hospital.Administrator;

/**
 *
 * @author USER
 */
public interface IAdministrator {
    
    public abstract boolean addAdmin(Administrator A);
    public abstract Administrator findAdmin(int AID);
    public abstract boolean deleteAdmin(int AID);
    public abstract boolean updateAdmin(Administrator A);
    public abstract ArrayList<Administrator> getAll();
    
}
