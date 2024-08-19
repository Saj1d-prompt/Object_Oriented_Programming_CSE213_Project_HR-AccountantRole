/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package accountant_User4;

import java.net.URL;
import java.time.LocalDate;
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
public class BudgetAllocationTableViewController implements Initializable {

    @FXML
    private TableView<Budget> budgetTableView;
    @FXML
    private TableColumn<Budget, String> deptTableColumn;
    @FXML
    private TableColumn<Budget, String> typeTableColumn;
    @FXML
    private TableColumn<Budget, LocalDate> dateTypeColumn;
    @FXML
    private TableColumn<Budget, String> amountTableColumn;
    
    ObservableList <Budget> budget = FXCollections.observableList(Accountant.loadBudgetDataFromFile("BudgetDataFile.bin"));

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<Budget,String>("amount"));
        deptTableColumn.setCellValueFactory(new PropertyValueFactory<Budget,String>("department"));
        typeTableColumn.setCellValueFactory(new PropertyValueFactory<Budget,String>("budgetType"));
        dateTypeColumn.setCellValueFactory(new PropertyValueFactory<Budget,LocalDate>("date"));
        
        budgetTableView.setItems(budget);
        
        
    }    
    
}
