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

//TODO: Make use of some of the extra fields for guests(credit card, address, etc.) and add column in Users database table
//TODO: to store email address rather than discard it
//TODO: Create method or lambda expression to disable and enable the appropriate fields when radio button is Employee/Guest
//TODO: Better error checking for input fields
//TODO: Change for using separate constructors for Employee and Guest to one constructor to simplify things
public class CreateNewGuestAccountController {

  private String userFirstName;
  private String userLastName;
  private String userEmail;
  private String userName;
  private int userPIN;
  private int userIsEmployee;
  private int userEmpType;
  private int roomNumber;
  private boolean insertSuccessful;

  @FXML
  public TextField firstName;
  @FXML
  public TextField lastName;
  @FXML
  private TextField pinField;
  @FXML
  public TextField billingAddress;
  @FXML
  public TextField emailField;
  @FXML
  public TextField phoneNumber;
  @FXML
  public TextField roomNumField;
  @FXML
  public TextField empTypeField;
  @FXML
  public ToggleGroup empGuestRadio;
  @FXML
  public TextField nameOnCard;
  @FXML
  public TextField securityCode;
  @FXML
  public PasswordField creditCard;
  @FXML
  public Button buttonCreateAccount;
  @FXML
  public ImageView logoHome;

  public String getFirstName(ActionEvent actionEvent) {
    return firstName.getText();
  }

  public void CreateAccount(ActionEvent actionEvent){
    userIsEmployee = 0;
    userFirstName = firstName.getText();
    userLastName = lastName.getText();
    userEmail = emailField.getText();
    try {
      userPIN = Integer.parseInt(pinField.getText());
    }
    catch (Exception e) {
      System.out.println("Type mismatch exception. PIN must be an integer.");
    }
    userName = userFirstName.toLowerCase() + userLastName.toLowerCase().charAt(0);

    try {
      roomNumber = Integer.parseInt(roomNumField.getText());
    }
    catch (Exception e) {
      System.out.println("Type mismatch exception. Room Number must be an integer.");
    }
    User newGuest = new User(0,userName, userPIN,roomNumber,"active");
    insertSuccessful = newGuest.insertUserInDB();

    if (insertSuccessful) {
      //After DB method returns true
      String dialogText = userFirstName + " " + userLastName + " with userName: " + userName;
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Success!");
      alert.setHeaderText(dialogText);
      alert.setContentText("Account has been created successfully!");
      alert.showAndWait();

      Main.setPane(SCREENS.MANAGERHOME.getValue());
    }
  }

  public void TakeHome(MouseEvent mouseEvent) {
    Main.setPane(SCREENS.MANAGERHOME.getValue());
  }

  public void getBackHome(MouseEvent mouseEvent) {
    Main.setPane(SCREENS.MANAGERHOME.getValue());
  }
}
