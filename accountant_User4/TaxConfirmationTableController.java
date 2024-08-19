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
public class TaxConfirmationTableController implements Initializable {

    @FXML
    private TableView<TaxPayment> taxTableView;
    @FXML
    private TableColumn<TaxPayment, String> amountPaidTableColumn;
    @FXML
    private TableColumn<TaxPayment, String> paidByTableColumn;
    
    ObservableList <TaxPayment> tax = FXCollections.observableList(Accountant.loadTaxPaymentDataFromFile("TaxFile.bin"));

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        amountPaidTableColumn.setCellValueFactory(new PropertyValueFactory<TaxPayment,String>("totalPayable"));
        paidByTableColumn.setCellValueFactory(new PropertyValueFactory<TaxPayment,String>("status"));
        //internNumberTableColumn.setCellValueFactory(new PropertyValueFactory<Intern,String>("internContactNum"));
        taxTableView.setItems(tax);
    }    
    
}
