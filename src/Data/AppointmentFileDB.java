/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;
import Hospital.Appointment;
import java.util.ArrayList;
import java.io.*;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.sql.Date;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author USER
 */
public class AppointmentFileDB implements IAppointment {

    private File appointmentFile;

    public AppointmentFileDB() {
        appointmentFile=new File("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Appointment.txt");
    }
  
    @Override
    public boolean scheduleAppointment(Appointment a) {
       Path File1=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Appointment.txt");
       try(BufferedWriter bw=Files.newBufferedWriter(File1,StandardCharsets.UTF_8,StandardOpenOption.APPEND);){
            bw.write(a.getAppointmentID()+":");
            bw.write(a.getPatient()+":");
            bw.write(a.getDoctor()+":");
            bw.write(a.getAppointmentDate()+":");
            bw.write(a.getAppointmentTime()+":");
            bw.write(a.getType()+":");
            bw.write(a.getStatus()+":");
            bw.write(a.getNotes()+"\n");
            bw.close();
         return true;
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
           return false;
       }
    }

    @Override
    public Appointment findAppointment(int aID) {
       Path myFile1=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Appointment.txt");
       String appointmentID=String.valueOf(aID);
            try(BufferedReader br=Files.newBufferedReader(myFile1,StandardCharsets.UTF_8);){
                String line;
               while((line=br.readLine())!=null){
                   String []s=line.split(":");
                   if (s[0].equals(appointmentID)){
                     String patient=s[1];
                     String doctor=s[2];
                     Date appointmentDate=Date.valueOf(s[3]);
                     String appointmentTime=s[4];
                     String type=s[5];
                     String status=s[6];
                     String notes=s[7];
                     Appointment a=new Appointment(aID, patient, doctor, appointmentDate, appointmentTime, type, status, notes);
                    return a;
                  }
               }
               return null;
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, e.getMessage());
               return null;
       }
    }

    @Override
    public boolean cancelAppointment(int aID) {
        Path myFile1=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Appointment.txt");
        Path temFile1=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/AppointmentTemp.txt");  
        boolean deleted=false;
        try(BufferedReader br=Files.newBufferedReader(myFile1,StandardCharsets.UTF_8);
           BufferedWriter bw=Files.newBufferedWriter(temFile1,StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);)
        {
            String line;
            while ((line=br.readLine())!=null){
               String[]s=line.split(":");
               if(Integer.valueOf(s[0])!=aID){
                   bw.write(line);
                   bw.newLine();
               }else{
                   deleted=true;
               }
            }     
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        try{
            Files.delete(myFile1);
            Files.move(temFile1,myFile1,StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
             e.printStackTrace();
               return false;
        }
        return deleted;
    }

    @Override
    public boolean rescheduleAppointment(Appointment a) {
        Path myFile1=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Appointment.txt");
        Path temFile1=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/AppointmentTemp.txt");  
         boolean updated=false;
         try{
              try(BufferedReader br=Files.newBufferedReader(myFile1,StandardCharsets.UTF_8);
           BufferedWriter bw=Files.newBufferedWriter(temFile1,StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);)
              {
                   String line;
            while ((line=br.readLine())!=null){
               String[]s=line.split(":");
               if(Integer.valueOf(s[0])!=a.getAppointmentID()){
                   bw.write(line);
               }else{
                   bw.write(a.getAppointmentID() + ":" + a.getPatient() + ":" + a.getDoctor() + ":" + a.getAppointmentDate() + ":" + a.getAppointmentTime() + ":" + a.getType() + ":" + a.getStatus() + ":" + a.getNotes());
                   updated=true;
               }
               bw.newLine();
            }
            bw.close();
          } 
           }catch(Exception e){
              e.printStackTrace();
               return false;  
           }
         try{
             Files.delete(myFile1);
             Files.move(temFile1,myFile1,StandardCopyOption.REPLACE_EXISTING);
           }catch(IOException e){
               e.printStackTrace();
               return false;
           }
         return updated;
    }

    @Override
    public ArrayList<Appointment> getAll() {
        ArrayList<Appointment> aList=new ArrayList<>();
        Path myFile1=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Appointment.txt");
        try(BufferedReader br=Files.newBufferedReader(myFile1,StandardCharsets.UTF_8);){
             String line;
           while((line=br.readLine())!=null){
              String[] s=line.split(":");
              int aID=Integer.valueOf(s[0]);
              String patient=s[1];
              String doctor=s[2];
              Date appointmentDate=Date.valueOf(s[3]);
              String appointmentTime=s[4];
              String type=s[5];
              String status=s[6];
              String notes=s[7];
              Appointment a=new Appointment(aID, patient, doctor, appointmentDate, appointmentTime, type, status, notes);
              aList.add(a);              
           }
          return aList;
       }catch(Exception e){
           return aList;
       }
    } 

    /*@Override
    public boolean sendReminder(Appointment a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
    
    
}
