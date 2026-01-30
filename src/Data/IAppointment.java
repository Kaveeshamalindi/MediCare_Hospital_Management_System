 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Data;
import java.util.ArrayList;
import Hospital.Appointment;

/**
 *
 * @author USER
 */
public interface IAppointment {
    
    public abstract boolean scheduleAppointment(Appointment a);
    public abstract Appointment findAppointment(int aID);
    public abstract boolean cancelAppointment(int aID);
    public abstract boolean rescheduleAppointment(Appointment a);
    //public abstract boolean sendReminder(Appointment a);
    public abstract ArrayList<Appointment> getAll();
    
}
