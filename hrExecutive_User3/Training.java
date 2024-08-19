/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrExecutive_User3;

import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class Training implements Serializable{
    private int id,number;
    private String name,dept,training;

    public Training() {
    }

    public Training(int id, int number, String name, String dept, String training) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.dept = dept;
        this.training = training;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }
    
}
