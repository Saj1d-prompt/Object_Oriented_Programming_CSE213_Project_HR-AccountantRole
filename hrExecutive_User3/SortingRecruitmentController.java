/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hrExecutive_User3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class SortingRecruitmentController implements Initializable {

    @FXML
    private TableView<Employee> employeeFileTableView;
    @FXML
    private TableColumn<Employee, String> employeeNameTableColumn;
    @FXML
    private TableColumn<Employee, String> employeeIDTableColumn;
    @FXML
    private TableColumn<Employee, String> numberTableColumn;
    @FXML
    private TableColumn<Employee, String> deptTableColumn;
    @FXML
    private TableColumn<Employee, LocalDate> assignedDateTableColumn;
    @FXML
    private ComboBox<String> sortingTypeComboBox;
    
    ObservableList<Employee> employee = FXCollections.observableList(HRExecutive.loadEmployeeList("EmployeeObject.bin"));
    Alert alert;
    
    String fileName = "sortFile.bin";
    
    File f = new File(fileName);
    @FXML
    private Button sortEmployeeListButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sortingTypeComboBox.getItems().addAll("Manufacturing Machine Operator","Accountant", 
                "HR executive", "Sales Officer", "Production Manager");
        
        employeeNameTableColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("employeeName"));
        employeeIDTableColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("employeeID"));
        numberTableColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("employeeContactNumber"));
        deptTableColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("assignedDept"));
        assignedDateTableColumn.setCellValueFactory(new PropertyValueFactory<Employee,LocalDate>("assignedDate"));

        
    }    

    @FXML
    private void generateEmployeeListOnMouseClicked(ActionEvent event) {
        
        employeeFileTableView.setItems(employee);
    }
    
//    private void setCellValueNull(){
//        employeeNameTableColumn.setCellValueFactory(null);
//        employeeIDTableColumn.setCellValueFactory(null);
//        numberTableColumn.setCellValueFactory(null);
//        deptTableColumn.setCellValueFactory(null);
//        assignedDateTableColumn.setCellValueFactory(null);
//    }

    @FXML
    private void sortEmployeeListOnMouseClicked(ActionEvent event) throws IOException {
        
        
        
        
        if(sortingTypeComboBox.getValue() == null){
            
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert");
            alert.setContentText("Sorting Type is not Selected");
            alert.setHeaderText(null);
            alert.showAndWait();
        
        }
        else{
            
            //employeeFileTableView.getItems().clear();
            f.getAbsoluteFile().delete();
            for (Employee e : employee){
            
                if(sortingTypeComboBox.getValue().equals(e.getAssignedDept())){
                    
                    HRExecutive.addEmployeetoList(e, f.getName());
                    ObservableList<Employee> sortedEmployee = FXCollections.observableArrayList(HRExecutive.loadEmployeeList(f.getName()));
                    employeeFileTableView.setItems(sortedEmployee);
                    
                }
                
            }
        }
        
        
    }

}
