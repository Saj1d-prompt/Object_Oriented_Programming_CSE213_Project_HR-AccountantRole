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
public class IncomeStatement implements Serializable{
    
    private int income,expense,withdrawal,totalProfit;

    public IncomeStatement() {
    }

    public IncomeStatement(int income, int expense, int withdrawal, int totalProfit) {
        this.income = income;
        this.expense = expense;
        this.withdrawal = withdrawal;
        this.totalProfit = totalProfit;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public int getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(int withdrawal) {
        this.withdrawal = withdrawal;
    }

    public int getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(int totalProfit) {
        this.totalProfit = totalProfit;
    }
    
    public int calculateIncomeStatement(int income, int expense, int withdrawal){
        
        int totalProfit = income - expense - withdrawal;
        return totalProfit;
        
    }
    
    
}
