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
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AccountantDashBoardController implements Initializable {

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
    private void employeeSalaryDeclarationSceneOnMouseClicked(ActionEvent event) throws IOException {
        changeScene("SalaryDeclaration.fxml");
    }

    @FXML
    private void internSalaryDeclarationSceneOnMouseClicked(ActionEvent event) throws IOException {
        changeScene("SalaryToIntern.fxml");
    }

    @FXML
    private void updateSalarySceneOnMouseClicked(ActionEvent event) throws IOException {
        changeScene("UpdateSalary.fxml");
    }

    @FXML
    private void taxPaymentSceneOnMouseClicked(ActionEvent event) throws IOException {
        changeScene("TaxPayment.fxml");
    }
    
    @FXML
    private void budgetAllocationSceneOnMouseClicked(ActionEvent event) throws IOException {
        changeScene("BudgetAllocation.fxml");
    }

    @FXML
    private void feedbackToHRSceneOnMouseClicked(ActionEvent event) throws IOException {
        changeScene("FeedBackToHR.fxml");
    }
    
    @FXML
    private void expenseReimbursementSceneOnMouseClicked(ActionEvent event) throws IOException {
        changeScene("ExpenseReimbursementRecord.fxml");
    }

    @FXML
    private void monthlyIncomeStatementSceneOnMouseClicked(ActionEvent event) throws IOException {
        changeScene("MonthlyIncomeStatementReport.fxml");
    }
    
    public void changeScene(String filename) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(filename));
        borderPane.setCenter(root);

    }

    @FXML
    private void logOutButtonOnMouseClicked(ActionEvent event) {
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
