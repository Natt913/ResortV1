import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FoodServiceController {
    public TextField totalAmount;
    public Button buttonSubmitOrder;
    //I created quantity fields only for the forst item in each category
    public TextField quantityCalmari;
    public TextField quantityCaprese;
    public TextField quantityZucchini;
    public TextField quantityVegetables;
    public TextField quantityPotato;
    public TextField quantitySalad;
    public TextField quantityChicken;
    public TextField quantityShrimp;
    public TextField quantityBeef;
    public TextField quantityMushroom;
    public TextField quantityTiramisu;
    public TextField quantityPannaCotta;
    public TextField quantityZeppole;
    public TextField roomNumber;

    public void getBackHome(MouseEvent mouseEvent) {
        Main.setPane(SCREENS.GUESTHOME.getValue());

    }

    public void submitOrder(ActionEvent actionEvent) {
        //After DB method returns true
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success!");
        alert.setHeaderText(null);
        alert.setContentText("Food request successfully submitted!");

        alert.showAndWait();

        Main.setPane(SCREENS.GUESTHOME.getValue());
    }
}
