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
public class UpdateSalary implements Serializable{
    
    private int employeeID, incrementedPercentage,oldSalary;
    private float newSalary;
    private String employeeName,dept;
    
    public UpdateSalary() {
    }

    public UpdateSalary(int employeeID, int incrementedPercentage, float newSalary, String employeeName, String dept) {
        this.employeeID = employeeID;
        this.incrementedPercentage = incrementedPercentage;
        this.newSalary = newSalary;
        this.employeeName = employeeName;
        this.dept = dept;
    }

    public UpdateSalary(int employeeID, int incrementedPercentage, float newSalary, int oldSalary, String employeeName, String dept) {
        this.employeeID = employeeID;
        this.incrementedPercentage = incrementedPercentage;
        this.newSalary = newSalary;
        this.oldSalary = oldSalary;
        this.employeeName = employeeName;
        this.dept = dept;
    }
    

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public long getIncrementedPercentage() {
        return incrementedPercentage;
    }

    public void setIncrementedPercentage(int incrementedPercentage) {
        this.incrementedPercentage = incrementedPercentage;
    }

    public float getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(int newSalary) {
        this.newSalary = newSalary;
    }

    public int getOldSalary() {
        return oldSalary;
    }

    public void setOldSalary(int oldSalary) {
        this.oldSalary = oldSalary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
