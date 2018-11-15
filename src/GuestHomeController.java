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
    Main.setPane(SCREENS.HOUSEKEEPINGREQUEST.getValue());
  }

  public void getMaintenanceRequest(ActionEvent actionEvent) {
    Main.setPane(SCREENS.MAINTENANCEREQUEST.getValue());
  }

  public void getFoodServices(ActionEvent actionEvent) {
    Main.setPane(SCREENS.FOODSERVICE.getValue());
  }

  public void getConciergeServices(ActionEvent actionEvent) {
    Main.setPane(SCREENS.CONCIERGE.getValue());
  }

}
