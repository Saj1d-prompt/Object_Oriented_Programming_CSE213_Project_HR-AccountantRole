/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accountant_User4;

import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class TaxPayment implements Serializable{
    private int profitAmount,taxPercent;
    private float totalPayable;
    private String status;

    public TaxPayment(int profitAmount, int taxPercent, float totalPayable, String status) {
        this.profitAmount = profitAmount;
        this.taxPercent = taxPercent;
        this.totalPayable = totalPayable;
        this.status = status;
    }
    
    

    public TaxPayment() {
    }

    public int getProfitAmount() {
        return profitAmount;
    }

    public void setProfitAmount(int profitAmount) {
        this.profitAmount = profitAmount;
    }

    public int getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(int taxPercent) {
        this.taxPercent = taxPercent;
    }

    public float getTotalPayable() {
        return totalPayable;
    }

    public void setTotalPayable(int totalPayable) {
        this.totalPayable = totalPayable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TaxPayment{" + "profitAmount=" + profitAmount + ", taxPercent=" + taxPercent + ", totalPayable=" + totalPayable + ", status=" + status + '}';
    }
    
    public float calculateTax(int profitAmount,int taxPercent){
        
        return (profitAmount * (taxPercent/100));
    
    }
}
