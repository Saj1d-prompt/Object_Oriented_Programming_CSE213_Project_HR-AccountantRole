
package accountant_User4;

import java.io.Serializable;

public class FeedBack implements Serializable{
    
    private String employeeName,feedback,typeOfFB;
    private int employeeID,contactNum;

    public FeedBack() {
    }

    public FeedBack(String employeeName, String feedback, String typeOfFB, int employeeID, int contactNum) {
        this.employeeName = employeeName;
        this.feedback = feedback;
        this.typeOfFB = typeOfFB;
        this.employeeID = employeeID;
        this.contactNum = contactNum;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getTypeOfFB() {
        return typeOfFB;
    }

    public void setTypeOfFB(String typeOfFB) {
        this.typeOfFB = typeOfFB;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getContactNum() {
        return contactNum;
    }

    public void setContactNum(int contactNum) {
        this.contactNum = contactNum;
    }

    @Override
    public String toString() {
        return "FeedBack{" + "employeeName=" + employeeName + ", feedback=" + feedback + ", typeOfFB=" + typeOfFB + ", employeeID=" + employeeID + ", contactNum=" + contactNum + '}';
    }
}
