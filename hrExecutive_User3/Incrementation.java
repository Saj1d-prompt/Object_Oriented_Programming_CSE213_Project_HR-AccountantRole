
package hrExecutive_User3;

import java.io.Serializable;

public class Incrementation implements Serializable{
    
    private String employeeName,employeeDept;
    private int employeeID,percentOfIncrement;

    public Incrementation() {
    }

    public Incrementation(String employeeName, String employeeDept, int employeeID, int percentOfIncrement) {
        this.employeeName = employeeName;
        this.employeeDept = employeeDept;
        this.employeeID = employeeID;
        this.percentOfIncrement = percentOfIncrement;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDept() {
        return employeeDept;
    }

    public void setEmployeeDept(String employeeDept) {
        this.employeeDept = employeeDept;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getPercentOfIncrement() {
        return percentOfIncrement;
    }

    public void setPercentOfIncrement(int percentOfIncrement) {
        this.percentOfIncrement = percentOfIncrement;
    }

    @Override
    public String toString() {
        return "Incrementation{" + "employeeName=" + employeeName + ", employeeDept=" + employeeDept + ", employeeID=" + employeeID + ", percentOfIncrement=" + percentOfIncrement + '}';
    }
    
}
