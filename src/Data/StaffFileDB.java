/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;
import Hospital.MedicalStaff;
import Hospital.Person;
import Hospital.Staff;
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
public class StaffFileDB implements IStaff{
    
    private File staffFile;

    public StaffFileDB() {
        
        staffFile=new File("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/MedicalStaff.txt");
        
    }

    @Override
    public boolean addRecord(Staff s) {
        Path File4=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/MedicalStaff.txt");
       try(BufferedWriter bw=Files.newBufferedWriter(File4,StandardCharsets.UTF_8,StandardOpenOption.APPEND);){
            bw.write(s.getStaffID()+":");
            bw.write(s.getLastName()+":");
            bw.write(s.getGender()+":");
            bw.write(s.getContactNumber()+":");
            bw.write(s.getDepartment()+":");
            bw.write(s.getHireDate()+":");
            bw.write(s.getSalary()+":");
            bw.write(s.getWorkSchedule()+":");
            bw.write(s.getQualifications()+":");
            bw.write(s.getStaffType()+"\n");
            bw.close();
         return true;
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
           return false;
       }
    }

    @Override
    public Staff findRecord(int sID) {
        Path myFile4=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/MedicalStaff.txt");
       String staffID=String.valueOf(sID);
            try(BufferedReader br=Files.newBufferedReader(myFile4,StandardCharsets.UTF_8);){
                String line;
               while((line=br.readLine())!=null){
                   String []c=line.split(":");
                   if (c[0].equals(staffID)){
                     String lastName=c[1];
                     String gender=c[2];
                     int contactNumber=Integer.valueOf(c[3]);
                     String department=c[4];
                     Date hireDate=Date.valueOf(c[5]);
                     String salary=c[6];
                     String workSchedule=c[7];
                     String qualifications=c[8];
                     String staffType=c[9];
                     
                    Staff s = new Staff(sID, lastName, gender, contactNumber, department, hireDate, salary, workSchedule, qualifications, staffType);
                    return s;
                  }
               }
               return null;
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, e.getMessage());
               return null;
       }
    }

    @Override
    public boolean deleteRecord(int sID) {
        Path myFile4=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/MedicalStaff.txt");
        Path temFile4=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/MedicalStaffTemp.txt");  
        boolean deleted=false;
        try(BufferedReader br=Files.newBufferedReader(myFile4,StandardCharsets.UTF_8);
           BufferedWriter bw=Files.newBufferedWriter(temFile4,StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);)
        {
            String line;
            while ((line=br.readLine())!=null){
               String[]c=line.split(":");
               if(Integer.valueOf(c[0])!=sID){
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
            Files.delete(myFile4);
            Files.move(temFile4,myFile4,StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
             e.printStackTrace();
               return false;
        }
        return deleted;
    }

    @Override
    public boolean updateRecord(Staff s) {
        Path myFile4=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/MedicalStaff.txt");
        Path temFile4=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/MedicalStaffTemp.txt");  
         boolean updated=false;
         try{
              try(BufferedReader br=Files.newBufferedReader(myFile4,StandardCharsets.UTF_8);
              BufferedWriter bw=Files.newBufferedWriter(temFile4,StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);)
              {
                   String line;
            while ((line=br.readLine())!=null){
               String[]c=line.split(":");
               if(Integer.valueOf(c[0])!=s.getStaffID()){
                   bw.write(line);
               }else{
                   bw.write(s.getStaffID() + ":" + s.getLastName() + ":" + s.getGender() + ":" + s.getContactNumber() + ":" + s.getDepartment() + ":" + s.getHireDate() + ":" + s.getSalary() + ":" + s.getWorkSchedule() + ":" + s.getQualifications() + ":" + s.getStaffType());
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
             Files.delete(myFile4);
             Files.move(temFile4,myFile4,StandardCopyOption.REPLACE_EXISTING);
           }catch(IOException e){
               e.printStackTrace();
               return false;
           }
         return updated;
    }

    @Override
    public ArrayList<Staff> getAll() {
        ArrayList<Staff> sList=new ArrayList<>();
        Path myFile1=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/MedicalStaff.txt");
       try(BufferedReader br=Files.newBufferedReader(myFile1,StandardCharsets.UTF_8);){
             String line;
           while((line=br.readLine())!=null){
              String[] c=line.split(":");
              int sID=Integer.valueOf(c[0]);
              String lastName=c[1];
              String gender=c[2];
              int contactNumber=Integer.valueOf(c[3]);
              String department=c[4];
              Date hireDate=Date.valueOf(c[5]);
              String salary=c[6];
              String workSchedule=c[7];
              String qualifications=c[8];
              String staffType=c[9];
              
              Staff s=new Staff(sID, lastName, gender, contactNumber, department, hireDate, salary, workSchedule, qualifications, staffType);
              sList.add(s);              
           }
          return sList;
       }catch(Exception e){
           return sList;
       }
    }   
}
