/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hrExecutive_User3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class HRDashBoardController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Button logOut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void employeeSelectionSceneOnMouseClicked(ActionEvent event) throws IOException {
        changeScene("EmployeeSelection.fxml");
    }

    @FXML
    private void internSelectionSceneOnMouseClicked(ActionEvent event) throws IOException {
        changeScene("InternSelection.fxml");
    }

    @FXML
    private void salaryIncrementationSceneOnMouseClicked(ActionEvent event) throws IOException {
        changeScene("SalaryIncrementation.fxml");
    }
    
    @FXML
    private void internTrainingSceneOnMouseClicked(ActionEvent event) throws IOException {
        changeScene("InternTrainingAllocation.fxml");
    }

    @FXML
    private void employeeRatioSceneOnMouseClicked(ActionEvent event) throws IOException {
        changeScene("EmployeeRatio.fxml");
    }

    @FXML
    private void sortingRecruitmentSceneOnMouseClicked(ActionEvent event) throws IOException {
        changeScene("SortingRecruitment.fxml");
    }

    @FXML
    private void workplacePolicySceneOnMouseClicked(ActionEvent event) throws IOException {
        changeScene("UpdateWorkPlacePolicies.fxml");
    }

    @FXML
    private void feedbackSceneOnMouseClicked(ActionEvent event) throws IOException {
        changeScene("EmployeeFeedBack.fxml");
    }
    
    public void changeScene(String filename) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource(filename));
        borderPane.setCenter(root);

    }

    @FXML
    private void logOutSceneOnMouseClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/mainpkg/LoginSc.fxml"));
            Scene scene = new Scene(root);

            Stage currentStage = (Stage) logOut.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
