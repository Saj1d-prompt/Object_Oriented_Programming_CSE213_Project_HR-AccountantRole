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
public class Salary implements Serializable{
    private int id, ContactNum, salary;
    private String name, recruitedDept,paymentStatus;

    public Salary() {
    }

    public Salary(int id, int ContactNum, int salary, String name, String recruitedDept, String paymentStatus) {
        this.id = id;
        this.ContactNum = ContactNum;
        this.salary = salary;
        this.name = name;
        this.recruitedDept = recruitedDept;
        this.paymentStatus = paymentStatus;
    }

    public Salary(int id, int ContactNum, int salary, String name, String recruitedDept) {
        this.id = id;
        this.ContactNum = ContactNum;
        this.salary = salary;
        this.name = name;
        this.recruitedDept = recruitedDept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContactNum() {
        return ContactNum;
    }

    public void setContactNum(int ContactNum) {
        this.ContactNum = ContactNum;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecruitedDept() {
        return recruitedDept;
    }

    public void setRecruitedDept(String recruitedDept) {
        this.recruitedDept = recruitedDept;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Salary{" + "id=" + id + ", ContactNum=" + ContactNum + ", salary=" + salary + ", name=" + name + ", recruitedDept=" + recruitedDept + ", paymentStatus=" + paymentStatus + '}';
    }
    
    
    
    
}
