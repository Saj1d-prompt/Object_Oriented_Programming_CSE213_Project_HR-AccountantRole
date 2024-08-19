/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hrExecutive_User3;

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
public class InternListController implements Initializable {

    @FXML
    private TableView<Intern> internListTableView;
    @FXML
    private TableColumn<Intern, String> internNameTableColumn;
    @FXML
    private TableColumn<Intern, String> internIDTableColumn;
    @FXML
    private TableColumn<Intern, String> internNumberTableColumn;
    @FXML
    private TableColumn<Intern, String> internUniNameTableColumn;
    @FXML
    private TableColumn<Intern, String> internRecruitedDeptTableColumn;
    @FXML
    private TableColumn<Intern, String> internStatusTableColumn;
    @FXML
    private TableColumn<Intern, LocalDate> internRecruitedDateTableColumn;
    
    ObservableList<Intern> internList = FXCollections.observableList(HRExecutive.loadInternList("InternObject.bin"));

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        internNameTableColumn.setCellValueFactory(new PropertyValueFactory<Intern,String>("internName"));
        internIDTableColumn.setCellValueFactory(new PropertyValueFactory<Intern,String>("internID"));
        internNumberTableColumn.setCellValueFactory(new PropertyValueFactory<Intern,String>("internContactNum"));
        internUniNameTableColumn.setCellValueFactory(new PropertyValueFactory<Intern,String>("uniName"));
        internRecruitedDeptTableColumn.setCellValueFactory(new PropertyValueFactory<Intern,String>("recruitedDept"));
        internStatusTableColumn.setCellValueFactory(new PropertyValueFactory<Intern,String>("status"));
        internRecruitedDateTableColumn.setCellValueFactory(new PropertyValueFactory<Intern,LocalDate>("recruitedDate"));
        
        internListTableView.setItems(internList);
    }    
    
}
