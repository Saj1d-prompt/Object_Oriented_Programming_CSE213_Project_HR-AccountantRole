/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrExecutive_User3;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Dell
 */
public class Employee implements Serializable{
    
    private int employeeID,employeeContactNumber;
    private String employeeName,assignedDept;
    private LocalDate assignedDate;

    public Employee() {
    }

    public Employee(int employeeID, int employeeContactNumber, String employeeName, String assignedDept, LocalDate assignedDate) {
        this.employeeID = employeeID;
        this.employeeContactNumber = employeeContactNumber;
        this.employeeName = employeeName;
        this.assignedDept = assignedDept;
        this.assignedDate = assignedDate;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getEmployeeContactNumber() {
        return employeeContactNumber;
    }

    public void setEmployeeContactNumber(int employeeContactNumber) {
        this.employeeContactNumber = employeeContactNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getAssignedDept() {
        return assignedDept;
    }

    public void setAssignedDept(String assignedDept) {
        this.assignedDept = assignedDept;
    }

    public LocalDate getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(LocalDate assignedDate) {
        this.assignedDate = assignedDate;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeID=" + employeeID + ", employeeContactNumber=" + employeeContactNumber + ", employeeName=" + employeeName + ", assignedDept=" + assignedDept + ", assignedDate=" + assignedDate + '}';
    }
    
    
}
