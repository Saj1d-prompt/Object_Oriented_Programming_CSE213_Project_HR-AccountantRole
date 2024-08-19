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
public class Intern implements Serializable{
    private String internName,uniName,recruitedDept,status;
    private int internID,internContactNum;
    private LocalDate recruitedDate;

    public Intern() {
    }
    
    public Intern(String internName, String uniName, String recruitedDept, String status, int internID, int internContactNum, LocalDate recruitedDate) {
        this.internName = internName;
        this.uniName = uniName;
        this.recruitedDept = recruitedDept;
        this.status = status;
        this.internID = internID;
        this.internContactNum = internContactNum;
        this.recruitedDate = recruitedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInternName() {
        return internName;
    }

    public void setInternName(String internName) {
        this.internName = internName;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getRecruitedDept() {
        return recruitedDept;
    }

    public void setRecruitedDept(String recruitedDept) {
        this.recruitedDept = recruitedDept;
    }

    public int getInternID() {
        return internID;
    }

    public void setInternID(int internID) {
        this.internID = internID;
    }

    public int getInternContactNum() {
        return internContactNum;
    }

    public void setInternContactNum(int internContactNum) {
        this.internContactNum = internContactNum;
    }

    public LocalDate getRecruitedDate() {
        return recruitedDate;
    }

    public void setRecruitedDate(LocalDate recruitedDate) {
        this.recruitedDate = recruitedDate;
    }

    @Override
    public String toString() {
        return "Intern{" + "internName=" + internName + ", uniName=" + uniName + ", recruitedDept=" + recruitedDept + ", status=" + status + ", internID=" + internID + ", internContactNum=" + internContactNum + ", recruitedDate=" + recruitedDate + '}';
    }


    
    
}
