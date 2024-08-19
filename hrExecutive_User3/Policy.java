/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrExecutive_User3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.scene.control.Alert;

/**
 *
 * @author Dell
 */
public class Policy {
    
    File policy = new File("PolicyFile.bin");
    Alert alert;
    
    private void showAlert(String message, Alert.AlertType alertType) {
        alert = new Alert(alertType);
        alert.setTitle("Policy Update");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
        public void savePolicy(String policyText) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(policy))) {
            oos.writeObject(policyText);
            showAlert("Policy saved successfully.", Alert.AlertType.INFORMATION);
        } catch (IOException e) {
            showAlert("Error saving policy.", Alert.AlertType.ERROR);
        }
    }

    public String loadPolicy() {
        String policyText = "";

        if (policy.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(policy))) {
                policyText = (String) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                showAlert("Error loading policy.", Alert.AlertType.ERROR);
            }
        } else {
            showAlert("Policy file not found.", Alert.AlertType.WARNING);
        }

        return policyText;
    }
    

}
