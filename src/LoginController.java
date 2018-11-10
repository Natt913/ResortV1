import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

  //these variables have to be private in order for the login to work
  public TextField userName;
  public PasswordField password;
  public Button buttonLogin;

  public String getUserName() {
    return userName.getText();
  }

  public String getPassword() {
    return userName.getText();
  }

  public void login(ActionEvent actionEvent) {
    if(userName.getText().equals("manager")) {
      Main.setPane(SCREENS.MANAGERHOME.getValue());
    }
    else if(userName.getText().equals("housekeeping")){
      Main.setPane(SCREENS.HOUSEKEEPING.getValue());
    }
    else if(userName.getText().equals("maintenance")){
      Main.setPane(SCREENS.MAINTENANCE.getValue());
    }
    else if(userName.getText().equals("valet")){
      Main.setPane(SCREENS.VALET.getValue());
    }
    //this will be replaced with username and pw from db query
    else if(userName.getText().equals("guest")){
      Main.setPane(SCREENS.GUESTHOME.getValue());
    }
    else{
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error!");
      alert.setHeaderText(null);
      alert.setContentText("Wrong username or password!");

      alert.showAndWait();
    }
  }
}