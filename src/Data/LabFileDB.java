/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;
import Hospital.Lab;
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
public class LabFileDB implements ILab{
    
    private File labFile;

    public LabFileDB() {
        
        labFile=new File("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Lab.txt");
    }

    @Override
    public boolean addTest(Lab L) {
        Path File7=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Lab.txt");
        try(BufferedWriter bw=Files.newBufferedWriter(File7,StandardCharsets.UTF_8,StandardOpenOption.APPEND);){
            bw.write(L.getTestNo()+":");
            bw.write(L.getTest()+":");
            bw.write(L.getTestResult()+"\n");
            bw.close();
         return true;
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
           return false;
       }
    }

    @Override
    public ArrayList<Lab> Display() {
        ArrayList<Lab> LList=new ArrayList<>();
        Path myFile7=Paths.get("E:/Software Engineering/Semester 2/Assignments/PR/MediCareHospital/Lab.txt");
        try(BufferedReader br=Files.newBufferedReader(myFile7,StandardCharsets.UTF_8);){
             String line;
           while((line=br.readLine())!=null){
              String[] s=line.split(":");
              int LID=Integer.valueOf(s[0]);
              String test=s[1];
              String testResult=s[2];
              
              Lab L=new Lab(LID, test, testResult);
              LList.add(L);              
           }
          return LList;
       }catch(Exception e){
           return LList;
       }
    }    
}
