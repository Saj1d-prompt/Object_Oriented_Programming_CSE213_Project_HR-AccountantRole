/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hrExecutive_User3;

import static hrExecutive_User3.HRExecutive.loadEmployeeList;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class EmployeeRatioController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;
    @FXML
    private PieChart pieChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadChartButtonOnMouseClick(ActionEvent event) {
        barChart.getData().clear();
        pieChart.getData().clear();
        
        //int[] list = HRExecutive.employeeRatioData();
        ArrayList <Employee> emp = loadEmployeeList("EmployeeObject.bin");
        
        int total = emp.size();
        int[] count = new int[5];
        
        for (Employee e : emp){
            
            String caseType = e.getAssignedDept();
            
            if(caseType.equals("Manufacturing Machine Operator")){
                count[0]++;
            }else if(caseType.equals("Accountant")){
                count[1]++;
            }else if(caseType.equals("HR executive")){
                count[2]++;
            }else if(caseType.equals("Sales Officer")){
                count[3]++;
            }else if(caseType.equals("Production Manager")){
                count[4]++;
            }
        }
        
        XYChart.Series<String,Integer> series = new XYChart.Series<>();
        
        series.getData().add(new XYChart.Data<>("Manufacturing Machine Operator",count[0]));
        series.getData().add(new XYChart.Data<>("Accountant",count[1]));
        series.getData().add(new XYChart.Data<>("HR executive",count[2]));
        series.getData().add(new XYChart.Data<>("Sales Officer",count[3]));
        series.getData().add(new XYChart.Data<>("Production Manager",count[4]));
        barChart.getData().add(series);
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Manufacturing Machine Operator (" + count[0] + " Employees)", (double) count[0] / total),
            new PieChart.Data("Accountant (" + count[1] + " Employees)", (double) count[1] / total),
            new PieChart.Data("HR executive (" + count[2] + " Employees)", (double) count[2] / total),
            new PieChart.Data("Sales Officer (" + count[3] + " Employees)", (double) count[3] / total),
            new PieChart.Data("Production Manager (" + count[4] + " Employees)", (double) count[4] / total));
        
        pieChart.setData(pieChartData);
        
        
    }
    
}
