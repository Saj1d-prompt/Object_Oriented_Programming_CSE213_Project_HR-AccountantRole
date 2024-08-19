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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class TaxPaymentController implements Initializable {

    @FXML
    private TextField profitAmountTextField;
    @FXML
    private TextField taxOercentTextField;
    @FXML
    private TextField totalTaxTextField;
    @FXML
    private RadioButton bkashRadioButton;
    @FXML
    private RadioButton rocketRadioButton;
    @FXML
    private RadioButton nagadRadioButton;
    
    ToggleGroup tg;
    
    Alert alert;
    
    TaxPayment tax;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tg = new ToggleGroup();
        
        bkashRadioButton.setToggleGroup(tg);
        rocketRadioButton.setToggleGroup(tg);
        nagadRadioButton.setToggleGroup(tg);
        
        // TODO
    }    

    @FXML
    private void calculateTaxButtonOnMouseClick(ActionEvent event) throws IOException {
        
        if(profitAmountTextField.getText().isEmpty() || taxOercentTextField.getText().isEmpty()){
            
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert");
            alert.setContentText("Please give proper Information");
            alert.setHeaderText(null);
            alert.showAndWait();

        }
        else{
            int profit = Integer.parseInt(profitAmountTextField.getText());
            int percent = Integer.parseInt(taxOercentTextField.getText());
            
            float total = (float) (profit + (profit * (percent/100f)));
            
            totalTaxTextField.setText(String.valueOf(total));
            
//            tax = new TaxPayment(profit, percent,
//                    total, selectRadioButton());
//            
//            Accountant.storeTaxPaymentDataToFile(tax, "TaxFile.bin");
            
            
        
        }
    }

    @FXML
    private void payTaxButtonOnMouseClick(ActionEvent event) throws IOException {
        
        if(radioButtonIsSelected().equals(false)){
            
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert");
            alert.setContentText("Please Select Payment Method");
            alert.setHeaderText(null);
            alert.showAndWait();

        }else{
            
            tax = new TaxPayment(Integer.parseInt(profitAmountTextField.getText()), Integer.parseInt(taxOercentTextField.getText()),
                    Float.parseFloat(totalTaxTextField.getText()), selectRadioButton());
            
            Accountant.storeTaxPaymentDataToFile(tax, "TaxFile.bin");
            
            alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setContentText("Payment Completed Successfully.");
                alert.setHeaderText(null);
                alert.showAndWait();
        
        
        }
        
    }
    
    private Boolean radioButtonIsSelected() {
        Boolean select = false;
        if (bkashRadioButton.isSelected() || rocketRadioButton.isSelected() || nagadRadioButton.isSelected()) {

            select = true;

        }
        return select;

    }
    
     private String selectRadioButton() {
        String status = "";

        if (bkashRadioButton.isSelected()) {

            status = "Bkash";

        }

        if (rocketRadioButton.isSelected()) {

            status = "Rocket";

        }
        if(nagadRadioButton.isSelected()){
            
            status = "Nagad";
        
        }
        return status;
    }

    @FXML
    private void confirmationButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent ViewParent = FXMLLoader.load(getClass().getResource("TaxConfirmationTable.fxml"));
        Scene newScene = new Scene(ViewParent);

        Stage newWindow  = new Stage();
        
        newWindow.setTitle("Intern List");
        newWindow.setScene(newScene);
        newWindow.show();
    }
    
}
