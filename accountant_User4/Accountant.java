/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accountant_User4;

import static hrExecutive_User3.HRExecutive.loadInternList;
import hrExecutive_User3.Intern;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import mainpkg.User;

/**
 *
 * @author Dell
 */
public class Accountant extends User implements Serializable{
    
    public Accountant(String fullName, String userName, String phoneNumber, String password, LocalDate Dob) {
        super(fullName, userName, phoneNumber, password, Dob);
    }
     
    public static void storeFeedbackToFile(FeedBack feedback, String fileN) throws IOException{
        ArrayList<FeedBack> feedBackStorage = loadFeedbackFromFile(fileN);
        feedBackStorage.add(feedback);
        
        try{
            
            FileOutputStream fos = new FileOutputStream(fileN);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(FeedBack feedB : feedBackStorage){
                oos.writeObject(feedB);
            }
            oos.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static ArrayList<FeedBack> loadFeedbackFromFile(String fileName){
        
        ArrayList<FeedBack> feedbackStore = new ArrayList();
        
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                try{
                    FeedBack feedBa = (FeedBack) ois.readObject();
                    feedbackStore.add(feedBa);
                
                }catch(Exception e){
                    break;
                }
            
            }
            ois.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    return feedbackStore;
    
    
    }
    
    public static ArrayList<Salary> loadSalaryDeclarationDataFromFile(String fileName){
        
        ArrayList<Salary> salaryData = new ArrayList();
        
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                try{
                    Salary data = (Salary) ois.readObject();
                    salaryData.add(data);
                
                }catch(Exception e){
                    break;
                }
            
            }
            ois.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    return salaryData;
    
    
    }
    
    public static void storeSalaryDeclarationDataToFile(Salary salary, String fileN) throws IOException{
        ArrayList<Salary> salaryData = loadSalaryDeclarationDataFromFile(fileN);
        salaryData.add(salary);
        
        try{
            
            FileOutputStream fos = new FileOutputStream(fileN);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(Salary s : salaryData){
                oos.writeObject(s);
            }
            oos.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
     public static void storeIncomeStatementDataToFile(IncomeStatement income, String fileN) throws IOException{
        ArrayList<IncomeStatement> incomeData = loadIncomeStatementDataFromFile(fileN);
        incomeData.add(income);
        
        try{
            
            FileOutputStream fos = new FileOutputStream(fileN);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(IncomeStatement s : incomeData){
                oos.writeObject(s);
            }
            oos.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }

    }
     
     public static ArrayList<IncomeStatement> loadIncomeStatementDataFromFile(String fileName){
        
        ArrayList<IncomeStatement> incomeStatementData = new ArrayList();
        
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                try{
                    IncomeStatement data = (IncomeStatement) ois.readObject();
                    incomeStatementData.add(data);
                
                }catch(Exception e){
                    break;
                }
            
            }
            ois.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    return incomeStatementData;
    
    
    }
     
    public static void storeUpdateSalaryDataToFile(UpdateSalary salary, String fileN) throws IOException{
        ArrayList<UpdateSalary> updateData = loadUpdateSalaryDataFromFile(fileN);
        updateData.add(salary);
        
        try{
            
            FileOutputStream fos = new FileOutputStream(fileN);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(UpdateSalary s : updateData){
                oos.writeObject(s);
            }
            oos.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }

    }
     
     
    public static ArrayList<UpdateSalary> loadUpdateSalaryDataFromFile(String fileName){
        
        ArrayList<UpdateSalary> updateSalaryData = new ArrayList();
        
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                try{
                    UpdateSalary data = (UpdateSalary) ois.readObject();
                    updateSalaryData.add(data);
                
                }catch(Exception e){
                    break;
                }
            
            }
            ois.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    return updateSalaryData;
    
    
    }
    
    public static ArrayList<TaxPayment> loadTaxPaymentDataFromFile(String fileName){
        
        ArrayList<TaxPayment> taxData = new ArrayList();
        
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                try{
                    TaxPayment data = (TaxPayment) ois.readObject();
                    taxData.add(data);
                
                }catch(Exception e){
                    break;
                }
            
            }
            ois.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    return taxData;

    }
    
    public static void storeTaxPaymentDataToFile(TaxPayment taxpay, String fileN) throws IOException{
        ArrayList<TaxPayment> taxData = loadTaxPaymentDataFromFile(fileN);
        taxData.add(taxpay);
        
        try{
            
            FileOutputStream fos = new FileOutputStream(fileN);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(TaxPayment t : taxData){
                oos.writeObject(t);
            }
            oos.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
    public static ArrayList<Reimbursement> loadReimbursementDataFromFile(String fileName){
        
        ArrayList<Reimbursement> reimburseData = new ArrayList();
        
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                try{
                    Reimbursement data = (Reimbursement) ois.readObject();
                    reimburseData.add(data);
                
                }catch(Exception e){
                    break;
                }
            
            }
            ois.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    return reimburseData;
    }
    
    public static void storeReimbersementDataToFile(Reimbursement reimberse, String fileN) throws IOException{
        ArrayList<Reimbursement> reimbData = loadReimbursementDataFromFile(fileN);
        reimbData.add(reimberse);
        
        try{
            
            FileOutputStream fos = new FileOutputStream(fileN);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(Reimbursement r : reimbData){
                oos.writeObject(r);
            }
            oos.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
    public static ArrayList<Budget> loadBudgetDataFromFile(String fileName){
        
        ArrayList<Budget> budgetData = new ArrayList();
        
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                try{
                    Budget data = (Budget) ois.readObject();
                    budgetData.add(data);
                
                }catch(Exception e){
                    break;
                }
            
            }
            ois.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    return budgetData;
    }
    
    public static void storeBudgetDataToFile(Budget budget, String fileN) throws IOException{
        ArrayList<Budget> budgData = loadBudgetDataFromFile(fileN);
        budgData.add(budget);
        
        try{
            
            FileOutputStream fos = new FileOutputStream(fileN);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(Budget r : budgData){
                oos.writeObject(r);
            }
            oos.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
}
