/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package accountant_User4;

import hrExecutive_User3.Employee;
import hrExecutive_User3.HRExecutive;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class SalaryDeclarationController implements Initializable {

    @FXML
    private ComboBox<Integer> empIDComboBox;
    @FXML
    private TextField empNameTextField;
    @FXML
    private TextField contactNumTextField;
    @FXML
    private TextField recruitedDeptTextField;
    @FXML
    private TextField salaryTextField;
    
    Alert alert;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList <Employee> employee = FXCollections.observableList(HRExecutive.loadEmployeeList("EmployeeObject.bin"));
        
        for (Employee e : employee){
            
            empIDComboBox.getItems().addAll(e.getEmployeeID());
            
        }
        
    }    

    @FXML
    private void declareSalaryButtonOnMouseClick(ActionEvent event) throws IOException {
        
        if(empIDComboBox.getValue() == null || salaryTextField.getText().isEmpty()){
            
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert");
            alert.setContentText("Please select Employee ID or Declare Salary");
            alert.setHeaderText(null);
            alert.showAndWait();
        
        }
        else{
            
            Salary salary = new Salary(empIDComboBox.getValue(),Integer.parseInt(contactNumTextField.getText()),
                Integer.parseInt(salaryTextField.getText()), empNameTextField.getText(), recruitedDeptTextField.getText());
            
            Accountant.storeSalaryDeclarationDataToFile(salary, "EmployeeSalaryData.bin");
            
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setContentText("Salary Declared Successfully!");
            alert.setHeaderText(null);
            alert.showAndWait();
        
        }
        
    }
    @FXML
    private void employeeIDComboBoxOnMouseClick(ActionEvent event) {
        ObservableList <Employee> employee = FXCollections.observableList(HRExecutive.loadEmployeeList("EmployeeObject.bin"));
        for (Employee em : employee){
            
            if (em.getEmployeeID() == empIDComboBox.getValue()){
                empNameTextField.setText(em.getEmployeeName());
                
                contactNumTextField.setText(String.valueOf(em.getEmployeeContactNumber()));
                
                recruitedDeptTextField.setText(em.getAssignedDept());
            }
        
        }
                
    }

    @FXML
    private void employeeListOnMouseClick(ActionEvent event) throws IOException {
        
        Parent ViewParent = FXMLLoader.load(getClass().getResource("EmployeeListWithSalary.fxml"));
        Scene newScene = new Scene(ViewParent);

        Stage newWindow  = new Stage();
        
        newWindow.setTitle("Employee List");
        newWindow.setScene(newScene);
        newWindow.show();
    }
    
    
}
