package resortoperation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class MangerHomeController {

  public Button buttonNewGuestAccount;
  public Button buttonFloorChart;
  public Button buttonAllRequests;
  public Button buttonEmployees;

  //these are request radio buttons - they suppose to disappear when req is done
  public CheckBox radio1;
  public CheckBox radio2;
  public CheckBox radio3;
  public CheckBox radio4;
  //when this button is clicked - radio disappears
  public Button buttonDone;



  public void buttonNewGuestAccount(ActionEvent actionEvent) {
    try{
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("createNewGuestAccount.fxml"));
      Parent root1 = (Parent) fxmlLoader.load();

      Stage myStage = new Stage();
      myStage.setTitle("Create New Guest Account");
      myStage.setScene(new Scene(root1));
      myStage.show();
      ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    catch (Exception e){
      System.err.println("Can't open new window");
    }
  }

  public void viewFloorChart(ActionEvent actionEvent) {
  }

  public void viewAllRequests(ActionEvent actionEvent) {
  }

  public void viewAllEmployees(ActionEvent actionEvent) {
  }

  public void RequestIsDone(ActionEvent actionEvent) {
  }
}
