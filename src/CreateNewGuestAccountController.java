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

//TODO: Make use of some of the extra fields for guests(credit card, address, etc.)
//TODO: Better error checking for input fields

public class CreateNewGuestAccountController {

  private String userFirstName;
  private String userLastName;
  private String userEmail;
  private String userPhone;
  private String userName;
  private String userStatus;
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
  public TextField userPhoneField;
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

  public void CreateAccount(ActionEvent actionEvent) {
    int newUserID;
    userIsEmployee = 0;
    userStatus = "active";
    userFirstName = firstName.getText();
    userLastName = lastName.getText();
    userEmail = emailField.getText();
    userPhone = userPhoneField.getText();
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
    User newGuest = new User(0, userName, userFirstName, userLastName, userEmail, userPhone, userPIN,roomNumber,
            userStatus);
    newUserID = newGuest.insertUserInDB();

    System.out.println("new userID: " + newUserID);
    Room thisRoom = new Room(roomNumber, newUserID);
    thisRoom.checkIn(newUserID);
//    FloorChartController.initialize();


//    Room thisRoom = new Room(roomNumber);

    if (newUserID > 0) {
      //After DB method returns true
      String dialogText = userFirstName + " " + userLastName + " with userName: " + userName + " checked into room " + roomNumber + ".";
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Success!");
      alert.setHeaderText("Account has been created successfully!");
      alert.setContentText(dialogText);
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
