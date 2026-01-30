/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;
import Hospital.MedicalRecord;
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
public class MedicalRecordFileDB implements IMedicalRecord{
    
    private File mRecordFile;

    public MedicalRecordFileDB() {
        mRecordFile=new File("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/MedicalRecord.txt");
    }
    
    

    @Override
    public boolean createRecord(MedicalRecord mR) {
        Path File2=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/MedicalRecord.txt");
       try(BufferedWriter bw=Files.newBufferedWriter(File2,StandardCharsets.UTF_8,StandardOpenOption.APPEND);){
            bw.write(mR.getRecordID()+":");
            bw.write(mR.getPatient()+":");
            bw.write(mR.getDoctor()+":");
            bw.write(mR.getVisitDate()+":");
            bw.write(mR.getSymptoms()+":");
            bw.write(mR.getDiagnosis()+":");
            bw.write(mR.getTreatment()+":");
            bw.write(mR.getPrescription()+":");
            bw.write(mR.getTestResult()+"\n");
            bw.close();
         return true;
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
           return false;
       }
    }

    @Override
    public MedicalRecord findRecord(int mRID) {
        Path myFile2=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/MedicalRecord.txt");
       String recordID=String.valueOf(mRID);
            try(BufferedReader br=Files.newBufferedReader(myFile2,StandardCharsets.UTF_8);){
                String line;
               while((line=br.readLine())!=null){
                   String []s=line.split(":");
                   if (s[0].equals(recordID)){
                     String patient=s[1];
                     String doctor=s[2];
                     Date visitDate=Date.valueOf(s[3]);
                     String symptoms=s[4];
                     String diagnosis=s[5];
                     String treatment=s[6];
                     String prescription=s[7];
                     String testResult=s[8];
                     MedicalRecord a=new MedicalRecord(mRID, patient, doctor, visitDate, symptoms, diagnosis, treatment, prescription, testResult);
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
    public boolean cancelRecord(int mRID) {
        Path myFile2=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/MedicalRecord.txt");
        Path temFile2=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/MedicalRecordTemp.txt");  
        boolean deleted=false;
        try(BufferedReader br=Files.newBufferedReader(myFile2,StandardCharsets.UTF_8);
           BufferedWriter bw=Files.newBufferedWriter(temFile2,StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);)
        {
            String line;
            while ((line=br.readLine())!=null){
               String[]s=line.split(":");
               if(Integer.valueOf(s[0])!=mRID){
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
            Files.delete(myFile2);
            Files.move(temFile2,myFile2,StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
             e.printStackTrace();
               return false;
        }
        return deleted;
    }

    @Override
    public boolean updateRecord(MedicalRecord mR) {
        Path myFile2=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/MedicalRecord.txt");
        Path temFile2=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/MedicalRecordTemp.txt");  
         boolean updated=false;
         try{
              try(BufferedReader br=Files.newBufferedReader(myFile2,StandardCharsets.UTF_8);
                BufferedWriter bw=Files.newBufferedWriter(temFile2,StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);)
              {
                String line;
                while ((line=br.readLine())!=null){
                String[]s=line.split(":");
                if(Integer.valueOf(s[0])!=mR.getRecordID()){
                   bw.write(line);
                }else{
                   bw.write(mR.getRecordID() + ":" + mR.getPatient() + ":" + mR.getDoctor() + ":" + mR.getVisitDate() + ":" + mR.getSymptoms() + ":" + mR.getDiagnosis() + ":" + mR.getTreatment() + ":" + mR.getPrescription() + ":" + mR.getTestResult());
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
             Files.delete(myFile2);
             Files.move(temFile2,myFile2,StandardCopyOption.REPLACE_EXISTING);
           }catch(IOException e){
               e.printStackTrace();
               return false;
           }
         return updated;
    }

    @Override
    public ArrayList<MedicalRecord> getAll() {
        ArrayList<MedicalRecord> mList=new ArrayList<>();
        Path myFile2=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/MedicalRecord.txt");
       try(BufferedReader br=Files.newBufferedReader(myFile2,StandardCharsets.UTF_8);){
             String line;
           while((line=br.readLine())!=null){
              String[] s=line.split(":");
              int mRID=Integer.valueOf(s[0]);
              String patient=s[1];
                     String doctor=s[2];
                     Date visitDate=Date.valueOf(s[3]);
                     String symptoms=s[4];
                     String diagnosis=s[5];
                     String treatment=s[6];
                     String prescription=s[7];
                     String testResult=s[8];
              MedicalRecord mR=new MedicalRecord(mRID, patient, doctor, visitDate, symptoms, diagnosis, treatment, prescription, testResult);
              mList.add(mR);              
           }
          return mList;
       }catch(Exception e){
           return mList;
       }
    }  
}
