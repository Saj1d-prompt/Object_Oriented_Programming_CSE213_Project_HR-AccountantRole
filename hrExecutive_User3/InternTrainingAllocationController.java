/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hrExecutive_User3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class InternTrainingAllocationController implements Initializable {

    @FXML
    private ComboBox<Integer> internIDComboBox;
    @FXML
    private Label nameLabel;
    @FXML
    private Label deptLabel;
    @FXML
    private Label numberLabel;
    @FXML
    private ComboBox<String> trainingComboBox;
    
    Alert alert;
    
    ObservableList <Intern> intern = FXCollections.observableList(HRExecutive.loadInternList("InternObject.bin"));
       

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //ObservableList <Intern> intern = FXCollections.observableList(HRExecutive.loadInternList("InternObject.bin"));
        for(Intern i : intern){
           internIDComboBox.getItems().addAll(i.getInternID());
        }
       
       
//        internIDComboBox.setOnAction(event ->{
//            String recruitedDept = deptLabel.getText();
//       
//       
//       
//            if(recruitedDept != null){
//           
//                switch(recruitedDept){
//                    case "HR Executive":
//                        trainingComboBox.getItems().setAll("Human Resource Information System","Employee Relations","Mentoring");
//                        break;
//                    case "Accountant":
//                        trainingComboBox.getItems().addAll("Communication Skill","Financial Reporting Development","Invoicing Skill");
//                        break;
//                    case "Manufacturing Machine Operator":
//                        trainingComboBox.getItems().addAll("Quality Control Development","Team Work Skill","Lean Manufacturing");
//                        break;
//                        
//                    case "Sales Officer":
//                        trainingComboBox.getItems().addAll("Customer Service Skill","Analysis Skill","Sales Processing");
//                        break;
//                    case "Production Manager":
//                        trainingComboBox.getItems().addAll("Production Management","Equipment Maintenance","Leadership");
//                        break;
//                }
//            }
//        });
    }
    @FXML
    private void allocateTrainingButtonOnMouseClick(ActionEvent event) {
        if(internIDComboBox.getValue().equals(null) || trainingComboBox.getValue().equals(null)){
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert");
            alert.setContentText("Please give proper Information");
            alert.setHeaderText(null);
            alert.showAndWait();
        
        }else{
            Training train = new Training(internIDComboBox.getValue(),Integer.parseInt(numberLabel.getText()),nameLabel.getText(),
                    deptLabel.getText(),trainingComboBox.getValue());
            
            HRExecutive.addTrainingDataToList(train, "AllocateTraining.bin");
            
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setContentText("Intern Successfully Added.");
            alert.setHeaderText(null);
            alert.showAndWait();
            
            internIDComboBox.setValue(null);
            nameLabel.setText(null);
            deptLabel.setText(null);
            numberLabel.setText(null);
            trainingComboBox.setValue(null);
            
            
            
        
        }
    }

    @FXML
    private void trainingListButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent ViewParent = FXMLLoader.load(getClass().getResource("TrainingInternList.fxml"));
        Scene newScene = new Scene(ViewParent);

        Stage newWindow  = new Stage();
        
        newWindow.setTitle("Intern List");
        newWindow.setScene(newScene);
        newWindow.show();
    }

    @FXML
    private void internIDComboBoxOnMouseClick(ActionEvent event) {
        for(Intern i : intern){
            
            if(i.getInternID() == internIDComboBox.getValue()){
                
                nameLabel.setText(i.getInternName());
                numberLabel.setText(String.valueOf(i.getInternContactNum()));
                deptLabel.setText(i.getRecruitedDept());
            
            }
        }
        
        if(deptLabel.getText().equals("HR executive")){
            trainingComboBox.getItems().addAll("Human Resource Information System","Employee Relations","Mentoring");
        }
        if(deptLabel.getText().equals("Accountant")){
            trainingComboBox.getItems().addAll("Communication Skill","Financial Reporting Development","Invoicing Skill");
        }
        if(deptLabel.getText().equals("Manufacturing Machine Operator")){
            trainingComboBox.getItems().addAll("Quality Control Development","Team Work Skill","Lean Manufacturing");
        }
        if(deptLabel.getText().equals("Sales Officer")){
            trainingComboBox.getItems().addAll("Customer Service Skill","Analysis Skill","Sales Processing");
        }
        if(deptLabel.getText().equals("Production Manager")){
            trainingComboBox.getItems().addAll("Production Management","Equipment Maintenance","Leadership");
        }
            
        
            
       // internIDComboBox.setOnAction(event ->{
        //String recruitedDept = deptLabel.getText();
       
       
       
//        if(deptLabel.getText() != null){
//           
//            switch(deptLabel.getText()){
//                case "HR Executive":
//                    trainingComboBox.getItems().setAll("Human Resource Information System","Employee Relations","Mentoring");
//                    break;
//                case "Accountant":
//                    trainingComboBox.getItems().addAll("Communication Skill","Financial Reporting Development","Invoicing Skill");
//                    break;
//                case "Manufacturing Machine Operator":
//                    trainingComboBox.getItems().addAll("Quality Control Development","Team Work Skill","Lean Manufacturing");
//                    break;
//                        
//                case "Sales Officer":
//                    trainingComboBox.getItems().addAll("Customer Service Skill","Analysis Skill","Sales Processing");
//                    break;
//                case "Production Manager":
//                    trainingComboBox.getItems().addAll("Production Management","Equipment Maintenance","Leadership");
//                    break;
//                    
//                default:
//                    trainingComboBox.getItems().clear();
//                    break;
//            }
//        }
    //});
        
        
    }
    
}
