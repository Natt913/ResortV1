package resortoperation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GuestHomeController {


  //this buttons supposed to take us to next pages
  public Button buttonHousekeeping;
  public Button buttonMaintenance;
  public Button buttonFooServices;
  public Button buttonConcierge;

  public void getHousekeepingRequest(ActionEvent actionEvent) {
    try{
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("guestServices.fxml"));
      Parent root1 = (Parent) fxmlLoader.load();

      Stage myStage = new Stage();
      myStage.setTitle("Requests");
      myStage.setScene(new Scene(root1));
      myStage.show();
      myStage.setResizable(false);
      ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    catch (Exception e){
      System.err.println("Can't open new window");
    }
  }

  public void getMaintenanceRequest(ActionEvent actionEvent) {
    try{
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("guestServices.fxml"));
      Parent root1 = (Parent) fxmlLoader.load();

      Stage myStage = new Stage();
      myStage.setTitle("Requests");
      myStage.setScene(new Scene(root1));
      myStage.show();
      myStage.setResizable(false);
      ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    catch (Exception e){
      System.err.println("Can't open new window");
    }
  }

  public void getFoodServices(ActionEvent actionEvent) {
    try{
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("guestServices.fxml"));
      Parent root1 = (Parent) fxmlLoader.load();

      Stage myStage = new Stage();
      myStage.setTitle("Requests");
      myStage.setScene(new Scene(root1));
      myStage.show();
      myStage.setResizable(false);
      ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    catch (Exception e){
      System.err.println("Can't open new window");
    }
  }

  public void getConciergeServices(ActionEvent actionEvent) {
  }
}
