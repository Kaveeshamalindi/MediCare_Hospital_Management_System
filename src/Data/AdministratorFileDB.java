/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;
import Hospital.Administrator;
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
public class AdministratorFileDB implements IAdministrator {
    
    private File adminFile;

    public AdministratorFileDB() {
        
        adminFile=new File("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Admin.txt");
    }

    @Override
    public boolean addAdmin(Administrator A) {
        Path File6=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Admin.txt");
        try(BufferedWriter bw=Files.newBufferedWriter(File6,StandardCharsets.UTF_8,StandardOpenOption.APPEND);){
            bw.write(A.getAdminID()+":");
            bw.write(A.getLastName()+":");
            bw.write(A.getGender()+":");
            bw.write(A.getAddress()+":");
            bw.write(A.getAccessLevel()+":");
            bw.write(A.getDepartment()+":");
            bw.write(A.getHireDate()+":");
            bw.write(A.getAdminType()+"\n");
            bw.close();
         return true;
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
           return false;
       }
    }

    @Override
    public Administrator findAdmin(int AID) {
        Path myFile6=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Admin.txt");
        String adminID=String.valueOf(AID);
            try(BufferedReader br=Files.newBufferedReader(myFile6,StandardCharsets.UTF_8);){
                String line;
               while((line=br.readLine())!=null){
                   String []s=line.split(":");
                   if (s[0].equals(adminID)){
                     String lastName=s[1];
                     String gender=s[2];
                     String address=s[3]; 
                     String accessLevel=s[4];
                     String department=s[5];
                     Date hireDate=Date.valueOf(s[6]);
                     String adminType=s[7];
                     Administrator A=new Administrator(AID, lastName, gender, address, accessLevel, department, hireDate, adminType);
                    return A;
                  }
               }
               return null;
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, e.getMessage());
               return null;
       }
    }

    @Override
    public boolean deleteAdmin(int AID) {
        Path myFile6=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Admin.txt");
        Path temFile6=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/AdminTemp.txt");  
        boolean deleted=false;
        try(BufferedReader br=Files.newBufferedReader(myFile6,StandardCharsets.UTF_8);
           BufferedWriter bw=Files.newBufferedWriter(temFile6,StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);)
        {
            String line;
            while ((line=br.readLine())!=null){
               String[]s=line.split(":");
               if(Integer.valueOf(s[0])!=AID){
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
            Files.delete(myFile6);
            Files.move(temFile6,myFile6,StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
             e.printStackTrace();
               return false;
        }
        return deleted;
    }

    @Override
    public boolean updateAdmin(Administrator A) {
        Path myFile6=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Admin.txt");
        Path temFile6=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/AdminTemp.txt");  
         boolean updated=false;
         try{
              try(BufferedReader br=Files.newBufferedReader(myFile6,StandardCharsets.UTF_8);
           BufferedWriter bw=Files.newBufferedWriter(temFile6,StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);)
              {
                   String line;
            while ((line=br.readLine())!=null){
               String[]s=line.split(":");
               if(Integer.valueOf(s[0])!=A.getAdminID()){
                   bw.write(line);
               }else{
                   bw.write(A.getAdminID() + ":" + A.getLastName() + ":" + A.getGender() + ":" + A.getAddress() + ":" + A.getAccessLevel() + ":" + A.getDepartment() + ":" + A.getHireDate() + ":" + A.getAdminType());
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
             Files.delete(myFile6);
             Files.move(temFile6,myFile6,StandardCopyOption.REPLACE_EXISTING);
           }catch(IOException e){
               e.printStackTrace();
               return false;
           }
         return updated;
    }

    @Override
    public ArrayList<Administrator> getAll() {
        ArrayList<Administrator> AList=new ArrayList<>();
        Path myFile6=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Admin.txt");
        try(BufferedReader br=Files.newBufferedReader(myFile6,StandardCharsets.UTF_8);){
             String line;
           while((line=br.readLine())!=null){
              String[] s=line.split(":");
              int AID=Integer.valueOf(s[0]);
              String lastName=s[1];
              String gender=s[2];
              String address=s[3]; 
              String accessLevel=s[4];
              String department=s[5];
              Date hireDate=Date.valueOf(s[6]);
              String adminType=s[7];
              Administrator A=new Administrator(AID, lastName, gender, address, accessLevel, department, hireDate, adminType);
              AList.add(A);              
           }
          return AList;
       }catch(Exception e){
           return AList;
       }
    } 
}
    
    
 

