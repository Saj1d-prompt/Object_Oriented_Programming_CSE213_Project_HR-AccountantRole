/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hrExecutive_User3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class TrainingInternListController implements Initializable {

    @FXML
    private TableView<Training> trainingTableView;
    @FXML
    private TableColumn<Training, String> nameTableColumn;
    @FXML
    private TableColumn<Training, String> idTableColumn;
    @FXML
    private TableColumn<Training, String> deptTableColumn;
    @FXML
    private TableColumn<Training, String> numberTableColumn;
    @FXML
    private TableColumn<Training, String> trainingTableColumn;
    
    ObservableList <Training> training = FXCollections.observableList(HRExecutive.loadTrainingDataFromList("AllocateTraining.bin"));

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Training,String>("name"));
        idTableColumn.setCellValueFactory(new PropertyValueFactory<Training,String>("id"));
        deptTableColumn.setCellValueFactory(new PropertyValueFactory<Training,String>("dept"));
        numberTableColumn.setCellValueFactory(new PropertyValueFactory<Training,String>("number"));
        trainingTableColumn.setCellValueFactory(new PropertyValueFactory<Training,String>("training"));
        
        trainingTableView.setItems(training);
        
        
    }    
    
}
