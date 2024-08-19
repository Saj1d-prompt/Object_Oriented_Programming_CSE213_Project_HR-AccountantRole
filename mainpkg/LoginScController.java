package mainpkg;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginScController implements Initializable {

    @FXML
    private TextField userIdTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private Button login;
    @FXML
    private Button signupButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBox.getItems().addAll("Retailer", "Manufacturing Machine Operator",
                "Accountant", "HR executive", "Sales Officer",
                 "Raw Material Supplier", "Production Manager", "CEO");
        //defaultIdpass
        userIdTextField.setText("admin");
        passwordTextField.setText("12345678");
    }


    @FXML
    private void loginButtonOnClick(ActionEvent event) throws IOException {
        String userType = userTypeComboBox.getValue();
        if (userType == null) {
            showErrorAlert("Error", "Please select a user type.");
            return;
        }

        String username = userIdTextField.getText();
        String password = passwordTextField.getText();

        boolean isValidLogin = SignUpFile.SignUpFileRead(userType, username, password);

        if (isValidLogin) {

            String userFullName = SignUpFile.FileRead_forUserName(userType, username, password);

            Stage currentStage = (Stage) login.getScene().getWindow();
            if (userType.equals("Retailer")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("User_MainDashboard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            }
            if (userType.equals("Manufacturing Machine Operator")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("User_MainDashboard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            }
            if (userType.equals("Accountant")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/accountant_User4/AccountantDashBoard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            }
            if (userType.equals("HR executive")) {
                SceneChange newScene = new SceneChange();
                newScene.Scenechanger(currentStage, "/hrExecutive_User3/HRDashBoard.fxml");
            }
            if (userType.equals("Sales Officer")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("SalesOfficerDashboard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            }
            if (userType.equals("Raw Material Supplier")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("RawMaterialDashboard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            }
            if (userType.equals("Production Manager")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("User_MainDashboard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            }
            if (userType.equals("CEO")) {
                SceneChange newScene = new SceneChange();
                newScene.Scenechanger(currentStage, "User_MainDashboard.fxml");
            }

        } else {

            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Unable to Login");
            a.setContentText("UserID and Password is Invalid");
            a.showAndWait();

        }
    }

    @FXML
    private void signUpButtonOnClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Sign Up.fxml"));
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) signupButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
