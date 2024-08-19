/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package accountant_User4;


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
public class ReimbursementListController implements Initializable {

    @FXML
    private TableView<Reimbursement> reimbursementTableView;
    @FXML
    private TableColumn<Reimbursement, String> nameTableColumn;
    @FXML
    private TableColumn<Reimbursement, String> idTableColumn;
    @FXML
    private TableColumn<Reimbursement, String> deptTableColumn;
    @FXML
    private TableColumn<Reimbursement, String> statusTableColumn;
    @FXML
    private TableColumn<Reimbursement, String> etTableColumn;
    @FXML
    private TableColumn<Reimbursement, String> amountTableColumn;
    
    ObservableList <Reimbursement> list = FXCollections.observableList(Accountant.loadReimbursementDataFromFile("ReimbersementFile.bin"));

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Reimbursement,String>("name"));
        idTableColumn.setCellValueFactory(new PropertyValueFactory<Reimbursement,String>("id"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<Reimbursement,String>("status"));
        etTableColumn.setCellValueFactory(new PropertyValueFactory<Reimbursement,String>("expenseType"));
        deptTableColumn.setCellValueFactory(new PropertyValueFactory<Reimbursement,String>("department"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<Reimbursement,String>("amount"));
        
        reimbursementTableView.setItems(list);
    }    
    
}
