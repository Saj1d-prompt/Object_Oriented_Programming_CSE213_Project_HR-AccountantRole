/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hrExecutive_User3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class EmployeeSelectionController implements Initializable {

    @FXML
    private TextField applicantNameTextField;
    @FXML
    private TextField applicantIDTextField;
    @FXML
    private TextField applicantContactNumberTextField;
    @FXML
    private ComboBox<String> departmentComboBox;
    @FXML
    private DatePicker assignedDatePicker;

    Employee employee;

    Alert alert;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        departmentComboBox.getItems().addAll("Manufacturing Machine Operator", "Accountant",
                "HR executive", "Sales Officer", "Production Manager");

    }

    @FXML
    private void recruitEmployeeOnMouseClick(ActionEvent event) throws IOException {

        if (applicantNameTextField.getText().isEmpty() || applicantIDTextField.getText().isEmpty()
                || applicantContactNumberTextField.getText().isEmpty()
                || departmentComboBox.getValue() == null || assignedDatePicker.getValue().toString().isEmpty()) {

            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert");
            alert.setContentText("Please give proper Information");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            employee = new Employee(Integer.parseInt(applicantIDTextField.getText()),
                    Integer.parseInt(applicantContactNumberTextField.getText()), applicantNameTextField.getText(),
                    departmentComboBox.getValue(), assignedDatePicker.getValue());

            HRExecutive.addEmployeetoList(employee, "EmployeeObject.bin");

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setContentText("Employee Successfully Added.");
            alert.setHeaderText(null);
            alert.showAndWait();

            applicantNameTextField.clear();
            applicantIDTextField.clear();
            applicantContactNumberTextField.clear();
            departmentComboBox.setValue(null);
            assignedDatePicker.setValue(null);
        }

    }

}
