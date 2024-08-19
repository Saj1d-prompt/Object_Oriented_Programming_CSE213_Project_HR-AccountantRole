/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package accountant_User4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class BudgetAllocationController implements Initializable {

    @FXML
    private ComboBox<String> departmentComboBox;
    @FXML
    private ComboBox<String> budgetTypeComboBox;
    @FXML
    private DatePicker allocationDatePicker;
    @FXML
    private TextField amountTextField;
    
    Alert alert;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        departmentComboBox.getItems().addAll("Manufacturing Department", "Accountant Department",
                "HR Department", "Sales Department", "Production Department");
        
        budgetTypeComboBox.getItems().addAll("Supplies Budget","Capital Budget","Operating Budget","Material Budget","Production Cost Budget","Meeting Cost Budget");
        
        
    }    

    @FXML
    private void allocateBudgetOnMouseClick(ActionEvent event) throws IOException {
        if(departmentComboBox.getValue().equals(null) || budgetTypeComboBox.getValue().equals(null) || 
                allocationDatePicker.getValue().toString().isEmpty() || amountTextField.getText().isEmpty() ){
            
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert");
            alert.setContentText("Please give proper Information");
            alert.setHeaderText(null);
            alert.showAndWait();

        }
        else{
            Budget budget = new Budget(departmentComboBox.getValue(),budgetTypeComboBox.getValue(),
                    Integer.parseInt(amountTextField.getText()),allocationDatePicker.getValue());
            
            Accountant.storeBudgetDataToFile(budget, "BudgetDataFile.bin");
            
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setContentText("Data Saved Successfully.");
            alert.setHeaderText(null);
            alert.showAndWait();
            
            departmentComboBox.setValue(null);
            budgetTypeComboBox.setValue(null);
            allocationDatePicker.setValue(null);
            amountTextField.clear();
        
        }
    }

    @FXML
    private void checkBudgetListOnMouseClick(ActionEvent event) throws IOException {
        
        Parent ViewParent = FXMLLoader.load(getClass().getResource("BudgetAllocationTableView.fxml"));
        Scene newScene = new Scene(ViewParent);

        Stage newWindow  = new Stage();
        
        newWindow.setTitle(null);
        newWindow.setScene(newScene);
        newWindow.show();
    }
    
}
