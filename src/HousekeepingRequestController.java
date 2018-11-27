import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.Action;

public class HousekeepingRequestController {
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

    public void getBackHome(MouseEvent mouseEvent) {
        Main.setPane(SCREENS.GUESTHOME.getValue());
    }

    public void submitRequest(ActionEvent event){
      //After DB method returns true
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Success!");
      alert.setHeaderText(null);
      alert.setContentText("Housekeeping request successfully submitted!");

      alert.showAndWait();

      Main.setPane(SCREENS.GUESTHOME.getValue());
    }
}
