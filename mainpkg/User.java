
package mainpkg;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class User implements Serializable{
    protected String fullName;
    protected String userName;
    protected String phoneNumber;
    protected String password;
    protected LocalDate Dob;

    public User(String fullName, String userName, String phoneNumber, String password, LocalDate Dob) {
        this.fullName = fullName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.Dob = Dob;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDob() {
        return Dob;
    }
    
}
