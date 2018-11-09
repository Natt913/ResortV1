package resortoperation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MaintenanceController {

    public Tab tabMaintenanceRequests;
    public Button buttonSubmit;
    public TextField textOther;
    public RadioButton ifLighting;
    public RadioButton ifPlumbing;
    public RadioButton ifTv;
    public RadioButton ifInternet;
    public RadioButton IfOther;

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
}
