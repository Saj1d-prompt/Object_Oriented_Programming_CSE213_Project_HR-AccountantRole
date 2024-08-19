/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package accountant_User4;

import hrExecutive_User3.HRExecutive;
import hrExecutive_User3.Intern;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class SalaryToInternController implements Initializable {

    @FXML
    private TextField internNameTextField;
    @FXML
    private TextField ConNumberTextField;
    @FXML
    private TextField recruitDeptTextField;
    @FXML
    private TextField statusTextField;
    @FXML
    private ComboBox<Integer> internIDComboBox;
    @FXML
    private TextField salaryTextField;
    
    Alert alert;
    Salary salary;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList <Intern> intern = FXCollections.observableList(HRExecutive.loadInternList("InternObject.bin"));
        
        for (Intern i : intern){
            if (i.getStatus().equals("Paid")){
                internIDComboBox.getItems().addAll(i.getInternID());
            } 
        }
    }    

    @FXML
    private void internIDSelectionOnMouseClick(ActionEvent event) {
        
        ObservableList <Intern> intern = FXCollections.observableList(HRExecutive.loadInternList("InternObject.bin"));
        
        for (Intern in : intern){
            
            if (in.getInternID() == internIDComboBox.getValue()){
                internNameTextField.setText(in.getInternName());
                ConNumberTextField.setText(String.valueOf(in.getInternContactNum()));
                recruitDeptTextField.setText(in.getRecruitedDept());
                statusTextField.setText(in.getStatus());
                
            }
            
            
        
        }
    }

    @FXML
    private void declareSalaryOnMouseClick(ActionEvent event) throws IOException {
        
        if(internIDComboBox.getValue() == null || salaryTextField.getText().isEmpty()){
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert");
            alert.setContentText("Please select Intern ID or Declare Salary");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
            salary = new Salary(internIDComboBox.getValue(), Integer.parseInt(ConNumberTextField.getText()),
                    Integer.parseInt(salaryTextField.getText()),internNameTextField.getText(),statusTextField.getText());
            
            Accountant.storeSalaryDeclarationDataToFile(salary, "InternSalaryData.bin");
            
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setContentText("Salary Declared Successfully!");
            alert.setHeaderText(null);
            alert.showAndWait();
    
        }
        
    }
    
}
