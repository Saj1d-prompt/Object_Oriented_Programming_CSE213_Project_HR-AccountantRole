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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class MonthlyIncomeStatementReportController implements Initializable {

    @FXML
    private TextField expenseTextField;
    @FXML
    private TextField totalProfitTextField;
    @FXML
    private TextField withdrawalTextField;
    @FXML
    private Label netIncomeLabel;
    
    Alert alert;
    
//    IncomeStatement is;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void calculateTotalProfitOnMouseClick(ActionEvent event) throws IOException {
        if(expenseTextField.getText().isEmpty() || totalProfitTextField.getText().isEmpty() || withdrawalTextField.getText().isEmpty()){
            
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert");
            alert.setContentText("Please give proper Information");
            alert.setHeaderText(null);
            alert.showAndWait();
        
        }else{
            
            IncomeStatement is = new IncomeStatement();
            File f = new File("IncomeStatementObj.bin");
            f.getAbsoluteFile().delete();
            int total = is.calculateIncomeStatement(Integer.parseInt(totalProfitTextField.getText()),
                        Integer.parseInt(expenseTextField.getText()),
                        Integer.parseInt(withdrawalTextField.getText()));
            is = new IncomeStatement(Integer.parseInt(totalProfitTextField.getText()),Integer.parseInt(expenseTextField.getText()),
                    Integer.parseInt(withdrawalTextField.getText()),total);
            
            Accountant.storeIncomeStatementDataToFile(is, "IncomeStatementObj.bin");
            netIncomeLabel.setText(String.valueOf(total));
            
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setContentText("Data Stored Successfully.");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        
        
    }

    @FXML
    private void generatePDFOnMouseClick(ActionEvent event) {
        ObservableList<IncomeStatement> obj;
        obj = FXCollections.observableList(Accountant.loadIncomeStatementDataFromFile("IncomeStatementObj.bin"));
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Save As PDF");
        filechooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF File","*.pdf"));
        
        File file = filechooser.showSaveDialog(null);
        
        if (file != null){
            
            saveTableViewContentAsPDF(obj,file.getAbsolutePath());
        
        }
        
    }
    private void saveTableViewContentAsPDF(ObservableList<IncomeStatement> items, String fileName) {
        try {
            PdfWriter pdfWriter = new PdfWriter(fileName);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);

            for (IncomeStatement i : items) {
                
                document.add(new Paragraph("Income Amount: "+ i.getIncome()));
                document.add(new Paragraph("Expense Amount: "+ i.getExpense()));
                document.add(new Paragraph("Owners Withdrawal : "+ i.getWithdrawal()));
                document.add(new Paragraph("Net Income "+ i.getTotalProfit()));
                document.add(new Paragraph("\n\n"));
            }

            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
