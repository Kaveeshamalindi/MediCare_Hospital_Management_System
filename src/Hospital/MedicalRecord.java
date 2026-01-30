/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hospital;
import java.sql.Date;

/**
 *
 * @author USER
 */
public class MedicalRecord {
    
    private int recordID;
    private String patient;
    private String doctor; 
    private Date visitDate;
    private String symptoms;
    private String diagnosis;
    private String treatment;
    private String prescription;
    private String testResult;

    public MedicalRecord() {
    }

    public MedicalRecord(int recordID, String patient, String doctor, Date visitDate, String sysptoms, String diagnosis, String treatment, String prescription, String testResult) {
        this.recordID = recordID;
        this.patient = patient;
        this.doctor = doctor;
        this.visitDate = visitDate;
        this.symptoms = sysptoms;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.prescription = prescription;
        this.testResult = testResult;
    }
    
    //Used to create Lab Class Constructor
    public MedicalRecord(String testResult) {
        this.testResult = testResult;
    }
    

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
}
