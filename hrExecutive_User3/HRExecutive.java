/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrExecutive_User3;

import accountant_User4.FeedBack;
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
public class HRExecutive extends User implements Serializable {
    
    public HRExecutive(String fullName, String userName, String phoneNumber, String password, LocalDate Dob) {
        super(fullName, userName, phoneNumber, password, Dob);
    }
    
    public static ArrayList<Employee> loadEmployeeList(String employeeFile){
        ArrayList<Employee> employeeList = new ArrayList();
        
        try{
            FileInputStream fis = new FileInputStream(employeeFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                try{
                    Employee employees = (Employee) ois.readObject();
                    employeeList.add(employees);
                
                }catch(Exception e){
                    break;
                }
            
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    return employeeList;
    
    }
    
    public static void addEmployeetoList(Employee employee, String employeeFile){
        
        ArrayList<Employee> fullEmployeeList = loadEmployeeList(employeeFile);
        fullEmployeeList.add(employee);
        
        try{
            
            FileOutputStream fos = new FileOutputStream(employeeFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(Employee emp : fullEmployeeList){
                oos.writeObject(emp);
            }
            oos.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
    
    public static ArrayList<Intern> loadInternList(String internFile){
        ArrayList<Intern> internList = new ArrayList();
        
        try{
            FileInputStream fis = new FileInputStream(internFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                try{
                    Intern interns = (Intern) ois.readObject();
                    internList.add(interns);
                
                }catch(Exception e){
                    break;
                }
            
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    return internList;
    
    }
    
    public static void addInterntoList(Intern intern, String internFile){
        
        ArrayList<Intern> fullInternList = loadInternList(internFile);
        fullInternList.add(intern);
        
        try{
            
            FileOutputStream fos = new FileOutputStream(internFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(Intern internss : fullInternList){
                oos.writeObject(internss);
            }
            oos.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
    public static void addSalaryIncrementDataToList(Incrementation incrementation, String increFile){
        
        ArrayList<Incrementation> fullList = loadSalaryIncrementDataFromList(increFile);
        fullList.add(incrementation);
        
        try{
            
            FileOutputStream fos = new FileOutputStream(increFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(Incrementation internss : fullList){
                oos.writeObject(internss);
            }
            oos.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
    public static ArrayList<Incrementation> loadSalaryIncrementDataFromList(String increFile){
        ArrayList<Incrementation> incrementList = new ArrayList();
        
        try{
            FileInputStream fis = new FileInputStream(increFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                try{
                    Incrementation increm = (Incrementation) ois.readObject();
                    incrementList.add(increm);
                
                }catch(Exception e){
                    break;
                }
            
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    return incrementList;
       
   }
    
    public static int[] employeeRatioData(){
        
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
        return count;    
    }
    
    public static ArrayList<Training> loadTrainingDataFromList(String increFile){
        ArrayList<Training> trainingList = new ArrayList();
        
        try{
            FileInputStream fis = new FileInputStream(increFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                try{
                    Training train = (Training) ois.readObject();
                    trainingList.add(train);
                
                }catch(Exception e){
                    break;
                }
            
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    return trainingList;
       
   }
    
    public static void addTrainingDataToList(Training training, String increFile){
        
        ArrayList<Training> trainData = loadTrainingDataFromList(increFile);
        trainData.add(training);
        
        try{
            
            FileOutputStream fos = new FileOutputStream(increFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(Training trainin : trainData){
                oos.writeObject(trainin);
            }
            oos.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
