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
  public TableView employeeTable;

  public void populateEmployeeList() {
    System.out.println("Populate Table.");

    ObservableList<User> currentEmployeeList = User.getUserList(1);
    System.out.println(currentEmployeeList.get(0).userName);

    TableColumn userIDCol = new TableColumn("UserID");
      userIDCol.setMinWidth(100);
      userIDCol.setCellValueFactory(
              new PropertyValueFactory<User, Integer>("userID"));

    TableColumn userNameCol = new TableColumn("UserName");
      userNameCol.setMinWidth(100);
      userNameCol.setCellValueFactory(
              new PropertyValueFactory<User, String>("userName"));

    TableColumn firstNameCol = new TableColumn("FirstName");
      firstNameCol.setMinWidth(100);
      firstNameCol.setCellValueFactory(
              new PropertyValueFactory<User, String>("userFirstName"));

    TableColumn lastNameCol = new TableColumn("LastName");
      lastNameCol.setMinWidth(100);
      lastNameCol.setCellValueFactory(
              new PropertyValueFactory<User, String>("userLastName"));

    TableColumn emailCol = new TableColumn("Email");
      emailCol.setMinWidth(100);
      emailCol.setCellValueFactory(
              new PropertyValueFactory<User, String>("userEmail"));

//      TODO: Figure out a way to display the employee type from the enum rather than the integer value as taken from db
    TableColumn employeeTypeCol = new TableColumn("Employee Type");
        employeeTypeCol.setMinWidth(130);
        employeeTypeCol.setCellValueFactory(
                new PropertyValueFactory<User, Integer>("empType"));

    employeeTable.setItems(currentEmployeeList);
    employeeTable.getColumns().addAll(userIDCol, userNameCol, firstNameCol, lastNameCol, emailCol, employeeTypeCol);
  }

  public void getBackHome(MouseEvent mouseEvent) {
    Main.setPane(SCREENS.MANAGERHOME.getValue());
  }

  public void launchNewEmployeeForm(ActionEvent actionEvent) {
    Main.setPane(SCREENS.EMPLOYEEACCOUNTFORM.getValue());
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    System.out.println("Call to initialize function. Populate table.");
  }
}
