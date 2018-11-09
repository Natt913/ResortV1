package resortoperation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
