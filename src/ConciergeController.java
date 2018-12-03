import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Class ConciergeController allows Guests to submit a concierge requests.
 *
 */
public class ConciergeController {
  @FXML
  public TextField quantityUniLandTickets;

  @FXML
  public TextField quantityAdvTickets;

  @FXML
  public TextField quantityKBBQ;

  /**
   * Function getBackHome brings the user back to the main menu once the back arrow icon is clicked.
   *
   * @param mouseEvent - Click of the mouse
   */
  public void getBackHome(MouseEvent mouseEvent) {

    //Set current pane in Main to GUESTHOME
    Main.setPane(SCREENS.GUESTHOME.getValue());
  }

  /**
   * Function submitReservation calculates the total amount that the guest owes, adds it to a field in the DB,
   * and creates a maintenance request for managers that contains the type of concierge service the guest has
   * selected.
   *
   * TODO: IMPLEMENT DB CHARGE AMOUNT + CREATE CONCIERGE REQUEST
   *
   * @param actionEvent - Click of the mouse onto button
   */
  public void submitReservation(ActionEvent actionEvent) {

    //After DB method returns true
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Success!");
    alert.setHeaderText(null);
    alert.setContentText("Reservation successfully submitted!");

    alert.showAndWait();

    //Bring guest back to main menu
    Main.setPane(SCREENS.GUESTHOME.getValue());

  }
}
