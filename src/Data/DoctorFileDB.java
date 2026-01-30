/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;
import Hospital.Doctor;
import Hospital.MedicalStaff;
import Hospital.Person;
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
public class DoctorFileDB implements IDoctor {
    
    private File doctorFile;

    public DoctorFileDB() {
        
        doctorFile=new File("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Doctor.txt");
    }

    @Override
    public boolean addDoctor(Doctor d) {
       Path File3=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Doctor.txt");
       try(BufferedWriter bw=Files.newBufferedWriter(File3,StandardCharsets.UTF_8,StandardOpenOption.APPEND);){
            bw.write(d.getStaffID()+":");
            bw.write(d.getSpecialization()+":");
            bw.write(d.getConsultationFee()+":");
            bw.write(d.getLicenseNumber()+":");
            bw.write(d.getYearsOfExperience()+":");
            bw.write(d.getSalary()+"\n");
            bw.close();
         return true;
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
           return false;
       }
    }

    @Override
    public Doctor findDoctor(int dID) {
        Path myFile3=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Doctor.txt");
        String staffID=String.valueOf(dID);
            try(BufferedReader br=Files.newBufferedReader(myFile3,StandardCharsets.UTF_8);){
                String line;
               while((line=br.readLine())!=null){
                   String []s=line.split(":");
                   if (s[0].equals(staffID)){
                     String specialization=s[1];
                     String consultationFee=s[2];
                     String licenseNumber=s[3];
                     String yearsOfExperience=s[4];
                     String salary=s[5];
                     Doctor d=new Doctor(dID, specialization, consultationFee, licenseNumber, yearsOfExperience, salary);
                    return d;
                  }
               }
               return null;
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, e.getMessage());
               return null;
       }
    }

    @Override
    public boolean deleteDoctor(int dID) {
        Path myFile3=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Doctor.txt");
        Path temFile3=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/DoctorTemp.txt");  
        boolean deleted=false;
        try(BufferedReader br=Files.newBufferedReader(myFile3,StandardCharsets.UTF_8);
           BufferedWriter bw=Files.newBufferedWriter(temFile3,StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);)
        {
            String line;
            while ((line=br.readLine())!=null){
               String[]s=line.split(":");
               if(Integer.valueOf(s[0])!=dID){
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
            Files.delete(myFile3);
            Files.move(temFile3,myFile3,StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
             e.printStackTrace();
               return false;
        }
        return deleted;
    }

    @Override
    public boolean updateDoctor(Doctor d) {
        Path myFile3=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Doctor.txt");
        Path temFile3=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/DoctorTemp.txt");  
         boolean updated=false;
         try{
              try(BufferedReader br=Files.newBufferedReader(myFile3,StandardCharsets.UTF_8);
           BufferedWriter bw=Files.newBufferedWriter(temFile3,StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);)
              {
                   String line;
            while ((line=br.readLine())!=null){
               String[]s=line.split(":");
               if(Integer.valueOf(s[0])!=d.getStaffID()){
                   bw.write(line);
               }else{
                   bw.write(d.getStaffID() + ":" + d.getSpecialization() + ":" + d.getConsultationFee() + ":" + d.getLicenseNumber() + ":" + d.getYearsOfExperience() + ":" + d.getSalary());
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
             Files.delete(myFile3);
             Files.move(temFile3,myFile3,StandardCopyOption.REPLACE_EXISTING);
           }catch(IOException e){
               e.printStackTrace();
               return false;
           }
         return updated;
    }

    @Override
    public ArrayList<Doctor> getAll() {
        ArrayList<Doctor> dList=new ArrayList<>();
        Path myFile3=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Doctor.txt");
        try(BufferedReader br=Files.newBufferedReader(myFile3,StandardCharsets.UTF_8);){
             String line;
           while((line=br.readLine())!=null){
              String[] s=line.split(":");
              int dID=Integer.valueOf(s[0]);
              String specialization=s[1];
              String consultationFee=s[2];
              String licenseNumber=s[3];
              String yearsOfExperience=s[4];
              String salary=s[5];
              Doctor d=new Doctor(dID, specialization, consultationFee, licenseNumber, yearsOfExperience, salary);
              dList.add(d);              
           }
          return dList;
       }catch(Exception e){
           return dList;
       }
    } 
}
