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
  private String requestDetail;

  @FXML
  public void getBackHome(MouseEvent mouseEvent) {
        Main.setPane(SCREENS.GUESTHOME.getValue());
    }

  private void requestDetailAdd(String value) {
    if(requestDetail.isEmpty())
      requestDetail = value.trim();
    else
      requestDetail += ", \r\n" + value.trim();
  }

  public void submitRequest(ActionEvent event){
      //
      requestDetail = "";

      if(getIntValue(quantityUniLandTickets) > 0) requestDetailAdd( "Reserve Universe Land Tickets: " + getIntValue(quantityUniLandTickets));
      if(getIntValue(quantityAdvTickets) > 0) requestDetailAdd( "Reserve Archipelagos of Adventure Tickets: " + getIntValue(quantityAdvTickets));
      if(getIntValue(quantityKBBQ) > 0) requestDetailAdd( "Reserve Seats at Korean BBQ: " + getIntValue(quantityKBBQ));

      Request thisRequest = new Request(User.globalCurrentUser.getUserID(), 6, requestDetail,
            User.globalCurrentUser.getGuestRoomNumber());
      thisRequest.insertRequestInDB();

      //After DB method returns true
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Success!");
      alert.setHeaderText(null);
      alert.setContentText("Reservation successfully submitted!");

      alert.showAndWait();

      Main.setPane(SCREENS.GUESTHOME.getValue());
  }

  public int getIntValue(TextField textField) {
      int value = 0;
      if(textField.getText() != null && textField.getText().trim().length() > 0)
      {
          try {
          value = Integer.parseInt(textField.getText().trim());
          } catch (NumberFormatException ex) {
            //
          }
      }
      return value;
  }
}
