/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accountant_User4;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Dell
 */
public class Budget implements Serializable{
    
    private String department,budgetType;
    private int amount;
    private LocalDate date;

    public Budget() {
    }

    public Budget(String department, String budgetType, int amount, LocalDate date) {
        this.department = department;
        this.budgetType = budgetType;
        this.amount = amount;
        this.date = date;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBudgetType() {
        return budgetType;
    }

    public void setBudgetType(String budgetType) {
        this.budgetType = budgetType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Budget{" + "department=" + department + ", budgetType=" + budgetType + ", amount=" + amount + ", date=" + date + '}';
    }
    
    
    
}
