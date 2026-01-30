/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hospital;

/**
 *
 * @author USER
 */
public class Lab extends MedicalRecord {
    
    private int testNo;
    private String test;

    public Lab() {
    }

    public Lab(int testNo, String test, String testResult) {
        super(testResult);
        this.testNo = testNo;
        this.test = test;
    }

    public int getTestNo() {
        return testNo;
    }

    public void setTestNo(int testNo) {
        this.testNo = testNo;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    
    
}
