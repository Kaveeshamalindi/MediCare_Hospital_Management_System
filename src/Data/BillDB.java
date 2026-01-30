/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;
import java.util.ArrayList;
import Hospital.Bill;

/**
 *
 * @author USER
 */
public class BillDB {
    
    private ArrayList<Bill> billList;

    public BillDB() {
        
        billList = new ArrayList<>();
    }
    
    public boolean generate(Bill b){
        //boolean flag = teacherList.add(t);
        return billList.add(b);
    }
    
}
