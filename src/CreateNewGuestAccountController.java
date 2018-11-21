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

  @FXML
  public TextField firstName;
  @FXML
  public TextField lastName;
  @FXML
  private TextField pinField;
  @FXML
  public TextField Address;
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
  public RadioButton isGuest;
  @FXML
  public RadioButton isEmployee;
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
    userFirstName = firstName.getText();
    userLastName = lastName.getText();
    userEmail = emailField.getText();
    RadioButton selectedRadioButton = (RadioButton) empGuestRadio.getSelectedToggle();
    System.out.println(selectedRadioButton);
    try {
      userPIN = Integer.parseInt(pinField.getText());
    }
    catch (Exception e) {
      System.out.println("Type mismatch exception. PIN must be an integer.");
    }
    userName = userFirstName.toLowerCase() + userLastName.toLowerCase().charAt(0);


    // Use employee constructor and insert statement, maybe go back to one constructor that handles both
    if (selectedRadioButton.getId().equals("radEmployee")) {
      userIsEmployee = 1;

      try {
        userEmpType = Integer.parseInt(empTypeField.getText());
      }
      catch (Exception e) {
        System.out.println("Type mismatch exception. Employee type must be an integer.");
      }

      User newEmployee = new User(userName, userPIN,userIsEmployee,userEmpType,"active");
      newEmployee.insertUserInDB();
    }
    // Use employee constructor and insert statement, maybe go back to one constructor that handles both
    else {
      userIsEmployee = 0;
      try {
        roomNumber = Integer.parseInt(roomNumField.getText());
      }
      catch (Exception e) {
        System.out.println("Type mismatch exception. Room Number must be an integer.");
      }
      User newGuest = new User(userName, userPIN,roomNumber,"active");
      newGuest.insertUserInDB();
    }

    String dialogText = userFirstName + " " + userLastName + " with userName: " + userName;
    //After DB method returns true
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Success!");
    alert.setHeaderText(dialogText);
    alert.setContentText("Account has been created successfully!");
    alert.showAndWait();

    Main.setPane(SCREENS.MANAGERHOME.getValue());
  }

  public void TakeHome(MouseEvent mouseEvent) {
    Main.setPane(SCREENS.MANAGERHOME.getValue());
  }

  public void takeHome(ActionEvent actionEvent) {
    Main.setPane(SCREENS.MANAGERHOME.getValue());
  }

  public void getBackHome(MouseEvent mouseEvent) {
    Main.setPane(SCREENS.MANAGERHOME.getValue());
  }
}
