/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hrExecutive_User3;

import accountant_User4.FeedBack;
import accountant_User4.Accountant;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
public class EmployeeFeedBackController implements Initializable {

    @FXML
    private TableView<FeedBack> feedbackTableView;
    @FXML
    private TableColumn<FeedBack, String> nameTableIndex;
    @FXML
    private TableColumn<FeedBack, String> idTableIndex;
    @FXML
    private TableColumn<FeedBack, String> numberTableIndex;
    @FXML
    private TableColumn<FeedBack, String> feedbackTableIndex;
    @FXML
    private TableColumn<FeedBack, String> messageTableIndex;
    
    
  //ObservableList <FeedBack> messege = FXCollections.observableList(Accountant.loadFeedbackFromFile("FeedBackFile.bin"));
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nameTableIndex.setCellValueFactory(new PropertyValueFactory<FeedBack,String>("employeeName"));
        idTableIndex.setCellValueFactory(new PropertyValueFactory<FeedBack,String>("employeeID"));
        numberTableIndex.setCellValueFactory(new PropertyValueFactory<FeedBack,String>("contactNum"));
        feedbackTableIndex.setCellValueFactory(new PropertyValueFactory<FeedBack,String>("typeOfFB"));
        messageTableIndex.setCellValueFactory(new PropertyValueFactory<FeedBack,String>("feedback"));

    }    

    @FXML
    private void loadFeedbackOnMouseClick(ActionEvent event) throws IOException {
        feedbackTableView.getItems().addAll(Accountant.loadFeedbackFromFile("FeedBackFile.bin"));
        //feedbackTableView.setItems(messege);
    }
    
}
