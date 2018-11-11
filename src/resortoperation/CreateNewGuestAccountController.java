package resortoperation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CreateNewGuestAccountController {

  public TextField firstName;
  public TextField lastName;
  public TextField Birthday;
  public TextField Address;
  public TextField email;
  public TextField phoneNumber;
  public RadioButton isMale;
  public RadioButton isFemale;
  public TextField nameOnCard;
  public TextField securityCode;
  public TextField billingAddress;
  public TextField username;
  public PasswordField password;
  public PasswordField creditCard;
  public Button buttonCreateAccount;
  public ImageView logoHome;
  public MenuButton buttonHome;

  public void getFirstName(ActionEvent actionEvent) {
  }

  public void CreateAccount(ActionEvent actionEvent){

    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Success!");
    alert.setHeaderText(null);
    alert.setContentText("Guest account has been created successfully!");

    alert.showAndWait();


    try{
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mangerHome.fxml"));
      Parent root1 = (Parent) fxmlLoader.load();

      Stage myStage = new Stage();
      myStage.setTitle("Manager View");
      myStage.setScene(new Scene(root1));
      myStage.show();
      myStage.setResizable(false);
      ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    catch (Exception e){
      System.err.println("Can't open new window");
    }
  }

  public void TakeHome(MouseEvent mouseEvent) {
  }

  public void takeHome(ActionEvent actionEvent) {
  }
}
