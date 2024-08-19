/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hrExecutive_User3;

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
public class SalaryIncrementationController implements Initializable {

    @FXML
    private TextField employeeNameTextField;
    @FXML
    private TextField employeeIDTextField;
    @FXML
    private ComboBox<String> deptComboBox;
    @FXML
    private ComboBox<String> incrementPercentComboBox;
    
    Alert alert;
    Incrementation incrementVals;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        deptComboBox.getItems().addAll("Manufacturing Machine Operator","Accountant", 
                "HR executive", "Sales Officer", "Production Manager");
        
        incrementPercentComboBox.getItems().addAll("1","2","3","4","5",
                "6","7","8","9","10");
        
        
        

    }    

    @FXML
    private void confirmIncrementationButtonOnMouseCkick(ActionEvent event) throws IOException {
        if (employeeNameTextField.getText().isEmpty() || employeeIDTextField.getText().isEmpty() || deptComboBox.getValue() == null || incrementPercentComboBox.getValue() == null ){
            
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert");
            alert.setContentText("Please give proper Information");
            alert.setHeaderText(null);
            alert.showAndWait();
        
        }else{
            incrementVals = new Incrementation(employeeNameTextField.getText(),deptComboBox.getValue(),
                    Integer.parseInt(employeeIDTextField.getText()),Integer.parseInt(incrementPercentComboBox.getValue()));
            
            HRExecutive.addSalaryIncrementDataToList(incrementVals, "SalaryIncrementObj.bin");
            
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setContentText("Data Successfully Added.");
            alert.setHeaderText(null);
            alert.showAndWait();
            
            employeeNameTextField.clear();
            employeeIDTextField.clear();
            deptComboBox.setValue(null);
            incrementPercentComboBox.setValue(null);
        }
        
    }


    

    @FXML
    private void incrementationListButtonOnMouseCkick(ActionEvent event) throws IOException {
        Parent ViewParent = FXMLLoader.load(getClass().getResource("SalaryIncrementData.fxml"));
        Scene newScene = new Scene(ViewParent);

        Stage newWindow  = new Stage();
        
        newWindow.setTitle("Intern List");
        newWindow.setScene(newScene);
        newWindow.show();
    }
    
}
