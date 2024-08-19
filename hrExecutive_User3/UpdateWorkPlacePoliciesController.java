/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hrExecutive_User3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class UpdateWorkPlacePoliciesController implements Initializable {

    @FXML
    private TextArea policyTextArea;
    
    Policy policy;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        policy = new Policy();
        String policyText;
        policyText = policy.loadPolicy();
        policyTextArea.setText(policyText);
        
    }    

    @FXML
    private void updatePolicyButtonOnMouseClick(ActionEvent event) throws IOException {
        String policyText = policyTextArea.getText();
        policy.savePolicy(policyText);
    }

    @FXML
    private void loadPolicyButtonOnMouseClick(ActionEvent event) throws IOException {
        String policyText = policy.loadPolicy();
        policyTextArea.setText(policyText);
    }
    
}
