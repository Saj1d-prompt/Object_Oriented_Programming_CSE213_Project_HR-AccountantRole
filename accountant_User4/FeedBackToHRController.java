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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class FeedBackToHRController implements Initializable {

    @FXML
    private TextField employeeNameTextField;
    @FXML
    private TextField employeeIDTextField;
    @FXML
    private TextField contactNumberTextField;
    @FXML
    private TextArea feedbackTextArea;
    @FXML
    private RadioButton concernRadioButton;
    @FXML
    private RadioButton suggestionsRadioButton;
    @FXML
    private RadioButton praiseRadioButton;
    
    ToggleGroup tg;
    Alert alert;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tg = new ToggleGroup();
        
        concernRadioButton.setToggleGroup(tg);
        suggestionsRadioButton.setToggleGroup(tg);
        praiseRadioButton.setToggleGroup(tg);
        
        
        // TODO
    }
    
    private Boolean selectRadioButton(){
        Boolean selection = false;
        if(concernRadioButton.isSelected() || suggestionsRadioButton.isSelected() || praiseRadioButton.isSelected()){
            selection = true;
        }
        return selection;
    }
    
    private String choiceOfRadioButton(){
        
        String choose = "";
        
        if(concernRadioButton.isSelected()){
            
            choose = "Concern";
        
        }
        if(suggestionsRadioButton.isSelected()){
            
            choose = "Suggestion";

        }
        if(praiseRadioButton.isSelected()){
            
            choose = "Praise";
        
        }
        return choose;
    
    }

    @FXML
    private void sendFeedbackOnMouseClick(ActionEvent event) throws IOException {
        
        if (employeeNameTextField.getText().isEmpty() || employeeIDTextField.getText().isEmpty() || 
                contactNumberTextField.getText().isEmpty() || feedbackTextArea.getText().isEmpty() ||
                selectRadioButton().equals(false)){
            
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert");
            alert.setContentText("Please give proper Information");
            alert.setHeaderText(null);
            alert.showAndWait();
        
        }
        else{
            FeedBack feed = new FeedBack(employeeNameTextField.getText(),feedbackTextArea.getText(),choiceOfRadioButton(),
                    Integer.parseInt(employeeIDTextField.getText()),Integer.parseInt(contactNumberTextField.getText()));
            
            Accountant.storeFeedbackToFile(feed,"FeedBackFile.bin");
            
             alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Information");
             alert.setContentText("Feedback is submitted Succesfully.");
             alert.setHeaderText(null);
             alert.showAndWait();
            
            
        }
    }
    
}
