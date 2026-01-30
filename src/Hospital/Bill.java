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
public class Bill {
    
    private int billID;
    private String patient;
    private String services;
    private Double madications;
    private Double consultationFees;
    private Double testCharges;
    private Double totalAmount;
    private String paymentStatus;
    private Double insuranceCoverage;
    private Date dueDate;

    public Bill() {
    }

    public Bill(int billID, String patient, String services, Double madications, Double consultationFees, Double testCharges, Double totalAmount, String paymentStatus, Double insuranceCoverage, Date dueDate) {
        this.billID = billID;
        this.patient = patient;
        this.services = services;
        this.madications = madications;
        this.consultationFees = consultationFees;
        this.testCharges = testCharges;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.insuranceCoverage = insuranceCoverage;
        this.dueDate = dueDate;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public Double getMadications() {
        return madications;
    }

    public void setMadications(Double madications) {
        this.madications = madications;
    }

    public Double getConsultationFees() {
        return consultationFees;
    }

    public void setConsultationFees(Double consultationFees) {
        this.consultationFees = consultationFees;
    }

    public Double getTestCharges() {
        return testCharges;
    }

    public void setTestCharges(Double testCharges) {
        this.testCharges = testCharges;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Double getInsuranceCoverage() {
        return insuranceCoverage;
    }

    public void setInsuranceCoverage(Double insuranceCoverage) {
        this.insuranceCoverage = insuranceCoverage;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    
}
