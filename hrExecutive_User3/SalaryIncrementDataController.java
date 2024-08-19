/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hrExecutive_User3;

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
public class SalaryIncrementDataController implements Initializable {
    
    ObservableList <Incrementation> sid = FXCollections.observableList(HRExecutive.loadSalaryIncrementDataFromList("SalaryIncrementObj.bin"));

    @FXML
    private TableView<Incrementation> incrementationDataTableView;
    @FXML
    private TableColumn<Incrementation, String> employeeNameTableColumn;
    @FXML
    private TableColumn<Incrementation, String> employeeIDTableColumn;
    @FXML
    private TableColumn<Incrementation, String> departmentTableColumn;
    @FXML
    private TableColumn<Incrementation, String> percentangeTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        employeeNameTableColumn.setCellValueFactory(new PropertyValueFactory<Incrementation,String>("employeeName"));
        employeeIDTableColumn.setCellValueFactory(new PropertyValueFactory<Incrementation,String>("employeeID"));
        percentangeTableColumn.setCellValueFactory(new PropertyValueFactory<Incrementation,String>("percentOfIncrement"));
        departmentTableColumn.setCellValueFactory(new PropertyValueFactory<Incrementation,String>("employeeDept"));
        
        incrementationDataTableView.setItems(sid);
    }    

    @FXML
    private void createPDFOnMouseClick(ActionEvent event) {
        
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Save As PDF");
        filechooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF File","*.pdf"));
        
        File file = filechooser.showSaveDialog(null);
        
        if (file != null){
            
            saveTableViewContentAsPDF(incrementationDataTableView.getItems(),file.getAbsolutePath());
        
        }
    }
    
    private void saveTableViewContentAsPDF(ObservableList<Incrementation> items, String fileName) {
        try {
            PdfWriter pdfWriter = new PdfWriter(fileName);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);

            for (Incrementation i : items) {
                
                document.add(new Paragraph("Emloyee Name: "+ i.getEmployeeName()));
                document.add(new Paragraph("Emloyee ID: "+ i.getEmployeeID()));
                document.add(new Paragraph("Emloyee Department: "+ i.getEmployeeDept()));
                document.add(new Paragraph("Increment Percentange: "+ i.getPercentOfIncrement() + "%"));
                document.add(new Paragraph("\n\n"));
            }

            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
