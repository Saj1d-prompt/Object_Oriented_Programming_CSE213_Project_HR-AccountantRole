/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package accountant_User4;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class EmployeeListWithSalaryController implements Initializable {

    @FXML
    private TableView<Salary> employeeListTableView;
    @FXML
    private TableColumn<Salary, String> nameTableColumn;
    @FXML
    private TableColumn<Salary, String> idTableColumn;
    @FXML
    private TableColumn<Salary, String> deptTableColumn;
    @FXML
    private TableColumn<Salary, String> numberTableColumn;
    @FXML
    private TableColumn<Salary, String> salaryTableColumn;
    
    ObservableList<Salary> salaryData = FXCollections.observableList(Accountant.loadSalaryDeclarationDataFromFile("EmployeeSalaryData.bin"));


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Salary,String>("name"));
        idTableColumn.setCellValueFactory(new PropertyValueFactory<Salary,String>("id"));
        numberTableColumn.setCellValueFactory(new PropertyValueFactory<Salary,String>("ContactNum"));
        salaryTableColumn.setCellValueFactory(new PropertyValueFactory<Salary,String>("salary"));
        deptTableColumn.setCellValueFactory(new PropertyValueFactory<Salary,String>("recruitedDept"));
        
        employeeListTableView.setItems(salaryData);
        
        // TODO
    }    

    @FXML
    private void generatePDFOnMouseClick(ActionEvent event) {
                
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Save As PDF");
        filechooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF File","*.pdf"));
        
        File file = filechooser.showSaveDialog(null);
        
        if (file != null){
            
            saveTableViewContentAsPDF(employeeListTableView.getItems(),file.getAbsolutePath());
        
        }
    }
    
    private void saveTableViewContentAsPDF(ObservableList<Salary> items, String fileName) {
        try {
            PdfWriter pdfWriter = new PdfWriter(fileName);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);

            for (Salary s : items) {
                
                document.add(new Paragraph("Emloyee Name: "+ s.getName()));
                document.add(new Paragraph("Emloyee ID: "+ s.getId()));
                document.add(new Paragraph("Emloyee Department: "+ s.getRecruitedDept()));
                document.add(new Paragraph("Contact Number: "+ s.getContactNum()));
                document.add(new Paragraph("Salary Amount: "+ s.getSalary()));
                document.add(new Paragraph("\n\n"));
            }

            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
