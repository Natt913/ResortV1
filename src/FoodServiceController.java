import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

/**
 * Class FoodServiceController allows guests to submit a personalized food service request.
 */
public class FoodServiceController {

    @FXML
    public TextField totalAmount;

    @FXML
    public Button buttonSubmitOrder;

    @FXML
    public TextField quantityCalmari;

    @FXML
    public TextField quantityCaprese;

    @FXML
    public TextField quantityZucchini;

    @FXML
    public TextField quantityVegetables;

    @FXML
    public TextField quantityPotato;

    @FXML
    public TextField quantitySalad;

    @FXML
    public TextField quantityChicken;

    @FXML
    public TextField quantityShrimp;

    @FXML
    public TextField quantityBeef;

    @FXML
    public TextField quantityMushroom;

    @FXML
    public TextField quantityTiramisu;

    @FXML
    public TextField quantityPannaCotta;

    @FXML
    public TextField quantityZeppole;

    @FXML
    public TextField roomNumber;


    /**
     * Brings guest back to the home screen.
     *
     * @param mouseEvent - Mouse click
     */
    public void getBackHome(MouseEvent mouseEvent) {
        Main.setPane(SCREENS.GUESTHOME.getValue());

    }

    /**
     * Fetches data from textFields and calculates total of the order. Assigns this total to field in user table,
     * then creates a foodService request with the value that the user provided.
     *
     * TODO: CREATE REQUEST
     *
     * @param actionEvent - Mouse click
     */
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
