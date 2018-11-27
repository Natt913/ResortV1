import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MaintenanceRequestController {

    public Tab tabMaintenanceRequests;
    public Button buttonSubmit;
    public TextField textOther;
    public RadioButton ifLighting;
    public RadioButton ifPlumbing;
    public RadioButton ifTv;
    public RadioButton ifInternet;
    public RadioButton IfOther;

    public void getBackHome(MouseEvent mouseEvent) {
        Main.setPane(SCREENS.GUESTHOME.getValue());
    }

    public void submitRequest(ActionEvent actionEvent) {
        //After DB method returns true
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success!");
        alert.setHeaderText(null);
        alert.setContentText("Maintenance request successfully submitted!");

        alert.showAndWait();

        Main.setPane(SCREENS.GUESTHOME.getValue());
    }
}
