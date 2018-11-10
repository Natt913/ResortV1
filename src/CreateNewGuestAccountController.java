import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CreateNewGuestAccountController {

  @FXML
  public TextField firstName;
  @FXML
  public TextField lastName;
  @FXML
  private TextField Birthday;
  @FXML
  public TextField Address;
  @FXML
  public TextField email;
  @FXML
  public TextField phoneNumber;
  @FXML
  public RadioButton isMale;
  @FXML
  public RadioButton isFemale;
  @FXML
  public TextField nameOnCard;
  @FXML
  public TextField securityCode;
  @FXML
  public TextField billingAddress;
  @FXML
  public TextField username;
  @FXML
  public PasswordField password;
  @FXML
  public PasswordField creditCard;
  @FXML
  public Button buttonCreateAccount;
  @FXML
  public ImageView logoHome;
  @FXML
  public MenuButton buttonHome;

  public String getFirstName(ActionEvent actionEvent) {
    return firstName.getText();
  }

  public void CreateAccount(ActionEvent actionEvent){


    //After DB method returns true
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Success!");
    alert.setHeaderText(null);
    alert.setContentText("Guest account has been created successfully!");

    alert.showAndWait();

    Main.setPane(SCREENS.MANAGERHOME.getValue());
  }

  public void TakeHome(MouseEvent mouseEvent) {
    Main.setPane(SCREENS.MANAGERHOME.getValue());
  }

  public void takeHome(ActionEvent actionEvent) {
    Main.setPane(SCREENS.MANAGERHOME.getValue());
  }
}
