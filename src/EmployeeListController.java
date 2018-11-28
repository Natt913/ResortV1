import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EmployeeListController implements Initializable {
  @FXML
  public TableView<User> employeeTable;

  public void populateEmployeeList() {
    ObservableList<User> currentEmployeeList = User.getUserList(1);
    TableColumn userIDCol = new TableColumn("UserID");
      userIDCol.setMinWidth(60);
      userIDCol.setCellValueFactory(
              new PropertyValueFactory<User, Integer>("userID"));

    TableColumn userNameCol = new TableColumn("UserName");
      userNameCol.setMinWidth(75);
      userNameCol.setCellValueFactory(
              new PropertyValueFactory<User, String>("userName"));

    TableColumn firstNameCol = new TableColumn("FirstName");
      firstNameCol.setMinWidth(90);
      firstNameCol.setCellValueFactory(
              new PropertyValueFactory<User, String>("userFirstName"));

    TableColumn lastNameCol = new TableColumn("LastName");
      lastNameCol.setMinWidth(90);
      lastNameCol.setCellValueFactory(
              new PropertyValueFactory<User, String>("userLastName"));

    TableColumn emailCol = new TableColumn("Email");
      emailCol.setMinWidth(220);
      emailCol.setCellValueFactory(
              new PropertyValueFactory<User, String>("userEmail"));

    TableColumn empTypeTextCol = new TableColumn("Employee Type");
        empTypeTextCol.setMinWidth(110);
        empTypeTextCol.setCellValueFactory(
                new PropertyValueFactory<User, String>("empTypeText"));

    employeeTable.setItems(currentEmployeeList);
    employeeTable.getColumns().clear();
//    employeeTable.getColumns().removeAll(userIDCol, userNameCol, firstNameCol, lastNameCol, emailCol, employeeTypeCol);
    employeeTable.getColumns().addAll(userIDCol, userNameCol, firstNameCol, lastNameCol, emailCol, empTypeTextCol);
  }

  public void deleteUser(ActionEvent actionEvent) {
    User selectedUser;
    selectedUser = employeeTable.getSelectionModel().getSelectedItem();
    if (selectedUser != null) {
      System.out.println("Delete User" + selectedUser.getUserName());
      selectedUser.deleteUser();
      populateEmployeeList();
    }
    else {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Error");
      alert.setHeaderText("User not deleted.");
      alert.setContentText("Select a user and then click Delete User button.");
      alert.showAndWait();
    }
  }

  public void getBackHome(MouseEvent mouseEvent) {
    Main.setPane(SCREENS.MANAGERHOME.getValue());
  }

  public void launchNewEmployeeForm(ActionEvent actionEvent) {
    Main.setPane(SCREENS.EMPLOYEEACCOUNTFORM.getValue());
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    populateEmployeeList();
  }
}
