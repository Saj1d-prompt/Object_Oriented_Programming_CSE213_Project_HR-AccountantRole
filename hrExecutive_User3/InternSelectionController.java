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
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class InternSelectionController implements Initializable {

    @FXML
    private TextField internNameTextField;
    @FXML
    private TextField internIDTextField;
    @FXML
    private TextField internContactNumTextField;
    @FXML
    private ComboBox<String> uniNameComboBox;
    @FXML
    private ComboBox<String> recruitedDeptComboBox;
    @FXML
    private RadioButton isPaidRadioButton;
    @FXML
    private RadioButton isNonPaidRadioButton;
    @FXML
    private DatePicker recruitedDatePicker;

    ArrayList<Intern> internList;

    ToggleGroup tg;

    Alert alert;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        uniNameComboBox.getItems().addAll("IUB", "NSU", "BracU", "UIU", "AUST", "DU");
        recruitedDeptComboBox.getItems().addAll("Manufacturing Machine Operator", "Accountant",
                "HR executive", "Sales Officer", "Production Manager");

        internList = new ArrayList();

        tg = new ToggleGroup();

        isPaidRadioButton.setToggleGroup(tg);
        isNonPaidRadioButton.setToggleGroup(tg);

    }

    private Boolean radioButtonIsSelected() {
        Boolean select = false;
        if (isPaidRadioButton.isSelected() || isNonPaidRadioButton.isSelected()) {

            select = true;

        }
        return select;

    }

    private String selectRadioButton() {
        String status = "";

        if (isNonPaidRadioButton.isSelected()) {

            status = "Non-Paid";

        }

        if (isPaidRadioButton.isSelected()) {

            status = "Paid";

        }
        return status;
    }

    @FXML
    private void hireInternOnMouseClick(ActionEvent event) throws IOException {
        
        if (internNameTextField.getText().isEmpty() || internIDTextField.getText().isEmpty()
                || internContactNumTextField.getText().isEmpty() || uniNameComboBox.getValue() == null || recruitedDeptComboBox.getValue() == null
                || radioButtonIsSelected().equals(false) || recruitedDatePicker.getValue().toString().isEmpty()) {

            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert");
            alert.setContentText("Please give proper Information");
            alert.setHeaderText(null);
            alert.showAndWait();
        } 
        else {
                Intern intern = new Intern(internNameTextField.getText(),uniNameComboBox.getValue(),recruitedDeptComboBox.getValue(),selectRadioButton(),
                        Integer.parseInt(internIDTextField.getText()),Integer.parseInt(internContactNumTextField.getText()),
                        recruitedDatePicker.getValue());
                
                HRExecutive.addInterntoList(intern, "InternObject.bin");
                
                
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setContentText("Intern Successfully Added.");
                alert.setHeaderText(null);
                alert.showAndWait();


        }

    }

    @FXML
    private void showInternListButtonOnMouseClick(ActionEvent event) throws IOException {
        
        
        Parent ViewParent = FXMLLoader.load(getClass().getResource("internList.fxml"));
        Scene newScene = new Scene(ViewParent);

        Stage newWindow  = new Stage();
        
        newWindow.setTitle("Intern List");
        newWindow.setScene(newScene);
        newWindow.show();
    }

}
