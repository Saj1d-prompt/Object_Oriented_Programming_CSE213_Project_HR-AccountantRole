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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ExpenseReimbursementRecordController implements Initializable {

    @FXML
    private TextField employeeNameTextField;
    @FXML
    private TextField employeeIDTextField;
    @FXML
    private TextField amountTextField;
    @FXML
    private RadioButton payAbleRadioButton;
    @FXML
    private RadioButton notPayableRadioButton;
    @FXML
    private ComboBox<String> deptComboBox;
    @FXML
    private ComboBox<String> expenseTypeComboBox;
    
    ToggleGroup tg;
    
    Alert alert;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        deptComboBox.getItems().addAll("Manufacturing Machine Operator", "Accountant",
                "HR executive", "Sales Officer", "Production Manager");
        
        expenseTypeComboBox.getItems().addAll("Training and Seminars","Client Meetings","Supplies Expense","Shipping Cost");
        
        tg = new ToggleGroup();
        payAbleRadioButton.setToggleGroup(tg);
        notPayableRadioButton.setToggleGroup(tg);
    }    

    @FXML
    private void saveDataButtonOnMouseClick(ActionEvent event) throws IOException {
        if(employeeNameTextField.getText().isEmpty() || employeeIDTextField.getText().isEmpty() || amountTextField.getText().isEmpty() ||
                deptComboBox.getValue() == null || expenseTypeComboBox.getValue() == null || radioButtonIsSelected().equals(false)){
            
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert");
            alert.setContentText("Please give proper Information");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else{
            Reimbursement reimburse = new Reimbursement(employeeNameTextField.getText(),deptComboBox.getValue(),selectRadioButton(),
                    expenseTypeComboBox.getValue(),Integer.parseInt(employeeIDTextField.getText()),Integer.parseInt(amountTextField.getText()));
            
            Accountant.storeReimbersementDataToFile(reimburse, "ReimbersementFile.bin");
            
            alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setContentText("Data Saved Successfully.");
                alert.setHeaderText(null);
                alert.showAndWait();

        
        }
    }

    @FXML
    private void reimbersementRecordListOnMouseClick(ActionEvent event) throws IOException {
        Parent ViewParent = FXMLLoader.load(getClass().getResource("ReimbursementList.fxml"));
        Scene newScene = new Scene(ViewParent);

        Stage newWindow  = new Stage();
        
        newWindow.setTitle(null);
        newWindow.setScene(newScene);
        newWindow.show();
    }
    
    private String selectRadioButton() {
        String status = "";

        if (payAbleRadioButton.isSelected()) {

            status = "Payable";

        }

        if (notPayableRadioButton.isSelected()) {

            status = "Not Payable";

        }
        return status;
    }
    
     private Boolean radioButtonIsSelected() {
        Boolean select = false;
        if (payAbleRadioButton.isSelected() || notPayableRadioButton.isSelected()) {

            select = true;

        }
        return select;

    }
}
