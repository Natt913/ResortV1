import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class EmployeeAccountFormController {

  private String userFirstName;
  private String userLastName;
  private String userEmail;
  private String userName;
  private int userPIN;
  private int userIsEmployee;
  private int userEmpType;
  private boolean insertSuccessful;

  @FXML
  public TextField firstName;
  @FXML
  public TextField lastName;
  @FXML
  private TextField pinField;
  @FXML
  public TextField emailField;
  @FXML
  public TextField phoneNumberField;
  @FXML
  public TextField empTypeField;
  @FXML
  public Button buttonCreateAccount;
  @FXML
  public ImageView logoHome;

  public void CreateAccount(ActionEvent actionEvent) {
    userIsEmployee = 1;
    userFirstName = firstName.getText();
    userLastName = lastName.getText();
    userEmail = emailField.getText();
    try {
      userPIN = Integer.parseInt(pinField.getText());
    } catch (Exception e) {
      System.out.println("Type mismatch exception. PIN must be an integer.");

      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error!");
      alert.setHeaderText(null);
      alert.setContentText("Type mismatch exception. PIN must be an integer.");

      alert.showAndWait();
    }
    userName = userFirstName.toLowerCase() + userLastName.toLowerCase().charAt(0);

    try {
      userEmpType = Integer.parseInt(empTypeField.getText());
    } catch (Exception e) {
      System.out.println("Type mismatch exception. Employee type must be an integer.");

      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error!");
      alert.setHeaderText(null);
      alert.setContentText("Type mismatch exception. Employee Type must be an integer.");

      alert.showAndWait();
    }

    User newEmployee = new User(0,userName, userPIN, userIsEmployee, userEmpType, "active");
    insertSuccessful = newEmployee.insertUserInDB();

    String dialogText = userFirstName + " " + userLastName + " with userName: " + userName;

    //After DB method returns true
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Success!");
    alert.setHeaderText(dialogText);
    alert.setContentText("Account has been created successfully!");
    alert.showAndWait();

    Main.setPane(SCREENS.EMPLOYEELIST.getValue());
    System.out.println("Create Employee User");
  }

  public void getBackHome(MouseEvent mouseEvent) {
    Main.setPane(SCREENS.EMPLOYEELIST.getValue());
  }
}
