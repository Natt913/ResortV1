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

public class ConciergeController {
  public TextField quantityUniLandTickets;
  public TextField quantityAdvTickets;
  public TextField quantityKBBQ;

    @FXML
    public void getBackHome(MouseEvent mouseEvent) {
        Main.setPane(SCREENS.GUESTHOME.getValue());
    }

  public void submitReservation(ActionEvent actionEvent) {
    //After DB method returns true
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Success!");
    alert.setHeaderText(null);
    alert.setContentText("Reservation successfully submitted!");

    alert.showAndWait();

    Main.setPane(SCREENS.GUESTHOME.getValue());

  }
}
