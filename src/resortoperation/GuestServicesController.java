package resortoperation;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GuestServicesController {

  //maintenence request tab vars
  public Tab tabMaintenanceRequests;
  public Button buttonSubmit;
  public TextField textOther;
  public RadioButton ifLighting;
  public RadioButton ifPlumbing;
  public RadioButton ifTv;
  public RadioButton ifInternet;
  public RadioButton IfOther;
  
  
  //food servives
  public TextArea totalAmmount;
  public Button buttonSubmitOrder;
  //I created quantity fields only for the forst item in each category
  public TextField quantityCalmari;
  public TextField quantityVegetables;
  public TextField quantityChicken;
  public TextField quantityDeserts;
  public TextField roomNumber;


  //housekeeping vars
  public Button buttonSubmitRequestHouskeeping;
  public TextField towelAmount;
  public TextField toiletPaperAmount;
  public TextField shampooAmount;
  public TextField conditionerAmount;
  public TextField soapAmount;
  public CheckBox changeSheets;
  public CheckBox restockFridge;
  public CheckBox cleanRoom;
  public CheckBox makeBed;
  public TextField textOtherReqs;


  //maintanance request tub
  public void getMaintenanceRequests(Event event) {

  }

  public void submitRequests(ActionEvent actionEvent) {
    String message = "";
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Maintenance Request Sent!");
    alert.setHeaderText(null);

    if(ifLighting.isSelected()){
      message += "Lighting Issue\n";
    }
    if(ifPlumbing.isSelected()){
      message += "Plumbing Issue\n";
    }
    if(ifTv.isSelected()){
      message += "TV Issue\n";
    }
    if(ifInternet.isSelected()){
      message += "Internet Issue\n";
    }
    if(IfOther.isSelected()){
      message += textOther.getText()+"\n";
    }

    alert.setContentText("You maintenance request has been submitted. \n\nHere's what you requested: \n\n"+
        message);

    alert.showAndWait();

    try{
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GuestHome.fxml"));
      Parent root1 = (Parent) fxmlLoader.load();

      Stage myStage = new Stage();
      myStage.setTitle("Home");
      myStage.setScene(new Scene(root1));
      myStage.show();
      ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    catch (Exception e){
      System.err.println("Can't open new window");
    }
  }

  public void getOtherRequests(ActionEvent actionEvent) {
  }
  
  //food services functions
  public void getTotal(MouseEvent mouseEvent) {
  }

  public void submitOrder(ActionEvent actionEvent) {
  }

  public void getRooomNumber(ActionEvent actionEvent) {
  }

  public void submitHouskeepingRequest(ActionEvent actionEvent) {
  }

  public void getOtherHouseKeppingReq(ActionEvent actionEvent) {
  }
  public void getBackHome(MouseEvent mouseEvent) {
    try{
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GuestHome.fxml"));
      Parent root1 = (Parent) fxmlLoader.load();

      Stage myStage = new Stage();
      myStage.setTitle("Home");
      myStage.setScene(new Scene(root1));
      myStage.show();
      ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
    }
    catch (Exception e){
      System.err.println("Can't open new window");
    }

  }

  public void getTotalFood(ActionEvent actionEvent) {
  }

  public void getTabHousekeeping(Event event) {
  }

  public void getTabFoodServices(Event event) {
  }

  //housekeeping functions
  
}
