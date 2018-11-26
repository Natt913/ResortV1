import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;

public class ManagerHomeController {

  public Button buttonNewAccount;
  public Button buttonFloorChart;
  public Button buttonAllRequests;
  public Button buttonEmployees;
  public Button viewFoodServices;

  //these are request radio buttons - they suppose to disappear when req is done
  public CheckBox radio1;
  public CheckBox radio2;
  public CheckBox radio3;
  public CheckBox radio4;
  //when this button is clicked - radio disappears
  public Button buttonDone;



  //brings to create new guest account screen
  public void buttonNewAccount(ActionEvent actionEvent) {
    Main.setPane(SCREENS.CREATENEWGUEST.getValue());
  }

  //brings to view floor chart screen
  public void viewFloorChart(ActionEvent actionEvent) {
    Main.setPane(SCREENS.FLOORCHART.getValue());
  }

  public void viewAllRequests(ActionEvent actionEvent) {
    Main.setPane(SCREENS.ALLREQUESTS.getValue());
  }

  public void viewAllEmployees(ActionEvent actionEvent) {
    Main.setPane(SCREENS.EMPLOYEELIST.getValue());
    // Messing around with loading from FXML at this point in order to fire initialize() method at right time.
    // This is going to be an all-or-nothing kind of change.
//
//    try {
////      Main.root.getChildren().remove(Main.grid.get(Main.current));
//      Main.root.getChildren().removeAll(Main.grid);
//      Main.root.getChildren().add(FXMLLoader.load(Main.class.getResource("employeeList.fxml")));
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//    }
  }

  public void viewFoodServicesEmp(ActionEvent actionEvent) {
    Main.setPane(SCREENS.FOODSERVICESVIEW.getValue());
  }

  public void viewValetEmp(ActionEvent actionEvent) {
    Main.setPane(SCREENS.VALETVIEW.getValue());
  }

  public void RequestIsDone(ActionEvent actionEvent) {
  }

  public void logOut(){
    Main.setPane(SCREENS.LOGIN.getValue());
  }
}
