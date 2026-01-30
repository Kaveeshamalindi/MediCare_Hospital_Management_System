/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;
import Hospital.Person;
import Hospital.Patient;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.sql.Date;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author USER
 */
public class PatientFileDB implements Ipatient {
    
    private File patientFile;
    
    public PatientFileDB() {
        patientFile=new File("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Patient.txt");
    }

    @Override
    public boolean registerPatient(Patient p) {
        Path File5=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Patient.txt");
       try(BufferedWriter bw=Files.newBufferedWriter(File5,StandardCharsets.UTF_8,StandardOpenOption.APPEND);){
            bw.write(p.getPersonID()+":");
            bw.write(p.getFirstName()+":");
            bw.write(p.getLastName()+":");
            bw.write(p.getDateOfBirth()+":");
            bw.write(p.getGender()+":");
            bw.write(p.getContactNumber()+":");
            bw.write(p.getEmergencyContact()+":");
            bw.write(p.getEmail()+":");
            bw.write(p.getAddress()+":");
            bw.write(p.getPatientID()+":");
            bw.write(p.getRegistrationDate()+":");
            bw.write(p.getBloodGroup()+":");
            bw.write(p.getAllergies()+":");
            bw.write(p.getInsuranceInfo()+"\n");
            bw.close();
         return true;
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
           return false;
       }
    }

    @Override
    public Patient findPatient(int pID) {
        Path myFile5=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Patient.txt");
        String personID=String.valueOf(pID);
            try(BufferedReader br=Files.newBufferedReader(myFile5,StandardCharsets.UTF_8);){
                String line;
               while((line=br.readLine())!=null){
                   String []s=line.split(":");
                   if (s[0].equals(personID)){
                     String firstName=s[1];
                     String lastName=s[2];
                     Date dateOfBirth=Date.valueOf(s[3]);
                     String gender=s[4];
                     int contactNumber=Integer.valueOf(s[5]);
                     int emergencyContact=Integer.valueOf(s[6]);                   
                     String email=s[7];
                     String address=s[8];
                     int patientID=Integer.valueOf(s[9]);
                     Date registrationDate=Date.valueOf(s[10]);
                     String bloodGroup=s[11];
                     String allergies=s[12];
                     String insuranceInfo=s[13];
                     Patient p=new Patient(pID, firstName, lastName, 
                             dateOfBirth, gender, contactNumber, 
                             emergencyContact, email, address, patientID, 
                             registrationDate, bloodGroup, allergies, insuranceInfo);
                    return p;
                  }
               }
               return null;
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, e.getMessage());
               return null;
       }
    }

    @Override
    public boolean removePatient(int pID) {
        Path myFile5=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Patient.txt");
        Path temFile5=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/PatientTemp.txt");  
        boolean deleted=false;
        try(BufferedReader br=Files.newBufferedReader(myFile5,StandardCharsets.UTF_8);
           BufferedWriter bw=Files.newBufferedWriter(temFile5,StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);)
        {
            String line;
            while ((line=br.readLine())!=null){
               String[]s=line.split(":");
               if(Integer.valueOf(s[0])!=pID){
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
            Files.delete(myFile5);
            Files.move(temFile5,myFile5,StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
             e.printStackTrace();
               return false;
        }
        return deleted;
    }

    @Override
    public boolean updateMedicalInfo(Patient p) {
        Path myFile5=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Patient.txt");
        Path temFile5=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/PatientTemp.txt");  
         boolean updated=false;
         try{
              try(BufferedReader br=Files.newBufferedReader(myFile5,StandardCharsets.UTF_8);
           BufferedWriter bw=Files.newBufferedWriter(temFile5,StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);)
              {
                   String line;
            while ((line=br.readLine())!=null){
               String[]s=line.split(":");
               if(Integer.valueOf(s[0])!=p.getPersonID()){
                   bw.write(line);
               }else{
                   bw.write(p.getPersonID() + ":" + p.getFirstName() + ":" + p.getLastName() + ":" + p.getDateOfBirth() + ":" + p.getGender() + ":" + p.getContactNumber() + ":" + p.getEmergencyContact() + ":" + p.getEmail() + ":" + p.getAddress() + ":" + p.getPatientID() + ":" + p.getRegistrationDate() + ":" + p.getBloodGroup() + ":" + p.getAllergies() + ":" + p.getInsuranceInfo());
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
             Files.delete(myFile5);
             Files.move(temFile5,myFile5,StandardCopyOption.REPLACE_EXISTING);
           }catch(IOException e){
               e.printStackTrace();
               return false;
           }
         return updated;
    }

    @Override
    public ArrayList<Patient> getMedicalHistory() {
        ArrayList<Patient> pList=new ArrayList<>();
        Path myFile5=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Patient.txt");
        try(BufferedReader br=Files.newBufferedReader(myFile5,StandardCharsets.UTF_8);){
             String line;
           while((line=br.readLine())!=null){
              String[] s=line.split(":");
              int pID=Integer.valueOf(s[0]);
              String firstName=s[1];
              String lastName=s[2];
              Date dateOfBirth=Date.valueOf(s[3]);
              String gender=s[4];
              int contactNumber=Integer.valueOf(s[5]);
              int emergencyContact=Integer.valueOf(s[6]);                   
              String email=s[7];
              String address=s[8];
              int patientID=Integer.valueOf(s[9]);
              Date registrationDate=Date.valueOf(s[10]);
              String bloodGroup=s[11];
              String allergies=s[12];
              String insuranceInfo=s[13];
              
              Patient p=new Patient(pID, firstName, lastName, dateOfBirth, gender, contactNumber, emergencyContact, email, address, patientID, registrationDate, bloodGroup, allergies, insuranceInfo);
              pList.add(p);              
           }
          return pList;
       }catch(Exception e){
           return pList;
       }
    }    
}